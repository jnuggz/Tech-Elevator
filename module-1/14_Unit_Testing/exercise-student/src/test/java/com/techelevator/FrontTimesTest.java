package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {

    private FrontTimes frontTimes;

    @Before
    public void setup() {
        frontTimes = new FrontTimes();
    }

    /*
    *   Character Length        Copies
    *   Alabama (3+)            2       ->AlaAla
    *   Hi (2)                  4       ->HiHiHiHiHi
    *   a (1)                   3       ->aaa
    *   null                    2       ->unknown
    *   ""                      3       ->unknown
    * */

    @Test
    public void make_copies_for_string_length_3_or_greater() {
        String makeCopies = frontTimes.generateString("Alabama", 2);
        Assert.assertEquals("AlaAla", makeCopies);
    }

    @Test
    public void make_copies_for_string_length_2() {
        String makeCopies = frontTimes.generateString("Hi", 4);
        Assert.assertEquals("HiHiHiHi", makeCopies);
    }

    @Test
    public void make_copies_for_string_length_1() {
        String makeCopies = frontTimes.generateString("a", 3);
        Assert.assertEquals("aaa", makeCopies);
    }

    @Test
    public void make_copies_for_string_empty_string() {
        String makeCopies = frontTimes.generateString("", 2);
        Assert.assertEquals("unknown", makeCopies);
    }

    @Test
    public void make_copies_for_string_null() {
        String makeCopies = frontTimes.generateString(null, 2);
        Assert.assertEquals("unknown", makeCopies);
    }

}

