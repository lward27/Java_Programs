public class Point
{
     private int x;
     private int y;
     public Point(int _x, int _y)
     {
          x = _x;
          y = _y;
     }
     public Point()
     {
          this(0,0);
     }
     public String toString()
     {
          return "(" + x + ", " + y + ")";
     }
  
     public boolean equals(Object that)
     {
          if( !(that instanceof Point))
          {
               return false;
          }
          Point thatConverted = (Point) that;
          return x == thatConverted.x && y == thatConverted.y;
     }   
     public int getX()
     {
          return x;
     }
     public int getY()
     {
          return y;
     }
     public void translate(int a, int b)
     {
          x += a;
          y =+ b;
     }
     public double distanceTo(Point p)
     {
          int deltax = x - p.x;  //local variable.  
          int deltay = y - p.y;
          return Math.hypot(deltax, deltay);
     }
     public static void main(String[] args)
     {
          Point p = new Point(1,20);
          Point q = new Point(2,60);
          System.out.println("The distance between " + p + " and "
                                  + q + " is " + p.distanceTo(q));
     }
}
