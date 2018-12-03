/** 
 * Prints the calculation for the sequence of 1/(2^i) from i=0 to the
 * provided n
 * @author Lucas Ward
 */
public class FractionSum {
   
	/**
	* Tests the printFractionSum method with different inputs
	* @param args array of command line arguments
	*/
	public static void main(String [] args) 
	{
		printFractionSum(1); //1 + (1/2)
      		printFractionSum(5); //1 + (1/2) + (1/4) + (1/8) + (1/16) + (1/32)
      		printFractionSum(4);   //1 + (1/2) + (1/4) + (1/8) + (1/16)
   	}

	/**
	* Prints the string with the expanded summation of 
	* 1 / 2^n using a Cumulative String and Fencepost loop
	* @param n the number of times to sum the expression
	*/
	public static void printFractionSum(int n) 
	{
		String s = "";
		for(int i = 0; i <= n; i++)
		{
			if(n == 0)
			{
				s += "1";
			}
			else if(i == 0)
			{
				s += "1 + ";
			}
			else if(i == n)
			{
				s += "(1/" + (int) Math.pow(2,i) + ")";
			}
			else
			{
				s += "(1/" + (int) Math.pow(2,i) +") + ";
			}
		}
		System.out.println(s);
	}

}

