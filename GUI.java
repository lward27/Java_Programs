import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame
{
    private static final int LOCATION_X = 100;
    private static final int LOCATION_Y = 100;
    
    private static final int PADDING = 20;
    private static final int LABEL_HEIGHT = 30;
    private static final int BUTTON_HEIGHT = 30;
    private static final Font DEFAULT_FONT = new Font("Arial", 1, 20);
    
    private BattleGame game;
    private JPanel humanGrid;
    private JPanel computerGrid;
    private JButton hButton;
    private JButton vButton;
    private JLabel message;
    
    public GUI( BattleGame game, BattleBoard humanBoard,
               BattleBoard computerBoard )
    {
        this.game = game;
        setLocation( LOCATION_X, LOCATION_Y );
        // ships are visible on the human grid but not on the computer grid
        // (last argument)
        humanGrid = new Grid( humanBoard, this, true );
        computerGrid = new Grid( computerBoard, this, false );
        int guiWidth = humanGrid.getWidth() + computerGrid.getWidth() + PADDING;
        int guiHeight = humanGrid.getHeight() + 3 * LABEL_HEIGHT + BUTTON_HEIGHT; 
        setSize( guiWidth, guiHeight );
        setTitle( "Battleship Game" );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout( new BorderLayout() );
        
        // add a message field centered below the game
        JPanel gamePanel = new JPanel( new GridLayout(1, 2) );
        add(gamePanel, BorderLayout.CENTER);
        message = new JLabel( "Game begins", JLabel.CENTER );
        message.setFont( DEFAULT_FONT );
        add(message, BorderLayout.SOUTH);
        
        // add human and computer panels to the game; the human panel has a
        // title, grid, and buttons; the computer panel has only a title and a
        // grid
        JPanel human = new JPanel();
        human.setLayout(new BoxLayout(human, BoxLayout.Y_AXIS));
        JPanel computer = new JPanel();
        computer.setLayout(new BoxLayout(computer, BoxLayout.Y_AXIS));
        gamePanel.add( human );
        gamePanel.add( computer );
        
        // add three parts to the human panel
        JLabel humanLabel = new JLabel( "Human", JLabel.CENTER );
        humanLabel.setFont( DEFAULT_FONT );
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        human.add( humanLabel );
        human.add( humanGrid );
        human.add( buttonPanel );
        
        // Set up the buttons
        EventButton hButton = new EventButton("Horizontal", true, game);
        hButton.setFont( DEFAULT_FONT );
        EventButton vButton = new EventButton("Vertical", false, game);
        vButton.setFont( DEFAULT_FONT );
        buttonPanel.add( hButton );
        buttonPanel.add( vButton );
        
        // Add two parts to the computer panel
        JLabel computerLabel = new JLabel( "Computer", JLabel.CENTER );
        computerLabel.setFont( DEFAULT_FONT );
        buttonPanel = new JPanel( new GridLayout(1, 2) );
        computer.add( computerLabel );
        computer.add( computerGrid );
        
        setVisible(true);
        repaint();
    }
    
    public void gridPress( JPanel grid, int row, int column ) {
        System.out.printf("grid press at (%d,%d)\n",row, column );
        if ( grid == humanGrid ) game.humanGridPress( row, column );
        else game.computerGridPress( row, column );
    }
    
    public void putMessage( String message ) {
        this.message.setText( message );
    }
}

//  [Last modified: 2010 04 14 at 14:40:43 GMT]
