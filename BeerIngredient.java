package edu.ncsu.csc.csc216.heckman_brewery.ingredients;

/**
 * Top level of the BeerIngredient hierarchy
 * @author SarahHeckman
 */
public class BeerIngredient implements Comparable<BeerIngredient> {
	
	/** Type of ingredient */
	private String type;
	/** 
	 * Amount of the ingredient to add - units are specific to
	 * the ingredient
	 */
	private double amount;
	/**
	 * Time to add the ingredient to the boil.  The boil starts
	 * at 60 and counts down to 0
	 */
	private double addTime;
		
	/**
	 * Creates a BeerIngredient with the specified attributes
	 * @param type of beer ingredient
	 * @param amount of ingredient
	 * @param addTime of ingredient to the boil
	 */
	public BeerIngredient(String type, double amount, double addTime) {
		this.type = type;
		this.amount = amount;
		this.addTime = addTime;
	}

	/**
	 * Returns the type of BeerIngredient
	 * @return type of BeerIngredient
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the amount of BeerIngredient
	 * @return amount of BeerIngredient
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Returns the add time of BeerIngredient
	 * @return add time for BeerIngredient
	 */
	public double getAddTime() {
		return addTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(addTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BeerIngredient other = (BeerIngredient) obj;
		if (Double.doubleToLongBits(addTime) != Double
				.doubleToLongBits(other.addTime))
			return false;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeerIngredient [type=" + type + ", amount=" + amount
				+ ", addTime=" + addTime + "]";
	}

	@Override
	public int compareTo(BeerIngredient o) {
		return toString().compareTo(o.toString());
	}

}
