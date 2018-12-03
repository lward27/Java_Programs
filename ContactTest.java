package edu.ncsu.csc.csc216.acronym_annihilator.model.contacts;

import junit.framework.TestCase;

public class ContactTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsValidContact() {
		Contact c1 = new Contact("Sarah", "Heckman", "sarah_heckman@gmail.com", null, null, -1);
		assertFalse(c1.isValidContact());
		c1.setLabel("Professional");
		c1.setLabelPosition(0);
		assertTrue(c1.isValidContact());
	}

}
