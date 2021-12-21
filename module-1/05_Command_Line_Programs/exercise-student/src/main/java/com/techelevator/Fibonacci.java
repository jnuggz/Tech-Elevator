package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		//User enters an integer to be placed in inputInteger variable
		System.out.print("Please enter an integer: ");
		int inputInteger = userInput.nextInt();
		userInput.nextLine();

		//Variables used to change the number in the loop to get to the next number in the sequence
		int firstNum = 0;
		int prevNum = 0;

		//Prints out the first number in the Fibonacci sequence and a space after
		System.out.print(0 + " ");

		//Loop used to print the next number in the sequence until the number is greater or equal to the inputted Integer
		for (int nextNum = 1; nextNum <= inputInteger; ) {

			System.out.print(nextNum + " ");

			//Using the variables above the nextNum will always be its current value plus previous number in sequence
			prevNum = firstNum;
			firstNum = nextNum;
			nextNum = nextNum + prevNum;
		}
	}
}


