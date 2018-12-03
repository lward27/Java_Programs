import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
     
public class BallDragFrame extends JFrame
{
     BallDragPanel bdp;
     public BallDragFrame()
     {
          super("Ball Drag Frame");
          bdp = new BallDragPanel();
     }
     public void go()
     {
          setSize(600,600);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          getContentPane().add(bdp);
          //config the menus
          JMenuBar mbar = new JMenuBar();
          JMenu backgroundMenu = new JMenu("Background Color");
          JMenu ballMenu = new JMenu("Ball Color");
          mbar.add(backgroundMenu);
          //red background
          ColorMenuItem redBG = new ColorMenuItem("red", Color.red);
          redBG.addActionListener(new BGColorListener(redBG.getColor()));
          backgroundMenu.add(redBG);
          //green background
          ColorMenuItem greenBG = new ColorMenuItem("green", Color.green);
          greenBG.addActionListener(new BGColorListener(greenBG.getColor()));
          backgroundMenu.add(greenBG);
          //blue background
          ColorMenuItem blueBG = new ColorMenuItem("blue", Color.blue);
          blueBG.addActionListener(new BGColorListener(blueBG.getColor()));
          backgroundMenu.add(blueBG);
          //reset background
          ColorMenuItem resetBG = new ColorMenuItem("reset", Color.black);
          resetBG.addActionListener(new BGColorListener(resetBG.getColor()));
          backgroundMenu.add(resetBG);
          
          mbar.add(ballMenu);
          setJMenuBar(mbar);
          
          setVisible(true);
     }
     class ColorMenuItem extends JMenuItem
     {
          Color color;
          public ColorMenuItem(String colorName, Color _color)
          {
               super(colorName);
               color = _color;
          }
          public Color getColor()
          {
               return color;
          }
     }
     class BGColorListener implements ActionListener
     {
          Color color;
          public BGColorListener(Color _color)
          {
               color = _color;
          }
          public void actionPerformed(ActionEvent e)
          {
               bdp.setBackgroundColor(color);
               bdp.repaint();
          }
     }
     public static void main(String[] args)
     {
          BallDragFrame bdf = new BallDragFrame();
          bdf.go();
     }
}
