/**
 * Prints out lists of numbers using nested for loops.
 * The problems are Exercises 12-14 from Reges and Stepp's
 * Building Java Programs.
 * 
 * @author Lucas Ward 
 */
public class NumberPrinter {
  
  /**
   * Starts the program and calls each of the methods that
   * complete one of the exercises
   * 
   * @param args
   */
  public static void main(String [] args) {
    exercise12();
    System.out.println();
    exercise13();
    System.out.println();
    exercise14();
  }
  
  /**
   * Prints out the following output
   * 000111222333444555666777888999
   * 000111222333444555666777888999
   * 000111222333444555666777888999
   */
  public static void exercise12() {
	for(int i=1; i<=3; i++)
	{
		for(int j=0; j<10; j++)
		{
			System.out.print(j);
			System.out.print(j);
			System.out.print(j);
		}
		System.out.println();
	}
  }
  
  /**
   * Prints out the following output
   * 99999888887777766666555554444433333222221111100000
   * 99999888887777766666555554444433333222221111100000
   * 99999888887777766666555554444433333222221111100000
   * 99999888887777766666555554444433333222221111100000
   * 99999888887777766666555554444433333222221111100000
   */
 public static final int MAXVAL = 9;
 public static final int MINVAL = 0;
 public static final int MAXOUTERVAL = 4;
 public static final int MINOUTERVAL = 1;
 
 public static void exercise13() {
	for(int i=MINOUTERVAL; i<=MAXOUTERVAL; i++)
        {
                for(int j=MAXVAL; j>=MINVAL; j--)
                {
                        System.out.print(j);
                        System.out.print(j);
                        System.out.print(j);
                        System.out.print(j);
                        System.out.print(j);
                }
                System.out.println();
        }
  }
  
  /**
   * Prints out the following output
   * 999999999888888887777777666666555554444333221
   * 999999999888888887777777666666555554444333221
   * 999999999888888887777777666666555554444333221
   * 999999999888888887777777666666555554444333221
   */
  public static final int NUMBEROFLINES = 4;
  public static final int NUMBERBEINGPRINTED = 9;
 
  public static void exercise14() {
	for(int i=1; i<=NUMBEROFLINES; i++)
	{
		for(int j=NUMBERBEINGPRINTED; j>=1; j--)
		{
			for(int k=j; k>=1; k--)
			{
				System.out.print(j);
			}
		}
		System.out.println();
	}
  }
}














