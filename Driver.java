public class Driver
{
     public static void main(String[] args)
     {
          //this is a place to record tests from the
          //interactions pane.  The grammactical short-
          //cuts of the interactions pane are impermissible here.
          Complex zero = new Complex();
          Complex z = new Complex(3,4);
          Complex w = new Complex(2,-3);
          Complex y = new Complex(3);
          Complex c = new Complex(6);
          System.out.println("zero = " + zero);
          System.out.println("z = " + z);
          System.out.println("w = " + w);
          System.out.println("z.add(w) = " + z.add(w) +
                             ", expected: 5.0 + 1.0i");
          System.out.println("y = " + y);
          System.out.println("w.conjugate() = " + w.conjugate() );
          System.out.println("z.negate() = " + z.negate() );
          System.out.println("w.abs() = " + w.abs() );
          System.out.println("w.multiply(z) = " + w.multiply(z) );
          System.out.println("z.pow(4) = " + z.pow(4) );
          System.out.println("c.copy() = " + c.copy() );
          System.out.println("y.equals(w) = " + y.equals(w) );
          System.out.println("y.divide(w) = " + y.divide(w) );
          System.out.println("y.distanceTo(w) = " + y.distanceTo(w) );
     }
}
