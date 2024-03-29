package com.techelevator.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SleepInTest {

    /*
        Declare a variable to reference the class we are testing
     */
    private SleepIn sleepIn;


    /*
        Create a method and instantiate the object we are testing assigning to the variable
        created above. This method must be marked with the @Before annotation so that it
        runs before each test.
     */

    @Before
    // Every Before test should instantiate the class
    public void setup(){
        sleepIn = new SleepIn();
    }

    @After
    public void cleanup() {
        // This test has nothing to cleanup, so this is optional
    }


    /*
       weekday      vacation
       true         false           -> false
       true         true
       false        false
       false        true
     */

    /*
        The @Test annotation marks a method to be run as a test
     */

    //@Before will runs before each test to do setup
    @Test
    public void not_sleepin_when_not_vacation_and_not_weekday() {
        // Arrange (setup)
            // this method doesn't need any steps to prepare it
        // Act (test)
        boolean result = sleepIn.sleepIn(true, false);
        // Assert (verify)
        // can also use Assert.assertTrue or .assertFalse
        Assert.assertFalse("SleepIn true when should be false", result);
    }
    //@After will run after each test to cleanup

    @Test
    public void sleepin_when_weekend_and_vacation() {
        // Arrange
        // Act
        boolean result = sleepIn.sleepIn(true, true);
        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void sleepin_when_not_weekday_and_not_vacation() {
        // Arrange
        // Act
        boolean result = sleepIn.sleepIn(false, false);
        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void sleepin_when_not_weekday_and_vacation() {
        // Arrange
        // Act and Assert
        Assert.assertTrue(sleepIn.sleepIn(false, true));
    }










}


