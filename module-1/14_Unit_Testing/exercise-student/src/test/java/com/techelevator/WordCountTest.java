package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    private WordCount wordCount;

    @Before
    public void setup() {
        wordCount = new WordCount();
    }

    /*
        ["hi", "hi", "bye", "hello"]        {"hi": 2, "bye": 1, "hello": 1}
        ["l", "m", "m", "n"]                {"l": 1, "m": 2, "n": 1}
        []                                  {}
        [null]                              {null]
     */

    @Test
    public void number_of_times_array_appears() {
        //Arrange
        String[] wordStrings = {"hi", "hi", "bye", "hello"};
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("hi", 2);
        myMap.put("bye", 1);
        myMap.put("hello", 1);
        //Act
        Map<String, Integer> actualResults = wordCount.getCount(wordStrings);
        //Assert
        Assert.assertEquals(myMap, actualResults);

    }

    @Test
    public void empty_string_array() {
        String[] emptyArray = {};
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("", 3);

        Map<String, Integer> getCount = wordCount.getCount(emptyArray);
        Assert.assertTrue(myMap.keySet().containsAll(getCount.keySet()));
    }

    @Test
    public void null_string_array() {
        String[] nullArray = {null};
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put(null, 1);

        Map<String, Integer> getCount = wordCount.getCount(nullArray);
        Assert.assertTrue(myMap.keySet().containsAll(getCount.keySet()));
    }
}
