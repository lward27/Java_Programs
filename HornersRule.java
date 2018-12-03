package edu.ncsu.csc.csc216.state;

/**
 * Horner's Rule code is from Suzanne Balik's and 
 * Matthias Stallmann's Finite-State Machines handout.
 * 
 * The implementation of the State pattern for 
 * Horner's Rule comes from Dr. Ed Gehringer's notes
 *  
 * @author Dr. Sarah Heckman
 */
public class HornersRule {
	
	private final State start = new Start();
	private final State integer = new Integer();
	private final State decimal = new Decimal();
	private State state = start; //always start in the initial state
	
	double sign = 1;
	double value = 0;
	double power = 0.1;
	double multi = 10.0;
	
	char ch;
	
	/** 
	 * Parses the given string and returns the double
	 * value it represents.  If the String is invalid
	 * then 0.0 is returned.
	 * @param s String to parse into a double
	 * @return double value of the String or 0.0 if invalid
	 */
	public double toDouble(String s) {
		//reset values
		state = start;
		sign = 1.0;
		value = 0;
		power = 0.1;
		multi = 10.0;
		try {
			int i = 0; 
			while (i < s.length()) {
				ch = s.charAt(i++);
				if (ch == '.') {
					state.onPoint();
				} else if (ch == '+') {
					state.onPlus();
				} else if (ch == '-') {
					state.onMinus();
				} else if (Character.isDigit(ch)) {
					state.onDigit();
				} else {
					state.onOther();
				}
			}
		} catch (NumberFormatException e) {
			value = 0.0;
		}
		
		return sign * value;
		
	}
	
	/**
	 * Starts the program.
	 * Usage: java HornersRule <input-to-parse>
	 * @param args command line arguments
	 */
	public static void main(String [] args) {
		if (args.length == 1) {
			System.out.println(new HornersRule().toDouble(args[0]));
		} else {
			System.out.println("Usage: java HornersRule <input>");
		}
	}
	
	/**
	 * Implementation of the Start state for the 
	 * Horner's Rule FSM
	 * @author SarahHeckman
	 */
	private class Start implements State {

		@Override
		public void onDigit() {
			value = ch - '0';
			state = integer;
		}

		@Override
		public void onMinus() {
			sign = -1.0;
			state = integer;
		}

		@Override
		public void onOther() {
			throw new NumberFormatException();
		}

		@Override
		public void onPlus() {
			state = integer;
		}

		@Override
		public void onPoint() {
			state = decimal;
		}
		
	}
	
	/**
	 * Implementation of the Integer state for the 
	 * Horner's Rule FSM
	 * @author SarahHeckman
	 */
	private class Integer implements State {

		@Override
		public void onDigit() {
			value = 10 * value + (ch - 'o');
		}

		@Override
		public void onMinus() {
			throw new NumberFormatException();
		}

		@Override
		public void onOther() {
			throw new NumberFormatException();
		}

		@Override
		public void onPlus() {
			throw new NumberFormatException();
		}

		@Override
		public void onPoint() {
			state = decimal;
		}
		
	}
	
	/**
	 * Implementation of the Decimal state for the 
	 * Horner's Rule FSM
	 * @author SarahHeckman
	 */
	private class Decimal implements State {

		@Override
		public void onDigit() {
		}

		@Override
		public void onMinus() {
		}

		@Override
		public void onOther() {
		}

		@Override
		public void onPlus() {
		}

		@Override
		public void onPoint() {
		}
		
	}

}
