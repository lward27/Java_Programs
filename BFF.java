package edu.ncsu.csc.csc216.acronym_annihilator;

/**
 * Acronym FSM for BFF
 * 
 * @author William Fisher
 * 
 */

public class BFF {

	final static String ACRONYM = "bff";
	final static String REPLACEMENT = "best friend forever";

	public static int getIndexOfBFF(String text) {

		final int WAS_NOT_BFF = 0;
		final int START = 1;
		final int BEST = 2;
		final int FRIEND = 3;
		final int FOREVER = 4;
		final int END_NON_CHAR = 5;

		int cc = 0; // character position count
		int state = START; // initial state
		char ch; // current character
		int i = 0; // for index of string of text

		while (i < text.length()) {
			ch = text.charAt(i++);
			switch (state) {
			case WAS_NOT_BFF:
				if (!Character.isLetter(ch)) {
					state = START;
					cc++;
					break;
				} else {
					state = WAS_NOT_BFF;
					cc++;
					break;
				}
			case START:
				if (ch == 'b' || ch == 'B') {
					state = BEST;
					cc++;
					break;
				}
				if (!Character.isLetter(ch)) {
					state = START;
					cc++;
					break;
				} else {
					state = WAS_NOT_BFF;
					cc++;
					break;
				}
			case BEST:
				if (ch == 'f' || ch == 'F') {
					state = FRIEND;
					cc++;
					break;
				}
				if (!Character.isLetter(ch)) {
					state = START;
					cc++;
					break;
				} else {
					state = WAS_NOT_BFF;
					cc++;
					break;
				}
			case FRIEND:
				if (ch == 'f' || ch == 'F') {
					state = FOREVER;
					cc++;
					break;
				}
				if (!Character.isLetter(ch)) {
					state = START;
					cc++;
					break;
				} else {
					state = WAS_NOT_BFF;
					cc++;
					break;
				}
			case FOREVER:
				if (cc == (text.length() - 1)) {
					return cc - ACRONYM.length();
				}
				if (!Character.isLetter(ch)) {
					state = END_NON_CHAR;
					break;
				} else {
					state = WAS_NOT_BFF;
					cc++;
					break;
				}
			case END_NON_CHAR:
				return cc - ACRONYM.length();
			}
		}
		return -1;
	}

	public static String findAndReplace(String text) {
		int i = getIndexOfBFF(text);
		if (i == -1) {
			return text;
		} else {
			while (i != -1) {
				text = text.substring(0, i) + REPLACEMENT
						+ text.substring(i + ACRONYM.length());
				i = getIndexOfBFF(text);
			}
			return text;
		}
	}
}
