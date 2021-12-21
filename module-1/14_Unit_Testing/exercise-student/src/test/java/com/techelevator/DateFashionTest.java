package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion dateFashion;

    @Before
    public void setup() {
        dateFashion = new DateFashion();
    }

    /*
    *   You (stylish)       Date (stylish)
    *   5                   8           -> 2 (get table)
    *   2                   5           -> 0 (don't get table)
    *   3                   5           -> 1 (maybe)
    *   2                   10          -> 0
    * */

    @Test
    public void get_table_if_one_person_is_very_stylish() {
        //Act
        int getTable = dateFashion.getATable(5, 8);
        //Assert
        Assert.assertEquals(2, getTable);
    }

    @Test
    public void do_not_get_table_if_one_person_is_not_stylish(){
        //Act
        int getTable = dateFashion.getATable(2, 6);
        //Assert
        Assert.assertEquals(0, getTable);
    }

    @Test
    public void possibly_get_table_if_both_are_somewhat_stylish() {
        int getTable = dateFashion.getATable(3, 5);
        Assert.assertEquals(1, getTable);
    }

    @Test
    public void do_not_get_table_if_one_person_is_not_stylish_but_other_is_stylish() {
        int getTable = dateFashion.getATable(2, 10);
        Assert.assertEquals(0, getTable);
    }
}
