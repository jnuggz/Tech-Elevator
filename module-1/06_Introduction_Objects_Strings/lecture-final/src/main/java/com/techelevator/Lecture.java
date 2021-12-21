package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		/*
			1. Declare a variable of the data type defined by the class
			2. Use the new keyword with the class name to instantiate the class into an Object,
			   which we assign to the variable
			3. Initialize the Object with its starting state, which is the () after the classname
		 */
		LegoPerson legoPersonOne = new LegoPerson();
		int x = 10;
		String test = "test";

		LegoPerson legoPersonTwo = new LegoPerson("builder", "red", true);
		LegoPerson legoPersonThree = new LegoPerson("astronaut", "blue", false);

		legoPersonTwo.setClotingColor("yellow");
		legoPersonThree.setOccupation("nurse");

		int one = 100;
		int two = one;
		one = 200;

		int[] numbersOne = { 10, 20, 30, 40 };
		int[] numbersTwo = numbersOne;
		numbersOne[1] = 55;




		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String str = "abc";
		String upperCaseStr = str.toUpperCase();

		String emptyString = "";
		String nullString = null;

		emptyString = emptyString.toUpperCase();
		// The next line will cause a nullPointerException
		//nullString.toUpperCase();


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		String hello1 = "hello";
		String hello2 = new String("hello");

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;

		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String name = "Tech Elevator";
		name = name.toLowerCase();

		// String are stored in memory as char[]
		//char singleCharacter = 'T';
		//char[] charArray = { 'T', 'e', 'c', 'h', ' ', 'E', 'l','e','v','a','t','o','r'};

		for (int i = 0; i < name.length(); i++) {
			System.out.println( name.charAt(i) );
		}

		// substring( inclusive starting index, exclusive ending index )
		String subStringed = name.substring(8, 12);
		// substring (provide only 1 argument, then starts at the index and goes to the end of String)
		String lastChars = name.substring( name.length() - 3);

		boolean startsWithTech = name.startsWith("tech");

		boolean startsWithTechWithoutCase = name.toUpperCase().startsWith("TECH");

		// IndexOf gets the index of where a String starts within another String
		int indexOfE = name.indexOf("e");

		String[] splitOnSpace = name.split(" ");
		String[] splitOnE = name.split("e");

		String[] splitIgnoreCase = name.toUpperCase().split("E");


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		char a = 'a';
		String b = String.valueOf(a);

		String countDown = String.join(" --> ", "Five", "Four", "Three", "Two", "One");

		System.out.println(countDown);

		char[] someCharacters = { 'J', 'a', 'v', 'a', ' ', 'B', 'l', 'u', 'e'};
		String stringFromCharArray = new String( someCharacters );

	}
}
