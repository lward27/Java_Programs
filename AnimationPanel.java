import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * A simple self-driving {@link JPanel} subclass that allows Java programming students to
 * explore the AWT graphics drawing commands.
 * 
 * @author      Dennis Yeh *** but modified by Lucas Ward
 */

public class AnimationPanel extends JPanel {
  
  // Global parameters
  private static int red = 0;
  private static Rectangle rectangle = new Rectangle( 0 , 10 , 200 , 300 );
  private static Rectangle rectangle2 = new Rectangle( 600, 10, 200, 300);
  
  /**
   * To be implemented by the student
   * 
   * @param g the {@link Graphics} context in which to paint
   */
  public void paintComponent (Graphics g) {
    
    Graphics2D g2d = (Graphics2D)g;
    
    clear( g2d );
    //g2d.setColor( new Color( red = (red + 5)%256 , 100 , 100) );
    g2d.setColor(Color.RED);
    /*if (DELAY > 10) {
      DELAY -= 1;
    }*/
    rectangle.translate(2,0);
    rectangle2.translate(-2,0);
    g2d.fill( rectangle );
    g2d.fill( rectangle2 );
    System.out.println(rectangle.getX());
    System.err.println(rectangle2.getX());
    if (rectangle.getX() >= 300)
      {
        g2d.setColor(Color.BLUE);
        g2d.fill( rectangle );
        rectangle2.translate(4,6);
        repaint();
      }
    if (rectangle.getX() == 600)
    {
      System.exit(0);
    }
  }
  
  /**
   * Refresh background.  Must be called in paintComponent
   */
  private void clear( Graphics2D g2d ) {
    Color current = g2d.getColor();
    g2d.setColor( Color.WHITE );
    g2d.fillRect(0,0,getWidth(),getHeight());
    g2d.setColor( current );
  }

  private void animate () { 
    while ( true ) {
      try {
        Thread.sleep ( 0 );
      } catch (Exception ex) {}
      repaint();
    }
  }
  
  /**
   * Drives AnimationPanel by showing a JFrame and setting an instance of
   * AnimationPanel as its content pane
   * 
   * @param args command-line arguments (not used)
   */
  public static void main (String[] args) {
    
    JFrame canvas = new JFrame();
    AnimationPanel panel = new AnimationPanel();
    canvas.setContentPane( panel );
    canvas.setSize( 800 , 600 );
    canvas.setVisible ( true );
    canvas.setFocusable ( true );
    canvas.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    panel.animate();
  }
}
