package edu.ncsu.csc.csc216.heckman_brewery.ingredients;


/**
 * Container class for ingredients that are different types of water
 * The units for amount is gallons
 * @author SarahHeckman
 */
public class Water extends BeerIngredient {
	
	/**
	 * pH of water to add to Beer 
	 */
	private double ph;
	
	/**
	 * Constructs a Water object with the specified values
	 * @param type
	 * @param amount
	 * @param addTime
	 * @param ph
	 */
	public Water(String type, double amount, double addTime, double ph) {
		super(type, amount, addTime);
		this.ph = ph;
	}
	
	/**
	 * Returns the pH of the water
	 * @return the pH of the water
	 */
	public double getPh() {
		return ph;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(ph);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Water other = (Water) obj;
		if (Double.doubleToLongBits(ph) != Double.doubleToLongBits(other.ph))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Water [ph=" + ph + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public int compareTo(BeerIngredient o) {
		return toString().compareTo(o.toString());
	}

}
