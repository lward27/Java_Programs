import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

/**
 * 
 * Definition of a heart class that extends <code>Shape</code>.
 */
public class Heart extends Shape
{
  
  //  Instance Field Variable
  private int size;
    
  /**
   * Constructs an instance of <code>Heart</code> at the specified location.
   * 
   * @param _x the x-coordinate of this Heart instance
   * @param _y the y-coordinate of this Heart instance
   */
  public Heart ( int _x, int _y )
  {
    super(_x, _y);
  }
  
  
  public Heart ( int _x, int _y, Color _color)
  {
    super ( _x, _y, _color);
  }
  
  
  public Heart ( int _x, int _y, int _size, Color _color)
  {
    super ( _x, _y, _color);
    size = _size;
  }
  
  /**
   * Draw this instance of <code>Heart</code>.  Displays a < and a 3 at the location specified by the x and y attributes.
   * 
   * @param g2d the graphics context in which to draw this heart
   * @return the integer corresponding this string
   */ 
  
  public void draw ( Graphics2D g2d )
  {
    Font current = g2d.getFont();
    g2d.setFont (current.deriveFont( (float)size ));
    g2d.drawString( "<3" , getX() , getY() );
    g2d.setFont ( current );
  }
  
  /**
   * Identify the type of this <code>Shape</code>
   * 
   * @return this type of this <code>Shape</code> as a <code>String</code>.
   */
  public String shapeType()
  {
    return "Heart";
  }
  
  public String showAttributes()
  {
    return "size = ";
  }
}
