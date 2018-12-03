/**
 * This class reverse and prints strings
 * @author Lucas Ward and Leonardo Bell
 */
public class PrintReverse
{
	/*
	 * The main method calls the printReverse method
	 */
	public static void main(String[] args)
	{
		printReverse("Hello There!");
		printReverse("Lucas Ward");
		printReverse("Leonardo Bell");
	}

	/*
	 * This method reverses and prints Strings
	 * @param printReverse takes a String
	 */
	public static void printReverse(String a)
	{
		int l = a.length();
		for(int j = l-1; j>=0; j--)
		{
			System.out.print(a.charAt(j));
		}
		System.out.println();
	}
}
