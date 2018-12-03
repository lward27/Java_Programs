import objectdraw.*;
import java.awt.*;

// The frog that is trying to get across the highway.  It moves in the 
// direction of mouse clicks.  It is killed when a vehicle hits it and is 
// reincarnated when the user restarts.
public class Frog {

    // The location where the frog starts when trying to cross the highway.
    // We remember this so we can reincarnate the frog.
    private double startX;
    private double startY;
    
    // What the frog looks like
    private VisibleImage frogImage;
    
    // How far the frog hops
    private int hopDistance;
    
    // Message the frog displays when it is hit by a car
    private Text ouch;
    
    // Remembers if the frog is alive or not
    private boolean alive;
    
    // Known from examining the gif
    private static final int FROG_HEIGHT = 48;
    
    // Draws a frog
    // Parameters:
    //   frogPic - what the frog looks like
    //   highwayCenterX - where the frog should start
    //   highwayBottom - the lowest part of the highway
    //   laneWidth - how far across a lane, the frog can hop one lane at a time
    //   canvas - canvas to draw on
    public Frog(Image frogPic, int highwayCenterX, 
                int highwayBottom, int laneWidth, DrawingCanvas canvas ) {
        
        // Remember the starting location for reincarnation
        double frogSpacing = (laneWidth - FROG_HEIGHT) / 2;
        startX = highwayCenterX;
        startY = highwayBottom + frogSpacing;
        
        // Display the frog in the right place.
        frogImage = new VisibleImage (frogPic, startX, startY, canvas);
        
        // Remember how far the frog can hop.
        hopDistance = laneWidth;
        
        // Create the ouch text to display when the frog is killed.
        ouch = new Text ("OUCH!", startX, startY + 30, canvas);
        ouch.setFontSize (20);
        ouch.setColor (Color.red);
        ouch.hide();
        
        // The frog starts out alive.
        alive = true;
    }
    
    // Returns the image of the frog
    public VisibleImage getBody () {
        return frogImage;
    }
    
    // Displays the ouch text and causes the frog to not move until after it 
    // is reincarnated.
    //
    // Precondition:  The frog is alive
    public void kill () {
        ouch.show();
        alive = false;
    }
    
    // Brings the frog back to life.  Removes the ouch text and moves the 
    // frog back to the start
    //
    // Precondition:  the frog is not alive
    public void reincarnate() {
        ouch.hide();
        alive = true;
        frogImage.moveTo (startX, startY);
    }
    
    
    // Causes the frog to move one hop towards the point where the user
    // clicked.  Left/right moves are given preference over forward/back moves.
    //
    // Precondition:  The frog is alive.
    public void hopToward(Location point){
        if (point.getX() < frogImage.getX()) {
            frogImage.move (-hopDistance, 0);
        }
        else if (point.getX() > frogImage.getX() + frogImage.getWidth()) {
            frogImage.move (hopDistance, 0);
        }
        else if (point.getY() < frogImage.getY()) {
            frogImage.move (0, -hopDistance);
        }
        else if (point.getY() > frogImage.getY() + frogImage.getHeight()) {
            frogImage.move (0, hopDistance);
        }
        // Else clicked on the image.  Don't move.
    }
    
    // Returns true if the frog is alive.
    public boolean isAlive () {
        return alive;
    }
    
}
