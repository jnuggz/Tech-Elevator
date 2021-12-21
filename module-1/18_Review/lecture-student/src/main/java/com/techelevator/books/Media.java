package com.techelevator.books;

public abstract class Media {

    private String title;
    private String genre;
    private int pageCount;
    private int rating;
    private String description;
    private String type;


    public Media() {

    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }


    public int getPageCount() {
        return pageCount;
    }


    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
