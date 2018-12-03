public class Circle implements Shape
{
     private double radius;
     public Circle(double _radius)
     {
          radius = _radius;
     }
     public double diameter()
     {
          return 2*radius;
     }
     public double perimeter()
     {
          return 2*Math.PI*radius;
     }
     public double area()
     {
          return Math.PI*radius*radius;
     }
}
