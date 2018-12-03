// page 262 number 7

import java.util.*;

public class EvenOrOdd
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.print("enter a number: ");
		int num = console.nextInt();
		evenOrOdd(num);
	}

	public static void evenOrOdd(int num)
	{
		if(num%2 == 1)
		{
			System.out.println("Odd");
		}
		else
		{
			System.out.println("Even");
		}
	}
}
