/**
 * This class prints the number with the largest absolute value
 */

public class NumberManipulator
{
	/**
	 * This method prints the results returned by largerAbsVal method
	 */
	public static void main(String[] args)
	{
		System.out.println(largerAbsVal(11,2));
		System.out.println(largerAbsVal(13,-14));
		System.out.println(largerAbsVal(0,6));
	}
	
	/**
	 * This method computes number with largest absolute value
	 * @param takes two integers
	 * @return returns the largets of the absolute value of the two integers taken
	 */
	public static int largerAbsVal(int x,int y)
	{
		int new_x = Math.abs(x);
		int new_y = Math.abs(y);
		return Math.max(new_x, new_y);
	}
}
