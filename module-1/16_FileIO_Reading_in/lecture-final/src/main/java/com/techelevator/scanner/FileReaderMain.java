package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderMain {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the file path >>>");
        String fileName = in.nextLine();
        File file = new File(fileName);

        System.out.println("Number of lines to read? >>>");
        int lineCount = in.nextInt();
        in.nextLine();

        try(Scanner fileScanner = new Scanner(file)){

            while(fileScanner.hasNextLine() && lineCount > 0){

                String line = fileScanner.nextLine();
                System.out.println(line);

               lineCount --;
            }

        }catch(FileNotFoundException e){
            System.out.println("File " + file.getAbsolutePath() + " not found :(");
        }

    }
}
