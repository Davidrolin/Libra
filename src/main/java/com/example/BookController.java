package com.example;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    // Hjälpmetod för att hämta användaren eller rensa sessionen om databasen startats om
    private User getAuthenticatedUser(Authentication authentication, HttpServletRequest request) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        String username = authentication.getName();
        return userRepository.findByUsername(username).orElseGet(() -> {
            // Om sessionen finns i webbläsaren men användaren raderats ur H2 vid omstart:
            SecurityContextHolder.clearContext();
            if (request != null && request.getSession(false) != null) {
                request.getSession().invalidate();
            }
            return null;
        });
    }

    @GetMapping
    public String listBooks(Model model, Authentication authentication, HttpServletRequest request) {
        User user = getAuthenticatedUser(authentication, request);
        if (user == null) {
            return "redirect:/login";
        }

        List<Book> userBooks = bookRepository.findByUser(user);
        model.addAttribute("books", userBooks);
        model.addAttribute("username", user.getUsername());
        return "books";
    }

    @PostMapping
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam Integer year,
                          @RequestParam String genre,
                          Authentication authentication,
                          HttpServletRequest request) {

        User user = getAuthenticatedUser(authentication, request);
        if (user == null) {
            return "redirect:/login";
        }

        // Backend-validering
        String cleanTitle = title != null ? title.trim() : "";
        String cleanAuthor = author != null ? author.trim() : "";
        String cleanGenre = genre != null ? genre.trim() : "";

        if (cleanTitle.isEmpty() || cleanTitle.length() > 150) {
            return "redirect:/books?error=title";
        }
        if (cleanAuthor.isEmpty() || cleanAuthor.length() > 100) {
            return "redirect:/books?error=author";
        }
        if (cleanGenre.isEmpty() || cleanGenre.length() > 50) {
            return "redirect:/books?error=genre";
        }

        if (year == null || year < -3000 || year > 2100) {
            return "redirect:/books?error=year";
        }

        Book book = new Book();
        book.setTitle(cleanTitle);
        book.setAuthor(cleanAuthor);
        book.setYear(year);
        book.setGenre(cleanGenre);
        book.setUser(user);

        bookRepository.save(book);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id, Authentication authentication, HttpServletRequest request) {
        User user = getAuthenticatedUser(authentication, request);
        if (user == null) {
            return "redirect:/login";
        }

        // Radera endast om boken tillhör den inloggade användaren
        bookRepository.findById(id).ifPresent(book -> {
            if (book.getUser().getId().equals(user.getId())) {
                bookRepository.delete(book);
            }
        });

        return "redirect:/books";
    }
}
