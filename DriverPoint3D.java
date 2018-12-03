public class DriverPoint3D
{
     public static void main(String[] args)
     {
          Point3D p = new Point3D(3,4,5);
          Point3D q = p;
          p.translate(2,2,2); //Mutator!
          System.out.println("p = " + p + "q = " + q);
     }
}
