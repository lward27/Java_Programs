/**
 * Linked lists implemented in a non-OO fashion using a recursive definition
 * A consequence of this type of implementation is that the result of each
 * operation is a newly defined list and the original list before the
 * operation still remains intact.
 *
 * All methods are static except toString(). Only the basic list methods are included. Thus,
 * outside this class definition, you have to say
 *
 *         RL.cons( A, B );
 *         RL.first( A );
 *          etc.
 *
 * @author Matt Stallmann, ordered list version 2008/08/21,
 * generic list 2010/08/19
 */

public class RL {
    /**
     * Used to get trace printing for recursive functions
     */
    static IndentPrinter indent = new IndentPrinter( System.out, "  | " );

    /** Using the Lisp acronyms*/
    private int car;
    private RL cdr;

    private RL( int element, RL list ) {
        car = element;
        cdr = list;
    }

    public static RL cons( int element, RL list ) {
        return new RL( element, list ); 
    }

    public static int first( RL list ) {
        return list.car;
    }

    public static RL rest( RL list ) {
        return list.cdr;
    }

    public static boolean isEmpty( RL list ) {
        return list == null;
    }

    private String stringHelper( RL list )
    {
        if ( list == null ) return "";
        if ( rest( list ) == null ) return "" + first( list );
        return first( list ) + "," + stringHelper( rest(list) );
    }

    public String toString()
    {
        return "[" + stringHelper( this ) + "]";
    }

    public static RL arrayToList( int [] array ) {
        RL list = null;
        for ( int i = array.length - 1; i >= 0; i-- ) {
            list = cons( array[i], list );
        }
        return list;
    }

    /**
     * (recursively) appends two lists
     */
    public static RL append( RL Lone, RL Ltwo ) {
        indent.println("-> append: " + Lone
                       + "; " + Ltwo );
        RL result = null;
        indent.increase();
        if ( isEmpty(Lone) ) result = Ltwo;
        else {
            RL recursiveResult = append( rest(Lone), Ltwo );
            result = cons( first(Lone), recursiveResult );
        }
        indent.decrease();
        indent.println("<- append: " + result );
        return result;
    }

    /**
     * A simple test of the recursive list class: creates two lists and appends
     * them. The "RL." prefixes are not necessary here, but are included to
     * illustrate hopw to use these functions in other classes. 
     */
  public static void main(String [] args)
  {
      RL Lone = null;
      RL Ltwo = null;
      int [] LoneArray = { 1, 2, 3 }; 
      Lone = RL.arrayToList( LoneArray );
      System.out.printf( "Lone = %s, Ltwo = %s\n"
                         + "first(Lone) = %d, rest(L1) = %s\n"
                         + "Lone empty = %b, Ltwo empty = %b\n",
                         Lone, Ltwo,
                         RL.first(Lone), RL.rest(Lone),
                         RL.isEmpty(Lone), RL.isEmpty(Ltwo) );
      Ltwo = RL.cons( 4, Ltwo );
      RL Lthree = RL.append( Lone, Ltwo );
      System.out.printf( "Lone = %s, Ltwo = %s, Lthree = %s\n",
                         Lone, Ltwo, Lthree );

  } // end, main
} // end, class

//  [Last modified: 2010 08 26 at 18:57:58 GMT]
