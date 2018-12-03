/**
 * This class represents a location on the BattleBoard's grid
 * @author Lucas Ward
 * @version 1.0
 */

public class Square
{
    //true is square has been hit by enemy fire
    private boolean hasHit;
    //a Ship instance
    private Ship _ship;
    
    /**
     * constructor
     */
    public Square()
    {
    }
    
    /**
     * returns true if square has been hit by enemy fire
     * @return boolean true if has been hit
     */
    public boolean hasBeenHit()
    {
        return hasHit;
    }
    
    /**
     * returns a Ship instance if there is a ship that
     * includes this square or null if there is no such ship
     * @return Ship a ship instance
     */
    public Ship getShip()
    {
        return _ship;
    }
    
    /**
     * updates the square to have been hit, if there is a ship
     * in the square, lets it know it has been hit
     */
    public void fireAt()
    {
        hasHit = true;
        if(hasShip() == true)
            _ship.hit();        
    }
    
    /**
     * returns true if the Square contains a Ship
     */
    public boolean hasShip()
    {
        if(_ship != null)
            return true;
        return false;
    }
    
    /**
     * add the given ship to the square
     * @param Ship a ship
     */
    public void addShip(Ship ship)
    {
        _ship = ship;
    }
    
    /**
     * Returns a String representation of a Square
     * @return String representation
     */
    public String toString()
    {
        if(hasShip() == true)
        {
            //square has ship and has been hit
            if(hasBeenHit() == true)
                return "R";
            //if square has not been hit and contains a ship
            else
                return _ship._getLength();
        }
        
        if(hasShip() == false)
        {
            //square has been hit and does not contain a ship
            if(hasBeenHit() == true)
                return "W";
            //does not contain a ship and has not been hit
            else
                return "-";
        }
        return "";
        
    }
}
