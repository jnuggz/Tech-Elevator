package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Test {

    private Less20 less20;

    @Before
    public void setup() {
        less20 = new Less20();
    }

    /*
    *   Int     Return
    *   40      false
    *   39      true
    *   38      true
    *   17      false
    *   41      false
    */

    @Test
    public void if_integer_is_multiple_of_20() {
        boolean trueMultiple = less20.isLessThanMultipleOf20(20);
        Assert.assertFalse(trueMultiple);
    }

    @Test
    public void if_integer_is_one_less_multiple_of_20() {
        boolean oneLess = less20.isLessThanMultipleOf20(39);
        Assert.assertTrue(oneLess);
    }

    @Test
    public void if_integer_is_two_less_multiple_of_20() {
        boolean twoLess = less20.isLessThanMultipleOf20(38);
        Assert.assertTrue(twoLess);
    }

    @Test
    public void if_integer_is_three_less_multiple_of_20() {
        boolean threeLess = less20.isLessThanMultipleOf20(17);
        Assert.assertFalse(threeLess);
    }

    @Test
    public void if_integer_is_one_more_multiple_of_20() {
        boolean oneMore = less20.isLessThanMultipleOf20(41);
        Assert.assertFalse(oneMore);
    }

}

