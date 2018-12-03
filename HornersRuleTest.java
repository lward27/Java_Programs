package edu.ncsu.csc.csc216.state;


import junit.framework.TestCase;

/**
 * JUnit test case for the HornersRule class.
 * This test case considers all possible states
 * and transitions in the HornersRule FSM.
 * @author Dr. Sarah Heckman
 */
public class HornersRuleTest extends TestCase {
	
	HornersRule rule;

	protected void setUp() throws Exception {
		super.setUp();
		rule = new HornersRule();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Tests the HornersRule.toDouble method
	 */
	public void testToDouble() {
		//Transitions from Start State
		assertEquals(0.0, rule.toDouble("+"));
		assertEquals(-0.0, rule.toDouble("-"));
		assertEquals(0.0, rule.toDouble("."));
		assertEquals(5.0, rule.toDouble("5"));
		assertEquals(0.0, rule.toDouble("a"));
		
		//Transitions from Integer State
		assertEquals(0.0, rule.toDouble("5+"));
		assertEquals(0.0, rule.toDouble("5-"));
		assertEquals(5.0, rule.toDouble("5."));
		assertEquals(25.0, rule.toDouble("25"));
		assertEquals(0.0, rule.toDouble("5a"));
		
		//Transitions from Decimal State
		assertEquals(0.0, rule.toDouble("5.3+"));
		assertEquals(0.0, rule.toDouble("5.3-"));
		assertEquals(0.0, rule.toDouble("5.3."));
		assertEquals(5.34, rule.toDouble("5.34"));
		assertEquals(0.0, rule.toDouble("5.3a"));
	}

}
