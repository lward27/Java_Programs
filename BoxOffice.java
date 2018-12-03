import java.util.*;

/**
 * The BoxOffice class computes ticket prices at a local theater
 * @author Lucas Ward
 * @version 1.0
 */
public class BoxOffice
{
	/**
	 * The main method introduces the user to the system and runs the user interface
	 */
	public static void main(String[] args)
	{
		System.out.println("	Welcome to the Show!");
		System.out.println("When prompted, please enter the movie you would like to see, the");
		System.out.println("date, whether or not its a matinee, and the number of adult");
		System.out.println("and Student tickets you would like to buy!");
		userInterface();
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * the userInterface method collects information such as movie, date, matinee, and
	 * number of tickets
	 */
	public static void userInterface()
	{
		Scanner console = new Scanner(System.in);

		System.out.print("Movie (Avatar, The Blind Side, Up): ");
		String movie = console.next();
		movie = movie.toLowerCase();
		
		if(isValidMovie(movie) == false)
		{	
			System.out.println("Invalid Input");
			System.exit(1);
		}		

		System.out.print("Month: ");
		int month = console.nextInt();

		System.out.print("Day: ");
		int day = console.nextInt();

		if(isValidDate(month,day) == false)
		{
			System.out.println("Invalid Input");
			System.exit(1);
		}
		
		System.out.print("Matinee (y,n): ");
		String matinee = console.next();

		isMatinee(matinee);

		System.out.print("Number of adult tickets: ");
		int numberOfAdultTickets = console.nextInt();

		System.out.print("Number of student tickets: ");
		int numberOfStudentTickets = console.nextInt();
		
		if(numberOfAdultTickets < 0 || numberOfStudentTickets < 0)
		{
			System.out.println("Invalid Input");
			System.exit(1);
		}

		System.out.println("price: " + getCost(movie, month, day, isMatinee(matinee), numberOfAdultTickets, numberOfStudentTickets));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * The isValidMovie method checks to make sure the user entered a valid movie title
	 * @param String movie inputed by user
	 * @return boolean
	 */
	public static boolean isValidMovie(String movie)
	{
		String s = movie;
		if(s.equals("avatar") == true || s.equals("the blind side") == true || s.equals("up") == true)
		{
			return true;
		}
		else
		{
			return false;	
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * The isValidDate method Returns true if the date is a valid date between March 1 and May 15   
	 * Returns false otherwise
	 * @param int month is the month the user enters
	 * @param int day is the day the user enters
	 * @return boolean true or false
	 */  
	public static boolean isValidDate(int month, int day)
	{     
		if(month == 3)
		{ 
			if(day >=1 && day <= 31)
			{
				return true;
			}
			return false;
		}
		if(month == 4)
		{
			if(day >= 1 && day <= 30)
			{
				return true;
			}
			return false;
		}
		if(month == 5)
		{
			if(day >= 1 && day <= 15)
			{
				return true;
			}
			return false;
		}
		return false;
   	}      
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	/**
	 * This method uses Zeller's algorithm to   
   	 * Return true if date falls on Monday through Thursday   
   	 * Return false if date falls on Friday through Sunday   
   	 * @param int month is the month entered by the user
	 * @param int day is the day entered by the user
	 * @return boolean true of false   
	 */
   	public static boolean isWeekday(int month, int day) 
	{      
		int y = 2010;
		int m = month;
		int d = day;
		int w = 0;
		int x = 0;
		int z = 0;
		w = y - (14 - m) / 12;
		x = w + w / 4 - w / 100 + w / 400;
		z = m +  12 * ((14 - m) / 12) - 2;
		int dayOfWeek = (d + x + (31 * z) / 12) % 7;
		if(dayOfWeek >= 1 && dayOfWeek <= 4)
		{
			return true;
		}
		return false;
	}      
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * This method returns true if it is a matinee and false if not
	 * @param String matinee is a Y or N specified by the user
	 * @return boolean true for y and false for n
	 */
	public static boolean isMatinee(String matinee)
	{	
		matinee.toLowerCase();
		if(matinee.equals("y") == true)
		{
			return true;
		}
		if(matinee.equals("n") == true)
		{
			return false;
		}
		else
		{
			System.out.println("Invalid Input");
			System.exit(1);
			return false;
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * This method Returns the cost of tickets
	 * @param String movie specified by user
	 * @param int month specified by user
	 * @param int day specified by user
	 * @param boolean isMatinee recieved from isMatinee method
	 * @param numberOfAdultTickets specified by user
	 * @param numberOfStudentTickets specified by user
	 * @return int price of tickets
	 */
	public static int getCost(String movie, int month, int day, boolean isMatinee,   
	                        int numberOfAdultTickets, int numberOfStudentTickets) 
	{      
		int Avatar = 10;
		int notAvatar = 8;
		int price = 0;
		if(isWeekday(month, day) == false)
		{
			price += 3*(numberOfAdultTickets + numberOfStudentTickets);
		}
		if(isMatinee == true)
		{
			if(movie.equals("avatar"))
			{
				price += (Avatar*(numberOfAdultTickets + numberOfStudentTickets));	
			}
			else
			{
				price += (notAvatar*(numberOfAdultTickets + numberOfStudentTickets));
			}
		}
		else
		{
			if(movie.equals("avatar"))
			{
				price += ((Avatar*numberOfAdultTickets)+((Avatar-2)*numberOfStudentTickets));	
			}
			else
			{
				price += ((notAvatar*numberOfAdultTickets)+((notAvatar-2)*numberOfStudentTickets));
			}
		}
	   	return price;
	}	

}
