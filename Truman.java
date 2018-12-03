import javax.swing.JOptionPane;

public class Truman
{
     public int getTheNumber() throws NumberFormatException
     {
          return Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
     }
     public void doSquat() throws InterruptedException
     {
          System.out.println("beep");
          Thread.sleep(3000);
          System.out.println("beep");
     }
}
