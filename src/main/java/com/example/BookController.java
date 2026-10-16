package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private final BookCollection bookCollection;

    public BookController(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
    }

    @GetMapping("/books")
    public String showBookList(Model model) {
        model.addAttribute("books", bookCollection.getBookList());
        return "books";
    }

    @PostMapping("/books/add")
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam int year,
                          @RequestParam String genre) {
        bookCollection.addbook(title, author, year, genre);
        return "redirect:/books";
    }

    @PostMapping("/books/rate")
    public String markAsFinishedAndRate(@RequestParam int bookId,
                                        @RequestParam int rating) {
        bookCollection.markAsFinishedAndRate(bookId, rating);
        return "redirect:/books";
    }

    @PostMapping("/books/delete")
    public String deleteBook(@RequestParam int bookId) {
        bookCollection.deleteBook(bookId);
        return "redirect:/books";
    }
}
