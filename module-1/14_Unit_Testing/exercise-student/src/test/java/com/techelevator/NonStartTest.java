package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {

    private NonStart nonStart;

    @Before
    public void setup() {
        nonStart = new NonStart();
    }

    /*
        Strings                 Concatenation Omitted
        ("hot", "wheels")       "otheels"
        ("hi", "no")            "io"
        ("a", "b")              ""
        ("", "go")              "o"
        ("gun", "")             "un"
        ("", "")                ""
     */


    @Test
    public void return_string_without_first_element(){
        //Act
        String partialString = nonStart.getPartialString("hot", "wheels");

        //Assert
        Assert.assertEquals("otheels", partialString);
    }

    @Test
    public void return_second_string_no_first_string() {
        String partialString = nonStart.getPartialString("", "go");
        Assert.assertEquals("o", partialString);
    }

    @Test
    public void return_first_string_no_second_string() {
        String partialString = nonStart.getPartialString("gun", "");
        Assert.assertEquals("un", partialString);
    }

    @Test
    public void return_no_first_string_no_second_string() {
        String noString = nonStart.getPartialString("", "");
        Assert.assertEquals("", noString);
    }


}
