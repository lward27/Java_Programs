package edu.ncsu.csc.csc216.acronym_annihilator.model.contacts;

import edu.ncsu.csc.csc216.acronym_annihilator.FSM;
import edu.ncsu.csc.csc216.acronym_annihilator.Lmao;
import junit.framework.TestCase;

/**
 * Tests Lmao acronym replacement.
 * @author Robert Atkinson
 *
 */
public class LmaoTest extends TestCase {
	/** Acronym to be tested. */
	FSM lmao;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		lmao = new Lmao();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
//	public void testContainsLmao() {
//		String msg1 = "lmao";
//		String msg2 = "I was lmao.";
//		String msg3 = "Mr. Palmao";
//		String msg4 = "";
//		
//		assertTrue(lmao.containsLmao(msg1));
//		assertTrue(lmao.containsLmao(msg2));
//		assertFalse(lmao.containsLmao(msg3));
//		assertFalse(lmao.containsLmao(msg4));
//		
//	}

	/**
	 * Test method for {@link edu.ncsu.csc.csc216.acronym_annihilator.Lmao#findAndReplace(java.lang.String)}.
	 */
	public void testFindAndReplace() {
		String msg1 = "lmao";
		String msg2 = "I was lmao.";
		String msg3 = "Lmao lmao and roflmao.";
		String msg4 = "LMAO";
		String msg5 = "Mr. Palmao";
		String msg6 = "";
		String msg7 = "lmaoff";
		
		assertEquals("laughing my assets off", lmao.findAndReplace(msg1));
		assertEquals("I was laughing my assets off.", lmao.findAndReplace(msg2));
		assertEquals("Laughing my assets off laughing my assets off and roflmao.", lmao.findAndReplace(msg3));
		assertEquals("Laughing my assets off", lmao.findAndReplace(msg4));
		assertEquals("Mr. Palmao", lmao.findAndReplace(msg5));
		assertEquals("", lmao.findAndReplace(msg6));
		assertEquals("lmaoff", lmao.findAndReplace(msg7));
		
	}

}
