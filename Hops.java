package edu.ncsu.csc.csc216.heckman_brewery.ingredients;

import java.util.ArrayList;


/**
 * Container class for ingredients that are different types of hops
 * The units for amount is ounces
 * @author SarahHeckman
 */
public class Hops extends FlavoredBeerIngredient {
	
	/**
	 * Constructs a Hops object with the specified values
	 * @param type of ingredient
	 * @param amount of ingredient
	 * @param addTime of ingredient
	 * @param flavors of ingredient
	 */
	public Hops(String type, double amount, double addTime, ArrayList<String> flavors) {
		super(type, amount, addTime, flavors);
	}

	@Override
	public String toString() {
		return "Hops [" + super.toString() + "]";
	}
	
	@Override
	public int compareTo(BeerIngredient o) {
		return toString().compareTo(o.toString());
	}
	
}
