package com.techelevator;


import com.techelevator.books.*;
import com.techelevator.books.filereader.MediaFileReader;
import com.techelevator.books.view.Menu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private Menu menu = new Menu();

    public void run() {

        Book newBook = new Book();
        newBook.setTitle("this is the title");

        Book secondBook = new Book();
        secondBook.setTitle("This is the second books title");

        System.out.println("One: " + newBook.hashCode());
        System.out.println("Two: " + secondBook.hashCode());


        BookUser user = new BookUser("1", "John", "Fulton");
        user.setEmail("john@techelevator.com");
        user.setFavoriteBook("John's Favorite Book");

        while(true) {
            String filename = menu.askUserForFilename();
            MediaFileReader fileReader = new MediaFileReader();
            try {
                List<Media> mediaCollection = fileReader.read(filename);
                user.getCollection().addAll(mediaCollection);
                break;
            } catch (FileNotFoundException e) {
                menu.tellUserInvalidFile();
            }
        }

        /*
         Print out the Users Books
         */
        menu.showCollectionName(user.getFullName());
        menu.printListOfMedia( user.getCollection().getBooks());
        menu.showTotalBooks( user.getCollection().countOfBooks() );


        List<Media> eContent = user.getCollection().listDownloadableContent();
        menu.printDownloadableContent(eContent);

    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }




    
}
