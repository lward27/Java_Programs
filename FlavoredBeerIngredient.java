package edu.ncsu.csc.csc216.heckman_brewery.ingredients;

import java.util.ArrayList;


/**
 * Container class for FlavoredBeerIngredient that
 * extends BeerIngredient but also tracks the flavors
 * the ingredient adds to the Beer
 * @author SarahHeckman
 */
public class FlavoredBeerIngredient extends BeerIngredient {
	
	/**
	 * Stores a description of the flavors an ingredient
	 * imparts to the Beer
	 */
	private ArrayList<String> flavors;
		
	/**
	 * Constructs a FlavoredBeerIngredient with the specified values
	 * @param type of ingredient
	 * @param amount of ingredient
	 * @param addTime of ingredient
	 * @param flavors of ingredient
	 */
	public FlavoredBeerIngredient(String type, double amount, double addTime, ArrayList<String> flavors) {
		super(type, amount, addTime);
		this.flavors = flavors;
	}
	
	/**
	 * Returns the list of flavors of the ingredient
	 * @return the list of flavors of the ingredient
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> getFlavors() {
		return (ArrayList<String>) flavors.clone();
	}
	
	/**
	 * Overrides BeerIngredient's getType method to also 
	 * print the flavors.  
	 * @return the type of the ingredient and flavors
	 */
	public String getType() {
		return super.getType() + " " + flavors.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((flavors == null) ? 0 : flavors.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlavoredBeerIngredient other = (FlavoredBeerIngredient) obj;
		if (flavors == null) {
			if (other.flavors != null)
				return false;
		} else if (!flavors.equals(other.flavors))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlavoredBeerIngredient [flavors=" + flavors + ", toString()="
				+ super.toString() + "]";
	}
	
	@Override
	public int compareTo(BeerIngredient o) {
		return toString().compareTo(o.toString());
	}
	
}
