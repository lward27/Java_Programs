import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JButton;


public class MultiPanel4 extends JPanel
{
     private Color squareColor;
     private Color backgroundColor;
     //private Square theWestSquare;
     //private Square theCenterSquare;
     //private Square theEastSquare;
     public MultiPanel4(Color _backgroundColor, Color _squareColor)
     {
          super();
          backgroundColor = _backgroundColor;
          //squareColor = _squareColor;
          //theWestSquare = new Square(0,0,squareColor);
          //theCenterSquare = new Square(200,0,squareColor);
          //theEastSquare = new Square(400,0,squareColor);
          
          
     }
     public MultiPanel4()
     {
          this(Color.BLUE, Color.white);
     }  
     /*public void setSquareColor(Color c)
     {
          squareColor = c;
     }*/
     public void paintComponent(Graphics g)
     {
          g.setColor(backgroundColor);
          g.fillRect(601,0,1, getHeight());
          /*g.setColor(theWestSquare.getColor());
          g.fillRect(theWestSquare.getUpperLeftX(), theWestSquare.getUpperLeftY(), 200, 600);
          g.setColor(theCenterSquare.getColor());
          g.fillRect(theCenterSquare.getUpperLeftX(), theCenterSquare.getUpperLeftY(), 200, 600);
          g.setColor(theEastSquare.getColor());
          g.fillRect(theEastSquare.getUpperLeftX(), theEastSquare.getUpperLeftY(), 200, 600);*/
     }
     public void setBackgroundColor(Color c)
     {
          backgroundColor = c;
     }
}
