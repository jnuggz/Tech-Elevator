package com.techelevator.books.view;

import com.techelevator.books.Media;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final static Scanner userInput = new Scanner(System.in);

    public String askUserForFilename() {
        System.out.println("Inventory filename >>>");
        return userInput.nextLine();
    }

    public void tellUserInvalidFile() {
        System.out.println("Invalid file, please try again!");
    }

    public void showCollectionName(String userName) {
        System.out.println();
        System.out.println();

        System.out.println(userName + "'s book collection");
        System.out.println("-----------------------------------------------");
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

    public void showTotalBooks(int count) {
        System.out.println("Total Books in Collection: " + count);
    }

    public void printDownloadableContent(List<Media> mediaList) {{
        System.out.println();
        System.out.println("Downloadable content: ");
        printListOfMedia(mediaList);
    }
    }


}
