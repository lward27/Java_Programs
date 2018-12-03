import edu.ncsu.csc.csc216.rectangles.Rectangle;
import junit.framework.TestCase;

/**
 * @author lucas
 *
 */
public class RectanglesTest extends TestCase {
	
	private Rectangle r;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		r = new Rectangle(0, 0, 5, 5);
	}
	
	public void testContains()
	{
		assertTrue("test (0,0) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(0,0));
		
		assertTrue("test (5,5) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(5,5));
		
		assertTrue("test (3,3) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(3,3));
		
		assertTrue("test (0,4) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(0,4));
		
		assertTrue("test (4,0) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(4,0));
		
		assertTrue("test (1,0) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(1,0));
		
		assertTrue("test (0,1) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(0,1));
		
		assertTrue("test (5,4) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(5,4));
		
		assertTrue("test (4,5) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(4,5));
		
		assertFalse("test (6,6) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(6,6));
		
		assertFalse("test (-1,-1) is contained in rectangle at " +
				"posiston (0,0) with width and heigth equal to" +
				" five", r.contains(-1,-1));
	}


}
