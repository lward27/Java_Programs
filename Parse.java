import java.io.*; // For input output functions     
import java.util.Scanner;  // For reading lines and words.
/** System.in.read() can throw an IOException   **/


public class Parse {
	
    private static PrintStream output; // initialize PrintStream

	static int LABEL = 0; // zero is no and 1 is yes
	static int OPCODE = 0;
	static int OPER1 = 0;
	static int OPER2 = 0;
	static int COMMENT = 0;

	/**
	 * Retreives input file sample.in
	 */
	public static void getFile() {
    	try {
        	Scanner fileInput = new Scanner(new File("sample.in"));
            while(fileInput.hasNextLine()) {
            	resetCodes(); // Resets Label -> comment codes to zero
            	processLine(fileInput.nextLine()); // sends line for processing
            }
        }
        catch(FileNotFoundException e) {
        	System.out.println("File does not exist");  // If file does not exist
        }
    }
	
	/**
	 * Reads a line and sets codes for the line.
	 * @param line
	 */
	public static void processLine(String line) {
    	Scanner lineInput = new Scanner(line); // pass the scanner the line of input
    	output.println(line); // prints the lint to ouput.txt
    	//System.out.println(line);
    	String word = ""; // creates variable to hold word to be processed
    	int count = 0; // counts which word of the line is being processed
    	while(lineInput.hasNext()) { // checks for next word
    		word = lineInput.next(); // sets word equal to next word
    		count ++; // increases count by 1
    		int len = word.length(); // set len to lenght of word being processed
    		// Checks for label
    		if(word.charAt(len - 1) == ':') {
    			LABEL = 1;
    		} 
    		// checks for comment
    		if(word.charAt(0) == ';') {
    			COMMENT = 1;
    		}
    		//Checks for opcode. if it is first or second word and is not a comment or label
    		if((count == 1 || count == 2) && word.charAt(len - 1) != ':' && COMMENT != 1) {
    			OPCODE = 1;
    		}
    		//checks for first operand and to see if a comment has all ready been read
    		if(OPCODE == 1 && word.charAt(0) == '[' && COMMENT != 1) {
    			OPER1 = 1;
    		}
    		// checks for first opcode and second opcode, and if a comment has been read
    		if(OPCODE == 1 && COMMENT != 1 && word.contains(",") == true) {
    			OPER1 = 1;
    			OPER2 = 1;
    		}
    		
    		//System.out.println("  " + word + "  " + count);
    		
    	}
    	// checks to see if line is an empty line, do not print opcodes
    	if(count != 0) {
    	  printCodes();
    	}
    	
    	
    	
    	
    }
	// sets printstream to print to output.txt, checks if file can be written
	public static void getPrintStream() {
		try
    	{
    		output = new PrintStream("output.txt");
    	}
    	catch (FileNotFoundException e)
    	{
    		System.out.println("Output file could not be written");

        }
	}
	
	/**
	 * pritns the codes for LABEL, OPCODE, OPER1, OPER2 AND COMMENT
	 */
	public static void printCodes() {
		
		if(LABEL == 0) {
			output.print("LABEL=N  ");
		} else { output.print("LABEL=Y  "); }
		if(OPCODE == 0) {
			output.print("OPCODE=N  ");
		} else { output.print("OPCODE=Y  "); }
		if(OPER1 == 0) {
			output.print("OPER1=N   ");
		} else { output.print("OPER1=Y   "); }
		if(OPER2 == 0) {
			output.print("OPER2=N   ");
		} else { output.print("OPER2=Y   "); }
		if(COMMENT == 0) {
			output.print("COMMENT=N   ");
		} else { output.print("COMMENT=Y   "); }
		output.println();
		output.println();
		
		
	}
	/**
	 * resets all codes to zero
	 */
	public static void resetCodes() {
		LABEL = 0;
		OPCODE = 0;
		OPER1 = 0;
		OPER2 = 0;
		COMMENT = 0;
	}
	/**
	 * main program driver
	 * @param args
	 */
	public static void main(String[] args) {
		getPrintStream();
		getFile();
		
	}
	
}
  
