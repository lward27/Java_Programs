import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class FirstGUI extends JPanel
{
     private static Ball sarah = new Ball(0, 0, 75, Color.BLUE);
     private static Ball fred = new Ball(75,0, 75, new Color(200, 4, 17));
     public void paintComponent(Graphics g)
     {
          sarah.drawWith(g);
          fred.drawWith(g);
          //g.draw(sarah);
          //g.drawLine(10, 100, 500, 50);
     }
     public void go()
     {
          JFrame f = new JFrame("Ball World");
          f.setSize(600,600);
          JButton b = new JButton("top");
          f.getContentPane().add(b, BorderLayout.NORTH);
          JButton c = new JButton("bottom");
          f.getContentPane().add(c, BorderLayout.SOUTH);
          JButton d = new JButton("left");
          f.getContentPane().add(d, BorderLayout.WEST);
          JButton e = new JButton("right");
          f.getContentPane().add(e, BorderLayout.EAST);
          //JButton g = new JButton("center");
          //f.getContentPane().add(g, BorderLayout.CENTER);
          f.getContentPane().add(new BallPanel(), BorderLayout.CENTER);
          f.setVisible(true);
          /*try    //wait 3000 ms.
          {
               Thread.sleep(1000);
          }
          catch(Exception ex)
          {
          }
          f.setTitle("Die now.");*/
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     public void finalize()
     {
          System.out.println("done");
     }
     public static void main(String [] args)
     {
          FirstGUI g = new FirstGUI();
          g.go();
          /*for(int i = 0; i < 20; i++)
          {
               g.go();
               try
               {
                    Thread.sleep(1000);
               }
               catch(Exception ex)
               {
               }
               sarah.translate(45,45);
               fred.translate(25,25);
          }*/
          
     }
}
