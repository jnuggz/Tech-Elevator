package com.techelevator.books.filereader;

import com.techelevator.books.Book;
import com.techelevator.books.Magazine;
import com.techelevator.books.Media;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MediaFileReader  {

    /*
    title|author|genre|rating|type
      0     1      2     3     4
     */
    public List<Media> read(String fileName) throws FileNotFoundException {

        List<Media> media = new ArrayList<Media>();

        File file = new File(fileName);

        try (Scanner fileScanner = new Scanner(file)) {

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                Media mediaLoadedFromLineOfFile = null;
                if (parts[4].equalsIgnoreCase("BOOK")) {
                    mediaLoadedFromLineOfFile = new Book();
                    ((Book) mediaLoadedFromLineOfFile).setAuthor(parts[1]);
                } else if (parts[4].equalsIgnoreCase("MAGAZINE")) {
                    mediaLoadedFromLineOfFile = new Magazine();
                }
                mediaLoadedFromLineOfFile.setTitle(parts[0]);
                mediaLoadedFromLineOfFile.setGenre(parts[1]);
                mediaLoadedFromLineOfFile.setRating(Integer.parseInt(parts[3]));
                media.add(mediaLoadedFromLineOfFile);
            }

        }


        return media;
    }
}
