import java.util.Scanner;
import java.util.InputMismatchException;

class CalculatorMania
{
  public static void calculateAlpha ()
  {
    Scanner in = new Scanner( System.in );
    try {
      System.out.print( "Enter the first number : " );
      double first = in.nextDouble();
      
      System.out.print( "Enter the second number : " );
      double second = in.nextDouble();
      
      System.out.print( "Enter an operator : " );
      char op = in.next().charAt( 0 );
      
      double result;
      
      switch ( op )
      {
        case '*' :
        case 'x' :
        case 'X' : result = first * second; break;
        
        case '/' : result = first / second; break;
        
        case '+' : result = first + second; break;
        
        default : result = first - second; break;
      }
      
      System.out.println( "The result is " + result );
    }
    
    catch ( InputMismatchException e ) {
      System.out.println( "nice number, user" );
      return;
    }
    
  }
  
   
  public static void calculateBeta () {
    
    Scanner in = new Scanner( System.in );
    String input = in.nextLine();
    while (input != null && !input.equals("quit")) {
      try {
        System.out.println( eval ( input ) );
      }
      catch ( SyntaxException ex )
      {
        ex.printStackTrace();
        System.out.println("ILL Eagle in put");
      }
      input = in.nextLine();
    }
    // "(((1+2)-(3*4))*2)"
  }


  
  public static class SyntaxException extends Exception
  {
    public SyntaxException ( String _msg )
    {
      super(_msg);
    }    
    public String possibleSuggestions()
    {
      return "try +,-,*, or /";
    }    
  }
  
  
  
  
  
// Recursive helper
  private static double eval( String exp ) throws SyntaxException
  {
    
    try 
    {
      double atom = Double.parseDouble( exp );
      return atom;
    }
    catch (NumberFormatException e) 
    {
    }
    
    if ( exp.equals("") )
    {
      throw new SyntaxException( "reached unexpected empty expression" );
    }
    
    // charAt(0)  should be '('
    else if ( exp.charAt(0) != '(' )
    {
      throw new SyntaxException("");
    }
    // charAt(exp.charAt( exp.length()-1)  should be ')'
    
    // Scan for correct operator
    int endIndex = exp.length();
    int lParenCount = 0;
    // count '('s, deduct when you find each ')'
    for (int i = 1 ; i < endIndex ; i++ ) {
      // if 0 '('s, correct operator found
      char next = exp.charAt(i);
      if ( next == '(' ) {
        lParenCount++;
      }
      else if (next == ')') {
        lParenCount--;
      }
      
      else if ( lParenCount == 0 ) {
        
        double left,right;
        switch ( next ) {
          case '*':
            left = eval(exp.substring(1,i));
            right = eval(exp.substring(i+1,endIndex-1));
            return left * right;
          case '+':
            left = eval(exp.substring(1,i));
            right = eval(exp.substring(i+1,endIndex-1));
            return left + right;
          case '-':
            left = eval(exp.substring(1,i));
            right = eval(exp.substring(i+1,endIndex-1));
            return left - right;
          case '/':
            left = eval(exp.substring(1,i));
            right = eval(exp.substring(i+1,endIndex-1));
            return left / right;
        }
      }
    }
    return 0.0;
  }
  
  public static void main ( String[] args )
  {
    calculateBeta();
  }
}
