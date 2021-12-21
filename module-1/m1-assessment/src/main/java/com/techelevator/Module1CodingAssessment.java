package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner userInput = new Scanner(System.in);

		//User should enter their zipcode
		System.out.println("Enter your zipcode: ");
		int userZipcode = userInput.nextInt();
		userInput.nextLine();

		//delivery fee = $3.99 if zipcode is between 20000 and 29999
		//delivery fee = $6.99 if zipcode is between 30000 and 39999
		//delivery fee = $0    if zipcode is between 10000 and 19999
		//delivery fee = $19.99 if zipcode doesn't meet requirements
		//same-day delivery = $5.99
		int waivedFee = 0;
		double sameDayDelivery = 5.99;
		double deliveryFeeOne = 3.99;
		double deliveryFeeTwo = 6.99;
		double deliveryFeeThree = 19.99;

		if (userZipcode >= 20000 && userZipcode <= 29999){
			System.out.println(deliveryFeeOne);
		} else if (userZipcode >= 30000 && userZipcode <= 39999) {
			System.out.println(deliveryFeeTwo);
		} else if (userZipcode >= 10000 && userZipcode <= 19999) {
			System.out.println(waivedFee);
		}
		System.out.println(deliveryFeeThree);














	}

}
