package com.techelevator.fizzbuzz;

/*
    Fizz for multiple of 3
    Buzz for multiple of 5
    FizzBuzz for multiple of 3 and 5
    Original number when not a multiple of 3 and 5
    Fizz works for negative numbers
    Buzz works for negative numbers

 */

import org.junit.*;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void fizz_returned_for_multiple_of_3() {
        String result = fizzBuzz.fizzBuzzIt(3);
        Assert.assertEquals("Fizz", result);
        Assert.assertEquals("Fizz", fizzBuzz.fizzBuzzIt(12));
        Assert.assertEquals("Fizz", fizzBuzz.fizzBuzzIt(33));
    }

    @Test
    public void buzz_returned_for_multiple_of_5() {
        Assert.assertEquals("Buzz", fizzBuzz.fizzBuzzIt(5));
        Assert.assertEquals("Buzz", fizzBuzz.fizzBuzzIt(20));
    }

    @Test
    public void fizzbuzz_returned_for_multiple_of_3_and_5() {
        Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzzIt(15));
    }

    @Test
    public void number_returned_when_not_multiple_of_3_or_5() {
        Assert.assertEquals("7", fizzBuzz.fizzBuzzIt(7));
    }
}
