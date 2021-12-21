package com.techelevator;


import com.techelevator.books.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        BookUser user = new BookUser("1", "John", "Fulton");
        user.setEmail("john@techelevator.com");
        user.setFavoriteBook("John's Favorite Book");

        // Create and Add a Book
        Book cleanCode = new Book();
        cleanCode.setTitle("Clean Code");
        cleanCode.setGenre("Programming");
        cleanCode.setAuthor("Martin Robert");
        cleanCode.setRating(5);
        cleanCode.setDescription("Details how to write clean code");

        user.getCollection().add(cleanCode);

        // Create a Second book
        Book braveNewWorld = new Book("Brave New World");
        braveNewWorld.setAuthor("Aldous Huxley");
        braveNewWorld.setGenre("Science Fiction");
        braveNewWorld.setRating(5);

        user.getCollection().add(braveNewWorld);


//        Book headFirstJava = new Book();
//
//        System.out.print("Book Title: ");
//        String bookTitle = input.nextLine();
//        headFirstJava.setTitle(bookTitle);
//
//        System.out.print("Book rating: ");
//        int bookRating = input.nextInt();
//        input.nextLine();
//        headFirstJava.setRating(bookRating);
//
//        user.getCollection().add(headFirstJava);


        Magazine newMagazine = new Magazine("Omni");
        newMagazine.setRating(4);
        user.getCollection().add(newMagazine);

        Magazine newMagazine2 = new Magazine("Testing Times");
        newMagazine2.setRating(2);
        user.getCollection().add(newMagazine2);

        Magazine newMagazine3 = new Magazine("Java Daily");
        newMagazine3.setRating(2);
        user.getCollection().add(newMagazine3);

        EBook eBook = new EBook("Head First Test", "MOBI",
                "headfirsttest.mobi", 1278);
        user.getCollection().add(eBook);

        user.getCollection().add( new EBook("Java Cookbook", "EPUB",
                "javacook.epub", 352));

        /*
         Print out the Users Books
         */

        System.out.println();
        System.out.println();

        System.out.println( user.getFullName() + "'s book collection");
        System.out.println("-----------------------------------------------");


        Application app = new Application();
        app.printListOfMedia( user.getCollection().getBooks());

        System.out.println("Total Books in Collection: " + user.getCollection().countOfBooks());

        System.out.println();
        System.out.println("Downloadable content: ");
        List<Media> eContent = user.getCollection().listDownloadableContent();
        app.printListOfMedia(eContent);

    }

    public void printListOfMedia(List<Media> mediaList) {

        for (Media currentMedia : mediaList) {
            System.out.println("Title: " + currentMedia.getTitle());
//            System.out.println("Author: " + currentMedia.getAuthor());
            System.out.println("Rating: " + currentMedia.getRating());
            System.out.println("Type: " + currentMedia.getType());
            System.out.println();
        }
    }


    
}
