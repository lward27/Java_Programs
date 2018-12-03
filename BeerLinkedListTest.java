package edu.ncsu.csc.csc216.heckman_brewery.list;

import edu.ncsu.csc.csc216.heckman_brewery.beer.Ale;
import edu.ncsu.csc.csc216.heckman_brewery.beer.Beer;
import edu.ncsu.csc.csc216.heckman_brewery.list.BeerLinkedList;
import junit.framework.TestCase;

public class BeerLinkedListTest extends TestCase {
	
	private BeerLinkedList<Beer> list;

	protected void setUp() throws Exception {
		super.setUp();
		list = new BeerLinkedList<Beer>();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSize() {
		//Test empty list
		assertEquals(0, list.size());
		
		//Test size of list with one node
		list.add(new Ale("Pale Ale"));
		assertEquals(1, list.size());
		
		//Test size of list after deleting node
		list.remove(0);
		assertEquals(0, list.size());
	}
	
	public void testAdd() {
		//Test adding a node to an empty list
		Beer b = new Ale("Pale Ale");
		list.add(b);
		assertEquals(1, list.size());
		assertEquals(b, list.get(0));
	}
	
	public void testRemove() {
		
		
	}
	
	public void testGet() {
		//Test getting beer from empty list
		try {
			list.get(3);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		//Test a negative index
		try {
			list.get(-4);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		//Test getting first beer in list
		Beer b = new Ale("Pale Ale");
		list.add(b);
		assertEquals(b, list.get(0));
		
	}

}
