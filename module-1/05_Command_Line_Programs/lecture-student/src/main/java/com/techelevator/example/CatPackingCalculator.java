package com.techelevator.example;

import java.util.Scanner;

public class CatPackingCalculator {

    /*
        3 steps of a command line application
        1. Take input
        2. calculate date (do something with the input)
        3. give output
     */

    //Command Line Arguments args is a string array
    public static void main( String [] args) {

        Scanner userInput = new Scanner(System.in);

        /*Need to have userInput.nextLine() if using userInput.nextInt() to clean up the newline
        int userInputX = userInput.nextInt();
        userInput.nextLine();

        /* Get the dimensions of the box */
        System.out.println("What is the length of the container in feet? ");
        String lengthOfContainer = userInput.nextLine();
        double containerLength = Double.parseDouble(lengthOfContainer);
        //can't do = (double) lengthOfContainer;
        //parsing calls a method, to input the String "variable" into the Parse

        /*Same result as above but above
        double containerLength = userInput.nextDouble();
        userInput.nextLine();
         */

        System.out.println("What is the width of the container in feet? ");
        String widthOfContainer = userInput.nextLine();
        int containerWidth = Integer.parseInt(widthOfContainer);
        //can't input a double into an Int


        System.out.println("What is the height of the container in feet? ");
        String heightOfContainer = userInput.nextLine();
        double containerHeight = Double.parseDouble(heightOfContainer);

        double estimatePackingDensityOfCat = 0.5;
        double avgVolumeOfHouseCat = 0.083;
        double containerVolume = containerWidth * containerHeight * containerLength;
        double catsByVolume = containerVolume / avgVolumeOfHouseCat;
        double packedCats = catsByVolume * estimatePackingDensityOfCat;

        //println() prints the text and automatically adds a newline
        System.out.println("Number of Cats: " + packedCats);
        //print() just prints the text without a newline
        //printf() prints formatted text using a formatter

        /*
            Height          Width          Length          Cats in Box
            -------------------------------------------------------------
            10               15              20               18000
         */
        System.out.printf("%-15s | %-15s | %-15s | %-25s %n", "Height", "Width", "Length", "Cats in Box");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-15s | %-15s | %-15s | %-6.0f %n", containerHeight, containerWidth, containerLength, packedCats);
        //%-6.0f means that 18000.2342348 will be cut to 6 digits (18000), the .0 means 0 decimal place
    }
}
