import java.io.*;
import java.util.*;

/**
 * Translates a file containing English to Pig Latin
 * and prints the results in another file
 * @author <YOUR NAME HERE>
 */
public class PigLatin {

	/**
	 * Starts the program
	 * @param args command line arguments
	 */
	public static void main(String [] args) {
		userInterface();
	}

	/**
	 * User interface that gets output and input file names from the
	 * user.  A Scanner is created for the input file and a PrintStream
	 * is created for the output file. If the objects are created
	 * successfully, then the input files is processed and results
	 * are printed to the output file via the processFile method
	 */
	public static void userInterface() {
		printDirections();
		Scanner console = new Scanner(System.in);
		System.out.print("Output File Name? ");
		String outputFile = console.nextLine();
		System.out.print("Input File Name? ");
		String inputFile = console.nextLine();

		Scanner inputFileScanner = getScanner(inputFile);
		PrintStream outputFilePrintStream = getPrintStream(outputFile);
		if (inputFileScanner != null && outputFilePrintStream != null) {
			processFile(inputFileScanner, outputFilePrintStream);
		}

	}

	/**
	 * Returns a Scanner for the String representing a possible file
	 * name or null if the file does not exist in the file system
	 * @param inputFileName String containing the user's input of a
	 *        fileName
	 * @return a Scanner or null if the file does not exist
	 */
	public static Scanner getScanner(String inputFileName) {
		//TODO: Create a null Scanner object
		Scanner lineInput = null;
		//TODO: Start a try catch block.  
		try
		{
			lineInput = new Scanner(new File(inputFileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		
			//TODO: Construct a new Scanner in the try block
			//Remember, to create a Scanner for a file, you must pass in
			//a file to the Scanner constructor


		//TODO: Create the catch for the appropriate exception that is 
		//thrown when creating a file Scanner.  Print the error message
		//"File Not Found" in the catch block
		


		//TODO: Return the Scanner object (or null if the Scanner is
		//not created).
		return lineInput;
	}

	/**
	 * Returns a PrintStream or null if the file cannot be created in
	 * the file system (which could be due to no space or lack of 
	 * permissions).
	 * @param outputFileName String containing the user's output file
	 *        name
	 * @return a PrintStream or null if file cannot be written
	 */
	public static PrintStream getPrintStream(String outputFileName) {
		//TODO: Create a null PrintStream object
		PrintStream output = null;	
		
		//TODO: Start a try block.  
		try
		{
			output = new PrintStream(outputFileName);
		}

			//TODO: Create a new PrintStream with the provided outputFileName
			//Remember, to create a PrintStream for a file, you must pass in
			//a file to the PrintStream constructor        
		catch(FileNotFoundException e)
		{
			System.out.println("File cannot be written");
		}	
		
		//TODO: Create the catch for the appropriate exception that is 
		//thrown when creating a PrintStream.  Print the error message
		//"File cannot be written" in the catch block
		

		//TODO: Return the PrintStream object (or null if the PrintStream is
		//not created).
		
		return output;
	}

	/**
	 * Processes the file using the given Scanner and PrintStream.  A 
	 * precondition of the method is that the Scanner and PrintStream
	 * cannot be null.
	 * @param input a Scanner for the input file
	 * @param output a PrintStream for the output file
	 */
	public static void processFile(Scanner input, PrintStream output) {
		//TODO: Complete the test for the while loop
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String pigLatinLine = processLine(line);
			output.println(pigLatinLine);
		}
	}

	/**
	 * Processes each line of the input file, and changes each English
	 * word to pig latin
	 * @param line a line of input
	 * @return the line in pig latin
	 */
	public static String processLine(String line) {
		//TODO: Create a Scanner called lineInput to process the line
		Scanner lineInput = new Scanner(line);
		
		String pigLatinLine = "";
		
		while (lineInput.hasNext()) {
			pigLatinLine += translateWord(lineInput.next()) + " ";
		}

		return pigLatinLine;
	}

	/**
	 * Translates an English word into Pig Latin.  If the word starts
	 * with a vowel, then -ay is added to the end of the word.  If the 
	 * word begins with a q, then -quay is added to the end of the word
	 * and the qu is removed from the beginning.  For all other letters
	 * the first character is removed and is added to the end as the 
	 * following -<char>ay.
	 * @param word word to translate to pig latin
	 * @return the pig latin word
	 */
	public static String translateWord(String word) {
		String newWord = "";
		char firstChar = word.charAt(0);
		if (Character.isLetter(firstChar)) {
			if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
				newWord += word + "-ay";
			} else if (firstChar == 'q') {
				newWord += word.substring(2) + "-quay";
			} else {
				newWord += word.substring(1) + "-" + firstChar + "ay";
			}
		} else {
			newWord = word;	//don't translate if doesn't start with a letter
		}
		return newWord;
	}

	/**
	 * Prints the directions of how to use the program
	 */
	public static void printDirections() {
		System.out.println("Welcome to Pig Latin Translator");
		System.out.println("You will be prompted for an output file name");
		System.out.println("that will store the results of translating");
		System.out.println("English into Pig-Latin");
		System.out.println();
		System.out.println("The English to translate will be read in from");
		System.out.println("a user provided file");
		System.out.println();
	}


}
