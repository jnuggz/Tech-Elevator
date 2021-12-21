package com.techelevator.books;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private List<Book> books = new ArrayList<Book>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int countOfBooks() {
        return books.size();
    }


}
