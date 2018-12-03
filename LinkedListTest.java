/**
 * 
 */
package edu.ncsu.csc.csc216.wolftours.tour_stop;

import junit.framework.TestCase;

/**
 * This tests methods in the LinkedList class
 * 
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class LinkedListTest extends TestCase {
	/** A List */
	List list;	
	/** A TourStop */
	private TourStop t1;
	/** A second TourStop */
	private TourStop t2;
	/** A third TourStop */
	private TourStop t3;
	/** A fourth TourStop */
	private TourStop t4;
	/** A fifth TourStop */
	private TourStop t5;
	/** A sixth TourStop */
	private TourStop t7;
	/** Another TourStop1 */	
	private TourStop stop1;
	/** Another TourStop2 */
	private TourStop stop2;
	/** Another TourStop3 */
	private TourStop stop3;	

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		// This initializes the appropriate fields with values for the TourStop objects
		t1 = new TourStop(123, "A", "1", null, null, null);
		t2 = new TourStop(456, "B", "2", null, null, null);
		t3 = new TourStop(789, "C", "3", null, null, null);
		t4 = new TourStop(101, "D", "4", null, null, null);
		t5 = new TourStop(202, "E", "5", null, null, null);
		t7 = new TourStop(303, "F", "6", null, null, null);

		stop1 = new TourStop(1, "Building 1", "512", "Street", "Cool place",
				"far away");
		stop2 = new TourStop(2, "Building 2", "Eighty-Eighth", "Blvd",
				"Skecth place", "farther away");
		stop3 = new TourStop(5, "Building 3", "Eighty-Eighth.5", "Court", "<3",
				"farthest away");		
		
		// This initializes the list
		list = new LinkedList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * This tests the indexOf method in LinkedList when seeking the index of a
	 * TourStop in the middle of the list.
	 */
	public void testIndexOf_1() {

		// Create Linked List
		List list = new LinkedList();

		// Add elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// What is expected result?
		int expectedResult = 2;

		// What is actual result?
		int actualResult = list.indexOf(t3);

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the indexOf method in LinkedList when seeking the index of a
	 * TourStop at the front of the list.
	 */
	public void testIndexOf_2() {

		// Create Linked List
		List list = new LinkedList();

		// Add elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// What is expected result?
		int expectedResult = 0;

		// What is actual result?
		int actualResult = list.indexOf(t1);

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the indexOf method in LinkedList when seeking the index of a
	 * TourStop at the end of the list.
	 */
	public void testIndexOf_3() {

		// Create Linked List
		List list = new LinkedList();

		// Add elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// What is expected result?
		int expectedResult = 4;

		// What is actual result?
		int actualResult = list.indexOf(t5);

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the indexOf method in LinkedList when seeking the index of a
	 * TourStop that is not in the list.
	 */
	public void testIndexOf_4() {

		// Create Linked List
		List list = new LinkedList();

		// Add elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// What is expected result?
		int expectedResult = -1;

		// What is actual result?
		int actualResult = list.indexOf(t7);

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}
	
	public void testIndexOf(){
		list.add(500, t1);
		assertEquals(list.indexOf(t1), list.size() - 1);
	}

	/**
	 * This tests the remove method in LinkedList when one element has been
	 * removed from the end of the list
	 */
	public void testRemove_1() {
		// Create Linked List
		List list = new LinkedList();
		
		// Add elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// Remove elements to the above LinkedList.
		list.remove(4);

		// What is expected result?
		int expectedResult = 4;

		// What is actual result?
		int actualResult = list.size();

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the remove method in LinkedList when one element has been
	 * removed from the front of the list
	 */
	public void testRemove_2() {
		// Create Linked List
		List list = new LinkedList();

		// Add elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);

		// Remove elements to the above LinkedList.
		list.remove(0);

		// What is expected result?
		int expectedResult = 2;

		// What is actual result?
		int actualResult = list.size();

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the remove method in LinkedList when one element has been
	 * removed from a list length one
	 */
	public void testRemove_3() {
		// Create Linked List
		List list = new LinkedList();

		// Add elements to the above LinkedList.
		list.add(t1);

		// Remove elements to the above LinkedList.
		list.remove(0);

		// What is expected result?
		int expectedResult = 0;

		// What is actual result?
		int actualResult = list.size();

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the remove method in LinkedList when two elements have been
	 * removed from the middle of the list
	 */
	public void testRemove_4() {
		// Create Linked List
		List list = new LinkedList();

		// Add elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// Remove elements to the above LinkedList.
		list.remove(1);
		list.remove(2);

		// What is expected result?
		int expectedResult = 3;

		// What is actual result?
		int actualResult = list.size();

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the size method in LinkedList when five elements have been
	 * added
	 */
	public void testSize_1() {
		// Create Linked List
		List list = new LinkedList();

		// Add 5 elements to the above LinkedList.
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// What is expected result?
		int expectedResult = 5;

		// What is actual result?
		int actualResult = list.size();

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the size method in LinkedList when one element has been added.
	 */
	public void testSize_2() {
		// Create Linked List
		List list = new LinkedList();

		// Add 1 element to the above LinkedList.
		list.add(t1);

		// What is expected result?
		int expectedResult = 1;

		// What is actual result?
		int actualResult = list.size();

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the size method in LinkedList when no elements have been
	 * added.
	 */
	public void testSize_3() {
		// Create Linked List
		List list = new LinkedList();

		// Add 0 elements to the above LinkedList.

		// What is expected result?
		int expectedResult = 0;

		// What is actual result?
		int actualResult = list.size();

		// JUnit Test Case
		assertEquals(expectedResult, actualResult);
	}

	/**
	 * This tests the contains method in LinkedList when no elements have been
	 * added, one stop has been added, and two stops have been added.
	 */
	public void testContains() {
		
		// Test contains after no stops have been added
		assertFalse(list.contains(stop1));

		// Add a TourStop to the list
		list.add(stop1);
		
		// Test contains after one stops have been added
		assertTrue(list.contains(stop1));
		assertFalse(list.contains(stop2));

		// Add another TourStop to the list
		list.add(stop2);
		
		// Test contains after two stops have been added
		assertTrue(list.contains(stop1));
		assertTrue(list.contains(stop2));
	}

	/**
	 * This tests the get method in LinkedList
	 */
	public void testGet() {
		// Add a TourStop to the list
		list.add(stop1);
		
		// Test get method after adding a TourStop
		assertFalse(list.get(0).equals(stop2));
		assertTrue(list.get(0).equals(stop1));

		// Add another TourStop to the list
		list.add(stop2);
		
		// Test get method after adding another TourStop
		assertTrue(list.get(1).equals(stop2));

		assertNull(list.get(3));
	}

	/**
	 * This tests the indexOfById method in LinkedList
	 */
	public void testIndexOfById() {
		// Add a TourStop to the list
		list.add(stop1);
		list.add(stop2);

		// Test the indexOfById
		assertTrue(list.indexOfById(1) == 0);
		assertTrue(list.indexOfById(2) == 1);
		assertTrue(list.indexOfById(42) == -1);
	}

	/**
	 * This tests the getPrevId method in LinkedList
	 */
	public void testGetPrevId() {
		// Add a TourStop to the list
		list.add(stop1);
		list.add(stop2);

		// Test the getPrevId
		assertTrue(list.getPrevId(stop2) == 1);
		assertTrue(list.getPrevId(stop1) == -1);
		assertTrue(list.getPrevId(stop3) == -1);

	}

	/**
	 * This tests the getNextId method in LinkedList
	 */
	public void testGetNextId() {
		// Add a TourStop to the list
		list.add(stop1);
		list.add(stop2);

		// Test the getNextId
		assertTrue(list.getNextId(stop2) == -1);
		assertTrue(list.getNextId(stop1) == 2);
		assertEquals(-1, list.getNextId(stop3));
	}

	/**
	 * This tests the add method in LinkedList when adding a TourStop
	 * in the middle of the list
	 */	
	public void testAdd_01() {
		// Create Linked List
		List testList = new LinkedList();

		// Add a stop to the list at index 0
		testList.add(0, stop1);		
		assertEquals(testList.indexOf(stop1), 0);

		// Add a stop to the list at index 1
		testList.add(1, stop2);		
		assertEquals(testList.indexOf(stop2), 1);

		// Add another stop to the list at index 1
		testList.add(1, stop3);
		
		// Test to ensure the third stop is added to index 1 and the 
		// original stop is shifted to index 2
		assertEquals(testList.indexOf(stop3), 1);
		assertEquals(testList.indexOf(stop2), 2);
	}

	/**
	 * This tests the add method in LinkedList when adding a TourStop
	 * at different indices in the list
	 */	
	public void testAdd_02() {
		// Create Linked List
		List testList = new LinkedList();

		// Add a stop to the list at index 0
		testList.add(0, stop1);
		assertEquals(testList.indexOf(stop1), 0);
		
		// Add a stop to the list at index 1
		testList.add(1, stop2); 					  	
		assertEquals(testList.indexOf(stop2), 1);
		
		// Add another stop to the list at index 0
		testList.add(0, stop3); 	
		
		// Test to ensure the third stop is added to index 0 and the 
		// original stops are shifted to the appropriate index
		assertEquals(testList.indexOf(stop3), 0); 		
		assertEquals(testList.indexOf(stop2), 2);
		assertEquals(testList.indexOf(stop1), 1); 												
	}	

	/**
	 * Tests isEmpty() method in LinkedList when the list is Empty and 
	 * after a TourStop has been added
	 */
	public void testIsEmpty() {
		// Add no TourStops to the list
		
		// Check to see that the list is empty
		assertTrue(list.isEmpty());
		
		// Add a TourStop to the list
		list.add(t1);
		
		// Check to see that the list is no longer empty
		assertFalse(list.isEmpty());
	}

	/**
	 * Tests set() method in LinkedList
	 */
	public void testSet() {		
		int testIndex0 = 0;
		int testIndex1 = 1;
		
		// Add two TourStops
		list.add(t1);
		list.add(t2);

		// Create a new TourStop
		TourStop newStop = new TourStop(1, "New Building", "100", "123 Test",
				"Description", "");

		// Set the TourStop to index 0
		list.set(0, newStop);
		//Test to see that the index was set
		assertTrue(list.get(testIndex0).equals(newStop));

		// Set the TourStop to index 1
		list.set(1, newStop);
		//Test to see that the index was set
		assertEquals(list.get(testIndex1), newStop);
	}

	/**
	 * Tests move() method in LinkedList
	 */
	public void testMove() {
		// Create a list
		list = new LinkedList();
		
		// Add three TourStops
		list.add(t1);
		list.add(t2);
		list.add(t3);
		
		TourStop stop = list.get(0);

		// Move the TourStop
		list.move(list.size() - 1, stop);
		// Test to ensure the TourStop was moved
		assertEquals(list.indexOf(stop), list.size() - 1);

		// Move the TourStop
		list.move(0, stop);
		// Test to ensure the TourStop was moved
		assertEquals(list.indexOf(stop), 0);

		// Move the TourStop
		list.move(1, stop);
		// Test to ensure the TourStop was moved
		assertEquals(list.indexOf(stop), 1);
	}
	
	
}
