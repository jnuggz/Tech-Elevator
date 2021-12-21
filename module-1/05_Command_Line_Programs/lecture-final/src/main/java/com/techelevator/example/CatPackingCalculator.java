package com.techelevator.example;

import java.util.Scanner;

public class CatPackingCalculator {

    /*
        3 steps of a command line application
        1. Take input
        2. calculate date (do something with the input)
        3. give output
     */


    public static void main( String[] args ) {

        Scanner userInput = new Scanner( System.in );


        /* Get the dimensions of the box */
        System.out.println("What it the length of the container in feet? ");
        String lengthOfContainerFromUser = userInput.nextLine();
        double containerLength = Double.parseDouble( lengthOfContainerFromUser );

//        double containerLength = userInput.nextDouble();
//        userInput.nextLine();


        System.out.println("What is the width of the container in feet? ");
        String widthOfContainerFromUser = userInput.nextLine();
        int containerWidth = Integer.parseInt( widthOfContainerFromUser );

        System.out.println("What is the height of the container in feed? ");
        String heightOfContainerFromUser = userInput.nextLine();
        double containerHeight = Double.parseDouble( heightOfContainerFromUser );

        double estimatedPackingDensityOfCat = 0.5;
        double avgVolumeOfHouseCat = 0.083;
        double containerVolume = containerWidth * containerHeight * containerLength;
        double catsByVolume = containerVolume / avgVolumeOfHouseCat;
        double packedCats = catsByVolume * estimatedPackingDensityOfCat;

        // println() prints the text and automatically adds a newline
        System.out.println();
        // print()  just prints the text without a newline
        // printf() prints formatted text using a formatter

        /*
            Height         Width      Length      Cats in Box
            ----------------------------------------------------
            10              15         20           18000
         */
        System.out.printf("%-15s | %-15s | %-15s | %-25s %n", "Height", "Width", "Length", "Cats in Box");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-15s | %-15s | %-15s | %-6.0f %n", containerHeight,
                containerWidth, containerLength, packedCats);
    }




}
