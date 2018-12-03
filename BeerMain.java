package edu.ncsu.csc.csc216.heckman_brewery;

import java.util.ArrayList;

import edu.ncsu.csc.csc216.heckman_brewery.beer.Ale;
import edu.ncsu.csc.csc216.heckman_brewery.beer.Beer;
import edu.ncsu.csc.csc216.heckman_brewery.ingredients.Hops;
import edu.ncsu.csc.csc216.heckman_brewery.ingredients.Maltose;
import edu.ncsu.csc.csc216.heckman_brewery.ingredients.Water;
import edu.ncsu.csc.csc216.heckman_brewery.ingredients.Yeast;

/**
 * Main class that creates a Beer (in this case a Pale Ale)
 * and adds ingredients to the beer.  The BeerIngredients are
 * then printed to the console. 
 * 
 * This project demonstrates inheritance and polymorphism.
 * 
 * @author SarahHeckman
 */
public class BeerMain {
	
	/**
	 * Starts the program
	 * @param args
	 */
	public static void main(String [] args) {
		//Creates the flavors ArrayLists that are passed
		//to constructors of FlavoredBeerIngredients
		ArrayList<String> yeastFlavors = new ArrayList<String>();
		yeastFlavors.add("dry");
		yeastFlavors.add("crisp");
		yeastFlavors.add("slightly tart");
		yeastFlavors.add("fruity");
		yeastFlavors.add("well-balanced");
		
		ArrayList<String> centennialHopsFlavors = new ArrayList<String>();
		centennialHopsFlavors.add("bittering");
		
		ArrayList<String> cascadeHopsFlavors = new ArrayList<String>();
		cascadeHopsFlavors.add("grapefruit");
		
		ArrayList<String> maltFlavors = new ArrayList<String>();
		maltFlavors.add("medium-bodied");

		//Create a new beer
		Beer b = new Ale("Pale Ale");
		//Add ingredients to the Beer
		b.addIngredient(new Water("Tap", 4, 60, 6.5));
		b.addIngredient(new Water("Mineral", 3, 0, 7.0));
		b.addIngredient(new Yeast("British Ale Liquid Yeast", 125, 0, yeastFlavors, 70, 85));
		b.addIngredient(new Hops("Centennial", 1, 60, centennialHopsFlavors));
		b.addIngredient(new Hops("Cascade", 1, 15, cascadeHopsFlavors));
		b.addIngredient(new Hops("Cascade", 1, 5, cascadeHopsFlavors));
		b.addIngredient(new Maltose("British Pale Ale Malt", 3.3, 60, maltFlavors, "dry"));
		
		//Get the ingredients list and print the information 
		//about each ingredient.  Pay attention to how the output 
		//of the getType() method changes depending on the underlying 
		//type of object currently in the for loop.  The getType()
		//method that is called is the one for the underlying object
		//That's polymorphism!
//		ArrayList<BeerIngredient> ingredients = b.getIngredients();
//		for (int i = 0; i < ingredients.size(); i++) {
//			System.out.println(ingredients.get(i).toString());
//		}
	}
}
