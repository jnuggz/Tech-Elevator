package com.techelevator.books;

public interface Downloadable {

    String getFormat();
    String getFileName();
    int getFileSizeInMegabytes();

    double calculateDownloadTime(int megabitsPerSecond);

}
