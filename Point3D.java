public class Point3D
{
private int x; //state of a class is reflected by instance variables
private int y;
private int z;
public Point3D(int _x, int _y, int _z)
    {
    x = _x;
    y = _y;
    z = _z;
    }
public Point3D()
    {
    this(0,0,0);
    }
public String toString()
{
    return "(" + x + ", " + y + ", " + z + ")";
}
public double distanceTo(Point3D that)
    {
    return Math.sqrt((x - that.x)*(x - that.x) + (y - that.y)*(y - that.y) + (z -that.z)*(z - that.z));
    }
public void translate(int a, int b, int c)
    {
    x += a;
    y += b;
    z += c;
    }
public int franistan(int mouse)
    {
    return x*y*z*mouse;
    }
public void zapToOrigin()
    {
    x = 0;
    y = 0;
    z = 0;
    }
}
