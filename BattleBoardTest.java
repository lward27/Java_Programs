/**
 * Automated white box test program for BattleBoard
 * @author Sarah Heckman
 */
public class BattleBoardTest {
    
    /** A private copy of the BattleBoard */
    private BattleBoard board;
    
    /**
     * Initializes the field
     */
    public BattleBoardTest() {
        board = new BattleBoard();
    }
    
    /**
     * Tests BattleBoard.addShip() method
     */
    public void testAddShip() {
        board = new BattleBoard();
        System.out.println("testAddShip");
        
        //Test adding a Ship at a valid location
        boolean expectedOutput = true;
        boolean actualOutput = board.addShip(1, true, 3, 5);
        System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
    }
    
    public void testAddShip2()
    {
        board = new BattleBoard();
        System.out.println("testAddShip2");
        
        //Test adding a Ship at an invalid location
        boolean expectedOutput = false;
        boolean actualOutput = board.addShip(3, true, 7, 7);
        System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
    }
    
    /**
     * Tests BattleBoard.getNumberOfShips() method
     */
    public void testGetNumberOfShips() {
        board = new BattleBoard();
        System.out.println("testGetNumberOfShips");
        
        //Test that there are no Ships when a BattleBoard is initially created
        int expectedOutput = 0;
        int actualOutput = board.getNumberOfShips();
        System.out.printf("Expected: %8d   Actual: %8d\n", expectedOutput, actualOutput);
        
        //Test the number of Ships after adding a Ship
        board.addShip(3, true, 7, 1);
        expectedOutput = 1;
        actualOutput = board.getNumberOfShips();
        System.out.printf("Expected: %8d   Actual: %8d\n\n", expectedOutput, actualOutput);
    }
    
    public void testGetNumberOfShips2() 
    {
        board = new BattleBoard();
        System.out.println("testGetNumberOfShips2");
        
        //Test that if a ship is add where it cannot be place, that the ship count does not increase
        int expectedOutput = 1;
        board.addShip(3,true,3,1);
        board.addShip(4,true,3,0);
            int actualOutput = board.getNumberOfShips();
        System.out.printf("Expected: %8d   Actual: %8d\n", expectedOutput, actualOutput);
        
    }
    
    /**
     * Tests BattleBoard.getShips() method
     */
    public void testGetShips() {
        board = new BattleBoard();
        System.out.println("testGetShips");
        
        //Test that all Ships are null when a BattleBoard is first created
        Ship [] ships = board.getShips();
        for (int i = 0; i < ships.length; i++) {
            try {
                ships[i].toString();
                System.out.printf("Expected: NullPointerException   Actual: Ship at index %d is not null\n", i);
            } catch (NullPointerException e) {
                System.out.printf("Expected: NullPointerException   Actual: NullPointerException\n");
            }
        }
    }
    
    /**
     * Tests BattleBoard.fireAtLocation() method
     */
    public void testFireAtLocation() {
        board = new BattleBoard();
        System.out.println("testFireAtLocation");
        
        //Test firing at a location that has never been fired at before
        boolean expectedOutput = true;
        boolean actualOutput = board.fireAtLocation(0, 0);
        System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        
    }
    
    public void testFireAtLocation2() 
    {
        board = new BattleBoard();
        System.out.println("testFireAtLocation2");
        
        //Test firing at a location that has been fired at before
        boolean expectedOutput = false;
        board.fireAtLocation(0, 0);
        boolean actualOutput = board.fireAtLocation(0, 0);
        System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        
    }
    
    /**
     * Tests BattleBoard.hasBeenHit() method
     */
    public void testHasBeenHit() {
        board = new BattleBoard();
        System.out.println("TestHasBeenHit");
        
        //Test to ensure a location that has never been fired at really hasn't
        //been fired at
        boolean expectedOutput = false;
        boolean actualOutput = board.hasBeenHit(0, 0);
        System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        
    }
    
    public void testHasBeenHit2() {
        board = new BattleBoard();
        System.out.println("TestHasBeenHit2");
        
        //Test to ensure a location that has been fired at really has
        //been fired at
        boolean expectedOutput = true;
        board.fireAtLocation(0,0);
        boolean actualOutput = board.hasBeenHit(0, 0);
        System.out.printf("Expected: %8s   Actual: %8s\n", expectedOutput, actualOutput);
        
    }
    
    /**
     * Tests BattleBoard.areAllShipsSunk() method
     */
    public void testAreAllShipsSunk() {
        board = new BattleBoard();
        System.out.println("testAreAllShipsSunk");
        
        //Test that the provided ship isn't sunk after being hit once
        board.addShip(2, true, 0, 0);
        board.fireAtLocation(0, 0);
        boolean expectedOutput = false;
        boolean actualOutput = board.areAllShipsSunk();
        System.out.printf("Expected: %8s   Actual: %8s\n\n", expectedOutput, actualOutput);
        
    }
    
     public void testAreAllShipsSunk2() {
        board = new BattleBoard();
        System.out.println("testAreAllShipsSunk2");
        
        //Test that the provided ship is sunk after being shot several times
        board.addShip(2, true, 0, 0);
        board.fireAtLocation(0, 0);
        board.fireAtLocation(0, 1);
        boolean expectedOutput = true;
        boolean actualOutput = board.areAllShipsSunk();
        System.out.printf("Expected: %8s   Actual: %8s\n\n", expectedOutput, actualOutput);
        
    }
    
    /**
     * Starts the BattleBoard automated white box test cases.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        BattleBoardTest test = new BattleBoardTest();
        test.testAddShip();
        test.testAddShip2();
        test.testGetNumberOfShips();
        test.testGetNumberOfShips2();
        test.testGetShips();
        test.testFireAtLocation();
        test.testFireAtLocation2();
        test.testHasBeenHit();
        test.testHasBeenHit2();
        test.testAreAllShipsSunk();
        test.testAreAllShipsSunk2();
    }
    
}
