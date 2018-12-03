import java.util.*;
import java.io.*;


/**
 * Secret Decoder encrypts and decrypts messages using a cipher file format
 * @author Lucas Ward
 * @version 1.0
 */
public class SecretDecoder
{
	/**
	 * The main menthod introduces the program and runs the user interface
	 */
	public static void main(String[] args)
	{
		System.out.println("Welcome to Ralphie's Secret Decoder.");
		System.out.println("When prompted, enter the name of the cipher file");
		System.out.println("to be used, as well as whether you want to encrypt,");
		System.out.println("decrypt, or quit, and the names of the input and");
		System.out.println("output files.");
		userInterface();
	}

	/**
	 * the user interface interacts with the user and runs the methods
	 */
	public static void userInterface()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the name of the cipher file.");
		String cipherFile = console.nextLine();
		while(true)
		{
			System.out.println("Would you like to (E)ncrypt, (D)ecrypt, or (Q)uit?");
			String option = console.nextLine();
			if(option.toLowerCase().equals("q"))
			{
				System.exit(0);
			} else {

		
		
				Scanner cipherScanner = null;
				try
				{
					cipherScanner = new Scanner(new File(cipherFile));
					} catch(FileNotFoundException e) {
					System.out.println("File Not Found");
				}
				
				if(option.toLowerCase().equals("e"))
				{	
					encrypt(getCipher(cipherScanner), getInputScanner(), getOutputPrintStream());
				}
				else if(option.toLowerCase().equals("d"))
				{
					decrypt(getCipher(cipherScanner), getInputScanner(), getOutputPrintStream());
				}
				else
				{
					System.out.println("wrong input try again");
				}
			}
		}	
	}

	/**
	 * Returns Scanner for an input file
	 * @return Scanner for an input file
	 */
	public static Scanner getInputScanner()
	{
		Scanner lineInput = null;
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the name of the input file.");
		String inputFileName = console.nextLine();
		File f = new File(inputFileName);
		while(!f.exists())
		{
			System.out.println("file does not exist, please try again");
			inputFileName = console.nextLine();
			f = new File(inputFileName);
		}
		try
		{
			lineInput = new Scanner(new File(inputFileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		return lineInput;
	
	}
	
	/**
	 * Returns PrintStream for output file
	 * @return PrintStream for output file
	 */
	public static PrintStream getOutputPrintStream()
	{
		PrintStream output = null;
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the name of the output file.");
		String outputFileName = console.nextLine();
		File f = new File(outputFileName);
		while(f.exists())
		{
			System.out.println("file all ready exists, okay to overwrite? (Y)es or (N)o?");
			if(console.nextLine().toLowerCase().equals("y"))
			{
				break;
			} else {
				System.out.println("please type a new file name");
				outputFileName = console.nextLine();
				f = new File(outputFileName);
			}
		}
		try
		{
			output = new PrintStream(outputFileName);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File cannot be written");
		}
		return output;
	}
	
	/**
	 * Returns char array that contains the cipher from file
	 * @param Scanner reads in cipher file to be saved into array
	 * @return char[] an array of characters
	 */
	public static char[] getCipher (Scanner cipherScanner)
	{
		char[] cipherArray = new char[26];
		int i = 0;
		while(cipherScanner.hasNext())
		{
			String character = cipherScanner.next();
			char character_1 = character.charAt(0);
			cipherArray[i] = character_1;
			i++;
		}
		return cipherArray;
		 
	}
	
	/**
	 * Encrypts message in input and outputs encrypted message
	 * to output based on cipher
	 * @param char[] an array of characters
	 * @param Scanner used to read the file
	 * @param PrintStream to print the encrypted message to
	 */
	public static void encrypt (char[] cipher, Scanner input, PrintStream
	output)
	{
		while(input.hasNextLine())
		{
			output.println(encryptLine(cipher, input.nextLine()));
		}
	}
	
	/**
	 * Returns string containing line encrypted using cipher
	 * @param char[] an array of characters
	 * @param String line to encrypt
	 * @return String an encryptedLine
	 */
	public static String encryptLine(char[] cipher, String line)
	{
		line = line.toLowerCase();
		int len = line.length();
		String encryptedLine = "";
		
		for(int i = 1; i <= len; i++)
		{
			if((int)line.charAt(i-1)-97 >= 0 && (int)line.charAt(i-1)-97 <= 26)
			{
				encryptedLine += cipher[((int)line.charAt(i-1))-97];
			}
			else
			{
				encryptedLine += line.charAt(i-1);
			}
		}
		return encryptedLine;
	}
	
	
	/**
	 * Decrypts message in input and outputs encrypted message
	 * to output based on cipher
	 * @param char[] an array of characters
	 * @param Scanner to read in the file
	 * @param PrintStream to print the decrypted message to
	 */
	public static void decrypt (char[] cipher, Scanner input, PrintStream
	output)
	{
		while(input.hasNextLine())
		{
			output.println(decryptLine(cipher, input.nextLine()));
		}
	}
	
	/**
	 * Returns string containing line decrypted using cipher
	 * @param char[] array of characters
	 * @param String line to be decrypted
	 * @return String decrypted line
	 */
	public static String decryptLine(char[] cipher, String line)
	{
		line = line.toLowerCase();
		int len = line.length();
		String decryptedLine = "";
		
		for(int i = 1; i <= len; i++)
		{
			if((int)line.charAt(i-1)-97 >= 0 && (int)line.charAt(i-1)-97 <= 26)
			{
				decryptedLine += (char)((indexOf(cipher, line.charAt(i-1)))+97);
			}
			else
			{
				decryptedLine += line.charAt(i-1);
			}
		}
		return decryptedLine;
	
	}
	
	/**
	 * Returns integer index of the character in the array
	 * @param char[] an array of letters
	 * @param char a character
	 * @return int index of char in array
	 */
	public static int indexOf(char[] cipher, char character)
	{
		for(int i = 0; i < cipher.length; i++)
		{
			if(cipher[i] == character)
			{
				return i;
			}
		}
		return -1;
	}


}
