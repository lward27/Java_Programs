import java.awt.Color;
import java.awt.Graphics;
public class Ball
{
     private int upperLeftX;
     private int upperLeftY;
     private int diameter;
     private Color color;
     
     public void drawWith(Graphics g)
     {
          Color current = g.getColor();
          g.setColor(color);
          g.fillOval(upperLeftX, upperLeftY, diameter, diameter);
          g.setColor(current);          
     }
     
     public Ball(int _x, int _y, int _diam, Color _color)
     {
          upperLeftX = _x;
          upperLeftY = _y;
          diameter = _diam;
          color = _color;
     }
     
     public void translate(int dx, int dy)
     {
          upperLeftX += dx;
          upperLeftY += dy;
     }
}
