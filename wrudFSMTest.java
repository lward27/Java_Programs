package edu.ncsu.csc.csc216.acronym_annihilator.model.contacts;

import edu.ncsu.csc.csc216.acronym_annihilator.wrudFSM;
import junit.framework.TestCase;

public class wrudFSMTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testFindAndReplace1() {
		String s1 = "wrud";
		assertEquals( "what are you doing", wrudFSM.findAndReplace(s1));
	}
	
	public void testFindAndReplace2() {	
		String s2 = "hi wrud";
		assertEquals("hi what are you doing", wrudFSM.findAndReplace(s2));
	}

	public void testFindAndReplace3() {
		String s3 = "hi wrud today";
		assertEquals("hi what are you doing today", wrudFSM.findAndReplace(s3));
	}
	
	public void testFindAndRepace4() {
		String s4 = "wrud today";
		assertEquals("what are you doing today", wrudFSM.findAndReplace(s4));
	}
	
	public void testFindAndRepace5() {
		String s5 = "lucas, wrud?";
		assertEquals("lucas, what are you doing?", wrudFSM.findAndReplace(s5));
	}
	
	public void testFindAndRepace6() {
		String s6 = "lucas, !wrud?";
		assertEquals("lucas, !what are you doing?", wrudFSM.findAndReplace(s6));
	}
	
	public void testFindAndRepace7() {
		String s7 = "I like cookies";
		assertEquals("I like cookies", wrudFSM.findAndReplace(s7));
	}
	
	/*public void testFindAndRepace8() {
		String s8 = "wrud wrud";
		assertEquals("what are you doing what are you doing", wrudFSM.findAndReplace(s8));
	}*/ 
	
}
