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
  
  public static double evaluate (String exp)  //recursively evaluate right subexpression 
  {
    System.out.println(exp);
    int left = 1;
    int right = exp.length()-1;
    if (( exp.charAt(0) != '(' ) && (exp.charAt(right) != ')' ))
    {    
      try 
      {
        double result = Double.parseDouble(exp.substring(left,right).trim());
        return result;
      }
      catch (NumberFormatException ex) {}
    }
    //find the operator
    int parenCount = 0;
    int opIndex = /*?*/-1;
    for (int index = 1; index < right ; index++)
    {
      switch (exp.charAt(index))
      {
        case '(':
          parenCount++;
          break;
        case ')':
          parenCount--;
          break;
        case '+':
        case '-':
        case '*':
        case '/':
            opIndex = index;
            break;
      }

    }
    //recursively evalutae left subexpression
    double leftVal = evaluate (exp.substring(1,opIndex));
    
    //recursively evaluate right subexpression
    double rightVal = evaluate (exp.substring(opIndex+1));
    return leftVal+rightVal;
    
  }
      
      
  public static void main(String[] args)
  {
    //read expressfrom user
    evaluate( "((4.5+3.2)+(6.7-8.2))" );
    /*try
    {
      go();
    }
    catch(InputMismatchException e)
    {
      System.out.println("FAIL!");
    }*/
  }
}
