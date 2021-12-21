package com.techelevator.books;

public class Book extends Media {

    private String author;
    private String isbn;

    public Book() {
        super("", "Book");
    }

    public Book(String title) {
        super(title, "Book");
    }

    public Book(String title, String type) {
        super(title, type);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
