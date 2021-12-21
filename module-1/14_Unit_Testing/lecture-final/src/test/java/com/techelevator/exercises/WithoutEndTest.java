package com.techelevator.exercises;

import org.junit.*;

public class WithoutEndTest {

    private WithoutEnd target;

    @Before
    public void createWithoutEndObject() {
        target = new WithoutEnd();
    }

    /*
        Tests we should have:
        abcabc -> bcab
        abc -> b
        ab -> ""
        a -> ""
        null -> "" ??
        "" -> ""
     */

    @Test
    public void returns_middle_for_string_over_3_chars() {
        // Arrange
            // No arrange needed for this test
        // Act
        String result = target.withoutEnd("abcabc");
        // Assert
                            // expectedResult, actualResult
        Assert.assertEquals("bcab", result);
    }

    @Test
    public void returns_empty_string_for_empty_string() {
        // Arrange
        String expectedResult = "";
        // Act
        String actualResult = target.withoutEnd("");
        // Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void returns_emptry_string_for_null() {
        // Arrange
        // Act
        String actualResult = target.withoutEnd(null);
        // Assert
        Assert.assertEquals("", actualResult);
    }
}
