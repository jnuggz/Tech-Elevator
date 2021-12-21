package com.techelevator.books;

public class BookUser {

    private String id;
    private String firstName;
    private String lastName;
    private String favoriteBook;
    private String email;
    private BookCollection collection = new BookCollection();


    public BookUser(String id) {
        this.id = id;
    }

    public BookUser(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public BookCollection getCollection() {
        return this.collection;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public String getEmail() {
        return email;
    }
}
