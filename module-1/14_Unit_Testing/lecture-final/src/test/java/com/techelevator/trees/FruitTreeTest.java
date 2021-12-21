package com.techelevator.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {

    private FruitTree fruitTree;

    @Before
    public void setup() {
        fruitTree = new FruitTree("Pear", 10);
    }

    /*
        - pick 1 fruit
        - pick too many fruit
        - pick negative fruit
        pick zero fruit
        verify type of fruit
        pick exactly 10 fruit
        pick 5 fruit
        pick fruit multiple times
        - pick fruit and then try to pick too many
        pick some fruit, then the remaining

     */

    @Test
    public void pick_one_fruit() {
        // Arrange
        // Act
        boolean pickedSuccessfully = fruitTree.pickFruit(1);
        // Assert
        Assert.assertTrue(pickedSuccessfully);
        int fruitThatShouldRemainOnTree = 9;
        int fruitActuallyLeftOnTree = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(fruitThatShouldRemainOnTree, fruitActuallyLeftOnTree);
    }

    @Test
    public void pick_too_many_fruit() {
        // Arrange
        // Act
        boolean pickedSuccessfully = fruitTree.pickFruit(11);
        // Asserts
        // Verify the return was false
        Assert.assertFalse(pickedSuccessfully);
        // Verify the number on the fruitTree did not change
        Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_negative_fruit() {
        // Arrange
        // Act
        boolean pickedSuccessfully = fruitTree.pickFruit(-1);
        // Asserts
        Assert.assertFalse("Allowed negative fruit to be picked", pickedSuccessfully);
        String failureMessage = "Expected 10 but was " + fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(failureMessage,10, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_fruit_then_try_to_pick_too_many() {
        // Arrange
        // to arrange for our test to try to pick too many fruit on the second time, arrange the
        // the state class by picking some fruit
        fruitTree.pickFruit(3);

        // Act - try to pick too many fruit
        boolean pickedSuccessfully = fruitTree.pickFruit(8);
        // Asserts
        Assert.assertFalse(pickedSuccessfully);
        Assert.assertEquals(7, fruitTree.getPiecesOfFruitLeft());

    }
}
