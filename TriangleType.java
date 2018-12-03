import java.util.*;


/**
 * The TriangleType class reads the length of three sides of a triangle from the user
 * and returns the type of the triangle; Isosceles, Scalene, or Equalateral
 * @author Lucas Ward
 * @version 1.0
 */
public class TriangleType
{
	/**
	 * the main method utilizes the scanner in order to load the side lengths.
	 */
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the first side: ");
		int side1 = console.nextInt();
		System.out.println("Enter the second side: ");
		int side2 = console.nextInt();
		System.out.println("Enter the third side: ");
		int side3 = console.nextInt();
		
		checkTriangle(side1, side2, side3);
		printTriangleType(side1, side2, side3);

	}

	/**
	 * the printTriangleType method takes three integers corresponding to three sides
	 * of a triangle and through a series of If and else If statements, prints the
	 * triangle type
	 * @param int side1 is the first side of the triangle
	 * @param int side2 being the second
	 * @param int side3 being the third
	 */
	public static void printTriangleType(int side1, int side2, int side3)
	{
		
		if(side1 == side2 && side1 == side3)
		{
			System.out.println("Equalateral");
		}
		else if(side1 == side2 || side1 == side3 || side2 == side3)
		{
			System.out.println("Isosceles");
		}
		else
		{
			System.out.println("Scalene");
		}
		printSideMax(side1, side2, side3);
	}

	/**
	 * the printSideMax method prints the longest side of the triangle
	 * @param int side1 is the first side of the triangle
	 * @param int side2 being the second
	 * @param int side3 being the third
	 */	
	public static void printSideMax(int side1, int side2, int side3)
	{
		int max = 0;
		if(side1 >= side2)
		{
			max = side1;
		}		
		if(side3 >= side2)
		{
			max = side3;
		}
		else
		{
			max = side2;
		}
		System.out.println("The max side length is: " + max);
	}

	public static void checkTriangle(int side1, int side2, int side3)
	{
		//int a_c = Math.max(side1, side2);
		//int hyp = Math.max(a_c, side3);
		if(side1 <= 0 || side2 <= 0 || side3 <= 0)
		{
			System.out.println("invalid input for side length, recieved negative int or zero, positive int expected");
			System.exit(0);
		}
		else if(side1 >= (side2 + side3) || side2 >= (side1 + side3) || side3 >= (side1 + side2))
		{
			System.out.println("invalid input for side length, longest side cannot be greater than the sum of the other two sides");
			System.exit(0);
		}
	}
}
