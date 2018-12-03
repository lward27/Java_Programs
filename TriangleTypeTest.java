/**
 * This class tests the TriangleType class, Since the TriangleType class is programmed to handle
 * incorrect input, the test class does not take into account negative numbers, letters, or zero.
 * @author Lucas Ward
 */

public class TriangleTypeTest
{
	/**
	 * The main method runs the test classes
	 */
	public static void main(String[] args)
	{
		testPrintTriangleType1();
		testPrintTriangleType2();
		testPrintTriangleType3();
		testPrintTriangleType4();
		testPrintTriangleType5();
	}

	// test class one side lengths: 3,4,5
	public static void testPrintTriangleType1()
	{
		System.out.println("	Expected: Type: scalene\n\t\t  Max side: 5");
		System.out.print("Actual: ");
		TriangleType.printTriangleType(3,4,5);
	}
	
	// test class one side lengths: 3,1,5
	public static void testPrintTriangleType2()
	{
		System.out.println("	Expected: Scalene\n\t\t  Max side: 5");
		System.out.print("Actual: ");
		TriangleType.printTriangleType(3,1,5);
	}

	// test class one side lengths: 99,88,99
	public static void testPrintTriangleType3()
	{
		System.out.println("	Expected: Isosceles\n\t\tMax side: 99");
		System.out.print("Actual: ");
		TriangleType.printTriangleType(99,88,99);
	}

	// test class one side lengths: 2,2,2
	public static void testPrintTriangleType4()
	{
		System.out.println("	Expected: Equilateral\n\t   Max side: 2");
		System.out.print("Actual: ");
		TriangleType.printTriangleType(2,2,2);
	}

	// test class one side lengths: 6,6,6
	public static void testPrintTriangleType5()
	{
		System.out.println("	Expected: Type: equilateral\n\t\t  Max side: 6");
		System.out.print("Actual: ");
		TriangleType.printTriangleType(6,6,6);
	}

}
