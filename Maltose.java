package edu.ncsu.csc.csc216.heckman_brewery.ingredients;

import java.util.ArrayList;


/**
 * Container class for ingredients that are different types of maltose (sugar)
 * The units for amount is pounds (lbs)
 * @author SarahHeckman
 */
public class Maltose extends FlavoredBeerIngredient {
	
	/**
	 * Type or source of malt
	 */
	private String maltSource;
	
	/**
	 * Creates a Maltose object with the specified values
	 * @param type of ingredient
	 * @param amount of ingredient
	 * @param addTime of ingredient
	 * @param flavors of ingredient
	 * @param maltSource of ingredient
	 */
	public Maltose(String type, double amount, double addTime, ArrayList<String> flavors, String maltSource) {
		super(type, amount, addTime, flavors);
		this.maltSource = maltSource;
	}

	/**
	 * Returns the source/type of the maltose
	 * @return source/type of maltose
	 */
	public String getMaltSource() {
		return maltSource;
	}
	
	/**
	 * Overrides the getType() method of FlavoredBeerIngredient
	 * so that the malt source is printed in addition
	 * to the other getType information
	 * @return type of the maltose
	 */
	public String getType() {
		return super.getType() + " " + maltSource; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((maltSource == null) ? 0 : maltSource.hashCode());
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
		Maltose other = (Maltose) obj;
		if (maltSource == null) {
			if (other.maltSource != null)
				return false;
		} else if (!maltSource.equals(other.maltSource))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Maltose [maltSource=" + maltSource + ", toString()="
				+ super.toString() + "]";
	}
	
	@Override
	public int compareTo(BeerIngredient o) {
		return toString().compareTo(o.toString());
	}
}
