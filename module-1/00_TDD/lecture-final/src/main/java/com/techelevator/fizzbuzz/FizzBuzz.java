package com.techelevator.fizzbuzz;

public class FizzBuzz {

    /*
    Given a number
    Return Fizz if the number is a multiple of 3
    Return Buzz if the number is a multiple of 5
    Return FizzBuzz if the number is a multiple of both 3 and 5
    Otherwise return the original number
     */

    private final static int FIZZ_NUMBER = 3;
    private final static int BUZZ_NUMBER = 5;

    private final static String FIZZBUZZ = "FizzBuzz";
    private final static String FIZZ = "Fizz";
    private final static String BUZZ = "Buzz";

    public String fizzBuzzIt(int number) {

        String originalNumber = String.valueOf(number);
        String returnValue = "";

        if (isMultipleOfThree(number)) {
            returnValue += FIZZ;
        }
        if (isMultipleOfFive(number)) {
            returnValue += BUZZ;
        }

        return returnValue.length() == 0 ? originalNumber: returnValue;
    }

    private boolean isMultipleOfThree(int number) {
        return number % FIZZ_NUMBER == 0;
    }

    private boolean isMultipleOfFive(int number) {
        return number % BUZZ_NUMBER == 0;
    }



}
