import java.util.Scanner;
import java.util.InputMismatchException;

public class Numbers
{
  private static void go()
  {
    try
    {
      //output result
      Scanner user = new Scanner(System.in);
      
      //prompt user for number
      System.out.println("Enter a number and press enter.");
      double op1 = user.nextDouble();
      user.nextLine();
      
      //prompt user for +-*/
      System.out.println("Operator. Now! and hit enter.");
      String line = user.nextLine();
      char op = line.equals("") ? '+' : line.charAt(0);
      /*
       char op;
       if(!line.equals(""))
       {
       op = '+';
       }
       else
       {
       op = line.charAt(0);
       }
       */
      
      //prompt user for number
      System.out.println("Number, pleezz. and hit enter.");
      double op2 = user.nextDouble();
      user.nextLine();
      
      if(op == '+')
      {
        System.out.println("The sum is " + (op1 + op2));
      }
      else if(op == '-')
      {
        System.out.println("The difference is " + (op1 - op2));
      }
      else
      {
        System.out.println("Es tut mir leid.  Unrecognized operator.");
      }
    }
    catch(InputMismatchException ex)
    {
      System.out.println("You didn't enter a number.");
    }
  }
  
  private static double evaluate ( String exp)  //recursively evaluate right subexpression 
  {
    //find the operator
    //recursively evalutae left subexpression
    //recursively evaluate right subexpression
    Scanner user2 = new Scanner(System.in);
    
  }
      
      
  public static void main(String[] args)
  {
    //read expressfrom user
    evaluate ( expression );
    try
    {
      go();
    }
    catch(InputMismatchException e)
    {
      System.out.println("FAIL!");
    }
  }
}
