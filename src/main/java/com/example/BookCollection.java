package com.example;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private List<Book> bookList = new ArrayList<>();

    private int nextId = 1;

    public void addbook(String title, String author, int year, String genre){
        bookList.add(new Book(title, author, year, genre, nextId));

        nextId++;
    }

    public List<Book> getBookList(){
        return List.copyOf(bookList);
    }

    public Book findBookById(int bookId){
        for(Book x: bookList){
            if(x.getBookId() == bookId){
                return x;
            }
        }
        return null;
    }

    public void markAsFinishedAndRate(int bookId, int rating){
        Book book = findBookById(bookId);

        if(book != null){
            book.setFinished(true);
            book.setRating(rating);
        }else{
            throw new IllegalArgumentException("Hittade ingen bok med ID: " + bookId);
        }

    }

    public void deleteBook(int bookId){
        bookList.removeIf(x -> x.getBookId() == bookId);
    }


}
