package edu.ncsu.csc.csc216.acronym_annihilator;

import edu.ncsu.csc.csc216.acronym_annihilator.model.contacts.Contact;
/**
 * Class to pass message to be expanded to 
 * strategies based on a contact label
 * @author Robert Atkinson
 * @author Lydia Peedin
 *
 */
public class AcronymManager {
	
	/**
	 * Expands acronyms based on the highest label of an array of Contacts
	 * @param contacts Array of contacts to be emailed
	 * @param msg Message to be searched for acronyms
	 * @return message with appropriate acronyms expanded.
	 */
	public static String annihilateAcronyms(Contact[] contacts, String msg) {
		
		
		for(int i = 0 ; i < contacts.length ; i++ ) {
			if (contacts[i] == null) {
				msg = Other.findAndReplace(msg);
				break;
			}
			if (contacts[i] != null) {
				if( contacts[i].getLabel().equals(Constants.PROFESSIONAL_LABEL)) {
					msg = Professional.findAndReplace(msg);
					break;
				}
				if ( contacts[i].getLabel().equals(Constants.OTHER_LABEL)) {
					msg = Other.findAndReplace(msg);
					break;
				}
				if ( contacts[i].getLabel().equals(Constants.FAMILY_LABEL)) {
					msg = Family.findAndReplace(msg);
				}
			}
			
		}
		
		return msg;
	}

}
