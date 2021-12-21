package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class AnimalGroupNameTest {

    private AnimalGroupName animalGroupName;

    @Before
    public void setup() {
        animalGroupName = new AnimalGroupName();
    }

    /*
        Contains                        Output
        animal name (lower case)        group name
        animal name (upper case)        group name
        null                            unknown
        ""                              unknown
        different animal                unknown
     */


    @Test
    public void animal_name_lowercase_matches_group_name() {
        Assert.assertEquals("Crash", animalGroupName.getHerd("rhino"));
        Assert.assertEquals("Tower", animalGroupName.getHerd("giraffe"));
        Assert.assertEquals("Herd", animalGroupName.getHerd("elephant"));
        Assert.assertEquals("Herd", animalGroupName.getHerd("lion"));
        Assert.assertEquals("Murder", animalGroupName.getHerd("crow"));
        Assert.assertEquals("Kit", animalGroupName.getHerd("pigeon"));
        Assert.assertEquals("Pat", animalGroupName.getHerd("flamingo"));
        Assert.assertEquals("Herd", animalGroupName.getHerd("deer"));
        Assert.assertEquals("Pack", animalGroupName.getHerd("dog"));
        Assert.assertEquals("Float", animalGroupName.getHerd("crocodile"));
    }

    @Test
    public void animal_name_uppercase_matches_group_name() {
        Assert.assertEquals("Crash", animalGroupName.getHerd("RHINO"));
        Assert.assertEquals("Tower", animalGroupName.getHerd("GIRAFFE"));
        Assert.assertEquals("Herd", animalGroupName.getHerd("ELEPHANT"));
        Assert.assertEquals("Herd", animalGroupName.getHerd("LION"));
        Assert.assertEquals("Murder", animalGroupName.getHerd("CROW"));
        Assert.assertEquals("Kit", animalGroupName.getHerd("PIGEON"));
        Assert.assertEquals("Pat", animalGroupName.getHerd("FLAMINGO"));
        Assert.assertEquals("Herd", animalGroupName.getHerd("DEER"));
        Assert.assertEquals("Pack", animalGroupName.getHerd("DOG"));
        Assert.assertEquals("Float", animalGroupName.getHerd("CROCODILE"));
    }

    @Test
    public void animal_name_as_null() {
        Assert.assertEquals("Unknown", animalGroupName.getHerd("null"));
    }

    @Test
    public void animal_name_as_empty_string() {
        Assert.assertEquals("Unknown", animalGroupName.getHerd(""));
    }

    @Test
    public void different_animal_name_not_found() {
        Assert.assertEquals("Unknown", "Tiger");
    }


}
