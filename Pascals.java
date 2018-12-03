import java.util.*;
public class Pascals
{
	public static void main(String[] args)
	{
		int[][] triangle = new int[9][];
		fillIn(triangle);
		System.out.println(Arrays.deepToString(triangle));
	}
	
	public static void fillIn(int[][] tri)
	{
		for(int i = 0; i < tri.length; i++)
		{
			//create new row
			tri[i] = new int[i+1];
			//Put in leading and trailing ones
			tri[i][0] = 1;
			tri[i][tri[i].length-1] = 1;
			if(i >= 2)
			{
				int[] prev = tri[i-1];
				for(int j = 0; j < prev.length-1; j++)
				{
					tri[i][j+1] = prev[j] + prev[j+1];
				}
			}
		}
	}
}
