package com.techelevator;

public class ArraysAndLoops {

    public static void main(String[] args) {

        String[] instructors = new String[5];

        int[] count = new int[]{10, 20, 30, 40, 50};

        count[2] = 100;
        //changed the 30 to 100

        instructors[0] = "John";
        instructors[1] = "Brian";
        instructors[2] = "Steve";
        instructors[3] = "Matt";
        instructors[4] = "Kevin";

        instructors[1] = "you are fired";
        instructors[1] = "Brian2";
        String name = instructors[1];

        //the following code will give us an ArrayIndexOutOfBounds exception
        //instructors[5] = "Andrew";
        //out of scope

        String greeting = " " + name;

        System.out.println(greeting);
        //this wouldn't work, would give weird results
        System.out.println("funky address ref " + count);
        //instead use below
        System.out.println("I want to see the first " + count[0]);
        System.out.println(instructors[1] + " " + instructors[4]);

        //for ( incrementor ; booleanCondition; iterator)
        //it is ok for use short variables for loops
        //i++ will add 1
        //int i = 0 will run 1 time
        //i < 10 must be true to run
        //i will change and add 1 until booleanCondition is true
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ");
        }
        //Block scoped {}
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        //System.out.println(sum);

        //Implied Blocks don't use {}
        //stay away from using this
        //if (5 > 10) int y = 10;

        //Building a loop that counts backwards
        for (int i = 100; i > 0; i--) {
            System.out.print(i);
        }

        //Continue stops the current execution of the block and goes to the next
        //increment in the loop
        //Skip numbers
        for (int counter = 0; counter < 100; counter++) {
            if (counter % 10 == 0) {
                continue;
            }
            System.out.println(counter);
        }
        //Break stops the current execution of the block and immediately ends the loop
        for (int counter = 0; counter < 100; counter++) {
            if (counter % 10 == 0) {
                break;
            }
        }
        for (int i = 0; i < instructors.length; i++) {
            System.out.println(instructors[i]);
        }

        for (int i = 0; i < instructors.length; i++) {
            if (i % 2 == 0) {
                System.out.println(instructors[i]);
            }
        }
        //int[] count
        for (int i = 0; i < count.length - 1; i++) {

        }
        //when 200 is found, skip it and the next number
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 200) {
                i++;
                continue;
                //System.out.println(count[1]);
            }
        }
        //when 200 is found, print it and the next number
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 100) {
                System.out.println(count[1]);
                if (i < count.length - 1) {
                    System.out.println(count[i + 1]);
                }
            }
        }
    }
}