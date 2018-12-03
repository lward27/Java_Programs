import java.awt.Color;
import java.awt.Graphics2D;

/**
* <code>Shape</code> serves as a unifying superclass for students' {@link JPanel}-drawable shape classes.
*/
public abstract class Shape 
{
 
  private int x;
  private int y;
  private Color myColor;
 
 
  /**
  *
  * Construct a <code>Shape</code> at the location specified by the given (x,y).  The meaning of location will
  * depend on each implementing subclass.
  *
  * @param _x x-coordinate of this <code>Shape</code>
  * @param _y y-coordinate of this <code>Shape</code>
  */
  public Shape ( int _x , int _y ) 
  {
   
    x = _x;
    y = _y;
  }
 
  /**
  *
  * Construct a <code>Shape</code> at the location specified by the given (x,y) in the specified color.
  *
  * @param _x x-coordinate of this <code>Shape</code>
  * @param _y y-coordinate of this <code>Shape</code>
  * @param _color the color of this <code>Shape</code>
  */
  public Shape ( int _x , int _y , Color _color ) 
  {
    this( _x , _y );
    myColor = _color;
  }
 
  /**
  *
  * Display this <code>Shape</code> - including it's pertinent attributes - as a <code>String</code>.
  *
  * @return the <code>String</code> representing this <code>Shape</code>.
  */
  public String toString() 
  {
  //return "[figure x@(1,2) width = 100 height = 100 ]";
    return "[" + shapeType() + "@(" + x + "," + y + ")"  + showAttributes()  +  "]" ;
  }
 
  protected abstract String shapeType();
  protected abstract String showAttributes();
 
  /**
  *
  * Change the color of this <code>Shape</code>.
  *
  * @param _color the new color of this <code>Shape</code>.
  */
  public void setColor ( Color _color ) 
  {
    myColor = _color;
  }
 
  /**
  *
  * Translate this <code>Shape</code> horizontally and vertically.
  *
  * @param dx the horizontal translation
  * @param dy the vertical translation
  */
  public void translate ( final int dx , final int dy ) 
  {
    setLocation( x + dx , y + dy );
  }
 
  /**
  * Move this <code>Shape</code> to the specified location.
  *
  * @param _x the x-coordinate of the <code>Shape</code>s new location.
  * @param _y the y-coordinate of the <code>Shape</code>s new location.
  */
  public void setLocation( final int _x , final int _y ) 
  { 
    x = _x;
    y = _y;
  }
 
  /**
  *
  * Paint this <code>Shape</code> in its current color in the given {@link Graphics2D} context.
  *
  * @param g2d the context where this <code>Shape</code> will paint.
  */
  public void paint ( Graphics2D g2d ) {
    paint( g2d , myColor );
  }
 
 
  /**
  *
  * Paint this <code>Shape</code> in the given color in the given {@link Graphics2D} context.
  *
  * @param g2d the context where this <code>Shape</code> will paint.
  * @param _color the color to paint in.
  */
  public void paint ( Graphics2D g2d , Color _color ) {
    Color current = g2d.getColor();
    g2d.setColor( _color );
    draw( g2d );
    g2d.setColor( current );
  }
 
  protected abstract void draw ( Graphics2D g2d );
 
 
  /**
  * Return the x-coordinate of this <code>Shape</code>.
  *
  * @return the x-coordinate of this <code>Shape</code>.
  */
  public int getX() {
    return x;
  }
 
 
  /**
  * Return the y-coordinate of this <code>Shape</code>.
  *
  * @return the y-coordinate of this <code>Shape</code>.
  */
  public int getY() {
    return y;
  }
 
}
