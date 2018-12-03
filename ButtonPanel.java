import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ButtonPanel extends JPanel
{
     JButton red;
     JButton green;
     JButton blue;
     JButton newBalls;
     public ButtonPanel()
     {
          super();
          
          red = new JButton("red");
          red.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e)
               {
                    System.out.println("I See Red!!");
               }
          });
          blue = new JButton("blue");
          green = new JButton("green");
          newBalls = new JButton("new Balls");
          setLayout(new GridLayout(1,4));
          add(newBalls);
          add(red);
          add(blue);
          add(green);
     }
     
}
