package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {

    private Lucky13 lucky13;

    @Before
    public void setup() {
        lucky13 = new Lucky13();
    }

    /*
    *   Array                   Result
    *   contains no 1's         True
    *   contains no 3's         True
    *   contains no 1's & 3's   True
    *   no array                False
    *   contains 1's & 3's      False
    */



    @Test
    public void array_contains_no_ones(){
        //Act
        int[] intArray = new int[]{0, 2, 4};
        boolean containsNoOnes = lucky13.getLucky(intArray);
        //Assert
        Assert.assertTrue(containsNoOnes);
    }

    @Test
    public void array_contains_no_threes() {
        int[] intArray = new int[] {2, 4, 6};
        boolean containsNoThrees = lucky13.getLucky(intArray);
        Assert.assertTrue(containsNoThrees);
    }

    @Test
    public void array_contains_no_ones_and_threes() {
        int[] intArray = new int[] {5, 7, 9};
        boolean containsNoOnesAndThrees = lucky13.getLucky(intArray);
        Assert.assertTrue(containsNoOnesAndThrees);
    }

    @Test
    public void array_contains_ones_and_or_threes() {
        int[] intArray = new int[] {1, 2, 3};
        boolean containsBothOnesAndThrees = lucky13.getLucky(intArray);
        Assert.assertFalse(containsBothOnesAndThrees);
    }

    @Test
    public void array_contains_empty_array() {
        int[] intArray = new int[] {};
        boolean containsNoArray = lucky13.getLucky(intArray);
        Assert.assertFalse(containsNoArray);
    }
}