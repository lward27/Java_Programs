import javax.swing.JFrame;
import java.awt.GridLayout;

public class KeyHolder extends JFrame
{
    TryKeyListener left;
    TryKeyListener right;
    public KeyHolder()
    {
        
        super("Key Listener Demo");
        left = new TryKeyListener();
        right = new TryKeyListener();
        getContentPane().setLayout(new GridLayout(1,2));
        getContentPane().add(left);
        getContentPane().add(right);
        //addKeyListener(t);
    }
    public void go()
    {
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        KeyHolder k = new KeyHolder();
        k.go();
    }
    
}
