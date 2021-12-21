package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	//Constructor was inherited using super
	public Chicken() {
		super("Chicken", "cluck!", 15);
	}

	//Method
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}