import java.util.*;

/**
 * This class converts a integer value into binary
 * @author Lucas Ward, Lydia Peedin
 * @version 1.0
 */
public class Binary
{	
	/**
	 * The main method accepts input from user and sends it to the 
	 * converter method
	 */
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.print("please insert an integer: ");
		int num = console.nextInt();
		bi_converter(num);
		tri_converter(num);
	}
	
	/**
	 * Converts an integer to a binary value and prints it
	 * @param int num that is converted to binary
	 */
	public static void bi_converter(int num)
	{
		System.out.print("The binary version of this number is: ");
		int remainder = 0;
		String binaryNum = "";
		while(num > 0)
		{
			remainder = num%2;
			num = num/2;
			binaryNum += remainder;
		}
		int len = binaryNum.length();
		for(int i = 0; i < len; i++)
		{
			System.out.print(binaryNum.charAt((len-1)-i));
		}
		System.out.println();
	}
	
	public static void tri_converter(int num)
        {
		System.out.print("The base 3 version of this number is: ");
                int remainder = 0;
                String trinaryNum = "";
                while(num > 0)
                {
                        remainder = num%3;
                        num = num/3;
                        trinaryNum += remainder;
                }
                int len = trinaryNum.length();
                for(int i = 0; i < len; i++)
                {
                        System.out.print(trinaryNum.charAt((len-1)-i));
                }
                System.out.println();
        }
	
}
