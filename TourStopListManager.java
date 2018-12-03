package edu.ncsu.csc.csc216.wolftours.tour_stop;

import edu.ncsu.csc.csc216.wolftours.db.WolfToursDbAdapter;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStop;
import android.content.Context;

/**
 * Singleton class that maintains an instance of itself and of the LinkedList.
 * Additionally, this class holds a reference to the database.
 * 
 * All operations to add, remove, update, and iterate through the list should
 * occur through TourStopListManager. This class allows for the update of both
 * the LinkedList object and the database when changes are made in the TourMaker
 * part of the program
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class TourStopListManager {

	/** Single instance of the TourStopListManager class */
	private static TourStopListManager instance;
	/** Reference to the list of TourStops */
	private List list;
	/**
	 * Reference to the database. The database must always be opened before
	 * calling any other database methods, and the database should always be
	 * closed before leaving the method!
	 */
	private WolfToursDbAdapter mDbHelper;
	/** Reference to the iterator */
	private Iterator iterator;

	/**
	 * Private constructor of a TourStopListManager that initializes the list
	 * and iterator to null and sets up the database connection with a Context
	 * passed from one of the Activity classes.
	 * 
	 * @param context
	 *            from an Activity class.
	 */
	private TourStopListManager(Context context) {
		list = null;
		iterator = null;
		mDbHelper = new WolfToursDbAdapter(context);
	}

	/**
	 * Returns a reference to the instance of the TourStopListManager that is
	 * generated with the given Context from an Activity class. If the instance
	 * has not yet been created (it's null), a new TourStopListManager is
	 * created. Then the instance is returned.
	 * 
	 * This implementation of the Singleton pattern is NOT thread safe. We can
	 * use this here, because our application is single threaded. If you are
	 * writing a multithreaded program and you want to use the singleton
	 * pattern, you'll need to study how to implement it in a thread-safe
	 * manner.
	 * 
	 * @param context
	 *            from an Activity class
	 * @return the single instance of TourStopListManager
	 */
	public static TourStopListManager getInstance(Context context) {
		if (instance == null) {
			instance = new TourStopListManager(context);
		}
		return instance;
	}

	/**
	 * Creates the list of TourStops from the database. NOTE: Remember to open
	 * and close the database.
	 */
	public void createTourStopList() {
		// Everyone
		// Open the database
		mDbHelper.open();

		// Creates a list of TourStops from the database
		list = mDbHelper.getTourStopList();

		// Closes the database
		mDbHelper.close();
	}

	/**
	 * Creates an iterator for the list
	 */
	public void createIterator() {
		// Lucas
		iterator = list.iterator();
	}

	/**
	 * Returns the next TourStop in the list or null if there is no next
	 * TourStop in the list. The next TourStop should come from the iterator.
	 * 
	 * @return the next TourStop in the list or null
	 */
	public TourStop getNext() {
		// Lucas
		if (iterator.hasNext() == true)
			return iterator.next();
		else
			return null;
	}

	/**
	 * Returns the previous TourStop in the list or null if there is no previous
	 * TourStop in the list. The previous TourStop should come from the
	 * iterator.
	 * 
	 * @return the previous TourStop in the list or null
	 */
	public TourStop getPrev() {
		// Lucas
		if (iterator.hasPrev() == true)
			return iterator.prev();
		else
			return null;
	}

	/**
	 * Returns true if the TourStop was successfully added to BOTH the database
	 * and the list.
	 * 
	 * The TourStop should be added to the database first so that the database
	 * id can be stored with the TourStop object in the list.
	 * 
	 * After adding the TourStop to the list, the updateTourStopListInDb()
	 * method should be called so that all previous and next references are
	 * updated.
	 * 
	 * NOTE: Remember to open and close the database.
	 * 
	 * @param stop
	 *            TourStop to add to the list
	 * @param index
	 *            to add the tour stop at
	 * @return true if the TourStop was successfully added to BOTH the database
	 *         and the list
	 */
	public boolean addTourStop(TourStop stop, int index) {
		// Will
		// open db
		mDbHelper.open();
		// add tourstop to db
		long dbId = mDbHelper.addTourStop(stop);
		// Check to see if it has the error value. If so, we don't want it in
		// our list!
		if (dbId == -1) {
			mDbHelper.close();
			return false;
		}
		// Set the stop's id.
		stop.set_id(dbId);
		mDbHelper.open();

		// Add TourStop to list
		list.add(index, stop);
		// Update list
		updateTourStopListInDb();
		mDbHelper.open();
		// Gets id in db and then checks to see if stop was successfully added
		// to the list
		TourStop addedTourStop = mDbHelper.getTourStopById(dbId);
		// Close db
		mDbHelper.close();
		boolean inList = list.contains(stop);
		if (addedTourStop != null && inList) {
			createIterator();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the TourStop object represented by the unique id or null if the
	 * TourStop object does not exist in the database. The TourStop object
	 * should be queried from the database since that is faster than searching
	 * the list.
	 * 
	 * NOTE: Remember to open and close the database.
	 * 
	 * @param l
	 *            of TourStop to find
	 * @return TourStop object represented by the id or null
	 */
	public TourStop getTourStopById(long l) {
		// Pierce
		// Get the index of the id (or -1 if its not in the list!)
		int index = list.indexOfById(l);

		// Return the stop, or null, depending on the index
		return list.get(index);

	}

	/**
	 * Returns the position in the list for the specified TourStop or -1 if the
	 * TourStop does not exist in the list.
	 * 
	 * @param stop
	 *            TourStop to find in the list
	 * @return the position of the TourStop or -1
	 */
	public int getTourStopPosition(TourStop stop) {
		// Pierce
		// return the index of the stop
		return list.indexOf(stop);
	}

	/**
	 * Removes the specified TourStop from the BOTH the database and the list.
	 * 
	 * The TourStop should be deleted from the database before removing it from
	 * the list.
	 * 
	 * After removing the TourStop from the list, the updateTourStopListInDb()
	 * method should be called so that all previous and next references are
	 * updated. NOTE: Remember to open and close the database.
	 * 
	 * @param stop
	 *            TourStop to delete
	 * @return true if the TourStop is removed from BOTH the database and the
	 *         list
	 */
	public boolean removeTourStop(TourStop stop) {

		boolean inListBeforeRemove = false;
		if (list.contains(stop)) {
			inListBeforeRemove = true;
		}

		// Open the database
		mDbHelper.open();

		boolean deletedFromDatabase = mDbHelper.deleteTourStop(stop.get_id());
		mDbHelper.open();

		list.remove(list.indexOf(stop));

		// Update the database
		updateTourStopListInDb();
		mDbHelper.open();

		// Check to see if the stop is in the list after remove
		boolean inListAfterRemove = list.contains(stop);

		if (inListBeforeRemove == true && inListAfterRemove == false
				&& deletedFromDatabase == true) {
			mDbHelper.close();
			return true;
		} else {
			mDbHelper.close();
			return false;
		}
	}

	/**
	 * Returns true if the specified TourStop is updated. This method may also
	 * potentially move the TourStop to a new position in the list.
	 * 
	 * The TourStop should be updated in BOTH the database and the list. You can
	 * use the list.set() and list.move() methods to help you update the list.
	 * 
	 * After updating the TourStop, the updateTourStopListInDb() method should
	 * be called so that all previous and next references are updated.
	 * 
	 * NOTE: Remember to open and close the database.
	 * 
	 * @param stop
	 *            TourStop to update
	 * @param position
	 *            to move the TourStop to
	 * @return true if the database AND list are updated
	 */
	public boolean updateTourStop(TourStop stop, int position) {
		// Robert
		mDbHelper.open();

		if (list.indexOf(stop) == position) {
			list.set(position, stop);
		} else {
			list.move(position, stop);
		}

		boolean updateDb = mDbHelper.updateTourStop(stop, getPrevId(stop),
				getNextId(stop));
		mDbHelper.open();

		if (stop.equals(list.get(list.indexOf(stop))) && updateDb) {
			mDbHelper.open();
			updateTourStopListInDb();
			createIterator();
			mDbHelper.close();
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the list is empty.
	 * 
	 * @return true if the list is empty
	 */
	public boolean isListEmpty() {
		// Robert
		return list.isEmpty();
	}

	/**
	 * Returns the unique id of the TourStop preceding the specified TourStop in
	 * the list or -1 if the TourStop is the first stop in the list
	 * 
	 * @param stop
	 *            current TourStop
	 * @return id of preceding TourStop or -1
	 */
	public long getPrevId(TourStop stop) {
		// Pierce
		// return the previous id
		return list.getPrevId(stop);
	}

	/**
	 * Returns the unique id of the TourStop following the specified TourStop in
	 * the list or -1 if the TourStop is the last stop in the list
	 * 
	 * @param stop
	 *            current TourStop
	 * @return id of following TourStop or -1
	 */
	public long getNextId(TourStop stop) {
		// Pierce
		// return the next id
		return list.getNextId(stop);
	}

	/**
	 * Iterates through the list and updates the previous and next information
	 * in the database.
	 * 
	 * The previous and next TourStops in the list are recorded in the database
	 * by listing the unique ids for the previous and next TourStops. Use the
	 * updateTourStopListNode() method to update the previous and next ids for
	 * the current TourStop.
	 * 
	 * This method should be called when ever the list is updated and nodes are
	 * added, deleted, or modified.
	 */
	private void updateTourStopListInDb() {
		createIterator();
		mDbHelper.open();
		while (iterator.hasNext()) {
			TourStop s = iterator.next();
			long prev = list.getPrevId(s);
			long next = list.getNextId(s);
			mDbHelper.updateTourStopListNode(s.get_id(), prev, next);
		}
		mDbHelper.close();
	}

	public boolean contains(TourStop stop) {
		return list.contains(stop);
	}

}
