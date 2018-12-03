package edu.ncsu.csc.csc216.wolftours.tour_stop;

import edu.ncsu.csc.csc216.wolftours.tour_stop.ListNode;

/**
 * This is the LinkedList class, it will implement the methods in List and
 * adding, removing, and editing TourStops in the list
 * 
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class LinkedList implements List {
	/** This is the first value in the list **/
	private ListNode front;
	/** This keeps track of the current number of elements **/
	private int size;

	/**
	 * This is the constructor for the LinkedList
	 */
	// post: constructs an empty list
	public LinkedList() {
		front = null;
		size = 0;
	}

	/**
	 * Adds a TourStop to the end of the list
	 * 
	 * @param stop
	 *            TourStop to add to the end of the list
	 */
	@Override
	public void add(TourStop stop) {
		// Will		
		if (front == null) {
			front = new ListNode(stop, null, null);
		} else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(stop, current, null);
		}
		size++;
	}

	/**
	 * A helper method that adds a TourStop to the front of the list
	 * 
	 * @param stop
	 *            TourStop to add to the front of the list
	 */
	public void addToFront(TourStop stop) {
		if (size == 0) {




			front = new ListNode(stop, null, null);			


		} else {
			ListNode addedToFront = new ListNode(stop, null, front);
			front = addedToFront;
		}
		size++;
	}

	/**
	 * Adds a TourStop at the specified location. All other TourStops are
	 * shifted to the right
	 * 
	 * @param index
	 *            to add the TourStop at
	 * @param stop
	 *            TourStop to add to the end of the list
	 */
	@Override
	public void add(int index, TourStop stop) {

		// Will

		if (index < 0) {
			add(stop);
			return;

		}
		
		if (index >= size){
			add(stop);
			return;
		}
		
		if (index <= size) {				

			ListNode current = front;

			if (index < 0) {				
				add(stop);					
			}else if (size == 0) {

				add(stop);
			} else if (index == 0) {
				addToFront(stop);

			}else if (index >= size){		
				     add(stop);

			} else {
				if (index == size) {
					add(stop);
				} else if (index < 0) {
					add(stop);
				} else {
					for (int i = 0; i < index - 1; i++) {
						current = current.next;
					}

					current.next = new ListNode(stop, current, current.next);					

					current.next.prev = current;
					size++;
				}
			}
		}
	}

	/**
	 * Clears all TourStops from the list
	 */
	@Override
	public void clear() {
		// Will
		front = null;
		front.next = null;
		size = 0;
	}

	/**
	 * Returns true if the list contains the TourStop
	 * 
	 * @param stop
	 *            true if the list contains the TourStop
	 * @return
	 */
	@Override
	public boolean contains(TourStop stop) {
		// Pierce
		// makes sure the list isn't empty
		if (isEmpty() == true) 
			return false;


		// Make a test ListNode and set it to the front so we don't lose the front
		ListNode test = front; 
		
		// Checks to see if the first stop equals the desired
		if (test.data.getName().equals(stop.getName())) 
			// if so, return true
			return true; 


		// Loop while there are nodes after the
		while (test.next != null) { 
			// current

			// checks to see if the current stop matches the desired stop
			if (test.data.getName().equals(stop.getName())) 				

				return true;
			
			// Increment to the next node
			test = test.next; 
		}


		// checks to see if the current stop matches
		if (test.data.getName().equals(stop.getName())) 

			// the desired stop
			return true;

		// gone through the list, no matches
		return false; 
	}

	/**
	 * Returns the TourStop at the specified index or null if there is no
	 * TourStop at the specified index.
	 * 
	 * @param index
	 *            of TourStop to get
	 * @return TourStop at the specified index or null
	 */
	@Override
	public TourStop get(int index) {
		// Pierce
		// checks to make sure that the linked list should contain the index
		if (index >= size() || isEmpty() == true || index < 0) 		
			return null;

		// Create a test node so we don't lose the front
		ListNode test = front; 

		for (int i = 0; i < index; i++)
			// Traverse through the linked list
			// throw away the current, we don't want it
			test = test.next; 
		return test.data;
	}

	/**
	 * Returns the unique id of the TourStop following the specified TourStop in
	 * the list or -1 if the TourStop is the last stop in the list
	 * 
	 * @param stop
	 *            current TourStop
	 * @return id of following TourStop or -1
	 */
	@Override
	public long getNextId(TourStop stop) {
		// Pierce
		// Find the index of the stop
		int index = indexOf(stop); 
		// checks to see if its the last
		if (index >= size() - 1 || index < 0) 
			// stop in the tour, or if its invalid
			// if so, return the flag value
			return -1; 
		else
			// Return the next ID
			return get(index + 1).get_id(); 
	}

	/**
	 * Returns the unique id of the TourStop preceding the specified TourStop in
	 * the list or -1 if the TourStop is the first stop in the list
	 * 
	 * @param stop
	 *            current TourStop
	 * @return id of preceding TourStop or -1
	 */
	@Override
	public long getPrevId(TourStop stop) {
		// Pierce
		// Find the index of the stop
		int index = indexOf(stop); 
		// checks to see if its the first stop in the tour, or  not in the list.
		if (index <= 0) 
			// if so, return the flag value
			return -1; 
		else
			// Return the previous ID
			return get(index - 1).get_id(); 
	}

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
	@Override
	public int indexOf(TourStop stop) {
		int index = 0;
		// Set the current position equal to the front of the list
		ListNode current = front;
		while (current != null) {
			if (current.data.equals(stop)) {
				return index;
			}
			// Increment the index
			index++;
			current = current.next;
		}
		// Return -1 since the stop was not found in the list
		return -1;
	}

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
	@Override
	public int indexOfById(long id) {
		// Pierce
		// checks to make sure the list isn't empty
		if (isEmpty() == true)
			// if so, return the flag value
			return -1; 
		// start the index at 0
		int index = 0; 
		// Create a test node so we don't lose the front
		ListNode test = front; 
		
		// Traverse through the linked list
		while (test.next != null) { 
			// checks the ID against the desired
			if (test.data.get_id() == id) 
				// ID
				// if its a match, return the index
				return index;
			// if not, increment the index
			index++; 
			// Increment to the next node
			test = test.next; 
		}
		// checks the ID against the desired ID
		if (test.data.get_id() == id) 
			// if its a match, return the index
			return index; 
		// No matches found, return a flag value
		return -1; 
	}

	/**
	 * Returns true if the list is empty.
	 * 
	 * @return true if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		// Robert
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns an iterator for the list.
	 * 
	 * @return an iterator for the list
	 */
	@Override
	public Iterator iterator() {
		// Lucas
		return new LinkedListIterator(front);
	}

	/**
	 * Moves the specified TourStop from it's current location in the list to
	 * the specified index.
	 * 
	 * @param index
	 *            to move the TourStop to
	 * @param stop
	 *            TourStop to move
	 */
	@Override
	public void move(int index, TourStop stop) {
		// Robert
		if (contains(stop)) {
			int currentIndex = indexOf(stop);

			remove(currentIndex);

			// Moves stop to end if index is greater than size or less than 0
			if (index >= size || index < 0) {
				add(stop);
			} else {
				add(index, stop);
			}
		}
	}

	/**
	 * Removes the TourStop at the specified index
	 * 
	 * @param index
	 *            of the TourStop to remove
	 */
	@Override
	public void remove(int index) {
		// Check for bad position
		// original: if (0 < index && index >= size()) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		// Check for empty list
		if (size() == 0) {
			throw new NullPointerException("Empty list" + size);
		}
		// This will remove from the front of the list
		if (index == 0) {
			// Removing the first element
			front = front.next;
		}
		// This will remove from the end of the list
		else if (index == (size() - 1)) {
			ListNode current = front;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			current.prev.next = null;
		}
		// This will remove from the elsewhere in the list
		else {
			// Removing from elsewhere
			ListNode current = front;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			// Set the "next" pointer
			current.prev.next = current.next;
			// Set the "previous" pointer
			current.next.prev = current.prev;
		}
		// Decrement the size
		size--;
	}

	/**
	 * Sets the TourStop at the specified index to the given TourStop (i.e. it
	 * overwrites the TourStop with the new information)
	 * 
	 * @param index
	 *            of the TourStop to overwrite
	 * @param stop
	 *            TourStop to store at the index
	 */
	@Override
	public void set(int index, TourStop stop) {
		// Robert
		ListNode current = this.front;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		current.data = stop;		

	}

	/**
	 * This method returns the size of the list
	 * 
	 * @return size of the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * This method creates a comma-separated, bracketed version of the list
	 */
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current.next != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
}
