package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		//Conversion number
		double footToMeters = 0.3048;

		//User should enter length in feet
		System.out.println("Enter length in feet: ");
		double feet = userInput.nextDouble();

		//Used the conversion numbers above to convert feet to meters
		double meters = feet * footToMeters;

		//Should display length in feet and meters
		System.out.println(feet + " feet is "  + meters + " meters");

	}

}
