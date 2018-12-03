import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorPanel extends JPanel implements MouseListener
{
     private Color backgroundColor;
     private ColorFrame parent;
     
     public ColorPanel(Color _backgroundColor)
     {
          super();
          backgroundColor = _backgroundColor;
          addMouseListener(this);
     }
     
     public ColorPanel()
     {
          this(Color.blue);
     }  

     public void paintComponent(Graphics g)
     {
          g.setColor(backgroundColor);
          g.fillRect(0,0,getWidth(), getHeight());
     }
     
     public void setBackgroundColor(Color c)
     {
          backgroundColor = c;
     }

     

/*********************************************************************/
     public void mouseClicked(MouseEvent e)
     {
          
          //getactive().setBackgroundColor(Color.blue);
          //setactive(cp);
          setBackgroundColor(Color.red);
          repaint();
     }
     public void mousePressed(MouseEvent e)
     {
     }
     public void mouseReleased(MouseEvent e)
     {
     }
     public void mouseEntered(MouseEvent e)
     {
     }
     public void mouseExited(MouseEvent e)
     {
     }
}
