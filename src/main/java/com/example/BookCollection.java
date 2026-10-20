package com.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCollection {

    private final BookRepository bookRepository;

    public BookCollection(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addbook(String title, String author, int year, String genre) {
        Book newBook = new Book(title, author, year, genre);
        bookRepository.save(newBook);
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public Book findBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void markAsFinishedAndRate(int bookId, int rating) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Hittade ingen bok med ID: " + bookId));

        book.setFinished(true);
        book.setRating(rating);
        bookRepository.save(book);
    }

    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
