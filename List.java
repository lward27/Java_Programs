package edu.ncsu.csc.csc216.wolftours.tour_stop;

/**
 * Interface for Lists that defines all methods that a list should implement
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public interface List {

	/**
	 * Adds a TourStop to the end of the list
	 * 
	 * @param stop
	 *            TourStop to add to the end of the list
	 */
	public void add(TourStop stop);

	/**
	 * Adds a TourStop at the specified location. All other TourStops are
	 * shifted to the right
	 * 
	 * @param index
	 *            to add the TourStop at
	 * @param stop
	 *            TourStop to add to the end of the list
	 */
	public void add(int index, TourStop stop);

	/**
	 * Clears all TourStops from the list
	 */
	public void clear();

	/**
	 * Returns true if the list contains the TourStop
	 * 
	 * @param stop
	 *            true if the list contains the TourStop
	 * @return
	 */
	public boolean contains(TourStop stop);

	/**
	 * Returns the TourStop at the specified index or null if there is no
	 * TourStop at the specified index.
	 * 
	 * @param index
	 *            of TourStop to get
	 * @return TourStop at the specified index or null
	 */
	public TourStop get(int index);

	/**
	 * Returns the index in the list containing the specified TourStop or -1 if
	 * the TourStop does not exit.
	 * 
	 * @param stop
	 *            TourStop to find in the list
	 * @return the index of the TourStop or -1
	 */
	public int indexOf(TourStop stop);
	  

	/**
	 * Returns the index in the list containing the TourStop represented by the
	 * unique id or -1 if the TourStop does not exist. Each TourStop has a
	 * unique id that identifies the TourStop in the database. The unique id is
	 * different than the TourStop's location (index) in the list.
	 * 
	 * @param id
	 *            of the TourStop
	 * @return the index of the TourStop or -1
	 */
	
	public int indexOfById(long id);

	/**
	 * Returns true if the list is empty.
	 * 
	 * @return true if the list is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns an iterator for the list.
	 * 
	 * @return an iterator for the list
	 */
	public Iterator iterator();

	/**
	 * Removes the TourStop at the specified index
	 * 
	 * @param index
	 *            of the TourStop to remove
	 */
	public void remove(int index);
		

	/**
	 * Sets the TourStop at the specified index to the given TourStop (i.e. it
	 * overwrites the TourStop with the new information)
	 * 
	 * @param index
	 *            of the TourStop to overwrite
	 * @param stop
	 *            TourStop to store at the index
	 */
	public void set(int index, TourStop stop);

	/**
	 * Returns the size of the list
	 * 
	 * @return size of the list
	 */
	public int size();
		

	/**
	 * Moves the specified TourStop from it's current location in the list to
	 * the specified index.
	 * 
	 * @param index
	 *            to move the TourStop to
	 * @param stop
	 *            TourStop to move
	 */
	public void move(int index, TourStop stop);

	/**
	 * Returns the unique id of the TourStop preceding the specified TourStop in
	 * the list or -1 if the TourStop is the first stop in the list
	 * 
	 * @param stop
	 *            current TourStop
	 * @return id of preceding TourStop or -1
	 */
	public long getPrevId(TourStop stop);

	/**
	 * Returns the unique id of the TourStop following the specified TourStop in
	 * the list or -1 if the TourStop is the last stop in the list
	 * 
	 * @param stop
	 *            current TourStop
	 * @return id of following TourStop or -1
	 */
	public long getNextId(TourStop stop);

}
