import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class BallPanel extends JPanel
{
     public void paintComponent(Graphics g)
     {
          Ball sarah = new Ball(0, 0, 50, Color.BLUE);
          for(int k = 0; k < 50; k += 1)
          {
               sarah.drawWith(g);
               sarah.translate(3,3);
               try
               {
                    Thread.sleep(100);
               }
               catch(Exception ex){}
          }
          
          Ball fred = new Ball(75,0, 75, Color.RED);
          fred.drawWith(g);
          //g.draw(sarah);
          //g.drawLine(10, 100, 500, 50);
          
     }
}
