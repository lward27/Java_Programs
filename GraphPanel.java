import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.awt.BorderLayout;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * A graphing companion to the Function classes.
 * 
 * @author      Dennis Yeh
 */

public class GraphPanel extends JPanel {
   
  
  private static final GraphPanel panel = new GraphPanel();
  private static final int WIDTH = 1000;
  private static final int HEIGHT = 700;
  private static final int TITLEBAR_WIDTH = 30;
  private static final int AXIS_WIDTH = 2;
  private static final int TICK_LENGTH = 5;  // half-length
  private static final int NUM_TICKS = 11;
  private static final Point ORIGIN = new Point(WIDTH/2,HEIGHT/2);
  private static double EPSILON = 0.01;
  private static double scalePerPixel = 0.01;
  private static final double ZOOM_SPEED = 2.0;
  private static int consoleX = 200;
  private static int consoleY = 300;
  private static Function f = new Constant(0);
  //private static final JTextField INPUT_FIELD = new JTextField(50);
  
  private static final Function[] MENU_FUNCTIONS =
  {
    /*
    , new Cosine()
    , new Tangent()
    , new Secant()
    , new Exponential(5)
    , new Logarithmic(5)
    , new Arcsine()
    , new Linear( 3 , 2 )
    , new Polynomial(new double[] {.04,.05,0,2})
    , new HyperExponential ( )    
   */
    new Constant(2)
    , new Constant(3.5)
    , new Sine()
    , new Linear(3)
    , new Tangent()
    , new Reciprical()
    , new Product(new Linear(2), new Sine())
    , new Cosine()
  };
  
  private static final JComboBox FUNCTION_MENU = new JComboBox();
  static {
    
    for (int i = 0 ; i < MENU_FUNCTIONS.length; i++ ) {
      FUNCTION_MENU.addItem ( MENU_FUNCTIONS[i] );
    }
    
    FUNCTION_MENU.setEditable(true);
    FUNCTION_MENU.addItemListener
      (new ItemListener() {
      public void itemStateChanged( ItemEvent e ) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          Function activeF = (Function)(FUNCTION_MENU.getSelectedItem());
          f = activeF;
        }
      }
    });
    
  }
  
  private static final ConsolePanel console = new ConsolePanel();
  
  private static final Color[] COLORS = { Color.RED , Color.GREEN , Color.BLUE , Color.CYAN };
  
  private static class ConsolePanel extends JPanel {
    
    public ConsolePanel() {
      setLayout( new BorderLayout(0,0) );
      final JTextField fOfx = new JTextField("f(x)=" , 0);
      fOfx.setEditable(false);
      add( fOfx , BorderLayout.WEST );
      //add( INPUT_FIELD , BorderLayout.CENTER );
      add( FUNCTION_MENU );
      JButton plotButton = new JButton("Plot it!");
      plotButton.addActionListener
        ( new ActionListener(){
        public void actionPerformed (ActionEvent e) {
          panel.repaint();
        }});
 //     plotButton.setSize( 10 , 10 );
      add( plotButton , BorderLayout.EAST );
     // setSize ( 300 , 20 );
    }
    
  }
  
  private static class AxisMover extends MouseInputAdapter implements MouseWheelListener {
   
    private int currX;
    private int currY;
    public void mousePressed ( MouseEvent e ) {
      currX = e.getX();
      currY = e.getY(); 
    }
    
    public void mouseDragged ( MouseEvent e ) {
      int newX = e.getX();
      int newY = e.getY();
      ORIGIN.translate ( newX - currX , newY - currY);
      currX = newX;
      currY = newY;
      panel.repaint();
    }
    
    public void mouseWheelMoved ( MouseWheelEvent e ) {
      int omega = e.getWheelRotation();
      boolean movedDown = omega > 0;
      scalePerPixel *= (movedDown ? ZOOM_SPEED : 1/ZOOM_SPEED) ;
      panel.repaint();
    }
  }
 /* 
  public GraphPanel () {
    JTextField box = new JTextField( "<html>3<sup>x</sup></html>" , 50);
    box.getCaretPosition();s
    add( box );
    box.setVisible ( true );
    
  }*/
  /**
   * To be implemented by the student
   * 
   * @param g the {@link Graphics} context in which to paint
   */
  public void paintComponent (Graphics g) {
    
   Graphics2D g2d = (Graphics2D)g;
   g2d.clearRect(0,0,WIDTH,HEIGHT);
   drawAxes( g2d );
   plotAll( g2d );
  }
  
  private static void plotAll ( Graphics2D g2d ) {
   Color curr = g2d.getColor();
   g2d.setColor( COLORS[0] );
   plotFunction( f , g2d);
   try {
     if ( f instanceof Differentiable ) {
       Differentiable df = ((Differentiable)f).derivative();   
       g2d.setColor( COLORS[1] );
       plotFunction( df , g2d);
       g2d.drawString( df.toString() , 0 , 20 );
       Function d2f = df.derivative();
       g2d.setColor( COLORS[2] );
       plotFunction( d2f , g2d);
       g2d.drawString( d2f.toString() , 0 , 50 );
     }
     if ( f instanceof Invertible ) {
      Function fInverse = (((Invertible)f).inverse());
      g2d.setColor( COLORS[3] );
      plotFunction ( fInverse , g2d );
     }
   }
   catch (RuntimeException ex) {
   }

   g2d.setColor(curr);
  }
  
  
  private static void drawAxes ( Graphics2D g2d ) {
    int x = (int)ORIGIN.getX();
    int y = (int)ORIGIN.getY();
    Stroke curr = g2d.getStroke();
    g2d.setStroke( new BasicStroke( AXIS_WIDTH ));
    g2d.drawLine( x , 0 , x , HEIGHT );
    g2d.drawLine( 0 , y , WIDTH , y );
    labelAxes ( g2d );
    g2d.setStroke(curr);
  }
  
  private static void labelAxes ( Graphics2D g2d ) {
    int originX = (int)ORIGIN.getX();
    int originY = (int)ORIGIN.getY();
    int hGap = WIDTH / (NUM_TICKS);
    int left = originX % hGap;
    for (int i = 0 ; i < NUM_TICKS ; i++ ) {
      int tickX = left + i * hGap;
      double x = (tickX - originX) * scalePerPixel;
      g2d.drawLine( tickX , originY + TICK_LENGTH , tickX , originY - TICK_LENGTH );
      g2d.drawString( (hGap * scalePerPixel > 1.0 ? String.valueOf((int)x) : String.format("%.2f",x))
                       , tickX + 3 ,  originY+(TICK_LENGTH * 2));
    }
    int vGap = HEIGHT / (NUM_TICKS);
    int top = originY % vGap;
    for (int i = 0 ; i < NUM_TICKS ; i++ ) {
      int tickY = top + i * vGap;
      double y = (tickY - originY) * scalePerPixel;
      g2d.drawLine( originX + TICK_LENGTH , tickY , originX - TICK_LENGTH , tickY );
      g2d.drawString( (vGap * scalePerPixel > 1.0 ? String.valueOf((int)y) : String.format("%.2f",y))
                       , originX+(TICK_LENGTH * 2) , tickY + 3 );
    }
  }
  
  private static void drawPoint( Graphics2D g2d , double x , double y ) {
    int originX = (int)ORIGIN.getX();
    int originY = (int)ORIGIN.getY();
    int panelX = originX + (int)(x/scalePerPixel);
    int panelY = originY - (int)(y/scalePerPixel);
    if ( 0 <= panelX && panelX <= WIDTH && 0 <= panelY && panelY <= HEIGHT )
      g2d.fillOval( panelX-1 , panelY-1 , 1 , 1 );
    
  }
  
  private static void connect( Graphics2D g2d , double x1 , double y1 , double x2 , double y2 ) {
    int originX = (int)ORIGIN.getX();
    int originY = (int)ORIGIN.getY();
    int panelX1 = originX + (int)(x1/scalePerPixel);
    int panelY1 = originY - (int)(y1/scalePerPixel);
    int panelX2 = originX + (int)(x2/scalePerPixel);
    int panelY2 = originY - (int)(y2/scalePerPixel);
    g2d.drawLine( panelX1 , panelY1 , panelX2 , panelY2 );
  }
    
  private static void plotFunction( Function f , Graphics2D g2d) {

    double originX = ORIGIN.getX();
    double prev = f.Of(-originX);
    for ( double x = -originX; x <= WIDTH - originX; x += EPSILON ) {
     
      drawPoint( g2d , x , f.Of(x) );
      connect( g2d , x - EPSILON , prev , x , prev = f.Of(x) );
    }
  }

  /**
   * Drives SketchPanel by showing a JFrame and setting an instance of
   * SketchPanel as its content pane
   * 
   * @param args command-line arguments (not used)
   */
  public static void main (String[] args) {
  
   JFrame canvas = new JFrame();
   AxisMover mover = new AxisMover();
   panel.addMouseListener( mover );
   panel.addMouseMotionListener( mover );
   panel.addMouseWheelListener( mover );
   panel.add( console , BorderLayout.NORTH );
   canvas.setContentPane( panel );
   canvas.setSize( WIDTH , HEIGHT+TITLEBAR_WIDTH );
   canvas.setVisible ( true );
   canvas.setFocusable ( true );
   canvas.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
