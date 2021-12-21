package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderSteps {

    public static void main(String[] args) {

        String fileName = "rtn.txt";
       // C:\Users\Student\source\repos\java-blue-main\module-1\16_FileIO_Reading_in\lecture-final\rtn.txt

        File file = new File(fileName);

        try(Scanner fileScanner = new Scanner(file)){

            while(fileScanner.hasNextLine()){
                String lineFromFile = fileScanner.nextLine();

                System.out.println(lineFromFile);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found :( ");
        }

    }
}
