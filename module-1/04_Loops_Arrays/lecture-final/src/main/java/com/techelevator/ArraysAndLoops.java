package com.techelevator;

public class ArraysAndLoops {

    public static void main(String[] args) {

        String[] instructors = new String[5];

        int[] count = new int[] {10, 20, 30, 40, 50};

        count[2] = 100;

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

        String greeting = " " + name;

        System.out.println(greeting);
        System.out.println("funky address ref " + count);
        System.out.println("I want to see the first " + count[0]);
        System.out.println(instructors[1] + " " + instructors[4]);

        for( int i = 0 ; i < 10; i++)
        {
            System.out.println(i + " ");
        }

        int sum = 0;

        for ( int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

        for (int i = 100; i > 0; i--) {
            System.out.println(i);
        }

        // Continue stops the current execution of the block and goes to the next
        // increment in the loop
        for ( int counter = 0; counter < 100; counter++) {
            if ( counter % 10 == 0) {
                continue;
            }
            System.out.println(counter);
        }

        // Break stops the current execution of the block and immediately ends the loop
        for ( int counter = 0; counter < 100; counter++) {
            if ( counter % 10 == 0) {
                break;
            }
            System.out.println(counter);
        }

        for (int i = 0; i < instructors.length; i++) {
            System.out.println( instructors[i] );
        }

        for (int i = 0; i < instructors.length; i++) {
            if ( i % 2 == 0) {
                System.out.println( instructors[i] );
            }
        }
        //int[] count = new int[] {10, 20, 30, 40, 50};
        for (int i = 0; i < count.length; i++) {
            count[i] = count[i] * 2;
        }

        // When 200 is found, skip it and the next number
        for (int i = 0; i < count.length; i++) {

            if (count[i] == 200) {
                i++;
                continue;
            }
            System.out.println(count[i]);
        }

        // When 200 is found, print it and the next number
        for (int i = 0; i < count.length; i++) {

            if (count[i] == 100) {
                System.out.println(count[i]);
                if (i  < count.length - 1) {
                    System.out.println(count[i + 1]);
                }
            }

        }

    }

}
