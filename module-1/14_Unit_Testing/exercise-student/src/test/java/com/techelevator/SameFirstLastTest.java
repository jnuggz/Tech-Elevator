package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {

    private SameFirstLast sameFirstLast;

    @Before
    public void setup() {
        sameFirstLast = new SameFirstLast();
    }


    /*
        Arrays          Result
        [2, 3, 2]       True
        [5, 2 ,9]       False
        [2, 2]          True
        [6, 7]          False
        [1]             False
     */

    @Test
    public void first_and_last_element_same() {
        int[] array = new int[] {2, 3, 2};
        boolean result = sameFirstLast.isItTheSame(array);
        Assert.assertTrue(result);
    }

    @Test
    public void first_and_last_element_not_same() {
        int[] array = new int[] {5, 3, 9};
        boolean result = sameFirstLast.isItTheSame(array);
        Assert.assertFalse(result);
    }

    @Test
    public void array_length_two_same() {
        int[] array = new int[] {2, 2};
        boolean result = sameFirstLast.isItTheSame(array);
        Assert.assertTrue(result);
    }

    @Test
    public void array_length_two_not_same() {
        int[] array = new int[] {6, 7};
        boolean result = sameFirstLast.isItTheSame(array);
        Assert.assertFalse(result);
    }
    @Test
    public void array_length_one() {
        int[] array = new int[] {2};
        boolean result = sameFirstLast.isItTheSame(array);
        Assert.assertTrue(result);
    }
}
