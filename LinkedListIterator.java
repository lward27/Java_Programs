/**
 * 
 */
package edu.ncsu.csc.csc216.wolftours.tour_stop;

/**
 * This is the LinkedListIterator class, it will implement the methods in
 * Iterator and iterate through the LinkedList
 * 
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class LinkedListIterator implements Iterator {
	
	/* This is a ListNode*/
	private ListNode current;
	
	/**
	 * Constructs a basic LinkedListIterator object
	 */
	public LinkedListIterator(ListNode front) {
		current = new ListNode(null, null, front);
	}

	/**
	 * This method will check to see if the current has a next
	 * 
	 * @see edu.ncsu.csc.csc216.wolftours.tour_stop.Iterator#hasNext()
	 * @return
	 */
	@Override
	public boolean hasNext() {
		// Lucas
		if (current != null && current.next != null)
			return true;
		else
			return false;
	}

	/**
	 * This method will check to see if the current has a previous
	 * 
	 * @see edu.ncsu.csc.csc216.wolftours.tour_stop.Iterator#hasPrev()
	 * @return
	 */
	@Override
	public boolean hasPrev() {
		// Lucas
		if (current != null && current.prev != null)
			return true;
		else
			return false;
	}

	/**
	 * This method will check for next
	 * 
	 * @see edu.ncsu.csc.csc216.wolftours.tour_stop.Iterator#next()
	 * @return stop
	 *            TourStop in the data contained in next
	 */
	@Override
	public TourStop next() {
		// Lucas
		current = current.next;
		TourStop returnData = current.data;		
		return returnData;
	}

	/**
	 * This method will check for prev
	 * 
	 * @see edu.ncsu.csc.csc216.wolftours.tour_stop.Iterator#prev()
	 * @return stop
	 *            TourStop in the data contained in prev
	 */
	@Override
	public TourStop prev() {
		// Lucas
		current = current.prev;
		TourStop returnData = current.data;
		return returnData;		
	}
}
