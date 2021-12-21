package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		//User will enter temperature in Fahrenheit
		System.out.println("Please enter the temperature in Fahrenheit: ");
		String userInputTemp = userInput.nextLine();
		double tempNumber = Double.parseDouble(userInputTemp);

		//Conversion formula to get Celsius calculation
		double tempC = (tempNumber - 32) / 1.8;

		//Should display temperature in F and also C
		System.out.println(tempNumber + "F" + " is" + tempC + "C");

	}
}
