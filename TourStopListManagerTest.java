/**
 * 
 */
package edu.ncsu.csc.csc216.wolftours.tour_stop;

import android.test.AndroidTestCase;
import edu.ncsu.csc.csc216.wolftours.db.WolfToursDbAdapter;

/**
 * Tests TourStopListManager methods
 * @author SarahHeckman
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class TourStopListManagerTest extends AndroidTestCase {
	
	private WolfToursDbAdapter db;
	private TourStopListManager manager;
	private TourStop stop1;
	private TourStop stop2;
	private TourStop stop3;

	/**
	 * This method sets up to prepare for testing
	 */
	protected void setUp() throws Exception {
		super.setUp();
		db = new WolfToursDbAdapter(mContext);
		db.open();
		db.dropTables();
		
		manager = TourStopListManager.getInstance(mContext);
		manager.createTourStopList();
		manager.createIterator();
		
		stop1 = new TourStop();
		stop1.setName("Memorial Bell Tower");
		stop1.setBuildingAddress("2101 Hillsborough St.");
		stop1.setBuildingNumber("2");
		stop1.setDescription("The memorial Bell Tower at NC State was designed in 1920. Its blending of Romanesque features and Gothic verticality are reminiscent of the towers of West Point. The 115-foot monument, called \"a legend in stone\" contains 1,400 tons of stone set on a 700-ton concrete base, and exceeded $150,000 in cost.");
		stop1.setImagePath("R.drawable.bell_tower");
		
		stop2 = new TourStop();
		stop2.setName("Holladay Hall");
		stop2.setBuildingAddress("20 Watauga Club Dr.");
		stop2.setBuildingNumber("3");
		stop2.setDescription("Holladay Hall was the first building on campus and, for years, contained virtually the entire college. Prisoners of the state penitentiary built what was then called \"Main Building\" with bricks donated by the prison. ");
		stop2.setImagePath("");
		
		stop3 = new TourStop();
		stop3.setName("Winslow Hall");
		stop3.setBuildingAddress("40 Pullen Rd.");
		stop3.setBuildingNumber("4");
		stop3.setDescription("Honoring more than 300 alumni who died in World War II and the Korean War, the Alumni Memorial Building, as it is seen today, was made possible through a funding gift from alumnus Dick Reynolds. Reynolds was the son of R. J. Reynolds, who owned the R. J. Reynolds Tobacco Company in Winston Salem. ");
		stop3.setImagePath("");
	}

	/**
	 * This method tears down to clean up after testing
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		db.close();
		db = null;
		stop1 = null;
		stop2 = null;
		stop3 = null;
	}
	
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#createIterator()}.
	 */	
	public void testCreateIterator() {
		//The iterator is created in setUp.  The asserts below, ensure
		//that the iterator was created when the list is empty
		assertNull(manager.getNext()); //No tour stops
		assertNull(manager.getPrev()); //No tour stops
		
		//when the list contains 1 tour stop
		manager.addTourStop(stop1, 0);
		manager.createIterator();
		assertEquals(stop1, manager.getNext());
		assertNull(manager.getNext());
		assertNull(manager.getPrev());
		
		//when the list contains 2 tour stops
		manager.addTourStop(stop2, 1);
		manager.createIterator();
		assertEquals(stop1, manager.getNext());
		assertEquals(stop2, manager.getNext());
		assertNull(manager.getNext());
		assertEquals(stop1, manager.getPrev());
		assertNull(manager.getPrev());
		
		//when the list contains 3 tour stops
		manager.addTourStop(stop3, 2);
		manager.createIterator();
		assertEquals(stop1, manager.getNext());
		assertEquals(stop2, manager.getNext());
		assertEquals(stop3, manager.getNext());
		assertNull(manager.getNext());
		assertEquals(stop2, manager.getPrev());
		assertEquals(stop1, manager.getPrev());
		assertNull(manager.getPrev());
	}
		
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#updateTourStopListInDb()}.
	 */	
	public void testUpdateTourStopListInDb() {
		//This is a private method, so we can't test it directly.
		//However, we can test the effects of the method since
		//it should be called by other methods (e.g. addTourStop, 
		//updateTourStop, and removeTourStop)
		
		//Add a tour stop (which calls the updateTourStopListInDb())
		//we'll check that things were saved by recreating the list
		//an checking the ids
		manager.addTourStop(stop1, 0);
		manager.createTourStopList();
		assertEquals(0, manager.getTourStopPosition(stop1));
		
		//Test adding a tour stop before the current one
		manager.addTourStop(stop2, 0);
		manager.createTourStopList();						  
		assertEquals(1, manager.getTourStopPosition(stop1));  	
		assertEquals(0, manager.getTourStopPosition(stop2));   	
	}										 	
																
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#createTourStopList()}.	
	 */
	public void testCreateTourStopList() {
		//Add a tour stop
		manager.addTourStop(stop1, 0);
		//Check to see id the List is empty after adding a stop
		assertEquals(false,manager.isListEmpty());
		
		manager.removeTourStop(stop1);      
		assertTrue(manager.isListEmpty());	
											
		//Creates a List from the database which is NOT empty because stop1 was has been added		
		manager.addTourStop(stop1, 0);
		manager.createTourStopList();	
		assertEquals(false,manager.isListEmpty());	
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#removeTourStop()}.
	 */
	public void testRemoveTourStop() {	
		// Checks if list is empty at start		
		assert(manager.isListEmpty());	
		
		// Add two TourStops					
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, 1);
		
		// Remove two tourStops
		manager.removeTourStop(stop1);
		manager.removeTourStop(stop2);
		
		// Checks that the list is now empty
		assertTrue(manager.isListEmpty());		
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#getTourStopById()}.
	 */
	public void testGetTourStopById(){
		// Add three TourStops
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, 1);
		manager.addTourStop(stop3, 2);
			
		// Tests the getTourStopById
		assertEquals(stop1, manager.getTourStopById(stop1.get_id()));
		assertEquals(stop2, manager.getTourStopById(stop2.get_id()));
		assertEquals(stop3, manager.getTourStopById(stop3.get_id()));
		assertNull(manager.getTourStopById(-1L));
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#getTourStopPosition()}.
	 */
	public void testGetTourStopPosition() {
		// Add two TourStops
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, 1);
		
		// Tests the GetTourStopPosition
		assertEquals(manager.getTourStopPosition(stop1), 0);     		
		assertEquals(manager.getTourStopPosition(stop2), 1);					
		assertEquals(manager.getTourStopPosition(stop3), -1);		 
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#getPrevId()}.
	 */
	public void testGetPrevId(){
		// Add two TourStops
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, 1);
		
		// Tests the getPrevId
		assertEquals(manager.getPrevId(stop2), 1);
		assertEquals(manager.getPrevId(stop1), -1);
		assertEquals(manager.getPrevId(stop3), -1);
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#getNextId()}.
	 */
	public void testGetNextId(){
		// Add two TourStops
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, 1);
		
		// Tests the getNextId
		assertEquals(manager.getNextId(stop2), -1);
		assertEquals(manager.getNextId(stop1), 2);
		assertEquals(manager.getNextId(stop3), -1);
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#updateTourStop()}.
	 */
	public void testUpdateTourStop(){
		// Add three TourStops
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, 1);
		manager.addTourStop(stop3, 2);
		
		// Sets the field BuildingNumber to 5
		stop2.setBuildingNumber("5");
		
		// Tests the updateTourStop
		assertTrue(manager.updateTourStop(stop2, 1));
		assertTrue(manager.updateTourStop(stop2, 0));
		assertEquals(manager.getTourStopPosition(stop1), 1);
		
		assertTrue(manager.updateTourStop(stop3, 10));
		assertEquals(manager.getTourStopPosition(stop3), 2);
		
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#isListEmpty()}.
	 */
	public void testIsListEmpty(){
		// Add no TourStops to the list
		
		// Check to see that the list is empty
		assertTrue(manager.isListEmpty());
		
		// Add a TourStop
		manager.addTourStop(stop1, 0);
		
		// Check to see that the list is no longer empty
		assertFalse(manager.isListEmpty());
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#addTourStop()}.
	 */
	public void testAddTourStop() {
		// Checks if list is empty at start
		assertTrue(manager.isListEmpty());
		// Open the Db
		db.open();
		// Add two TourStops
		manager.addTourStop(stop1, 0);	
		manager.addTourStop(stop2, 1);
		
		// Checks that the list is no longer empty
		assertFalse(manager.isListEmpty());
		
		// Checks that the id of stop1 & stop2 are in the db
		// Open the Db
		db.open();
		assertTrue(stop1.equals(db.getTourStopById(stop1.get_id())));
		// Open the Db
		db.open();
		assertTrue(stop2.equals(db.getTourStopById(stop2.get_id())));
		// Close the Db
		db.close();
	}

	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#getNext()}.
	 */
	public void testGetNext() {		
		// Add a TourStop 
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, -4);
		manager.addTourStop(stop3, 9);
		
		// Create the Iterator
		manager.createIterator();		
		
		// Test the getNext method
		assertEquals(manager.getNext(), stop1);	
		assertEquals(manager.getNext(), stop2);
		assertEquals(manager.getNext(), stop3);	
	}	
	
	/**
	 * Test method for {@link edu.ncsu.csc.csc216.wolftours.tour_stop.TourStopListManager#getPrev()}
	 */
	public void testGetPrev(){
		// Add a TourStop 
		manager.addTourStop(stop1, 0);
		manager.addTourStop(stop2, 1);
		manager.addTourStop(stop3, 2);
		
		// Create the Iterator
		manager.createIterator();
		
		manager.getNext();
		manager.getNext();
		manager.getNext();
		
		// Test the getPrev method
		assertEquals(manager.getPrev(), stop2);
		assertEquals(manager.getPrev(), stop1);
		assertNull(manager.getPrev());			
	}	
}
