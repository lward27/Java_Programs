public class SumTo
{
	public static void main(String[] args)
	{
		printSumTo(10);
	}
	
	public static void printSumTo(int n)
	{
		String s = "";
		for(int i = 1; i <= n; i++)
		{
			if(i == n)
			{
				s += i;
			}
			else
			{
			s += i + " + ";
			}
		}
		System.out.println(s);
	}
}
