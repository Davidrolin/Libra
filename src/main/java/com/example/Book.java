package com.example;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String author;

    @Column(name = "publication_year")
    private int year;

    private String genre;
    private boolean finished;
    private int rating;

    public Book() {
    }

    public Book(String title, String author, int year, String genre) {
        this(title, author, year, genre, false, 0);
    }

    public Book(String title, String author, int year, String genre, boolean finished, int rating) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setGenre(genre);
        setFinished(finished);

        if (finished) {
            setRating(rating);
        } else {
            this.rating = 0;
        }
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Felaktig titel");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Felaktigt namn");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("Felaktig genre");
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Felaktig rating");
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", finished=" + finished +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }
}
