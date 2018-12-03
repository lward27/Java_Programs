import java.util.*;

/**
 * The main engine for playing the battleship game. Interacts with two
 * boards, the corresponding displays, and a GUI
 * @author Matt Stallmann, based on Dan Longo's code 2010/04/12
 */
public class BattleGame {
    public static final int ROWS = 8;
    public static final int COLS = 8;
    public static final int NUMBER_OF_SHIPS = 4;
    public static final int [] SHIP_LENGTHS = { 1, 2, 3, 4 };
    public static final String [] SHIP_NAMES =
    {
        "submarine",
        "destroyer",
        "cruiser",
        "battleship"
    };
    
    private BattleBoard humanBoard;
    private BattleBoard computerBoard;
    private BattleAI ai;
    private GUI gui;
    
    private boolean donePlacingShips = false;
    private boolean horizontal = true;
    private int shipIndex = 0;
    
    private boolean finished = false;
    
    /**
     * Constructor - sets up
     *  - boards for human and computer
     *  - panels for displaying these boards
     *  - an AI program for the computer
     *  - the GUI
     * @param seed the random seed that is used for the computer's AI; if it's
     * 0, the random sequence is unpredictable and not repeatable.
     */
    public BattleGame( long seed ) {
        humanBoard = new BattleBoard();
        computerBoard = new BattleBoard();
        // GUI needs to know where to dispatch messages
        gui = new GUI( this, humanBoard, computerBoard );
        ai = new BattleAI( /*this,*/ computerBoard, seed );
        gui.putMessage( "Put " + SHIP_NAMES[0]
                           + ", length = " + SHIP_LENGTHS[0] );
    }
    
    /**
     * @return number of rows of the game board
     */
    int getNumberOfRows() { return ROWS; }
    
    /**
     * @return number of columns of the game board
     */
    int getNumberOfColumns() { return COLS; }
    
    /**
     * @return the number of ships used in the game
     */
    public int getNumberOfShips() { return NUMBER_OF_SHIPS; } 
    
    /**
     * @return the length of the i-th ship
     */
    public int getShipLength( int i ) {
        return SHIP_LENGTHS[i];
    }
    
    /**
     * Reacts to a mousePress in a grid square of the human player's grid 
     * @param row the row of the grid in which the mouse was pressed
     * @param column the column of the grid in which the mouse was pressed
     */
    public void humanGridPress( int row, int column ) {
        System.out.printf("-> humanGridPress (%d,%d) horizontal = %b\n",
                          row, column, horizontal);
        if ( ! donePlacingShips ) {
            if ( ! humanBoard.addShip( SHIP_LENGTHS[shipIndex],
                                      horizontal, row, column ) ) {
                gui.putMessage( "No room: try again with "
                                   + SHIP_NAMES[shipIndex] );
            }
            else {
                moveOnToNextShip();
            }
            gui.repaint();
        }
    }
    
    /**
     * Reacts to a mousePress in a grid square of the computer's grid 
     * @param row the row of the grid in which the mouse was pressed
     * @param column the column of the grid in which the mouse was pressed
     */
    public void computerGridPress( int row, int column ) {
        System.out.printf("-> computerGridPress (%d,%d)\n", row, column);
        if ( donePlacingShips && ! finished ) {
            if ( ! computerBoard.fireAtLocation( row, column ) ) {
                gui.putMessage( "Square already hit -- try again" );
                return;
            }
            else {
                checkResults( computerBoard );
            }
            if ( ! finished ) { 
                computerTurn();
            }
            if ( ! finished ) {
                gui.putMessage("Your turn. Fire again.");
            }
            gui.repaint();
        }
    }
    
    /**
     * A ship has been successfully placed -- moves on to the next one
     */
    public void moveOnToNextShip() {
        System.out.printf("moveOnToNextShip, shipIndex = %d, done = %b" +
                          ", num_ships = %d\n",
                          shipIndex, donePlacingShips,
                          humanBoard.getNumberOfShips());
        shipIndex++;
        if ( shipIndex < NUMBER_OF_SHIPS ) {
            gui.putMessage( "Put " + SHIP_NAMES[shipIndex]
                               + ", length = " + SHIP_LENGTHS[shipIndex] );
            System.out.println( "Put " + SHIP_NAMES[shipIndex]
                                   + ", length = " + SHIP_LENGTHS[shipIndex] );
        }
        else {
            donePlacingShips = true;
            gui.putMessage("Done placing ships. Firing begins"
                               + " (computer fired first).");
            // computer fires first
            computerTurn();
        }
        gui.repaint();
    }
    
    /**
     * Reacts to the pressing one of the two buttons (horizontal or vertical)
     */
    public void buttonPress(boolean horizontal) {
        System.out.printf("-> buttonPress(%b)\n", horizontal);
        this.horizontal = horizontal;
    }
    
    /**
     * Checks the results of firing at a position and lets the GUI know if
     * either party has won
     */
    public void checkResults( BattleBoard board ) {
        if ( board.areAllShipsSunk() ) {
            if ( board == computerBoard ) {
                gui.putMessage( "Human Wins!" );
            }
            else {
                gui.putMessage( "Computer Wins!" );
            }
            finished = true;
        }
    }
    
    /**
     * Computer takes a turn.
     */
    public void computerTurn() {
        ai.fireAtHumanBoard( humanBoard );
        checkResults( humanBoard );
    }
    
    /**
     * Prints a message about how the program should be used
     */
    public static void usageMessage() {
        System.out.println( "Usage: java BattleGame seed" );
        System.out.println( " where seed is an integer that determines the"
                               + " start of the random sequence" );
        System.out.println( " if seed = 0, 'true' randomness is used" );
    }
    
    /**
     * Cranks up the game. The rest is driven by mouse events.
     */
    public static void main( String args[] ) {
        if ( args.length != 1 ) {
            usageMessage();
            System.exit(1);
        }
        int seed = Integer.parseInt( args[0] );
        BattleGame bg = new BattleGame( seed );
    }
} // end class

//  [Last modified: 2010 04 19 at 20:23:15 GMT]
