import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class ColorFrame extends JFrame
{
     ColorPanel [][] boxes;
     ColorFrame pparent;
     int n;
     public ColorFrame(int _n)
     {
          super("ColorBox");
          n = _n;
          boxes = new ColorPanel [n][n];
          boxcontainer.setLayout(new GridLayout(n,n));
          for(int k = 0; k < n; k++){
               for(int l = 0; l < n; l++){
               boxes[k][l] = new ColorPanel(Color.blue);
               }
          }
          pparent = this;
     }
     public void reset()
     {
           for(int k = 0; k < n; k++){
               for(int l = 0; l < n; l++){
               boxes[k][l].setIsActive(false);
               }
          }
     }
     JPanel boxcontainer = new JPanel();
     public void go()
     {
          setSize(1000,1000);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //boxcontainer.setLayout(new GridLayout(4,4));          
          for(int k = 0; k < n; k++){
               for(int l = 0; l < n; l++){
               boxcontainer.add(boxes[k][l]);
               }
          }
          getContentPane().add(BorderLayout.CENTER, boxcontainer);
          
          JMenuBar mbar = new JMenuBar();
          setJMenuBar(mbar);          
          JMenu fileMenu = new JMenu("File");
          mbar.add(fileMenu);
          
          FileMenuItem closer = new FileMenuItem("Close");
          closer.addActionListener(new CloseListener());
          fileMenu.add(closer);
          FileMenuItem clear = new FileMenuItem("Clear");
          clear.addActionListener(new ClearListener());
          fileMenu.add(clear);
          
          setVisible(true);
     }
     public class FileMenuItem extends JMenuItem
     {
          public FileMenuItem( String name )
          {
               super(name);
          }
     }
     
     class CloseListener implements ActionListener
     {
          public CloseListener()
          {
          }
          public void actionPerformed(ActionEvent e)
          {
               System.exit(0);
          }
     }
     class ClearListener implements ActionListener
     {
          public ClearListener()
          {
          }
          public void actionPerformed(ActionEvent e)
          {
               pparent.reset();
               pparent.repaint();
          }
     }
     public static void main(String [] args)
     {
          ColorFrame g = new ColorFrame(4);
          g.go();
     }
     

/*********************************************************************************/
     class ColorPanel extends JPanel implements MouseListener, KeyListener, FocusListener
     {
          private Color backgroundColor;
          private boolean isActive;
          private ColorPanel activePanel;
          int xloc;
          int yloc;
          public ColorPanel(Color _backgroundColor)
          {
               super();
               backgroundColor = _backgroundColor;
               addMouseListener(this);
               setFocusable(true);
               addFocusListener(this);
               addKeyListener(this);
          }
          public void setIsActive(boolean b)
          {
               isActive = b;
          }
          
          public ColorPanel()
          {
               this(Color.blue);
          }  
          
          public void paintComponent(Graphics g)
          {
               //backgroundColor = isActive? Color.red : Color.blue;
               g.setColor(backgroundColor);
               g.fillRect(0,0,getWidth(), getHeight());
               //System.out.println("" + lastPressed);
          }
          
          public void setBackgroundColor(Color c)
          {
               backgroundColor = c;
          }
          public void moveColor(int xchange, int ychange) 
          {
               boxes[xloc][yloc].setBackgroundColor(Color.red);
               xloc = xchange;
               yloc = ychange;
               isActive = true;
               pparent.repaint();
          }
          public void mouseClicked(MouseEvent e) 
          {
               pparent.reset();
               xloc = n*e.getY()/getWidth();
               yloc = n*e.getX()/getHeight();
               moveColor(xloc, yloc);
               System.err.println("xloc = " + xloc + ", yloc = " + yloc);
               System.err.println("( " + e.getX() + " , " + e.getY() + " )");
          }
          
          
          /*********************************************************************/
          //ColorPanel active = null;
          /*public void mouseClicked(MouseEvent e)
          {
               pparent.reset();
               isActive = true;
               pparent.repaint();
          }*/
          public void mousePressed(MouseEvent e){}
          public void mouseReleased(MouseEvent e){}
          public void mouseEntered(MouseEvent e){}
          public void mouseExited(MouseEvent e){}
          /*********************************************************************/

          public void keyPressed(KeyEvent e)
          {
               requestFocus();
               int character = e.getKeyCode();
               if(character == KeyEvent.VK_LEFT)
               {
                    System.err.println("left");
                    pparent.repaint();
               }
               if(character == KeyEvent.VK_RIGHT)
               {
                    System.err.println("right");
               }
               if(character == KeyEvent.VK_DOWN)
               {
                    System.err.println("down");
               }
               if(character == KeyEvent.VK_UP)
               {
                    System.err.println("up");
               }                           
          }
          public void keyReleased(KeyEvent e){}
          public void keyTyped(KeyEvent e)
          {              
          }
          public void focusGained(FocusEvent e)
          {
               requestFocus();
          }
          public void focusLost(FocusEvent e){}
     }
}
