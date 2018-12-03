/**
 * This class prints numbers
 * @author Leonardo Bell and Lucas Ward
 * @version 1.0
 */

public class PrintNumbers
{
	/**
	 * This method calls the PrintNumbers Method in order to print numbers.
	 */
	public static void main(String[] args)
	{
		printNumbers(15);
		System.out.println();
		printNumbers(3);
		System.out.println();
		printNumbers(7);
		System.out.println();
	}
	
	/**
	 * This method takes an integer called max_number and prints the numbers preceding it up to it.
	 */
	public static void printNumbers(int max_number)
	{
		for(int i = 1; i <= max_number; i++)
		{
			System.out.print("[" + i + "] ");

		}
	}
}
