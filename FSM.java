package edu.ncsu.csc.csc216.acronym_annihilator;
/**
 * Interface for FSMs.  Finds and replaces acronyms.
 * @author Robert Atkinson
 * @author Lydia Peedin
 * @author Lucas Ward
 * @author Pierce Ellis
 * @author William Fisher
 *
 */
public interface FSM {
	
	/**
	 * Finds the appropriate Acronym and replaces it.
	 * @param msg message to be searched.
	 * @return message with appropriate acronyms expanded.
	 */
	public String findAndReplace(String msg);

}
