package edu.ncsu.csc.csc216.heckman_brewery.beer;

import java.util.Collection;

import edu.ncsu.csc.csc216.heckman_brewery.ingredients.BeerIngredient;

/**
 * Beer contains a list of ingredients that are the 
 * recipe for making a particular Beer
 * @author SarahHeckman
 */
public abstract class Beer implements Brewable, Fermentable, Comparable<Beer> {
	
	private String name;
	
	/**
	 * Constructs a Beer object to initialize the fields.
	 * A Beer object can never be instantiated b/c the class
	 * is abstract
	 */
	public Beer(String name) {
		this.name = name;
	}
	
	/**
	 * Adds an ingredient to the list
	 * @param i ingredient to add to the list
	 */
	public abstract boolean addIngredient(BeerIngredient i);
	
	/**
	 * Returns the list of ingredients
	 * @return collection of ingredients
	 */
	public abstract Collection<BeerIngredient> getIngredients();
	
	/**
	 * Sets the beer's name
	 * @param name the name of the beer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the beer's name
	 * @return the name of the beer
	 */
	public String getName() {
		return name;
	}

	@Override
	public void brew() {
		System.out.println(name + " is brewing");
	}

	@Override
	public void ferment() {
		System.out.println(name + " is fermenting");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beer [name=" + name + "]";
	}

}
