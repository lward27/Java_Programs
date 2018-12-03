import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.FileNotFoundException;
/**
 * This class generates a file of random grades then tallys each number
 * @author Lucas Ward
 * @version 1.0
 */
public class ArrayAlgorithms
{

	/**
	 * The main method calls the method to generate the file of random
	 * numbers then calls the method to compute the tally
	 */
	public static void main(String[] args)
	{
		generateTallyFile();
		int[] array = tallyData(new File("tallydata.txt"));
		printArray(array);

		//test indexOf
		int idx5 = indexOf(array, 5);
		System.out.println("index of 5 in array: " + idx5);
		int idx980 = indexOf(array, 980);
		System.out.println("index of 980 in array: " + idx980);
	
		//test nextIndexOf
		int idx980_2 = nextIndexOf(array, 980, idx980 + 1);
		System.out.println("Next index of 980 in array: " + idx980_2);
		
		//test replaceAll
		replaceAll(array, 980, 67);
		printArray(array);
	
		int[] a1 = {1,2,3,4,5};
		int[] a2 = {1,2,3,4,5};
		int[] a3 = {5,4,3,2,1};
		System.out.println("array1 and array2 are equal: " + equals(a1, a2));
		System.out.println("array1 and array2 are equal: " + equals(a1, a3));

		//test Max
		System.out.println("The max of the array is: " + max(array));
		
	}

	/** 
	 * return true if the arrays are equal
	 * @param array1 array to compare
	 * @param array2 array to compare
	 * @return true of false
	 */
	public static boolean equals(int[] array1, int[] array2)
	{
		if(array1.length != array2.length)
		{
			return false;
		}
		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i] != array2[i])
			{
				return false;
			}
		}
		return true;
	}

	public static int max(int[] array1)
	{
		int max = 0;
		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i] > max)
			{
				max = array1[i];	
			}
		}
		return max;
	}

	/**
	 * Returns the index of the given value in the array
	 * or -1 if the value does not exist in the array
	 * @param array array of integers
	 * @param value value to find in array
	 * @return first index of value or -1
	 */
	public static int indexOf(int[] array, int value)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == value)
			{
				return i;
			}
		}
		return -1;	
	}

	/**
	 * Returns the index of the next given value in the array
	 * or -1 if the value does not exist in the array
	 * @param array array of integers
	 * @param value value to find next in array
	 * @param startingIndex index to start looking from
	 * @return next index of value of -1
	 */	
	public static int nextIndexOf(int[] array, int value, int startingIndex)
	{
		for(int i = startingIndex; i < array.length; i++)
		{
			if(array[i] == value)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Replaces a certain value with another value at every instance
	 * of that value in the array
	 * @param array array of integers
	 * @param beingReplaced value to be replaced
	 * @param replacer value to replace the value being replaced
	 */
	public static void replaceAll(int[] array, int beingReplaced, int replacer)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == beingReplaced)
			{
				array[i] = replacer;
			}
		} 
	}
	
	/**
	 * The printArray method prints the tally array
	 * @param int[] returns an array
	 */
	public static void printArray(int[] array)
	{
		System.out.print("[");
		for(int i = 0; i < array.length; i++)
		{
			if(i < array.length - 1)
			{
				System.out.print(array[i] + ",");
			}
			else {
				System.out.print(array[i]);
			}
		}
		System.out.println("]");
	}
	
	/**
	 * The generateTallyFile method creates a file full of ints between 1 and 5
	 * @return array called tally
	 */
	public static void generateTallyFile()
	{
		File f = new File("tallydata.txt");
		try {
			PrintStream out = new PrintStream(f);
			Random r = new Random(1L);
			for(int i = 0; i < 5000; i++)
			{	
				int random = r.nextInt(5) + 1;
				out.print(random + " ");
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * counts the number of occurences of each value
	 * @param File file of integers from 1 to 5
	 * @return array of tallys
	 */
	public static int[] tallyData(File f)
	{
		//create array to hold tally
		int [] tally = new int[5];

		//process file
		try {
			Scanner fileReader = new Scanner(f);
			while(fileReader.hasNextInt())
			{
				int grade = fileReader.nextInt();
				tally[grade-1]++;
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(InputMismatchException e) {
			e.printStackTrace();
		}
		return tally;
	}
}
