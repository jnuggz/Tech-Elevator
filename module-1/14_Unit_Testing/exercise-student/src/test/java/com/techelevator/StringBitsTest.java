package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {

    private StringBitsTest stringBitsTest;

    @Before
    public void setup() {
        stringBitsTest = new StringBitsTest();
    }

    /*
        String              New String
        "Laptop"            "Lpo"
        "No"                "N"
        ""                  ""
        null                null
     */

    @Test
    public void return_new_string_every_other_char() {
        StringBits newString = new StringBits();
        String everyOther = newString.getBits("Laptop");
        Assert.assertEquals("Lpo", everyOther);
    }

    @Test
    public void return_new_string_empty_string() {
        StringBits newString = new StringBits();
        String everyOther = newString.getBits("");
        Assert.assertEquals("", everyOther);
    }

    @Test
    public void return_new_string_null() {
        StringBits newString = new StringBits();
        String everyOther = newString.getBits(null);
        Assert.assertNull(null, everyOther);
    }


}
