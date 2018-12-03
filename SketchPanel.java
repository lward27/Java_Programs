import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Random;

/**
* A simple self-driving {@link JPanel} subclass that allows Java programming students to
* explore the AWT graphics drawing commands.
* 
* @author Dennis Yeh
*/

public class SketchPanel extends JPanel 
{

  
  

/**
* To be implemented by the student
* 
* @param g the {@link Graphics} context in which to paint
*/
  public void paintComponent (Graphics g) 
  {
    Graphics2D g2d = (Graphics2D)g;
    Graphics2D g2d2 = (Graphics2D)g;
    g.setColor(Color.WHITE);
    g.fillRect(0,0,getWidth(), getHeight());
    
    ////////////////////////////////////////////////////////////
    //   Add your drawing commands here                       //
    /*for (int i = 0 ; i < 1 ; i++)
    {
      int x = (int)(Math.random() * getWidth());
      int y = (int)(Math.random() * getHeight());
      int size = (int)(Math.random() * 200 );
      Random r = new Random();
      Color color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
      Heart burn = new Heart( x, y, size, color);
      burn.paint( g2d );
    }*/
    for (int i = 0 ; i < /*number of squares*/ 500 ; i++)
    {
      
      Random q = new Random();
      Color color = new Color(q.nextInt(256), q.nextInt(256), q.nextInt(256));
      Square spin = new Square( 200, 200, color);
      g2d2.rotate(/*|||rotation facor|||*/ 5, 400, 400);      
      spin.paint(g2d2);
    }
    //s.setLocation( 500, 500 );
    //s.paint(g2d , new Color( 20 + i, 100 + i, 200 - i ));
    
    
    //                                                        //
    ////////////////////////////////////////////////////////////
  }
  
  
  /*
   * Drives SketchPanel by showing a JFrame and setting an instance of
   * SketchPanel as its content pane
   * 
   * @param args command-line arguments (not used)
   */
  public static void main (String[] args)
  {    
    JFrame canvas = new JFrame();
    canvas.setLocation(400,400);
    canvas.setContentPane( new SketchPanel() );
    canvas.setSize( 1000 , 1000 );
    canvas.setVisible ( true );
    canvas.toFront ( );
    canvas.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}

 
