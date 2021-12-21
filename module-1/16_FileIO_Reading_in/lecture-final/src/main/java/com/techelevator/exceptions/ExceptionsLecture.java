package com.techelevator.exceptions;

import java.util.Scanner;

public class ExceptionsLecture {

    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.print("Input a whole number >>> ");
            String userSelection = input.nextLine();
            int number = 0;

            try {
                number = Integer.parseInt(userSelection);
                System.out.println("Your number was " + number);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }

    }

}
