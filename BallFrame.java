import javax.swing.JFrame;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class BallFrame extends JFrame
{
     BallPanel bp;
     ButtonPanel butp;
     public BallFrame()
     {
          super("Ball World");
          bp = new BallPanel();
          butp = new ButtonPanel();
     }
     public void go()
     {
          setSize(1920,1150);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          //put ball panel into content pane
          getContentPane().add(BorderLayout.CENTER, bp);
          getContentPane().add(BorderLayout.NORTH, butp);
          bp.setBalls(generateBalls(500));
          setVisible(true);
     }
     public ArrayList<Ball> generateBalls(int n)
     {
          ArrayList<Ball> out = new ArrayList<Ball>();
          Random r = new Random();
          for (int k = 0; k < n; k++)
          {
               Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
               out.add(new Ball(r.nextInt(1820), r.nextInt(1000), r.nextInt(100), c));
          }
          return out;
     }
     public static void main(String[] args)
     {
          BallFrame f = new BallFrame();
          f.go();
     }
//************************************************************************************************//
     class ButtonPanel extends JPanel
     {
          JButton red;
          JButton green;
          JButton blue;
          JButton newBalls;
          JButton reset;
          
          super();
               
               red = new JButton("red");
               red.addActionListener(new ColorListener(Color.red));
               blue = new JButton("blue");
               blue.addActionListener(new ColorListener(Color.blue));
               green = new JButton("green");
               green.addActionListener(new ColorListener(Color.green));
               reset = new JButton("reset");
               reset.addActionListener(new ColorListener(Color.black));
               newBalls = new JButton("new Balls");
               newBalls.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                         bp.setBalls(generateBalls(500));
                         bp.repaint();
                    
                    }
               });
               setLayout(new GridLayout(1,4));
               add(newBalls);
               add(red);
               add(blue);
               add(green);
               add(reset);
          }
          class ColorListener implements ActionListener
          {
               private Color color;
               public ColorListener(Color _color)
               {
                    color = _color;
               }
               public Color getColor()
               {
                    return color;
               }
               public void actionPerformed(ActionEvent e)
               {
                    bp.setBackgroundColor(color);
                    bp.repaint();
               }
          }
     }
}
