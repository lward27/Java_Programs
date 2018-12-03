/**
 * This Class Approximates the value of Pi and e and compares these approximations to Java's Math.PI and Math.E constants
 * @author Lucas Ward
 * @version 1.0
 */

public class Calculator
{
	/**
	 * This method calls the approximation methods
	 */
	public static void main(String[] args)
	{
		calculatePi(10);
		calculatePi(100000);
		calculatePi(1000000);
		System.out.println("This is Javas value for PI: " + Math.PI);
		//System.out.println("The Value of the Java Constant Math.PI is equal to " + Math.PI + ".");
		factorial(5);
		calculateE(25);
	}
	
	/**
         * This method approximates PI and compares it to Math.PI!
	 * @param num_iter takes an integer value equal to the number of terms in the Madhava-Leibniz sequence used to approximate PI
         */
	public static void calculatePi(int num_iter)
	{
		int num_iter_2 = 2*num_iter;
		double approx_pie_1 = 0;
		double approx_pie_2 = 0;
		
		for(double j = 1; Math.abs(j) < num_iter_2; j += 4)
		{		
			
			double current_num_in_sequence = 4/j;
			approx_pie_1 += current_num_in_sequence;
		}
		
		for(double k = -3; Math.abs(k) < num_iter_2; k -= 4)
		{
			double current_num_in_neg_sequence = 4/k;
			approx_pie_2 += current_num_in_neg_sequence;
 
		}
		
		double approx_pie = approx_pie_1 + approx_pie_2;
		System.out.println("The approximateion of Pi using " + num_iter + " iterations of the Madhava-Leibniz sequence is " + approx_pie); 

	}

	/**
	 * This method approximates E, prints each succesive approximation of E, and compares the approximation to Math.E
	 * @param num_iter takes an integer value equal to the number of terms used in the sequence to approximate E
	 */
	public static void calculateE(int num_iter)
	{
		double approx_e = 0;
		for(int j = 0; j < num_iter; j++)
		{
			double current_num_in_sequence = 1./factorial(j);
			approx_e += current_num_in_sequence;
			System.out.println(approx_e);
		}
		System.out.println("This is my approximation of e: " + approx_e + " compared to the value of Math.E (" + Math.E + ") used by Java as a constant for E");
	}	
	
	/**
	 * This method calculates n! of a given integer n
	 * @param n takes an integer value that is in turn used to calculate n!
	 */

	public static double factorial(int n)
	{
		double factorial_ans = 1;
		for(int j = 1; j <= n; j++)
		{
			factorial_ans = factorial_ans * j;
		}
		return factorial_ans;
	}
}












