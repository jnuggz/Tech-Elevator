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

        //need fileObject first in Java
        //path is relative to the folder "lecture-student"
        File fileObject = new File(path);

        try (Scanner fileScanner = new Scanner(fileObject)) {

            int segmentNumber = 0;
            while (fileScanner.hasNextLine()) {
                //this is going to read the file
                //read only until we have enough of them

                //to check for group of text use list
                List<String> linesInSegment = new ArrayList<String>();

                int count = lineCount;
                while(count > 0 && fileScanner.hasNextLine()) {
                    //line above is asking "is there another line" keep going
                    //line below will only check for each line
                    String lineFromFile = fileScanner.nextLine();
                    linesInSegment.add(lineFromFile);
                    count--;
                    //this while loop will run as many times as we put the line count
                }

                //this puts segments of text into the file
                //file.txt-0 and file.txt-1....
                String pathToNewSegmentFile = path + "-" + segmentNumber;
                segmentNumber++;

                //try into a try is usually discouraged but in this case there is a resource, so its ok
                try (PrintWriter printWriter = new PrintWriter(pathToNewSegmentFile);
                     BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {

                    for (String line : linesInSegment) {
                        //this would put all the text in one line
                        bufferedWriter.write(line);
                        //.write() doesn't add a new line, so we need to add .newLine()
                        bufferedWriter.newLine();
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileObject.getAbsolutePath());
        } catch (IOException e) {
            //line above is used to catch the IOException from line 49
            System.out.println("Unable to access file: " + e.getMessage());
        }

    }
}
