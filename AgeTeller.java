import java.util.*;

public class AgeTeller
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How old are you?");
		int age = in.nextInt();
		System.out.println("you'll be 40 in " + (40 - age) + " years.");
	}	
}
