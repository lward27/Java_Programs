package edu.ncsu.csc.csc216.heckman_brewery.beer;

import java.util.ArrayList;
import java.util.Collection;

import edu.ncsu.csc.csc216.heckman_brewery.ingredients.BeerIngredient;
import edu.ncsu.csc.csc216.heckman_brewery.ingredients.Yeast;

/**
 * Container class for Ales.  Ales extends the Beer class and implements
 * Beer's abstract method for adding and ingredient.
 * @author SarahHeckman
 *
 */
public class Ale extends Beer {
	
	private Collection<BeerIngredient> ingredients;
	
	/**
	 * Constructs a new Ale object
	 * @param name
	 */
	public Ale(String name) {
		super(name);
		ingredients = new ArrayList<BeerIngredient>();
	}

	@Override
	public boolean addIngredient(BeerIngredient i) {
		if (i instanceof Yeast) {
			Yeast y = (Yeast)i;
			if (y.getLowerFermentationTemp() >= 70) {
				ingredients.add(i);
				return true;
			} else {
				return false;
			}
		} else {
			ingredients.add(i);
			return true;
		}
	}
	
	@Override
	public Collection<BeerIngredient> getIngredients() {
		return ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((ingredients == null) ? 0 : ingredients.hashCode());
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
		Ale other = (Ale) obj;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ale [ingredients=" + ingredients + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int compareTo(Beer o) {
		return toString().compareTo(o.toString());
	}

}
