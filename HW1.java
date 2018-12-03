/**
 * This class contains the difference and unshuffle functions, along
 * with all of their helper functions.
 * @author Lucas Ward
 * @version 1.0
 */
public class HW1 {
	static IndentPrinter indent = new IndentPrinter( System.out, "  | " );
	
	/**
	 * This function adds one to a binary number list.
	 * @param binary
	 * @return list
	 */
	public static RL plusOne( RL binary ) {
		indent.println("-> plusOne: " + binary);
		indent.increase();
        RL ret = null;
        if ( binary == null ) ret = RL.cons( 1, null );
        else {
            RL rec = plusOne( RL.rest( binary ) );
            int f = RL.first( rec );
            if ( RL.first(binary) == 1 && f == 1 )
                ret = RL.cons( 1, RL.cons( 0, RL.rest( rec ) ) );
            else if ( RL.first( binary ) == 1 || f == 1 )
                ret = RL.cons( 0, RL.cons( 1, RL.rest(rec) ));
            else ret = RL.cons( 0, RL.cons( 0, RL.rest(rec) ));
        }
        indent.decrease();
        indent.println("<- result: " + ret);
        return ret;
    }
	
	/**
	 * This function performs one's complement on a binary list.
	 * @param toBeFlipped
	 * @return list
	 */
	public static RL complement(RL toBeFlipped)
	{
		indent.println("-> complement: " + toBeFlipped);
		indent.increase();
		RL comped = null;
		if(toBeFlipped == null)
			return null;
		else {
			RL rec = complement(RL.rest(toBeFlipped));
			if(RL.first(toBeFlipped) == 1)
				comped = RL.cons(0, rec);
			if(RL.first(toBeFlipped) == 0)
				comped = RL.cons(1, rec);
		}
		indent.decrease();
		indent.println("<- result: " + comped);
		return comped;
	}
	
	/**
	 * This function removes the first element from a list.
	 * @param list
	 * @return list
	 */
	public static RL removeFirst(RL list)
	{
		RL newList = RL.rest(list);
		return newList;
	}
	
	/**
	 * This function returns the sum of two lists.
	 * @param L1
	 * @param L2
	 * @return list
	 */
	public static RL sum(RL L1, RL L2)
	{
		indent.println("-> sum: " + L1 + ", " + L2);
		indent.increase();
        RL zeroList = null;
        zeroList = RL.cons(0, zeroList);
		if(L1 == null) {
			return zeroList;
		}
		RL summed = sum(RL.rest(L1), RL.rest(L2));
		int s = RL.first(L1) + RL.first(L2) + RL.first(summed);
		int b = s % 2;
		int c = s / 2;
		
		RL result = RL.cons(c, RL.cons(b, RL.rest(summed)));
		indent.decrease();
		indent.println("<- result: " + result );
		
		return result;
	}
	
	/**
	 * This function returns the difference of two lists.
	 * @param L1
	 * @param L2
	 * @return list
	 */
	public static RL difference(RL L1, RL L2) 
	{
		L2 = complement(L2);
		L2 = plusOne(L2);
		L2 = removeFirst(L2);
		RL diffList = sum(L1,L2);
		diffList = removeFirst(diffList);
		return diffList;
	}
	
	/**
	 * This function reverses a list.
	 * @param list
	 * @return list
	 */
	public static RL reverse(RL list)
	{
		indent.println("-> reverse: " + list);
		indent.increase();
		if(RL.isEmpty(list))
		{	
			indent.decrease();
			indent.println("<- result: " + null);
			return null;
		}
		RL rL = RL.rest(list);
		RL result = addToEnd(RL.first(list), reverse(rL));
		indent.decrease();
		indent.println("<- result: " + result);
		return result;
	}
	
	/**
	 * This function adds an element to the end of a list
	 * @param element
	 * @param list
	 * @return list
	 */
	public static RL addToEnd(int element, RL list)
	{
		indent.println("-> addToEnd: " + list);
		indent.increase();
		if(RL.isEmpty(list))
		{
			indent.decrease();
			indent.println("<- result: " + null);
			return RL.cons(element, null);
		}
		RL result = RL.cons(RL.first(list), addToEnd(element, RL.rest(list)));
		indent.decrease();
		indent.println("<- result: " + result);
		return result;
	}
	
	/**
	 * This function calls reverse on the shuffle function
	 * which returns odd position before even ones.
	 * reversing the result gives evens before odds.
	 * @param list
	 * @return list
	 */
	public static RL unshuffleCall(RL list)
	{
		return reverse(unshuffle(list, 1));
	}
	
	/**
	 * this function returns odd positions before even
	 * ones.
	 * @param list
	 * @param odd
	 * @return list
	 */
	public static RL unshuffle(RL list, int odd)
	{
		indent.println("-> unshuffle: " + list);
		indent.increase();
		RL result = null;
		RL temp = null;
		if(RL.isEmpty(list))
			return null;
		if(odd%2 != 0)
		{
			temp = addToEnd(RL.first(list),RL.rest(list));
			result = RL.cons(RL.first(temp),unshuffle(RL.rest(temp), odd++));
		}	
		else 
			result = unshuffle(RL.rest(list), odd++);
		indent.decrease();
		indent.println("<- result: " + result);
		return result;
	}
	
	/**
	 * This function calls the other functions for running
	 * and testing purposes.
	 * @param args
	 */
	public static void main(String [] args)
    {
		RL list = null;
		RL list2 = null;
		RL list3 = null;
		RL list4 = null;
		
        list = RL.cons(0, list);
        list = RL.cons(1, list);
        list = RL.cons(0, list);
        list = RL.cons(1, list);
        
        list2 = RL.cons(1, list2);
        list2 = RL.cons(1, list2);
        list2 = RL.cons(1, list2);
        list2 = RL.cons(0, list2);
        
        list3 = RL.cons(1, list3);
        list3 = RL.cons(1, list3);
        list3 = RL.cons(1, list3);
        
        list4 = RL.cons(0, list4);
        list4 = RL.cons(1, list4);
        list4 = RL.cons(1, list4);
        
        System.out.println("This is list 1: " + list);
        System.out.println("This is list 2: " + list2);
        RL subbedList = difference(list, list2);
        System.out.println("This is the difference of list one and two: " + subbedList);
        
        System.out.println("This is list 3: " + list3);
        System.out.println("This is list 4: " + list4);
        RL subbedList2 = difference(list3, list4);
        System.out.println("This is the difference of list three and four: " + subbedList2);
        
        /*System.out.println("this is list 3: " + list3);
        RL newlist = unshuffleCall(list3);
        System.out.println("This is the unshuffled list: " + newlist);*/
    } // end, main

}
