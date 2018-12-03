import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The tricky part of this class is to realize that x-coordinates on the grid
 * translate to columns in the game and y-coordinates to rows.
 * @author Matt Stallmann, 2010/04/12, based on Suzanne Balik's idea of
 * having the BattleBoard be used to determine what is drawn on the panel.
 */

public class Grid extends JPanel implements MouseListener
{
    private static final int GRID_SQUARE_LENGTH = 50;
    /** to allow room for text labels when they are added */
    private static final int TEXT_SIZE = 10;
    private static final int CIRCLE_SIZE = 30;
    private static final Color SEA = new Color(108, 182, 255);
    
    private BattleBoard board;
    private GUI gui;
    private boolean visible;
    private int rows;
    private int columns;
    private int width;
    private int height;
    private int panelWidth;
    private int panelHeight;
    
    /**
     * Constructor: draws a game board and awaits mouse events
     * @param board the board that will be drawn each time
     * @param gui the GUI to which mouse events will be dispatched
     * @param visible true if all the ships should be shown, as is the case
     * with the human's board
     */
    public Grid( BattleBoard board, GUI gui, boolean visible )
    {
        this.board = board;
        this.gui = gui;
        this.visible = visible;
        this.rows = board.getNumberOfRows();
        this.columns = board.getNumberOfColumns();
        this.width = GRID_SQUARE_LENGTH * columns;
        this.height = GRID_SQUARE_LENGTH * rows;
        setSize( width, height );
        this.panelWidth = width + TEXT_SIZE;
        this.panelHeight = height + TEXT_SIZE;
        addMouseListener( this );
        repaint();
    }
    
    public int getPanelWidth() { return panelWidth; }
    public int getPanelHeight() { return panelHeight; }
    
    public void paint(Graphics g)
    {
        //    super.paintComponent(g);
        g.setColor( SEA );
        g.fillRect( 0, 0, width, height );
        drawGrid(g);
        drawHits(g);
        drawShips(g);
        drawShipHits(g);
    }
    
    public void drawGrid(Graphics g)
    {
        g.setColor(Color.black);
        // paint horizontal lines
        for(int i = 1; i < board.getNumberOfRows(); i++)
        {
            g.drawLine(0, i * GRID_SQUARE_LENGTH,
                       width, i * GRID_SQUARE_LENGTH);
        }
        // paint vertical lines
        for(int i = 1; i < board.getNumberOfColumns(); i++)
        {
            g.drawLine( i * GRID_SQUARE_LENGTH, 0,
                       i * GRID_SQUARE_LENGTH,
                       height);
        }
    }
    
    public void drawCircle(Graphics g, int row, int col) {
        int offset = (GRID_SQUARE_LENGTH - CIRCLE_SIZE) / 2;
        // Note: x coordinate -> column; y -> row
        g.fillOval( col * GRID_SQUARE_LENGTH + offset,
                   row * GRID_SQUARE_LENGTH + offset,
                   CIRCLE_SIZE, CIRCLE_SIZE );
    }
    
    public void drawHits(Graphics g) {
        g.setColor(Color.white);
        for ( int row = 0; row < board.getNumberOfRows(); row++ ) {
            for ( int col = 0; col < board.getNumberOfColumns(); col++ ) {
                if ( board.hasBeenHit( row, col ) ) {
                    drawCircle(g, row, col);
                }
            }
        }
    }
    
    public void drawShips(Graphics g) {
        g.setColor(Color.lightGray);
        Ship [] ships = board.getShips();
        for ( int i = 0; i < board.getNumberOfShips(); i++ ) {
            if ( ships[i] == null ) break;
            if ( ! visible && ! ships[i].isSunk() ) continue;
            // Note: x coordinate -> column; y -> row
            int upperLeftX = GRID_SQUARE_LENGTH * ships[i].getStartCol();
            int upperLeftY = GRID_SQUARE_LENGTH * ships[i].getStartRow();
            int width = GRID_SQUARE_LENGTH;
            if ( ships[i].isHorizontal() )
                width = GRID_SQUARE_LENGTH * ships[i].getLength();
            int height = GRID_SQUARE_LENGTH;
            if ( ! ships[i].isHorizontal() )
                height = GRID_SQUARE_LENGTH * ships[i].getLength();
            g.fillOval( upperLeftX, upperLeftY, width, height );
        }
    }
    
    public void drawShipHits(Graphics g) {
        g.setColor(Color.red);
        Ship [] ships = board.getShips();
        for ( int i = 0; i < board.getNumberOfShips(); i++ ) {
            if ( ships[i] == null ) break;
            int topRow = ships[i].getStartRow();
            int leftCol = ships[i].getStartCol();
            int length = ships[i].getLength();
            if ( ships[i].isHorizontal() ) {
                for ( int col = leftCol; col < leftCol + length; col++ ) {
                    if ( board.hasBeenHit(topRow, col) ) drawCircle( g, topRow, col );
                } 
            }
            else {
                for ( int row = topRow; row < topRow + length; row++ ) {
                    if ( board.hasBeenHit(row, leftCol) ) drawCircle( g, row, leftCol );
                } 
            }
        }
    }
    
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mousePressed(MouseEvent e)
    {
        System.out.printf("mouse press at (%d,%d)\n", e.getX(), e.getY() );
        int x = e.getX();
        int y = e.getY();
        // Note: x coordinate -> column; y -> row
        int row = y / GRID_SQUARE_LENGTH; 
        int column = x / GRID_SQUARE_LENGTH;
        gui.gridPress( this, row, column );
    }
    
}

//  [Last modified: 2010 04 14 at 14:43:57 GMT]
