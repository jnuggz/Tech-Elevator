package com.techelevator.books;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private List<Media> media = new ArrayList<Media>();

    public void add(Media media) {
        this.media.add(media);
    }

    public List<Media> getBooks() {
        return media;
    }

    public int countOfBooks() {
        return media.size();
    }

    public List<Media> listDownloadableContent() {

        List<Media> downloadables = new ArrayList<Media>();

        for (Media currentMedia : media) {
            if (currentMedia instanceof Downloadable) {
                downloadables.add( currentMedia );
            }
        }

        return downloadables;
    }

}
