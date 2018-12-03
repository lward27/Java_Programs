package edu.ncsu.csc.csc216.wolftours.db;

import edu.ncsu.csc.csc216.wolftours.tour_stop.Iterator;
import edu.ncsu.csc.csc216.wolftours.tour_stop.List;
import edu.ncsu.csc.csc216.wolftours.tour_stop.TourStop;
import android.database.Cursor;
import android.test.AndroidTestCase;

/**
 * Tests WolfToursDbAdapter methods
 * @author LydiaPeedin
 * @author LucasWard
 * @author RobertAtkinson
 * @author PierceEllis
 * @author WilliamFisher
 */
public class WolfToursDbAdapterTest extends AndroidTestCase {
	
	private WolfToursDbAdapter db;
	
	private TourStop stop1;
	private TourStop stop2;
	private TourStop stop3;

	protected void setUp() throws Exception {
		super.setUp();
		db = new WolfToursDbAdapter(mContext);
		db.open();
		
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

	protected void tearDown() throws Exception {
		super.tearDown();
		db.dropTables();
		db.close();
		db = null;
	}

	public void testAddTourStop() {
		long id1 = db.addTourStop(stop1);
		assertEquals(1, id1);
		
		long id2 = db.addTourStop(stop2);
		assertEquals(2, id2);
		
		long id3 = db.addTourStop(stop3);
		assertEquals(3, id3);
		
		long id4 = db.addTourStop(stop1);
		assertEquals(-1, id4);
	}

	public void testDeleteTourStop() {
		assertFalse(db.deleteTourStop(3));
		long id1 = db.addTourStop(stop1);
		stop1.set_id(id1);
		assertTrue(db.deleteTourStop(id1));
	}

	public void testUpdateTourStop() {
		assertFalse(db.updateTourStop(stop1, -1, -1));
		
		long id1 = db.addTourStop(stop1);
		stop1.set_id(id1);
		stop1.setName("Bell Tower");
		assertTrue(db.updateTourStop(stop1, -1, -1));
		assertEquals(stop1, db.getTourStopById(id1));
		
		long id2 = db.addTourStop(stop2);
		stop2.set_id(id2);
		stop2.setDescription("asdf");
		assertTrue(db.updateTourStop(stop1, -1, 2));
		assertTrue(db.updateTourStop(stop2, 1, -1));
		assertEquals(stop2, db.getTourStopById(id2));
		assertEquals(-1, db.getPrevIdById(1));
		assertEquals(2, db.getNextIdById(1));
		assertEquals(1, db.getPrevIdById(2));
		assertEquals(-1, db.getNextIdById(2));
		
		stop2.setName("Bell Tower");
		assertFalse(db.updateTourStop(stop2, 1, -1));
	}

	public void testUpdateTourStopListNode() {
		assertFalse(db.updateTourStopListNode(1, -1, -1));
		
		long id1 = db.addTourStop(stop1);
		stop1.set_id(id1);
		assertTrue(db.updateTourStopListNode(1, -1, -1));
		assertEquals(stop1, db.getTourStopById(id1));
		assertEquals(-1, db.getPrevIdById(1));
		assertEquals(-1, db.getNextIdById(1));
		
		long id2 = db.addTourStop(stop2);
		stop2.set_id(id2);
		assertTrue(db.updateTourStopListNode(1, -1, 2));
		assertTrue(db.updateTourStopListNode(2, 1, -1));
		assertEquals(stop2, db.getTourStopById(id2));
		assertEquals(-1, db.getPrevIdById(1));
		assertEquals(2, db.getNextIdById(1));
		assertEquals(1, db.getPrevIdById(2));
		assertEquals(-1, db.getNextIdById(2));
		
	}

	public void testGetTourStopList() {
		List list = db.getTourStopList();
		assertTrue(list.isEmpty());
		try {
			list.get(0);
			//fail();
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		long id1 = db.addTourStop(stop1);
		stop1.set_id(id1);
		list = db.getTourStopList();
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
		assertEquals(stop1, list.get(0));
		
		long id2 = db.addTourStop(stop2);
		stop2.set_id(id2);
		db.updateTourStopListNode(1, -1, 2);
		db.updateTourStopListNode(2, 1, -1);
		list = db.getTourStopList();
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());
		assertEquals(stop1, list.get(0));
		assertEquals(stop2, list.get(1));
		Iterator iterator = list.iterator();
		if (iterator.hasNext()) {
			TourStop s = iterator.next();
			assertEquals(stop1, s);
		} 
		if (iterator.hasNext()) {
			TourStop s = iterator.next();
			assertEquals(stop2, s);
		}
		assertFalse(iterator.hasNext());
		if (iterator.hasPrev()) {
			TourStop s = iterator.prev();
			assertEquals(stop1, s);
		}
		assertFalse(iterator.hasPrev());
		
		
		long id3 = db.addTourStop(stop3);
		stop3.set_id(id3);
		db.updateTourStopListNode(3, -1, 1);
		db.updateTourStopListNode(1, 3, 2);
		db.updateTourStopListNode(2, 1, -1);
		list = db.getTourStopList();
		
		assertEquals(3, list.size());
		assertEquals(stop3, list.get(0));
		assertEquals(stop1, list.get(1));
		assertEquals(stop2, list.get(2));
		iterator = list.iterator();
		if (iterator.hasNext()) {
			TourStop s = iterator.next();
			assertEquals(stop3, s);
		}
		if (iterator.hasNext()) {
			TourStop s = iterator.next();
			assertEquals(stop1, s);
		} 
		if (iterator.hasNext()) {
			TourStop s = iterator.next();
			assertEquals(stop2, s);
		}
		assertFalse(iterator.hasNext());
		if (iterator.hasPrev()) {
			TourStop s = iterator.prev();
			assertEquals(stop1, s);
		}
		if (iterator.hasPrev()) {
			TourStop s = iterator.prev();
			assertEquals(stop3, s);
		}
		assertFalse(iterator.hasPrev());
	}
	
	public void testGetTourStopById() {
		assertNull(null, db.getTourStopById(1L));
		
		long id1 = db.addTourStop(stop1);
		stop1.set_id(id1);
		assertEquals(stop1, db.getTourStopById(stop1.get_id()));
	}
	
	public void testGetAllTourStopNames() {
		Cursor c = db.getAllTourStopNames();
		c.moveToFirst();
		assertEquals(0, c.getCount());
		
		long id1 = db.addTourStop(stop1);
		stop1.set_id(id1);
		long id2 = db.addTourStop(stop2);
		stop2.set_id(id2);
		long id3 = db.addTourStop(stop3);
		stop3.set_id(id3);
		
		c = db.getAllTourStopNames();
		c.moveToFirst();
		assertEquals(3, c.getCount());
		assertEquals(stop2.get_id(), c.getLong(0));
		assertEquals(stop2.getName(), c.getString(1));
		c.moveToNext();
		assertEquals(stop1.get_id(), c.getLong(0));
		assertEquals(stop1.getName(), c.getString(1));
		c.moveToNext();
		assertEquals(stop3.get_id(), c.getLong(0));
		assertEquals(stop3.getName(), c.getString(1));
	}

}
