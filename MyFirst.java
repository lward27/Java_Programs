public class MyFirst 
{
     public int abs(int x) 
     {
          if( x < 0) 
          {
               x = -x;
          }
     return x;
     }
     public void countDown(int n)
     {
          while(n >= 0)
          {
               System.out.print(n + " " );
               n--;
          }
          System.out.print("Blastoff!");
     }
     public int triangle(int n)
     {
          int sum = 0;
          for(int k = 1; k <= n; k++)
          {
               sum += k;
          }
          return sum;
     }
}
