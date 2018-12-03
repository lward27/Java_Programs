/**
 * 
 */
package edu.ncsu.csc.csc216.acronym_annihilator;

/**
 * @author Robert Atkinson
 * @author Pierce Ellis
 * @author William Fisher
 * @author Lucas Ward
 * @author Lydia Peedin
 * @version 1.0
 */
public class Family {
	
	/**
	 * Finds and replaces only WRUD and BFF in a message
	 * @param msg Message to be searched and replaced
	 * @return Message with appropriate acronyms expanded.
	 */
	public static String findAndReplace(String msg) {
		msg = WRUD.findAndReplace(msg);
		msg = BFF.findAndReplace(msg);
		
		return msg;
	}

}
