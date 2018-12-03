public class ArrayEx
{
	public static void main(String [] args)
	{
		int[] grades = new int[30];
		int sum = 0;
		int c = 0;
		while(c < grades.length)
		{
			grades[c] = c;
			c++;
		}
		/*
		for(int student : grades)
		{
			sum += student;
		}*/
		System.out.println("Average " + ((double)getSum(grades))/grades.length);

	}
	
	public static int getSum(int[] grades)
	{	
		int sum = 0;
		for(int student : grades)
		{
			sum += student;
		}
		return sum;
	}
}
