/**
 * 
 */
package edu.ncsu.csc.csc216.acronym_annihilator.model.contacts;

import edu.ncsu.csc.csc216.acronym_annihilator.IDK;
import junit.framework.TestCase;

/**
 * This class will test the methods in the IDK class
 * @author Lydia Peedin
 */
public class IDKTest extends TestCase {
	
	/** This is the first string that will used for testing */
	private String msg_1;
	/** This is the second string that will used for testing */
	private String msg_2;
	/** This is the third string that will used for testing */
	private String msg_3;
	/** This is the fourth string that will used for testing */
	private String msg_4;
	/** This is the fifth string that will used for testing */
	private String msg_5;
	/** This is the sixth string that will used for testing */
	private String msg_6;
	/** This is the seventh string that will used for testing */
	private String msg_7;
	/** This is the eighth string that will used for testing */
	private String msg_8;
	/** This is the ninth string that will used for testing */
	private String msg_9;
	/** This is the tenth string that will used for testing */
	private String msg_10;

	/**
	 * This set up before the tests are run	 
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		msg_1 = "IdK";
		msg_2 = "(idk)";
		msg_3 = "idk.";
		msg_4 = "id";
		msg_5 = "ice";
		msg_6 = "idknow";
		msg_7 = "idk, idk, idk.";
		msg_8 = "because idk";
		msg_9 = "abcIDKxyz";
		msg_10 = "I said idk & I mean idk";
	}

	/**
	 * This tear down after the tests are run	 
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * This method will test the findAndReplace 
	 * method when the string contains only the
	 * acronym
	 */
	public void testIDK_1() {	
		
		IDK idk = new IDK ();				
	
		assertEquals("I don't know",idk.findAndReplace(msg_1));
	}	
	
	/**
	 * This method will test the findAndReplace
	 * method when the string contains the
	 * acronym within parenthesis
	 */
	public void testIDK_2() {	
		
		IDK idk = new IDK ();
		
		assertEquals("(I don't know)",idk.findAndReplace(msg_2));
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when the string contains the
	 * acronym as a sentence
	 */
	public void testIDK_3() {	
		
		IDK idk = new IDK ();		
		
		assertEquals("I don't know.",idk.findAndReplace(msg_3));
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when the string contains the
	 * first 2 letters of acronym
	 */
	public void testIDK_4() {	
		
		IDK idk = new IDK ();		
		
		assertEquals("id",idk.findAndReplace(msg_4));
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when the string contains the
	 * first letter of acronym
	 */
	public void testIDK_5() {	
		
		IDK idk = new IDK ();
		
		assertEquals("ice",idk.findAndReplace(msg_5));
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when the string contains a phrase
	 * with idk at the beginning
	 */
	public void testIDK_6() {	
		
		IDK idk = new IDK ();		
		
		assertEquals("idknow",idk.findAndReplace(msg_6));	
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when the string contains the
	 * successive occurrences of the acronym
	 */
	public void testIDK_7() {	
		
		IDK idk = new IDK ();
	
		assertEquals("I don't know, I don't know, I don't know.",idk.findAndReplace(msg_7));
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when the string contains a phrase
	 * ending with idk
	 */
	public void testIDK_8() {	
		
		IDK idk = new IDK ();		
		
		assertEquals("because I don't know",idk.findAndReplace(msg_8));
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when the string letters containing
	 * the idk in the middle
	 */
	public void testIDK_9() {	
		
		IDK idk = new IDK ();		
		
		assertEquals("abcIDKxyz",idk.findAndReplace(msg_9));
	}
	
	/**
	 * This method will test the findAndReplace
	 * method when a string containing 2 instances
	 * of idk
	 */
	public void testIDK_10() {	
		
		IDK idk = new IDK ();		
		
		assertEquals("I said I don't know & I mean I don't know",idk.findAndReplace(msg_10));
	}

}
