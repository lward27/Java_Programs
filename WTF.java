package edu.ncsu.csc.csc216.acronym_annihilator;


public class WTF {

	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int ZERO = 0;
	private static final int WTF_LENGTH = 3;
	private static final String WTF = "what the fudge";
	
	
	/**
	 * Should not use the main method due to this being a static object
	 */
	public static void main(String[] args) {
		System.out.println("Error, should not have reached here");
	}
	
	/**
	 * The FSM to replace the WTF acronym. 
	 * @param msg The message to be processed
	 * @return The unabreviated message
	 */
	public static String findAndReplace(String msg){
		char ch; //The character to be looked at
		int i = 0; //Incrementor 
		int state = 1; //Start at state 1
		int k = 0;  //Keeps track of where the 'w' is in "wtf"
		
		//Loop while there is still letters left in the text
		while (i < msg.length()){
			switch (state){
			case ZERO: 
				ch = msg.charAt(i);
				if (!Character.isLetter(ch)){
					state = ONE;
					break;
				}
				break;
			case ONE:
				ch = msg.charAt(i);
				if (!Character.isLetter(ch)){
					state = ONE;
					break;
				}
				if (ch == 'w' || ch == 'W'){
					state = TWO;
					k = i;
					break;
				}
				state = ZERO;
				break;
			case TWO:
				ch = msg.charAt(i);
				if (!Character.isLetter(ch)){
					state = ONE;
					break;
				}
				if (ch == 't' || ch == 'T'){
					state = THREE;
					break;
				}
				state = ZERO;
				break;
			case THREE:
				ch = msg.charAt(i);
				if (!Character.isLetter(ch)){
					state = ONE;
					break;
				}
				if (ch == 'f' || ch == 'F'){
					state = FOUR;
					break;
				}
				state = ZERO;
				break;
			case FOUR:
				ch = msg.charAt(i);
				if(!Character.isLetter(ch)){
					state = FIVE;
					break;
				}
				state = ZERO;
				break;
			case FIVE:
				msg = replace(msg, i, k);
				state = ZERO;
				break;
			default:
				System.out.println("Oops");
			}
			i++;
		}
		
		//Verifies that if a final state was met, it was replaced (handles if it was the end of the line)
		if (state == FOUR || state == FIVE)
			msg = replace(msg, i, k);
	
		return msg;
	}
	
	/**
	 * Replaces the found "wtf" acronym
	 * @param msg the text that contains the acronym 
	 * @param i The last character that was looked at
	 * @param k The location of the 'w' in "wtf"
	 * @return  The unabreviated message
	 */
	private static String replace(String msg, int i, int k){
		String newMsg; 
		
		newMsg = msg.substring(0, k) + WTF + msg.substring(k+WTF_LENGTH); //Cuts out the "wtf" and replaces it with "what the fudge"
		return newMsg;
	}
	

}
