package edu.ncsu.csc.csc216.heckman_brewery;

import java.util.Vector;

import edu.ncsu.csc.csc216.heckman_brewery.beer.Beer;

public class Brewery {
	
	private static Brewery instance;
	private Vector<Beer> beersOnTap;
	
	private Brewery() {
		beersOnTap = new Vector<Beer>();
	}
	
	public static Brewery getInstance() {
		if (instance == null) {
			instance = new Brewery();
		}
		return instance;
	}
	
	public void addBeer(Beer beer) {
		beersOnTap.add(beer);
	}
	
	public Vector<Beer> getBeers() {
		return beersOnTap;
	}

}
