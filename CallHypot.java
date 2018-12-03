public class CalHypot
{
	public static void main(String[] args)
	{
		calculateHypotenuse(3,5);
	}
	public static double calculateHypotenuse(int x, int y)
	{
		return Math.sqrt((x*x)+(y*y));
	}
}
