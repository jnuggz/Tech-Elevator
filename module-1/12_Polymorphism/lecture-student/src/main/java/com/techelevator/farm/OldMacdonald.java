package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		//For loop
		//When instantiating, Cow and Chicken class already extends FarmAnimal
		//Changed FarmAnimal to Singable and itemsForSale to singable
		Singable[] singers = new Singable[]{new Cow(), new Chicken(),
				new Sheep(), new Tractor(), new MusicBox()};

		//For Each loop
		for (Singable singer : singers) {
			String name = singer.getName();
			String sound = singer.getSound();

			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		//ArrayList implementation class
		List<Sellable> itemsForSale = new ArrayList<Sellable>();
		itemsForSale.add(new Cow());
		itemsForSale.add(new Chicken());
		itemsForSale.add(new Sheep());
		itemsForSale.add(new Egg());
		itemsForSale.add(new MusicBox());


		System.out.println();
		System.out.println("Items for sale: ");
		for (Sellable item : itemsForSale) {
			System.out.println(item.getName() + " $" + item.getPrice());
		}

		/*
			Casting
				widening or casting to a more generic type, is
				done implicitly
				This is called Upcasting (because we are casting
				Up the hierarchy from the more specific to the
				more general
		 */
		/*
			Chicken has access to everything:
			getName()
			getSound()
			getPrice()
			layEgg()
		 */
		Chicken chicken = new Chicken();
		/*
			When chicken cast to FarmAnimal, chicken can only access:
			getName()
			getSound()
			getPrice()
		 */
		FarmAnimal chickenAsFarmAnimal = chicken;
		/*
			When chicken cast to Sellable, chicken can only access:
			getName()
			getPrice()
		 */
		Sellable chickenAsSellable = chicken;
		/*
			When chicken cast to Singable, check can only access:
			getName()
			getSound()
		 */
		Singable chickenAsSingable = chicken;

		/*
			Casting
			When narrowing or going to the more specific, must
			be explicit
			This is called Downcasting (because we are casting
			down from the more general from the more specific)
		 */
		Singable chickenSinger = new Chicken();

		Singable tractorSinger = new Tractor();

		/*
			Can cast the chicken into a Sellable
		 */
		Sellable chickenSellable = (Sellable)chickenSinger;

		/*
			Casting the tractor to Sellable will result in a
			ClassCastException at runtime, because Tractor
			does not implement the Sellable interface
		 */

		//Sellable tractorSellable = (Sellable)tractorSinger;

		/*
			Can also cast the chickenSinger into a FarmAnimal or a Chicken
		 */
		FarmAnimal chickenFarmAnimal = (FarmAnimal) chickenSinger;
		Chicken backToChicken = (Chicken) chickenSinger;


		/*When .equals is called on tractorOne and passed tractorTwo
			then in the method
				The this keyword refers to tractorOne
				the obj variable contains tractorTwo
		 */
		Tractor tractorOne = new Tractor();
		Tractor tractorTwo = tractorOne;
		tractorOne.equals(tractorTwo);

	}
}
