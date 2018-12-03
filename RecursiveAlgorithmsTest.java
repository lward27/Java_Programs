package edu.ncsu.csc.csc216.recursion;

import java.util.Scanner;

import junit.framework.TestCase;

public class RecursiveAlgorithmsTest extends TestCase {
	
	private RecursiveAlgorithms r;

	protected void setUp() throws Exception {
		super.setUp();
		
		r = new RecursiveAlgorithms();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testMystery1() {
		assertEquals(9, r.mystery1(648));
	}
	
	public void testMystery2() {
		assertEquals(334488, r.mystery2(348));
	}

	public void testPow() {
		assertEquals(81, r.pow(3, 4));
		assertEquals(4, r.pow(2, 2));
		assertEquals(1, r.pow(1, 0));
	}

	public void testPrintBinary() { 
		assertEquals("111", r.printBinary(7));
		assertEquals("1100", r.printBinary(12));
		assertEquals("101010", r.printBinary(42));
		assertEquals("0", r.printBinary(0));
		assertEquals("1", r.printBinary(1));
	}

	public void testIsPalindrome() {
		assertTrue(r.isPalindrome("madam"));
		assertTrue(r.isPalindrome("racecar"));
		assertTrue(r.isPalindrome("step on no pets"));
		assertTrue(r.isPalindrome("able was I ere I saw elba"));
		assertFalse(r.isPalindrome("Java"));
		assertFalse(r.isPalindrome("rotater"));
		assertFalse(r.isPalindrome("byebye"));
		assertFalse(r.isPalindrome("notion"));
	}
	
	public void testReverseLines() {
		Scanner input = new Scanner("Roses are red,\nViolets are blue.\nAll my base\nAre belong to you.\n");
		String output = "Are belong to you.\nAll my base\nViolets are blue.\nRoses are red,\n";
		assertEquals(output, r.reverseLines(input));
	}
}
