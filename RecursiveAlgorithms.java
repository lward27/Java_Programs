package edu.ncsu.csc.csc216.recursion;

import java.io.File;
import java.util.Scanner;

/** 
 * Class containing various recursive algorithms
 * @author SarahHeckman
 */
public class RecursiveAlgorithms {
	
	/**
	 * Starts program
	 */
	public static void main(String [] args) {
		RecursiveAlgorithms r = new RecursiveAlgorithms();
		r.printStars(4);
		
		System.out.println();
		
		r.crawl(new File("."));
	}
	
	/**
	 * Prints the given number of stars
	 * @param n number of stars to print
	 */
	public void printStars(int n) {
		if (n == 0) {
			//base case; print new line
			System.out.println();
		} else {
			//recursive case; print one more star
			System.out.print("*");
			printStars(n - 1);
		}
	}
	
	/**
	 * Mystery method 1 for recursive tracing
	 * @param n some value of interest
	 */
	public int mystery1(int n) {
		if (n < 10) {
			return n;
		} else {
			int a = n / 10;
			int b = n % 10;
			return mystery1(a + b);
		}
	}
	
	/**
	 * Myster method 2 for recursive tracing
	 * @param n some value of interest
	 */
	public int mystery2(int n) {
		if (n < 10) {
			return (10 * n) + n;
		} else {
			int a = mystery2(n / 10);
			int b = mystery2(n % 10);
			return (100 * a) + b;
		}
	}
	
	/**
	 * Returns the value of the given
	 * base raised to the given exponent
	 * @param base value of base
	 * @param exp value of exponent
	 * @return base raised to exponent
	 */
	public int pow(int base, int exp) {
		if(exp == 0) {
			//base case; always returns 1
			return 1;
		} else if(exp % 2 == 0) {
			//recursive case 1
			return pow(base * base, exp/2);
		} else {
			//recursive case 2
			return base*pow(base,exp-1);
		}
	}
		
	/**
	 * Print a Binary number, it's user's responsibility
	 * to include a print line after calling it.
	 * @param num Number to change to binary
	 */
	public String printBinary(int num) {
		String str = "";
		if(num <= 1) {
			return "" + num;
		} else {
			str += num % 2;
			return printBinary(num / 2) + str;
		}
	}
	
	/**
	 * Returns true if the given string
	 * is a panindrome
	 */
	public boolean isPalindrome(String s) {
		return false;
	}
	
	/**
	 * Reverses the lines in a file
	 */
	public String reverseLines(Scanner input) {
		return "";
	}
	
	/**
	 * Recursively prints information about
	 * a directory structure (if there is one)
	 * @param f file/directory structure to crawl
	 */
	public void crawl(File f) {
		
	}
	
	/**
	 * Helper method for file crawler
	 * @param f file/directory to crawl
	 * @param indent level to indent
	 */
	private void crawl(File f, String indent) {
		
	}

}
