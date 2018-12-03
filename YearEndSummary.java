import java.util.*;

public class YearEndSummary
{



	
	public static void main(String[] args)
	{
		introduction();
		userInterface();
	}
	
	public static void userInterface()
	{
		double automotive_total = 0.0;
       		double clothing_total = 0.0;
       		double entertainment_total = 0.0;
       		double food_total = 0.0;
       		double housing_total = 0.0;
       		double medical_total = 0.0;
       		double other_total = 0.0;
       		double grand_total = 0.0;
		
		Scanner input_category = new Scanner(System.in);
		System.out.print("Enter Category or Q to Quit: ");
		String category = input_category.next();
		category = category.toLowerCase();	
		

		if(category.equals("a"))
		{
			Scanner input_money = new Scanner(System.in);
			System.out.println("Enter Amount: ");
			double amount = input_money.nextDouble();
			int cents = (int)Math.round(amount * 100);
			automotive_total += cents;
			grand_total += cents;
			userInterface();
		}
		if(category.equals("c"))
                {
                        Scanner input_money = new Scanner(System.in);
                        System.out.println("Enter Amount: ");
                        double amount = input_money.nextDouble();
                        int cents = (int)Math.round(amount * 100);
                        clothing_total += cents;
			grand_total += cents;
                }
		if(category.equals("e"))
                {
                        Scanner input_money = new Scanner(System.in);
                        System.out.println("Enter Amount: ");
                        double amount = input_money.nextDouble();
                        int cents = (int)Math.round(amount * 100);
                        entertainment_total += cents;
			grand_total += cents;
                }
		if(category.equals("f"))
                {
                        Scanner input_money = new Scanner(System.in);
                        System.out.println("Enter Amount: ");
                        double amount = input_money.nextDouble();
                        int cents = (int)Math.round(amount * 100);
                        food_total += cents;
			grand_total += cents;
                }
		if(category.equals("h"))
                {
                        Scanner input_money = new Scanner(System.in);
                        System.out.println("Enter Amount: ");
                        double amount = input_money.nextDouble();
                        int cents = (int)Math.round(amount * 100);
                        housing_total += cents;
			grand_total += cents;
                }
		if(category.equals("m"))
                {
                        Scanner input_money = new Scanner(System.in);
                        System.out.println("Enter Amount: ");
                        double amount = input_money.nextDouble();
                        int cents = (int)Math.round(amount * 100);
                        medical_total += cents;
			grand_total += cents;
                }
		if(category.equals("o"))
                {
                        Scanner input_money = new Scanner(System.in);
                        System.out.println("Enter Amount: ");
                        double amount = input_money.nextDouble();
                        int cents = (int)Math.round(amount * 100);
                        other_total += cents;
			grand_total = cents;
                }
		System.out.println(grand_total);


	}
	
	public static void introduction()
	{
		System.out.println("Year-End Summary calculator, please");
		System.out.println("choose a category: A-utomotive, C-lothing,");
		System.out.println("E-ntertainment, F-ood, H-ousing, M-edical,");
		System.out.println("O-ther, or Q-uit.");
	}
}
