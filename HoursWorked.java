import java.io.*;
import java.util.*;

/**
 * 
 */
public class HoursWorked
{

	public static void main(String[] args) 
	{
		userInterface();
	}

	public static void userInterface() 
	{
		Scanner in = new Scanner(System.in);
		System.out.print(" What is the name of the file? ");
		String s = in.next();
		File f = new File(s);
		while(!f.exists()) {
                               System.out.println("File does not exist, please try again");
                }
			
			//PrintLine(System.out, name, id, hoursWorked);
		try 
		{
			PrintStream output = new PrintStream("output.txt");	
                	calculateHours(f,output);	
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Output file could not be written");

		}

	}
	
	public static void processLine(String line, PrintStream output) 
	{
		Scanner lineInput = new Scanner(line);
		if(lineInput.hasNext())
		{
			String name = "";
			double hoursWorked = 0.0;
			int id = lineInput.nextInt();
			name = lineInput.next();		
		while(lineInput.hasNextDouble())
			{
					hoursWorked += lineInput.nextDouble();
			}
		printLine(output, name, id, hoursWorked);
		}
	}
	
	
	public static void calculateHours(File f, PrintStream output)
	{
		try
		{
               		Scanner fileInput = new Scanner(f);
			while(fileInput.hasNextLine())
			{
				processLine(fileInput.nextLine(), output);
			}
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("File " + f.getName() + " could not be found!");
		}
		
	}

	public static void printLine(PrintStream output, String name, int id, double hoursWorked)
	{
		output.println("Employee: " + name + "(" + id + ") worked " + hoursWorked);
	}
}












