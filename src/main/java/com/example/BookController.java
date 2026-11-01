package com.example;

import com.example.Book;
import com.example.User;
import com.example.BookRepository;
import com.example.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookController(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    // för att hämta den inloggade användaren från databasen
    private User getLoggedInUser(Authentication authentication) {
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Inloggad användare hittades inte"));
    }

    @GetMapping
    public String listBooks(Model model, Authentication authentication) {
        User currentUser = getLoggedInUser(authentication);

        // inloggade användarens böcker
        List<Book> userBooks = bookRepository.findByUser(currentUser);

        model.addAttribute("books", userBooks);
        model.addAttribute("newBook", new Book());
        model.addAttribute("username", currentUser.getUsername());
        return "books";
    }

    @PostMapping
    public String addBook(@ModelAttribute Book book, Authentication authentication) {
        User currentUser = getLoggedInUser(authentication);

        // Kopplar boken till den inloggade användaren
        book.setUser(currentUser);
        bookRepository.save(book);

        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id, Authentication authentication) {
        User currentUser = getLoggedInUser(authentication);

        // Radera bara om boken faktiskt tillhör den inloggade användaren
        bookRepository.findById(id).ifPresent(book -> {
            if (book.getUser().getId().equals(currentUser.getId())) {
                bookRepository.delete(book);
            }
        });

        return "redirect:/books";
    }
}
