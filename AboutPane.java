import javax.swing.JEditorPane;

public class AboutPane extends JEditorPane implements Runnable
{
     public void run()
     {
          go();   
     }

     public AboutPane()
     {
          super("String", "hello");
     }
     public void go()
     {
          setSize(200,600);
          setVisible(true); 
     }
     public static void main (String[] args)
     {
          AboutPane f = new AboutPane();
          f.run();
     }
}
