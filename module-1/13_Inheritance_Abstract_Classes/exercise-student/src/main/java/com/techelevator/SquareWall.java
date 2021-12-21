package com.techelevator;

public class SquareWall extends RectangleWall{

    private int sideLength;

    //Constructor
    public SquareWall(String name, String color, int sideLength) {
        //the constructor in RectangleWall has 4 arguments
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    public String toString() {
        return getName() + " (" + sideLength + "x" + sideLength + ") " + "square";
    }







}
