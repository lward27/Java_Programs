import java.util.*;

public class Pick
{
	public static void main(String[] args)
	{
		System.out.println("This program picks numbers from");
		System.out.println("1 to 100 until a particular");
		System.out.println("number comes up");
		System.out.println();

		Scanner console = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Pick a number between 1 and 100--> ");
		int number = console.nextInt();

		int result = -1;
		int count = 0;
		while(result != number)
		{
			result = r.nextInt(100) + 1;
			System.out.println("next number = " + result);
			count++;
		}
		System.out.println("Your number came up after " +
				    count + " times");


	}
}
