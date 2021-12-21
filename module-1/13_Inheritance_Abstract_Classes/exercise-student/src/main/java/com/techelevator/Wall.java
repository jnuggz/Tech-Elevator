package com.techelevator;

public abstract class Wall {

    private String name;
    private String color;

    //Constructor
    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }

    //getArea() will be implemented by subclasses
    //method needs to be abstract
    public abstract int getArea();

    //Getter
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
