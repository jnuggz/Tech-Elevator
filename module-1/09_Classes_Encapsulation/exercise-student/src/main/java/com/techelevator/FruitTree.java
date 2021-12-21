package com.techelevator;

public class FruitTree {

    //Member Variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    //Constructor
    public FruitTree(String typeOfFruit, int piecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruit;
    }

    //Method
   public boolean pickFruit (int numberOfPiecesToRemove){
        if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        }else
       return false;
    }

    //Getter
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }
}
