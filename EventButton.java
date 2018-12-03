import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Generic button handling code, customized (slightly) for the battleship
 * application.
 * @author Matt Stallmann, 2007/11/15
 */

public class EventButton extends JButton implements MouseListener {
    private String title;
    private BattleGame game;
    private boolean horizontal;
    
    /** Constructor -- sets up the initial characteristics of the frame */
    public EventButton(String title, boolean horizontal, BattleGame game) {
        super( title );
        this.title = title;
        this.horizontal = horizontal;
        this.game = game;
        addMouseListener(this);
    }
    
    public void mousePressed(MouseEvent e) {
        System.out.printf("Button pressed (in Button class), horizontal = %b\n",
                          horizontal);
        game.buttonPress(horizontal);
    }
    
    public void mouseReleased(MouseEvent e) {
    }
    
    public void mouseClicked(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
}

//  [Last modified: 2010 04 13 at 23:59:40 GMT]
