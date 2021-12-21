package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {

    private CigarParty cigarParty;

    @Before
    public void setup() {
        cigarParty = new CigarParty();
    }

    /*
    *   Cigars      isWeekend
    *   30          False   -> False
    *   50          False   -> True
    *   70          True    -> True
    *   20          True    -> False
    *   45          True    -> True
    * */

    @Test
    public void party_unsuccessful_cigars_out_of_range_not_weekend(){
        //Act
        boolean haveParty = cigarParty.haveParty(30, false);
        //Assert
        Assert.assertFalse(haveParty);
    }

    @Test
    public void party_successful_cigars_in_range_not_weekend() {
        //Act
        boolean haveParty = cigarParty.haveParty(50, false);
        //Assert
        Assert.assertTrue(haveParty);
    }

    @Test
    public void party_successful_cigars_in_range_is_weekend() {
        //Act
        boolean haveParty = cigarParty.haveParty(70, true);
        //Assert
        Assert.assertTrue(haveParty);
    }

    @Test
    public void party_unsuccessful_cigars_out_of_range_is_weekend() {
        boolean haveParty = cigarParty.haveParty(20, true);
        Assert.assertFalse(haveParty);
    }

    @Test
    public void party_successful_cigar_in_range_is_weekend() {
        boolean haveParty = cigarParty.haveParty(45, true);
        Assert.assertTrue(haveParty);
    }
}
