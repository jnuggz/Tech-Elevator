package com.techelevator;

import java.lang.reflect.Array;
import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		//Declaring a variable of Data Type List
		//Will hold a list of strings
		//new will instantiate
		List<String> instructors = new ArrayList<String>();

		// adds elements to the List
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Kevin");
		instructors.add("Andrew");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// for List use .size(), items in list, instead of .length()
		// .get() will returns elements at given index
		for (int i = 0; i < instructors.size(); i++){
			System.out.println( instructors.get(i) ); //for an array would use instructors[i]
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		//this would add John to the list as index[5]
		instructors.add("John");

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		//Rachelle is now index[3] and Kevin + Andrew are moved down the list
		instructors.add(3, "Rachelle");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		//index[4] was removed
		instructors.remove(4);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		//Will return true or false if item is in the list
		//Uses .contain() in boolean
		boolean isSteveInList = instructors.contains("Steve");
		boolean isKevinInList = instructors.contains("Kevin");

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		//This will show what index the item is in
		int indexOfAndrew = instructors.indexOf("Andrew");
		//Index below is -1 because it is not found
		int indexOfAbc = instructors.indexOf("abc");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

//		this will give an error because it doesn't know how to build an Array
//		String[] instructorsArray = instructors.toArray();

		//instantiate a new array of strings into the method toArray
		//Uses .toArray()
		String[] instructorsArray = instructors.toArray(new String[instructors.size()]);

		//Array can be turned into lists using .asLists()
		String[] letters = { "a", "b", "c", "d",};
		List<String> lettersAsLists = Arrays.asList(letters);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		//Uses .sort() to order in alphabetical or numeric order
		Collections.sort(instructors);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		//Uses .reverse() to flip the order alphabetically or numerically
		Collections.reverse(instructors);

		/*
			To use primitive data types the Wrapper class must be used
			There are 8 primitive data types
			Integer, Double, Character, Boolean, Byte, Short, Long, Float
		 */
		List<Integer> numbers = new ArrayList<Integer>();

		//autoboxing automatically defaults an int
		//results in adding 10 as the value of the index[0]
		numbers.add(10);

		//Has a strike through because IntelliJ knows theres a better way to do this
		//It does the parsing for us
		Integer employees = new Integer(25);
		Integer piecesOfCake = new Integer("24");

		//Autoboxing allows this to work
		if (employees > piecesOfCake){
			System.out.println("Not enough cake");
		}

		Integer objX = 10;
		int intY = 20;
		intY = objX + 5;
		objX = intY + 10;

		//default value of double is 0
//		double acctBalance;
//		Double accountBalance = null;
//		accountBalance = accountBalance + 100;

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		//Will loop back into the collection and spit out the next element in the list
		for (String name : instructors)	{
			System.out.println(name);
		}

		//For each loop for integers
		double[] doubles = { 2.5, 3.567, 1.2, 0.75, 783.12 };

		for (double currentItem : doubles){
			double dblValue = currentItem * 2;
			System.out.println(dblValue);
		}

		/*
			Queue
		 */

		//Queue uses LinkedList, must import LinkedList
		Queue<String> tasks = new LinkedList<String>();

		// the .offer() method adds to the queue
		tasks.offer("Clean dishes");
		tasks.offer("Sweep floor");
		tasks.offer("Clean counters");
		tasks.offer("Scrub ceiling");

		// While loop will loop while the condition is true
		// Line is saying while its not true that the tasks is empty
		while ( !tasks.isEmpty() ){
			// To retrieve an item from the queue use poll()
			System.out.println("Working on tasks: " + tasks.poll() );
			System.out.println("The Next item will be: " + tasks.peek() );
		}

		/*
			Stack
		 */

		Stack<Integer> numberHistory = new Stack<Integer>();
		// The push() adds things to the stack
		numberHistory.push(10);
		numberHistory.push(20);
		numberHistory.push(30);
		numberHistory.push(40);

		while ( !numberHistory.isEmpty() ) {
			// retrieve items with pop()
			System.out.println( numberHistory.pop() );
		}
	}
}
