package com.techelevator.farm;

/*
Marking a class final prevents it from becoming a superclass, meaning
no other classes can extend.
 */
public final class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "Meow", 0);
    }

    @Override
    public String eat() {
        return "The cat eats";
    }

    /*
        getSound() cannot be Overriden because it is final
     */
//    @Override
//    public String getSound() {
//        return "MEOW!!!!!";
//    }
}
