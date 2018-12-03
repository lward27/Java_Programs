import java.util.*;
  

/**
 * This class calculates the sphereical distance between two points given their
 * Latitude and Longitude in degrees, distance in Km
 * @author Lucas Ward
 * @version 1.1
 */
public class DistanceCalculator
{
	public static final double EARTH_RADIUS = 6372.795;

	/**
	 * The main method gets the Latitudes and Longitudes from the user, and
	 * uses them as the parameters in the distance method
	 */
     	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		
		System.out.print("enter the latitude of the first point: ");
		double firstLatitude = console.nextDouble();
		System.out.print("enter the longitude of the first point: ");
		double firstLongitude = console.nextDouble();
		System.out.print("enter the latitude of the second point: ");
		double secondLatitude = console.nextDouble();
		System.out.print("enter the longitude of the second point: ");
		double secondLongitude = console.nextDouble();
		System.out.println();
		System.out.println("The Distance between these two points is: " + distance(firstLatitude,
				  firstLongitude, secondLatitude, secondLongitude) + " kilometers.");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
     	* Calculates distance in km between two points on the surface of the earth
     	* given their latitude and longitude in degrees
     	* @param firstLatitude latitude of first point in degrees
     	* @param firstLongitude longitude of first point in degrees
     	* @param secondLatitude latitude of second point in degrees
     	* @param secondLongitude longitude of second point in degrees
     	* @return distance in km between the two points
     	*/   
    	public static double distance(double firstLatitude, double firstLongitude,
                                  double secondLatitude, double secondLongitude) 
	{
        	double latOne = Math.toRadians(firstLatitude);
	        double lonOne = Math.toRadians(firstLongitude);
		double latTwo = Math.toRadians(secondLatitude);
		double lonTwo = Math.toRadians(secondLongitude);
		double delLon = lonTwo - lonOne;
		
		return (Math.acos((Math.sin(latOne)*Math.sin(latTwo)) +
		       ((Math.cos(latOne)*Math.cos(latTwo)*Math.cos(delLon)))))*EARTH_RADIUS;            
    	}
}
