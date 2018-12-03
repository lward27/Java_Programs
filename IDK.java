/**
 * 
 */
package edu.ncsu.csc.csc216.acronym_annihilator;

/**
 * This class will implement the methods from the FSM interface.
 * @author Lydia Peedin
 *
 */
public class IDK {
	/** This is used to identify State 0 */
	private static final int STATE_ZERO = 0;
	/** This is used to identify State 1 */
	private static final int STATE_ONE = 1;
	/** This is used to identify State 2 */
	private static final int STATE_TWO = 2;
	/** This is used to identify State 3 */
	private static final int STATE_THREE = 3;
	/** This is used to identify State 4 */
	private static final int STATE_FOUR = 4;
	/** This is used to identify State 5 */
	private static final int STATE_FIVE = 5;
	/** This is a String that will replace the acronym idk */
	private String I_DONT_KNOW = "I don't know";
	
	/**
	 * This method will find and replace the acronyms
	 * @param String that contains the message
	 * @return String that contains the expanded acronyms
	 */
	//@Override
	public String findAndReplace(String msg) {
		String text = "";
		int i = 0;
		int state = STATE_ONE;
		char c;
		int x = 0;
		
		while (i < msg.length()){
			switch (state){			
				case STATE_ZERO: 
					c = msg.charAt(i);
					if (!Character.isLetter(c)){
						i++;
						state = STATE_ONE;
						break;
					}
					// This will occur if it is a letter
					i++;					
					break;

				case STATE_ONE:
					c = msg.charAt(i);
					if (!Character.isLetter(c)){
						i++;
						state = STATE_ONE;
						break;
					}
					if (c == 'i' || c == 'I'){						
						x = i;
						i++;
						state = STATE_TWO;						
						break;
					}
					// This will occur if it is a letter other than 'c' or 'C'
					i++;
					state = STATE_ZERO;
					break;				
				
				case STATE_TWO:
					c = msg.charAt(i);
					if (!Character.isLetter(c)){
						i++;
						state = STATE_ONE;
						break;
					}
					if (c == 'd' || c == 'D'){
						i++;
						state = STATE_THREE;						
						break;
					}
					// This will occur if it is a letter other than 'd' or 'D'
					i++;
					state = STATE_ZERO;
					break;					
				
				case STATE_THREE:
					c = msg.charAt(i);
					if (!Character.isLetter(c)){
						i++;
						state = STATE_ONE;
						break;
					}
					if (c == 'k' || c == 'K'){
						i++;
						state = STATE_FOUR;						
						break;
					}					
					// This will occur if it is a letter other than 'k' or 'K'
					i++;
					state = STATE_ZERO;
					break;				
				
				case STATE_FOUR:
					c = msg.charAt(i);
					if (!Character.isLetter(c)){
						i++;
						state = STATE_FIVE;
						break;
					}	
					// This will occur if it is a letter
					i++;
					state = STATE_ZERO;
					break;				
				
				case STATE_FIVE:
					c = msg.charAt(i);
					i++;					
					break;
			}
			
										//This check is to ensure this is carried out only if idk is the last thing in the String
			if (state == STATE_FOUR && ((msg.lastIndexOf('k') == (msg.length() - 1)) || (msg.lastIndexOf('K') == (msg.length() - 1)))){
	
				if (x == 0) {
					text = (I_DONT_KNOW + findAndReplace(msg.substring(x + 3, msg.length())));
					return text;
				} else {
					text = (msg.substring(0, x ) + I_DONT_KNOW + findAndReplace(msg.substring(x + 3, msg.length())));
					return text;
				}				
				
			} else if (state == STATE_FIVE){
				
				if (x == 0) {
					text = (I_DONT_KNOW + findAndReplace(msg.substring(x + 3, msg.length())));
					return text;
				} else {
					text = (msg.substring(0, x ) + I_DONT_KNOW + findAndReplace(msg.substring(x + 3, msg.length())));
					return text;
				}
			}
		}		
		text = msg.substring(0,msg.length());
		return text;
	}
}
