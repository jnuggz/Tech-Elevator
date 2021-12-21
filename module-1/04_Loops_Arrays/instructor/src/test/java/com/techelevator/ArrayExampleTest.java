package com.techelevator;

import org.junit.*;

public class ArrayExampleTest {

    private Exercises target;

    @Before
    public void setup() {
        target = new Exercises();
    }
    @After
    public void cleanup() {

    }

    @Test
    public void last_value_largest() {
        // Arrange
        int[] testValue = { 1, 2, 3 };
        int[] expectedResult = { 3, 3, 3 };

        // Act
        int[] actualResult = target.maxEnd3(testValue);

        // Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

}
