public class RandomString
{
  public static int[] randomArray(int range)
  {
    int[] newArray = new int[range];
    for(int i = 0; i < range; i++)
    {
      newArray[i] = (int)(Integer.MAX_VALUE * Math.random());
    }
    int i = 0;
    while(i < newArray.length)
    {
      System.out.print(newArray[i]);
      System.out.print(", ");
      i++;
    }
    return newArray;
    
  }
}

