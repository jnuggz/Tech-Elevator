package com.techelevator.books;

public class EBook extends Book implements Downloadable {

    private String format;
    private String filename;
    private int fileSize;

    public EBook(String title, String format,
                 String filename, int fileSizeInMegabytes) {
        super(title);
        this.format = format;
        this.filename = filename;
        this.fileSize = fileSizeInMegabytes;
    }

    @Override
    public String getFormat() {
        return this.format;
    }

    @Override
    public String getFileName() {
        return this.filename;
    }

    @Override
    public int getFileSizeInMegabytes() {
        return this.fileSize;
    }

    @Override
    public double calculateDownloadTime(int megabitsPerSecond) {
        double timeInSeconds = (double) fileSize / (megabitsPerSecond / 8d);
        return timeInSeconds;
    }
}
