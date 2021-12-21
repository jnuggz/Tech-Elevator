package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Test {

    private MaxEnd3 maxEnd3;

    @Before
    public void setup() {
        maxEnd3 = new MaxEnd3();
    }

    /*
         Larger Value           Cloned Element
         [1, 2, 3]              [3, 3, 3]
         [5, 2, 1]              [5, 5, 5]
         [4, 3, 4]              [4, 4, 4]
     */

    @Test
    public void first_element_in_array_is_largest() {
        int[] firstElement = new int[] {3, 2, 1};
        int[] expectedResult = new int[]{3, 3, 3};
        int[] actualResult = maxEnd3.makeArray(expectedResult);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void last_element_in_array_is_largest() {
        int[] lastElement = new int[] {1, 2, 5};
        int[] expectedResult = new int[] {5, 5, 5};
        int[] actualResult = maxEnd3.makeArray(expectedResult);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void first_and_last_element_same() {
        int[] lastElement = new int[] {4, 2, 4};
        int[] expectedResult = new int[] {4, 4, 4};
        int[] actualResult = maxEnd3.makeArray(expectedResult);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}
