import javax.swing.JFrame;

public class Helpframe extends JFrame implements Runnable
{
     public void run()
     {
          go();   
     }

     public Helpframe()
     {
          super("Help");
     }
     public void go()
     {
          setSize(400,600);
          setVisible(true); 
     }
     public static void main (String[] args)
     {
          Helpframe f = new Helpframe();
          f.run();
     }
}
