package com.techelevator.farm;

public class Sheep extends FarmAnimal {

    public Sheep() {
        super("Sheep", "Baa!",300 );
    }

    @Override
    public String eat() {
        return "The sheep eats";
    }
}
