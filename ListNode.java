package edu.ncsu.csc.csc216.wolftours.tour_stop;

/**
 * A ListNode object that is a Node for a LinkedList. A ListNode contains it's
 * data (TourStop) and a reference to a previous and next node on a doubly
 * linked list.
 * 
 * The ListNode class can be moved to be an inner class in your list
 * implementation.
 * 
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class ListNode {

	/** The TourStop the ListNode contains */
	public TourStop data;
	/** The next ListNode on the linked list */
	public ListNode next;
	/** The previous ListNode on the linked list */
	public ListNode prev;

	/**
	 * Constructs a new ListNode object with the given data, previous node, and
	 * next node. All inputs to the constructor can potentially be null.
	 * 
	 * @param data
	 *            TourStop stored in the node
	 * @param prev
	 *            previous ListNode in the list
	 * @param next
	 *            next ListNode in the list
	 */
	public ListNode(TourStop data, ListNode prev, ListNode next) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

}
