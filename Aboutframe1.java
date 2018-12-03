import javax.swing.JFrame;

public class Aboutframe extends JFrame implements Runnable
{
     public void run()
     {
          go();
     }
     public Aboutframe()
     {
          super("About");
     }
     public void go()
     {
          setSize(200,600);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setVisible(true);                    
     }
     

}
