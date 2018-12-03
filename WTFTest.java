package edu.ncsu.csc.csc216.acronym_annihilator.model.contacts;

import edu.ncsu.csc.csc216.acronym_annihilator.WTF;
import junit.framework.TestCase;


public class WTFTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testFindAndReplace() {
		String q1 = "wtf";
		String t1 = "what the fudge";
		String q2 = "ok wtf";
		String t2 = "ok what the fudge";
		String q3 = "wtf ok";
		String t3 = "what the fudge ok";
		String q4 = "Well wtf ok";
		String t4 = "Well what the fudge ok";
		String q5 = "wtfwtf wtf wtf";
		String t5 = "wtfwtf what the fudge what the fudge";
		String q6 = "WtF";
		String t6 = "what the fudge";
		String q7 = "WTF";
		String t7 = "what the fudge";
		String q8 = "@wtf!";
		String t8 = "@what the fudge!";
		
		System.out.println(Character.isLetter('@'));
		
		assertEquals(WTF.findAndReplace(q1), t1);
		assertEquals(WTF.findAndReplace(q2), t2);
		assertEquals(WTF.findAndReplace(q3), t3);
		assertEquals(WTF.findAndReplace(q4), t4);
		assertEquals(WTF.findAndReplace(q5), t5);
		assertEquals(WTF.findAndReplace(q6), t6);
		assertEquals(WTF.findAndReplace(q7), t7);
		assertEquals(WTF.findAndReplace(q8), t8);
		

	}

}
