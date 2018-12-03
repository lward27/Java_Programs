import javax.swing.JOptionPane;

public class Foolishness
{
     public static void main(String [] args)
     {
          String numberString = JOptionPane.showInputDialog("Enter a number (not 27)");
          int number = 0;
          try
          {
               number = Integer.parseInt(numberString);
          }
          catch(NumberFormatException e)
          {
               System.err.println("Illegal entry: " + numberString + " is not a number, it is a MISTAKE!!!");
          }
          System.out.println(number);
     }
}
