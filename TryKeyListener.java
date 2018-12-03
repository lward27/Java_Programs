import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Graphics;;
import java.awt.Color;
import java.awt.Font;

public class TryKeyListener extends JPanel implements KeyListener,
    FocusListener
   // implements MouseListener;
{
    private String lastPressed;
    public TryKeyListener()
    {
        super();
        lastPressed = "q";
        setFocusable(true);
        addKeyListener(this);
        addFocusListener(this);
    }
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(), getHeight());
        g.setColor(Color.green);
        g.setFont(new Font("Monospaced", Font.BOLD, 72));
        System.out.println("" + lastPressed);
        g.drawString(lastPressed, getWidth()/2, getHeight()/2);
    }
        
    public void keyPressed(KeyEvent e)
    {
        requestFocus();
    }
    public void keyReleased(KeyEvent e)
    {
        repaint();
    }
    public void keyTyped(KeyEvent e)
    {
        lastPressed = String.format("%s", e.getKeyChar());
        System.out.println("lastPressed = " + lastPressed);
    }
    public void focusGained(FocusEvent e)
    {
        System.out.println("focused");
        requestFocus();
    }
    public void focusLost(FocusEvent e)
    {
        System.out.println("unfocused");
    }
        
}
