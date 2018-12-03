import javax.swing.JOptionPane;

public class CountDown
{
     public static void main(String[] args)
     {
          int n = 10;
          while( n >= 0)
          {
               try
               {
                    System.out.println(n);
                    String silly = JOptionPane.showInputDialog("TYPE SOMTHING");
                    int pointless = Integer.parseInt(silly);
                    n--;
                    Thread.sleep(1000);
               }
               catch (NumberFormatException e)
               {
                    System.err.println("goof");
               }
               catch (InterruptedException e){}
               catch (Exception e)
               {
                    System.err.println("Yer smoking' buster...");
               }
               finally
               {
                    System.out.println("This runs no matter what");
               }
               
          }
     }
}
