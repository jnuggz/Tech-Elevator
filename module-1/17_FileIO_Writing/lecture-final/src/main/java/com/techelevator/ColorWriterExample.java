package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ColorWriterExample {

    /*
    Set a Path to write the colors and numbers to
     */
    private final static String FILE_NAME = "colorWriterOutput";
    private final static int UPPER_LIMIT = 200;

    public static void main(String[] args) throws FileNotFoundException {

        try (PrintWriter printWriter = new PrintWriter(FILE_NAME)) {
            for (int i = 1 ; i <= UPPER_LIMIT ; i++) {
                //System.out.println(getOutput(i));
                    printWriter.println(getOutput(i));
            }
        }

        System.out.println("DONE!");
    }


    private static String getOutput(int i) {

        String output = String.valueOf(i);

        if (i % 5 == 0) {
            output = "RED";
        } else if (i % 7 == 0) {
            output = "BLUE";
        } else if (i % 9 == 0) {
            output = "GREEN";
        }

        return output;
    }
}
