package edu.ncsu.csc.csc216.acronym_annihilator;

/**
 * Finds and replaces "lmao" with
 * "laughing my assets off" within a
 * given text.
 * @author Robert Atkinson
 * 
 * 
 */
public class Lmao implements FSM {

	/** Index of String msg initialized to 0 */
	private int index = 0;
	/** 0th state of the FSM */
	private final int STATE_0 = 0;
	/** initial state of the FSM */
	private final int STATE_1 = 1;
	/** 2nd state of the FSM */
	private final int STATE_2 = 2;
	/** 3rd state of the FSM */
	private final int STATE_3 = 3;
	/** 4th state of the FSM */
	private final int STATE_4 = 4;
	/** 5th state of the FSM */
	private final int STATE_5 = 5;

	@Override
	public String findAndReplace(String msg) {
		String beforeLmao = "";
		String afterLmao = "";
		while (containsLmao(msg)) {
			beforeLmao = msg.substring(0, index + 1);
			afterLmao = msg.substring(index + 4);
			msg = beforeLmao + "aughing my assets off" + afterLmao;
		}

		index = 0;

		return msg;
	}

	/**
	 * Finds the first instance of lmao within a
	 * given text.
	 * @param text Text to be searched.
	 * @return true if text contains lmao.
	 * @return false if text does not contain lmao.
	 */
	private boolean containsLmao(String text) {
		int state = STATE_1;

		while (index < text.length()) {
			switch (state) {
			case STATE_0:
				if (!Character.isLetter(text.charAt(index))) {
					state = 1;
				}
				index++;
				break;
			case STATE_1:
				if (!Character.isLetter(text.charAt(index))) {
					index++;
					break;
				} else if (text.charAt(index) == 'l' || text.charAt(index) == 'L') {
					state = 2;
					index++;
					break;
				} else {
					state = 0;
					index++;
					break;
				}
			case STATE_2:
				if (!Character.isLetter(text.charAt(index))) {
					state = 1;
					index++;
					break;
				} else if (text.charAt(index) == 'm' || text.charAt(index) == 'M') {
					state = 3;
					index++;
					break;
				} else {
					state = 0;
					index++;
					break;
				}
			case STATE_3:
				if (!Character.isLetter(text.charAt(index))) {
					state = 1;
					index++;
					break;
				} else if (text.charAt(index) == 'a' || text.charAt(index) == 'A') {
					state = 4;
					index++;
					break;
				} else {
					state = 0;
					index++;
					break;
				}
			case STATE_4:
				if (!Character.isLetter(text.charAt(index))) {
					state = 1;
					index++;
					break;
				} else if (text.charAt(index) == 'o' || text.charAt(index) == 'O') {
					if (index == text.length() - 1){
						index -= 3;
						return true;
					}
					state = 5;
					index++;
					break;
				} else {
					state = 0;
					index++;
					break;
				}
			case STATE_5:
				if (Character.isLetter(text.charAt(index))) {
					state = 0;
					index++;
					break;
				} else {
					index -= 4;
					return true;
				}
			}
		}
		return false;
	}

}
