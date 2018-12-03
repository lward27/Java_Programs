package edu.ncsu.csc.csc216.acronym_annihilator;

public class wrudFSM {
	
	public static String findAndReplace(String s) {
		int i = 0;
		int loc = 0;
		
		final int ZERO = 0;
		final int ONE = 1;
		final int TWO = 2;
		final int THREE = 3;
		final int FOUR = 4;
		final int FIVE = 5;
		final int SIX = 6;
		final int ERROR = 7;
		
		
		
		int state = ONE; //current state - always start at state ONE
		char ch; //current character
		String newS = "";
		
		while (state != ERROR && i < s.length()) {
			ch = s.charAt(i++); //Get the character at i then increment i
			switch(state) {
				case ZERO:
					if(i == s.length()) {
						newS = s;
					} else if(!Character.isLetter(ch)) {
						state = ONE;
					} else {
						state = ZERO;
					}
					break;
				case ONE:
					if(ch == 'W' || ch == 'w') {
						System.out.println("going to state two");
						state = TWO;
					} else if (!Character.isLetter(ch)) {
						state = ONE;
					} else {
						state = ZERO;
					}
					break;
				case TWO:
					if(ch == 'R' || ch == 'r') {
						System.out.println("going to state three");
						state = THREE;
					} else if (!Character.isLetter(ch)) {
						state = ONE;
					} else {
						state = ZERO;
					}
					break;
				case THREE:
					if(ch == 'U' || ch == 'u') {
						System.out.println("going to state four");
						state = FOUR;
					} else if (!Character.isLetter(ch)) {
						state = ONE;
					} else {
						state = ZERO;
					}
					break;
				case FOUR:	
					if(ch == 'D'|| ch == 'd') {
						if(i == s.length()) {
							newS = s.substring(0,i-4) + "what are you doing" + s.substring(i);
						}
						System.out.println("goind to state five" + i + s.length());
						loc = i-4;
						state = FIVE;
					} else if (!Character.isLetter(ch)) {
						state = ONE;
					} else {
						state = ZERO;
					}
					break;
				case FIVE:
					if(i == s.length()) {
						newS = s.substring(0,loc) + "what are you doing" + s.substring(loc + 4, s.length());
					} else if (!Character.isLetter(ch)) {
						System.out.println("going to state six via not is letter");
						state = SIX;
					} else {
						System.out.println("going to state zero and i don't know why...");
						state = ZERO;
					}
					break;
				case SIX:
					newS = s.substring(0,loc) + "what are you doing" + s.substring(loc + 4, s.length());
					break;
				
				
			}
			
		}
		
		return newS;
	}


}
