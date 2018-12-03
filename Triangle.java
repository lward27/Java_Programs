public class Triangle implements Polygon
{
     double side1;
     double side2;
     double side3;
     public Triangle(double _side1, double _side2, double _side3)
     {
          side1 = _side1;
          side2 = _side2;
          side3 = _side3;
     }
     public double perimeter()
     {
          return side1 + side2 +side3;
     }
     public double diameter()
     {
          return 0.0;
     }
     public double area()
     {
          double semiP = (side1 + side2 + side3)*.5;
          return Math.sqrt(semiP*(side1 - semiP)*(side2 - semiP)*(side3 -semiP));
     }
     public int numSides()
     {
          return 3;
     }
}
