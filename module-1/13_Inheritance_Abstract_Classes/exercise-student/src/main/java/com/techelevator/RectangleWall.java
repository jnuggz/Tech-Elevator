package com.techelevator;

public class RectangleWall extends Wall{

    private int length;
    private int height;

    //Constructor
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    //Method
    //getArea() returns the length x height
    public int getArea() {
        int area = length * height;
        return area;
    }

    public String toString() {
        return getName() + " (" + length + "x" + height +") " + "rectangle";
    }

    //Getter
    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }
}
