/**
 * This class is a model template for the humans and compuers
 * battleship board
 * @author Lucas Ward
 * @version 1.0
 */
public class BattleBoard
{
    //Two deminsional array of squares
    Square[][] squares = new Square[BattleGame.COLS][BattleGame.ROWS];
    //array of ships
    Ship[] ships = new Ship[BattleGame.NUMBER_OF_SHIPS];
    
    /**
     * Constructs all the squares and ships to null settings and such
     */
    public BattleBoard()
    {
        for(int i = 0; i < BattleGame.COLS; i++)
        {
            for(int j = 0; j < BattleGame.ROWS; j++)
                squares[j][i] = new Square();
        }
        
        for(int i = 0; i < BattleGame.NUMBER_OF_SHIPS; i++)
        {
            ships[i] = new Ship();
        }
    }
    
    public boolean hasShips(int len, boolean isHorizontal, int startRow, int startCol)
    {
        boolean hasShips = false;
        if(isHorizontal == true)
        {
            for(int j = startCol; j < startCol + len; j++)
            {
                if(squares[j][startRow].hasShip() == true)
                    hasShips = true;
            }
        }
        if(isHorizontal == false)
        {
            for(int j = startRow; j < startRow + len; j++)
            {
                if(squares[startCol][j].hasShip() == true)
                    hasShips = true;
            }
        }
        return hasShips;
        
    }
    
    /**
     * adds a ship to the board
     * @return boolean true if addition is successful
     * @param int length of ship
     * @param boolean ships oreintation
     * @param int starting row
     * @param int starting column
     */
    public boolean addShip(int length, boolean isHorizontal, int startRow, int startCol)
    {
        
        //ships[length-1] = new Ship(length,isHorizontal,startRow,startCol);
        
        
        if(isHorizontal == true)
        {
            if(startCol + length <= BattleGame.COLS && hasShips(length,isHorizontal,startRow,startCol) == false)
            {
                ships[length-1] = new Ship(length,isHorizontal,startRow,startCol);
                for(int i = startCol; i < startCol + length; i++)
                { 
                    squares[i][startRow].addShip(ships[length-1]);
                }
                return true;
            }
            else
                return false;
        }
        

    
    
        if(isHorizontal == false)
        {
            if(startRow + length <= BattleGame.ROWS && hasShips(length,isHorizontal,startRow,startCol) == false)
            {
                ships[length-1] = new Ship(length,isHorizontal,startRow,startCol);
                for(int i = startRow; i < startRow + length; i++)
                {
                    squares[startCol][i].addShip(ships[length-1]);
                }
                return true;
            }
            else
                return false;
        }
        return false;
        
    }
    
    /**
     * returns the number of ships deployed on the battleboard
     * @return int number of ships
     */
    public int getNumberOfShips()
    {
        int numShips = 0;
        for(int i = 0; i < ships.length; i++)
        {
            if(ships[i].getLength() != 0)
                numShips++;
        }
        return numShips;
    }
    
    /**
     * returns an array of ships
     * @return Ship[] an array of ships
     */
    public Ship[] getShips()
    {
        return ships;
    }
    
    /**
     * returns true if enemy can fire at location, and fires if it can
     * @return boolean true of false
     * @param int row to fire at
     * @param int column to fire at
     */
    public boolean fireAtLocation(int row, int col)
    {
        if(squares[col][row].hasBeenHit() == true)
            return false;
        else
        {
            squares[col][row].fireAt();
            return true;
        }  
    }
    
    /**
     * returns true if the enemy has already fired on the square located
     * at the specified row and column
     * @return boolean true of false
     * @param int row
     * @param int column
     */
    public boolean hasBeenHit(int row, int col)
    {
         if(squares[col][row].hasBeenHit() == true)
             return true;
         else
             return false;
    }
    
    /**
     * returns true if all of the Ships on the
     * BattleBoard have been sunk by enemy fire
     * @return boolean true of false
     */
    public boolean areAllShipsSunk()
    {
        int true_count = 0;
        for(int i = 0; i < BattleGame.NUMBER_OF_SHIPS; i++)
        {
            if(ships[i].isSunk() == true)
                true_count++;
        }
        if(true_count == BattleGame.NUMBER_OF_SHIPS)
            return true;
        return false;
    }
    
    /**
     * returns the number of rows in the Battle Board
     * @return int number of rows
     */
    public int getNumberOfRows()
    {
        return BattleGame.ROWS;
    }
    
    /**
     * returns the number of columns in the battle Board
     * @return int number of columns
     */
    public int getNumberOfColumns()
    {
        return BattleGame.COLS;
    }
    
    /**
     * returns a string representation of the BattleBoard
     * @return String, the board
     */
    public String toString()
    {
        for(int i = 0; i < BattleGame.COLS; i++)
        {
            System.out.println();
            for(int j = 0; j < BattleGame.ROWS; j++)
            {
                System.out.print(squares[j][i].toString());
            }
        }
        return "";
    }
    
}
