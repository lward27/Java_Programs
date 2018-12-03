import java.util.*;

/**
 * Determines the first 'num' characters of a String 'word', where
 * 'num' and 'word' are entered by the user
 * @author Lucas Ward
 */
public class Substring 
{
	/**
	* Main method that starts program and handles user I/O
	*/
	public static void main(String [] args) 
	{
      		Scanner in = new Scanner(System.in);
  		System.out.print("Enter a word: ");
		String word = in.next();
		System.out.print("Enter a number: ");
		int num = in.nextInt();
		printSub(word, num);
   	}

  	 /**
   	 * Prints the first num characters of the specified word
   	 * PRECONDITION: num < word.length()
   	 * @param word String containing a word
   	 * @param num number of letters to print in the String
   	 */
   	public static void printSub(String word, int num) 
	{
		System.out.println(word.substring(0, num));
	}
}
