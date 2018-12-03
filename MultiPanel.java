import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class MultiPanel extends JPanel
{
     private Color backgroundColor;
     
     public MultiPanel(Color _backgroundColor)
     {
          super();
          backgroundColor = _backgroundColor;
     }
     
     public MultiPanel()
     {
          this(Color.orange);
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
}
