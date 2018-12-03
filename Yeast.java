package edu.ncsu.csc.csc216.heckman_brewery.ingredients;

import java.util.ArrayList;


/**
 * Container class for ingredients that are different types of yeast
 * The units for amount is milliliters
 * @author SarahHeckman
 */
public class Yeast extends FlavoredBeerIngredient {
	
	/**
	 * Lower bound of temp required for yeast to ferment the beer
	 */
	private int lowerFermentationTemp;
	/**
	 * Upper bound of temp required for yeast to ferment the beer
	 */
	private int upperFermentationTemp;
	
	/**
	 * Creates a Yeast object with the specified values
	 * @param type of ingredient
	 * @param amount of ingredient
	 * @param addTime of ingredient
	 * @param flavors of ingredient
	 * @param lowerFermentationTemp of ingredient
	 * @param upperFermentationTemp of ingredient
	 */
	public Yeast(String type, double amount, double addTime, ArrayList<String> flavors, 
			int lowerFermentationTemp, int upperFermentationTemp) {
		super(type, amount, addTime, flavors);
		this.lowerFermentationTemp = lowerFermentationTemp;
		this.upperFermentationTemp = upperFermentationTemp;
	}

	/**
	 * Returns the lower fermentation temp for the yeast
	 * @return lower fermentation temp
	 */
	public int getLowerFermentationTemp() {
		return lowerFermentationTemp;
	}

	/**
	 * Returns the upper fermentation temp for the yeast
	 * @return upper fermentation temp
	 */
	public int getUpperFermentationTemp() {
		return upperFermentationTemp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + lowerFermentationTemp;
		result = prime * result + upperFermentationTemp;
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
		Yeast other = (Yeast) obj;
		if (lowerFermentationTemp != other.lowerFermentationTemp)
			return false;
		if (upperFermentationTemp != other.upperFermentationTemp)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Yeast [lowerFermentationTemp=" + lowerFermentationTemp
				+ ", upperFermentationTemp=" + upperFermentationTemp
				+ ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public int compareTo(BeerIngredient o) {
		return toString().compareTo(o.toString());
	}

}
