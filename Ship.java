/**
 * this class represents a single ship in a fleet of ships
 * @author Lucas Ward
 * @version 1.0
 */
public class Ship
{
    //a ships length, type int
    private int len;
    //the number of times it has been hit, type int
    private int numberHits;
    //ship orientation, boolean
    private boolean isHorizon;
    //ships location row
    private int sRow;
    //ships location column
    private int sCol;
    
    /**
     * Initializes the classes instance variables with the following parameters
     * @param int length of ship
     * @param boolean isHorizontal, the oreintation
     * @param int starting row
     * @param int starting col
     */
    public Ship(int length, boolean isHorizontal, int startRow, int startCol)
    {
        len = length;
        isHorizon = isHorizontal;
        sRow = startRow;
        sCol = startCol;
    }
    
    /**
     * null constructor
     */
    public Ship()
    {
        this(0,true,0,0);
    }
    
    /**
     * returns the length of the ship
     * @return int length
     */
    public int getLength()
    {
        return len;
    }
    
    /**
     * same as getLength() method, except it returns length as a string
     * @return String length
     */
    public String _getLength()
    {
        String a = String.valueOf(getLength());
        return a;
    }
    
    /**
     * returns true if the ship has horizontal orientation
     * @return boolean true of false
     */
    public boolean isHorizontal()
    { 
        return isHorizon;
    }
    
    /**
     * returns the row of the upper left corner of the Ship
     * @return int row
     */
    public int getStartRow()
    {
        return sRow;
    }
    
    /**
     * returns the column of the upper left corner of the Ship
     * @return int column
     */
    public int getStartCol()
    {
        return sCol;
    }
    
    /**
     * simulates hitting the ship, therefore updates instance variable
     * numberOfHits
     */
    public void hit()
    {
        numberHits++;
    }
    
    /**
     * returns true if the ship is sunk (numberOfHits == length)
     * @return boolean true of false
     */
    public boolean isSunk()
    {
        if(numberHits >= len)
        {
            return true;
        }
        return false;
    }
    
    /**
     * returns a string representation of a ship
     * @return String representation of ship
     */
    public String toString()
    {
        return "The Ship of length " + getLength() + " at location (" + getStartCol() + "," + getStartRow() + "), is it Horizontal? " + isHorizontal() + ". It has been hit " + numberHits + " times. Is the ship sunk? " + isSunk();
    }
}
