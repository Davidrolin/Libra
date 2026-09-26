package com.example;

public class Book {

    private String title;
    private String author;
    private int year;
    private String genre;
    private boolean finished;
    private double rating;
    private int bookId;

    public Book(String title, String author, int year, String genre, int bookId){
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.bookId = bookId;
    }

    public Book(String title, String author, int year, String genre, int bookId, boolean finished, double rating){
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.finished = finished;
        this.rating = rating;
        this.bookId = bookId;

    }

    public double getRating() {
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
