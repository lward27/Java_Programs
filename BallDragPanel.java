import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallDragPanel extends JPanel 
     implements MouseMotionListener, MouseListener
{
     //initial ball color.
     private Color ballColor;
     private Color backgroundColor;
     private Ball theBall;
     private int lastPressedX;
     private int lastPressedY;
     
     public BallDragPanel(Color _ballColor, Color _backgroundColor)
     {
          super();
          ballColor = _ballColor;
          backgroundColor = _backgroundColor;
          theBall = new Ball(0,0,100, ballColor);
          addMouseMotionListener(this);
          addMouseListener(this);
          lastPressedX = 0;
          lastPressedY = 0;
     }
     public BallDragPanel()
     {
          this(Color.white, Color.black);
     }
     //setters
     public void setBallColor(Color c)
     {
          ballColor = c;
     }
     public void setBackgroundColor(Color c)
     {
          backgroundColor = c;
     }
     public void paintComponent(Graphics g)
     {
          g.setColor(backgroundColor);
          g.fillRect(0,0,getWidth(), getHeight());
          g.setColor(theBall.getColor());
          g.fillOval(theBall.getUpperLeftX(), theBall.getUpperLeftY(), theBall.getDiameter(), theBall.getDiameter());
     }
     /**************MouseMotionListener methods*************************************************************/
     public void mouseMoved(MouseEvent e)
     {
     //   System.out.println("I'm moved...");
     }
     public void mouseDragged(MouseEvent e)
     {
     //   System.out.println("What a drag");
          if(theBall.contains(e.getX(), e.getY()))
          {
          theBall.setUpperLeft(-theBall.getUpperLeftX() + e.getX(), 
                               -theBall.getUpperLeftY() + e.getY());
          System.out.println(e.getX() + "\t" + e.getY());
          System.out.println("lastPressed: " + lastPressedX + "\t" + lastPressedY);
          repaint();
          }
     }
     public void mouseClicked(MouseEvent e)
     {
          theBall.setColor(Color.magenta);
          repaint();
     }
     public void mouseEntered(MouseEvent e)
     {
          theBall.setColor(Color.yellow);
          repaint();
     }
     public void mouseExited(MouseEvent e)
     {
          theBall.setColor(Color.white);
          repaint();
     }
     public void mousePressed(MouseEvent e)
     {
          lastPressedX = e.getX();
          lastPressedY = e.getY();
     }
     public void mouseReleased(MouseEvent e)
     {
          backgroundColor = Color.black;
          repaint();
     }
}
