import java.util.Scanner;
import java.io.*;


public class programThree {
	static int amount;
	static boolean active = true;
	
	public static void main(String[] args) throws IOException
	{
		System.out.print("Please enter your name: ");
		Scanner keyboard = new Scanner(System.in);
		String name = keyboard.nextLine();
		
		File file = new File(name);
		
		if(!file.exists()) {
			System.out.println("Welcome to the Bank of Holly.");
			System.out.println("We are delighted to open a new account for you.");
			System.out.print("What is the amount of you initial deposit? (do not enter , or $) ");
			amount = keyboard.nextInt();
			System.out.println("Your opening balance is $" + amount);
			//PrintWriter outputFile = new PrintWriter(file);
		}
		else
		{
			System.out.println("Welcome back, " + name);
			Scanner inputFile = new Scanner(file);
			amount = inputFile.nextInt();
			System.out.println("Your current balance is $" + amount);
		}

		while(active == true)
		{
			System.out.print("1 - Deposit\n2 - Withdrawal\n3 - Balance Inquiry\n4 - Quit\nPlease enter the number for the type of transaction you would like to make: ");
			int choice = keyboard.nextInt();
			if(choice == 1)
			{
				//depoist
				System.out.print("Please enter the amount for your deposit (do not enter, or $): ");
				int deposit = keyboard.nextInt();
				amount += deposit;
				System.out.println("Transaction complete. Thank you.");
			}
			if(choice == 2)
			{
				//withdrawal
				System.out.print("Please enter the amount you would like to withdraw (do not enter , or $): ");
				int withdraw = keyboard.nextInt();
				if(amount >= withdraw)
				{
					amount -= withdraw;
					System.out.println("Transaction complete. Thank you.");

				}
				else
				{
					System.out.println("Not enough funds.");
				}
			}
			if(choice == 3)
			{
				//Balance Inquiry
				System.out.println("Your current balance is " + amount);
			}
			if(choice == 4)
			{
				//quit
				System.out.println("Thank you for banking with Bank of Kristen. We appreciate your buisness.");
				PrintWriter outputFile = new PrintWriter(file);
				outputFile.println(amount);
				outputFile.close();
				System.exit(1);
			}
			else if(choice != 1 && choice != 2 && choice != 3 && choice != 4)
			{
				System.out.println("Incorrect input, please try again.");
			}
				
		}
		
	}
}
