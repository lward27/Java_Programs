import java.util.*;

/**
 * A very stupid computer strategy, everything random. In order to make this
 * smarter, you would need a BattleBoard method that lets the computer know
 * whether the most recent firing hit a ship and/or some information about
 * the progress of the game.
 */

public class BattleAI {
    
    private BattleBoard computerBoard;
    private Random r;
    
    /**
     * Constructor
     * initializes instance variables, sets up the random number sequence and
     * places the ships
     * @param game the current game (not implemented); needed to allow computer
     * to fire in an intelligent fashion; this would also require the game to
     * implement a method that allows the computer to determine whether a ship
     * has been hit
     * @param computerBoard the computer's game board; used for placing the ships
     * @param seed the random number seed; not used if seed = 0
     */
    public BattleAI(/*BattleGame game,*/ BattleBoard computerBoard, long seed) {
        this.computerBoard = computerBoard;
        if ( seed == 0 ) r = new Random();
        else r = new Random( seed );
        setUpShips();
        //System.out.println(computerBoard); 
    }
    
    /** sets up ships in a random fashion */
    private void setUpShips() {
        for (int i = 0; i < BattleGame.NUMBER_OF_SHIPS; i++) {
            boolean successful = false;
            while(!successful) {
                int orientation = r.nextInt(2);
                boolean horizontal = true;
                if (orientation == 1) {
                    horizontal = false;
                }
                int row = r.nextInt(computerBoard.getNumberOfRows());
                int col = r.nextInt(computerBoard.getNumberOfColumns());
                if (computerBoard.addShip(BattleGame.SHIP_LENGTHS[i], horizontal, 
                                          row, col)) {
                    successful = true;
                }
            }
        }
    }
    
    /** Chooses a random position for firing at the board of the human player */
    public void fireAtHumanBoard(BattleBoard humanBoard) {
        boolean successful = false;
        while (!successful) {
            int row = r.nextInt(computerBoard.getNumberOfRows());
            int col = r.nextInt(computerBoard.getNumberOfColumns());
            if (!humanBoard.hasBeenHit(row, col)) {
                humanBoard.fireAtLocation(row, col);
                successful = true;
            }
        }
    }
    
    public static void main(String[] args) {
        BattleBoard computerBoard = new BattleBoard();
        BattleBoard humanBoard = new BattleBoard();
        BattleAI ai = new BattleAI(/*new BattleGame(),*/ computerBoard,1);
        System.out.println("\nComputer Board\n" + computerBoard);
        
        for (int i = 0; i < 5; i++) {
            ai.fireAtHumanBoard(humanBoard);
        }
        System.out.println("\nHuman Board\n" + humanBoard);
    }
}





//  [Last modified: 2010 04 15 at 17:13:00 GMT]
