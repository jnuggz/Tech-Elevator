package com.techelevator.farm;

/*
abstract class can be extended, but itself cannot be instantiated
abstract class can pass on functionality through inheritance like a superclass
abstract class can force an override in a subclass like an interface
abstract classes are still DataTypes
 */
public abstract class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private int price;
	private boolean isSleeping = false;

	public FarmAnimal(String name, String sound, int price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	/*
	An abstract method can only be in an abstract class
	and force a subclass of this class to Override with an implementation
	(like an interface does)
	 */
	public abstract String eat();


	public void sleep() {
		this.isSleeping = true;
	}
	public void wake() {
		this.isSleeping = false;
	}

	public String getName() {
		return name;
	}

	/*
	The final keyword on a method prevents a subclass
	from providing their own Override
	 */
	public final String getSound() {
		if (isSleeping) {
			return "Zzzzzzzz";
		}
		return sound;
	}

	public int getPrice() {
		return price;
	}

}