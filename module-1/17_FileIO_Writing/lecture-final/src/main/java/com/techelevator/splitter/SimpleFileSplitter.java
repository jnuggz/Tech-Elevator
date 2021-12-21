package com.techelevator.splitter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleFileSplitter {

    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Path to file to split: ");
        String path = userInput.nextLine();
        System.out.println("Number of lines per section: ");
        int lineCount = userInput.nextInt();
        userInput.nextLine();

        File fileObject = new File(path);

        try (Scanner fileScanner = new Scanner(fileObject)) {

            int segmentNumber = 0;
            while(fileScanner.hasNextLine()) {

                List<String> linesInSegment = new ArrayList<String>();

                int count = lineCount;
                while(count > 0 && fileScanner.hasNextLine()) {
                    String lineFromFile = fileScanner.nextLine();
                    linesInSegment.add( lineFromFile );
                    count--;
                }

                String pathToNewSegmentFile = path + "-" + segmentNumber;
                segmentNumber++;

                try (PrintWriter printWriter = new PrintWriter(pathToNewSegmentFile);
                     BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {

                    for (String line : linesInSegment) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileObject.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Unable to access file: " + e.getMessage());
        }

    }
}
