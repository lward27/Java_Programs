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
     SPanel allContent;
     int n;
     
     public ColorFrame(int _n) {
          super("Blueboard");
          n = _n;
          allContent = new SPanel(n);
     }
     public ColorFrame() {
          this(4);
     }
     public void go() {
          setSize(600,600);
          /*  allContent.setLayout(new GridLayout(n,n));
           for(int k = 0; k < n; k++){
           for (int l = 0; l < n; l++){
           allContent.add(allContent.board[k][l]);
           }
           }
           */
          JMenuBar mbar = new JMenuBar();
          JMenu fmenu = new JMenu("File");
          JMenuItem exit = new JMenuItem("Quit", 113);
          exit.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                    System.exit(0); }
          });
          JMenuItem refresh = new JMenuItem("Refresh", 114);
          refresh.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                    allContent.refresh(); }
          });
          fmenu.setMnemonic(102);
          fmenu.add(exit);
          fmenu.add(refresh);
          mbar.add(fmenu);
          
          getContentPane().add(allContent);
          setJMenuBar(mbar);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setVisible(true);
     }
     
     public static void main(String[] args) {
          ColorFrame s = new ColorFrame();
          s.go();
     }
     
     
     /*********************************************************************/
     class CPanel extends JPanel implements MouseListener
     {
          Color color;
          
          public CPanel(Color c) {
               super();
               color = c;
               this.setColor(color);
          }
          public CPanel() {
               this(Color.blue);
          }
          public Color getColor() {
               return color;
          }
          public void setColor(Color c) {
               color = c;
          }
          public void paintComponent(Graphics g) {
               g.setColor(color);
               g.fillRect(0,0,getWidth(), getHeight());
          }
          /*  public int getUpperLeftX() {
           return upperLeftX;
           }
           public int getUpperLeftY() {
           return upperLeftY;
           } */
          public void mouseClicked(MouseEvent e) { 
               this.setColor(Color.red);
               System.out.println("Click!");
               repaint();
          }
          public void mouseEntered(MouseEvent e) { }
          public void mouseExited(MouseEvent e) { }
          public void mousePressed(MouseEvent e) { }
          public void mouseReleased(MouseEvent e) { } 
     }


/******************************************************/

  class SPanel extends JPanel implements MouseListener, KeyListener, FocusListener
  {
       
       int n; //n is dimensions
       CPanel [][] board;
       int xred;
       int yred;
       
       public SPanel(int _n) {
            super();
            n = _n;
            board = new CPanel[n][n];
            this.setLayout(new GridLayout(n,n));
            for(int k = 0; k < n; k++){
                 for (int l = 0; l < n; l++){
                      board[k][l] = new CPanel();
                      this.add(board[k][l]);
                 }
            }
            addMouseListener(this);
            setFocusable(true);
            addKeyListener(this);
            addFocusListener(this);
       }
       
       public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,getWidth(), getHeight());
       }
       public void refresh() {
            for(int k = 0; k < n; k++){
                 for (int l = 0; l < n; l++){
                      board[l][k].setColor(Color.blue);
                 }
            }
            repaint();
       }
       
       public void moveRed(int xmod, int ymod) {
            refresh();
            //System.out.println(xmod + "\t" + ymod);
            board[ymod][xmod].setColor(Color.red);
            xred = xmod;
            yred = ymod;
            repaint();
       }
       
       public void mouseClicked(MouseEvent e) {
            xred = n*e.getX()/getWidth();
            yred = n*e.getY()/getHeight();
            moveRed(xred, yred);
       }
       public void mouseEntered(MouseEvent e) { }
       public void mouseExited(MouseEvent e) { }
       public void mousePressed(MouseEvent e) { }
       public void mouseReleased(MouseEvent e) { }
       
       public void keyTyped(KeyEvent e) { }
       public void keyPressed(KeyEvent e) { }
       public void keyReleased(KeyEvent e) {
            //System.out.println(e.getKeyCode());
            if (e.getKeyCode() == 37) {
                 //left arrow
                 if (xred != 0) {
                      //System.out.println("Xred != 0, Xred ==" + xred);
                      moveRed(xred-1, yred);
                 }
            }
            if (e.getKeyCode() == 39) {
                 //right arrow
                 if (xred != n-1) {
                      //System.out.println("Xred != n, Xred ==" + xred);
                      moveRed(xred+1, yred);
                 }
            }
            if (e.getKeyCode() == 38) {
                 //up arrow
                 if (yred != 0) {
                      //System.out.println("Yred != 0, Yred ==" + yred);
                      moveRed(xred, yred-1);
                 }
            }
            if (e.getKeyCode() == 40) {
                 //down arrow
                 if (yred != n-1) {
                      //System.out.println("Yred != n, Yred ==" + yred);
                      moveRed(xred, yred+1);
                 }
            }
       }
       
       public void focusGained(FocusEvent e) {
            System.out.println("focused");
            requestFocus();
       }
       public void focusLost(FocusEvent e) {
            System.out.println("unfocused");
       }
  }
}
