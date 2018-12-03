import java.awt.*;
import java.util.*;

/*
 * This class returns the perimeter of a triangle given these two values
 * a = 50, b = 100
 * @author Lucas Ward and Leonardo Bell
 */
public class TrianglePerimeter
{
	//public static final int a = 50;
	//public static final int b = 100;

	
	/*
	 * The main method sets the points and runs the perimeter method
	 */
	public static void main(String[] args)
	{

		Scanner in = new Scanner(System.in);
		System.out.println("What are the values of a and b?");
		int a = in.nextInt();
		int b = in.nextInt();
		Point p1 = new Point();
		Point p2 = new Point(a,b);
		System.out.println("Perimeter: " + perimeter(p1,p2));	
	}

	/*
	 * This method calculates the distance between two points
	 * @param Takes two points
	 * @return returns a double
	 */
	public static double perimeter(Point p1, Point p2)
	{

		return (p1.distance(p2))+(p2.x)+(p2.y);
	
	}
}





