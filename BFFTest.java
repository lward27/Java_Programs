package edu.ncsu.csc.csc216.acronym_annihilator.model.contacts;

import junit.framework.TestCase;
import edu.ncsu.csc.csc216.acronym_annihilator.BFF;

/**
 * This class will test the methods in the BFF class
 * @author William Fisher
 * @version 1.0
 */
public class BFFTest extends TestCase {
	
	private String msg_1;
	private String msg_2;
	private String msg_3;
	private String msg_4;
	private String msg_5;
	private String msg_6;
	private String msg_7;
	private String msg_8;
	private String msg_9;
	private String msg_10;
	private String msg_11;
	private String msg_12;
	private String msg_13;
	private String msg_14;
	private String msg_15;

	/**
	 * This set up before the tests are run	 
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		msg_1 = "idk my best friend forever jill.";
		msg_2 = "idkmybffjill";
		msg_3 = "idk mybff jill.";
		msg_4 = "idk my bffjill.";
		msg_5 = "idk my best friend forever, jill!";
		msg_6 = "idkmyBFFjill";
		msg_7 = "idk myBFF jill.";
		msg_8 = "idk my BFFjill.";
		msg_9 = "idkmyBFfjill";
		msg_10 = "idk mybFF jill.";
		msg_11 = "idk my bfFjill.";
		msg_12 = "my best friend forever jill best friend forever jill";
		msg_13 = "(best friend forever)";
		msg_14 = "my best friend forever.jill is cool";
		msg_15 = "my best friend forever";
	}

	/**
	 * This tear down after the tests are run	 
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * This method will test the findAndReplace method 
	 * when a sentence contains a lowercase version of 
	 * the acronym
	 */	
	public void testLowercaseBFF_1() {
		assertEquals(BFF.findAndReplace("idk my bff jill."), msg_1);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the string contains a random letters with 
	 * a lowercase version of the acronym
	 */	
	public void testLowercaseBFF_2() {
		assertEquals(BFF.findAndReplace("idkmybffjill"), msg_2);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a "word" ending with 
	 * a lowercase version of the acronym
	 */
	public void testLowercaseBFF_3() {
		assertEquals(BFF.findAndReplace("idk mybff jill."), msg_3);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a "word" beginning 
	 * with a lowercase version of the acronym
	 */	
	public void testLowercaseBFF_4() {
		assertEquals(BFF.findAndReplace("idk my bffjill."), msg_4);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a with a lowercase 
	 * version of the acronym followed by a comma
	 */	
	public void testLowercaseBFF_5() {
		assertEquals(BFF.findAndReplace("idk my bff, jill!"), msg_5);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when a sentence contains a uppercase version of 
	 * the acronym
	 */		
	public void testUppercaseBFF_1() {
		assertEquals(BFF.findAndReplace("idk my BFF jill."), msg_1);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the string contains a random letters with a 
	 * uppercase version of the acronym
	 */	
	public void testUppercaseBFF_2() {
		assertEquals(BFF.findAndReplace("idkmyBFFjill"), msg_6);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a "word" ending with 
	 * a uppercase version of the acronym
	 */
	public void testUppercaseBFF_3() {
		assertEquals(BFF.findAndReplace("idk myBFF jill."), msg_7);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a "word" beginning 
	 * with a uppercase version of the acronym
	 */	
	public void testUppercaseBFF_4() {
		assertEquals(BFF.findAndReplace("idk my BFFjill."), msg_8);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a with a uppercase 
	 * version of the acronym followed by a comma
	 */	
	public void testUppercaseBFF_5() {
		assertEquals(BFF.findAndReplace("idk my BFF, jill!"), msg_5);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when a sentence containing the the acronym in 
	 * the middle with a combination of upper and 
	 * lowercase letters
	 */	
	public void testMixcaseBFF_1() {
		assertEquals(BFF.findAndReplace("idk my BfF jill."), msg_1);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the string contains a random letters with 
	 * a upper and lowercase version of the acronym
	 */	
	public void testMixcaseBFF_2() {
		assertEquals(BFF.findAndReplace("idkmyBFfjill"), msg_9);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a "word" ending with 
	 * a upper and lowercase version of the acronym
	 */
	public void testMixcaseBFF_3() {
		assertEquals(BFF.findAndReplace("idk mybFF jill."), msg_10);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a a "word" beginning  
	 * with a upper and lowercase version of the acronym
	 */	
	public void testMixcaseBFF_4() {
		assertEquals(BFF.findAndReplace("idk my bfFjill."), msg_11);
	}

	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains a with a upper and 
	 * lowercase version of the acronym followed by a 
	 * comma
	 */	
	public void testMixcaseBFF_5() {
		assertEquals(BFF.findAndReplace("idk my bFf, jill!"), msg_5);
	}
	
	/**
	 * This method will test the findAndReplace method 
	 * when a string containing 2 instances of the acronym
	 */	
	public void testMultipleBFF_1() {
		assertEquals(BFF.findAndReplace("my bff jill bff jill"), msg_12);
	}
	
	/**
	 * This method will test the findAndReplace method 
	 * when the string contains the acronym within 
	 * parenthesis
	 */
	public void testSurroundBFF_1() {
		assertEquals(BFF.findAndReplace("(bff)"), msg_13);
	}
	
	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains the acronym followed 
	 * by a period
	 */
	public void testBFF_1() {
		assertEquals(BFF.findAndReplace("my bff.jill is cool"), msg_14);
	}
	
	/**
	 * This method will test the findAndReplace method 
	 * when the sentence contains the acronym at the end
	 */
	public void testBFFAtEnd() {
		assertEquals(BFF.findAndReplace("my bff"), msg_15);
	}
}
