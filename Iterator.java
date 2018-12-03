package edu.ncsu.csc.csc216.wolftours.tour_stop;

/**
 * Interface that defines the methods that a List Iterator should implement. An
 * iterator starts at a specified point in the list and moves forwards and
 * backwards from the current TourStop if able.
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public interface Iterator {

	/**
	 * Constant the identifies the iterator
	 */
	public static final String TOUR_STOP_LIST_ITERATOR = "iterator";

	/**
	 * Returns true if the next TourStop in the list is not null.
	 * 
	 * @return true if the next TourStop is not null
	 */
	public boolean hasNext();

	/**
	 * Returns the next TourStop in the list or null if there is no next
	 * TourStop
	 * 
	 * @return the next TourStop in the list
	 */
	public TourStop next();

	/**
	 * Returns true if the previous TourStop in the list is not null
	 * 
	 * @return true if the previous TourStop is not null
	 */
	public boolean hasPrev();

	/**
	 * Returns the previous TourStop in the list or null if there is no previous
	 * TourStop
	 * 
	 * @return
	 */
	public TourStop prev();

}
