import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.util.Random;
import javax.swing.JInternalFrame;


public class Multiframe extends JFrame
{
     MultiPanel left;
     MultiPanel center;
     MultiPanel right;
     MultiPanel active;
     ButtonPanel butp;
     public Multiframe()
     {          
          super("MultiFrame");
          butp = new ButtonPanel();
          left = new MultiPanel(Color.white);
          center = new MultiPanel(Color.white);
          right = new MultiPanel(Color.white);
          active = left;
     }
     
     
     public void go()
     {
          setSize(800,600);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JPanel colors = new JPanel();
          colors.setLayout(new GridLayout(1,3));          
          colors.add(left);
          colors.add(center);
          colors.add(right); 
          getContentPane().add(BorderLayout.CENTER, colors);
          getContentPane().add(BorderLayout.NORTH, butp);

          JMenuBar mbar = new JMenuBar();
          setJMenuBar(mbar);
          
          JMenu posistion = new JMenu("Posistion");
          mbar.add(posistion);          
          JMenu size = new JMenu("Size");
          mbar.add(size);
          JMenu help = new JMenu("Help");
          mbar.add(help);
          
          MenuItem leftitem = new MenuItem("left");
          leftitem.addActionListener(new PosistionListener(left));
          posistion.add(leftitem);
          MenuItem centeritem = new MenuItem("center");
          centeritem.addActionListener(new PosistionListener(center));
          posistion.add(centeritem);
          MenuItem rightitem = new MenuItem("right");
          rightitem.addActionListener(new PosistionListener(right));
          posistion.add(rightitem);
          
          MenuItem smallitem = new MenuItem("800 x 600");
          smallitem.addActionListener(new SizeListener(800,600));
          size.add(smallitem);
          MenuItem mediumitem = new MenuItem("1280 x 960");
          mediumitem.addActionListener(new SizeListener(1280,960));
          size.add(mediumitem);
          MenuItem largeitem = new MenuItem("1600 x 1024");
          largeitem.addActionListener(new SizeListener(1600,1024));
          size.add(largeitem);
          MenuItem xlargeitem = new MenuItem("1920 x 1200");
          xlargeitem.addActionListener(new SizeListener(1920,1200));
          size.add(xlargeitem);
          
          MenuItem helpitem = new MenuItem("Help");
          helpitem.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e)
               {
                    Runnable help = new Helpframe();
                    Thread v = new Thread(help);
                    v.start();
               }
          });
          help.add(helpitem);
          
          MenuItem aboutitem = new MenuItem("About");
          aboutitem.addActionListener(new ActionListener(){
    /*       ^
             | this was the problem the entire time...  i didnt
               change it to aboutitem, it was helpitem... AHH!! */
               public void actionPerformed(ActionEvent e)
               {
                    Runnable about = new Aboutframe();
                    Thread t = new Thread(about);
                    t.start();
               } 
          });
          help.add(aboutitem);
          
          setVisible(true);
     }


     class SizeListener implements ActionListener
     {
          int x;
          int y;
          public SizeListener(int _x, int _y)
          {
               x = _x;
               y = _y;
          }
          public void actionPerformed(ActionEvent e)
          {
               setSize(x,y);
          }
     }           
          
          
     class MenuItem extends JMenuItem
     {
          public MenuItem(String item)
          {
               super(item);
          }
     }
     
     
     class PosistionListener implements ActionListener
     {
          MultiPanel multipanel;
          public PosistionListener(MultiPanel _multipanel)
          {
               multipanel = _multipanel;
          }
          public void actionPerformed(ActionEvent e)
          {
               active = multipanel;
          }
     }
     
     
     public static void main(String [] args)
     {
          Multiframe g = new Multiframe();
          g.go();
     }
     
     
/*******************************************************************/    
     
     
     class ButtonPanel extends JPanel
     {
          JButton red;
          JButton green;
          JButton blue;
          JButton random;
          JButton reset;
          JButton restart;
          public ButtonPanel()
          {
               super();
               red = new JButton("red");
               red.addActionListener(new ColorListener(Color.red));
               blue = new JButton("blue");
               blue.addActionListener(new ColorListener(Color.blue));
               green = new JButton("green");
               green.addActionListener(new ColorListener(Color.green));
               
               random = new JButton("random");
               random.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                         
                         active.setBackgroundColor(Color.WHITE);
                         active.repaint();
                    }
               });
               
               reset = new JButton("reset");
               reset.addActionListener(new ColorListener(Color.white));
               
               restart = new JButton("restart");
               restart.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                         left.setBackgroundColor(Color.white);
                         center.setBackgroundColor(Color.white);
                         right.setBackgroundColor(Color.white);
                         left.repaint();
                         center.repaint();
                         right.repaint();
                         active = left;
                    }
               });               
               
               setLayout(new GridLayout(2,3));
               add(red);
               add(green);
               add(blue);
               add(random);
               add(reset);
               add(restart);
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
                    active.setBackgroundColor(color);
                    active.repaint();   
               }
          }
     }

}


/*comments:
 *           After I got the Threads to work and show the 
 *           About window and Help window, I realized that
 *           it wasn't even a Jframe I needed... it was a 
 *           Text component like a JEditorPane...
 *           So i just left them blank!  But maybe someday i
 *           will go back and fix it.
 *       
 *           */
        
        
        
        
        
     
        
        
        
        
        
