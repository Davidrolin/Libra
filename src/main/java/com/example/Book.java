package com.example;

import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private int year;
    private String genre;
    private boolean finished;
    private int rating;
    private int bookId;

    public Book(String title, String author, int year, String genre, int bookId) {
        this(title, author, year, genre, bookId, false, 0);
    }

    public Book(String title, String author, int year, String genre, int bookId, boolean finished, int rating) {

        setTitle(title);
        setAuthor(author);
        setYear(year);
        setGenre(genre);
        setBookId(bookId);
        setFinished(finished);

        if (finished) {
            setRating(rating);
        } else {
            this.rating = 0;
        }
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public int getBookId() {
        return bookId;
    }

    public void setAuthor(String author) {

        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Felaktigt namn");
        }
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("Felaktig genre");
        }
    }

    public void setRating(int rating) {

        if (rating <= 5 && rating >= 1) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Felaktig rating");
        }
    }

    public void setTitle(String title) {

        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Felaktig titel");
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", finished=" + finished +
                ", rating=" + rating +
                ", bookId=" + bookId +
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
