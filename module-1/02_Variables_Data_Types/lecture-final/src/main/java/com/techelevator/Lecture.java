package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		int costOfBookInDollars = 10;
		boolean isPaintedRed = true;

		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		// Declaration defines the data type and name of the variable
		int numberOfExercises;

		// Assignment sets the value the variable will hold
		numberOfExercises = 0;

		// Assignment can change the value
		numberOfExercises = 26;

		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		// Declaration and Assignment can occur together
		double half = 0.5;

		System.out.println(half);

		char singleLetter = 'a';

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";

		System.out.println(name);

		String nameWithStartingTab = "\tTech Elevator";

		System.out.println(nameWithStartingTab);

		String nameWithNewLineAndDoubleQuotes = "\"Tech \n Elevators\"";
		System.out.println(nameWithNewLineAndDoubleQuotes);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		float pi = 3.1416f;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String yourName = "your name";
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfMouseButtons = 3;

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int percentageOfBatteryRemaining = 80;
		double remainingBatteryPercent = .80;

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);

		// division of 7/2
		double sevenDividedByTwo = 7.0 / 2;
		System.out.println(sevenDividedByTwo);

		int sevenModulusTwo = 7 % 2;
		System.out.println(sevenModulusTwo);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double addition = 12.3 + 32.1;
		System.out.println(addition);

		System.out.println(10/3.0);
		/*
		12. Create a String that holds your full name.
		*/
		String firstName = "John";
		String lastName = "Fulton";
		// Can use + to concatenate Strings (or put them together)
		String fullName = firstName + " " + lastName;
		System.out.println(fullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String hello = "Hello, " + fullName;
		System.out.println(hello);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		System.out.println(fullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire";

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw" + 2;
		System.out.println(saw);
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw += 0;
		System.out.println(saw);

		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println( 4.4 / 2.2 );
		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println( 5.4 / 2 );

		/*
		20. What is 5 divided by 2?
		*/
		System.out.println( 5 / 2 );

		int numberOfBooks = 7;
		int totalCostOfBooks = 3;
		int costPerBook = numberOfBooks / totalCostOfBooks;
		System.out.println(costPerBook);


		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println( 5.0 / 2 );

		double answer = 5 / 2;
		System.out.println(answer);

		answer = 5d / 2;
		System.out.println(answer);

		answer = (double) 5 / 2;
		System.out.println(answer);

		long bigNumber = 10;
		int smallNumber = (int) bigNumber;

		// If a value doesn't fit into the type it is cast to it is truncated
		double doubleValue = 10.2576;
		int intValue = (int) doubleValue;
		System.out.println(intValue);

		int grade = 8 / 10;
		System.out.println(grade);

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println( 5 % 2 );
		/*
		24. What is 1,000,000,000 * 3?
		*/
		int tooLargeOfNumber = 1000000000 * 3;
		System.out.println( tooLargeOfNumber );

		long tooLargeAsLong = 1000000000L * 3;
		System.out.println(tooLargeAsLong);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercises = false;
		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;
		
		
	}

}
