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
 *
 */
public class Other {
	
	/**
	 * Finds and replaces all available acronyms
	 * @param msg Message to be searched and replaced
	 * @return Message with appropriate acronyms expanded.
	 */
	public static String findAndReplace(String msg) {
		msg = Lmao.findAndReplace(msg);
		msg = WRUD.findAndReplace(msg);
		msg = WTF.findAndReplace(msg);
		msg = IDK.findAndReplace(msg);
		msg = BFF.findAndReplace(msg);
		
		return msg;
	}

}
