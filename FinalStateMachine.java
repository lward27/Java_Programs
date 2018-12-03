public class FinalStateMachine {
	
	public static final int STATE_ZERO = 0;
	public static final int STATE_ONE = 1;
	
	public int containsLol(String txt) {
		
		int chCount = 0;
		int i = -1;
		int sIdx = 0;
		int state = STATE_ONE;
		
		while(sIdx < txt.length()) {
			char c = txt.charAt(sIdx);
			switch( state ) {
				case STATE_ZERO:
					if(c == 'l' || c == 'L'){
						chCount++;
					} else if(c == 'o' || c == 'O') {
						chCount++;
					} else if(Character.isLetter(c)) {
						chCount++;
					} else {
						chCount++;
						state = STATE_ONE;
					}
					break;
			}
			sIdx++;
		}
		return sIdx;
	}
}
