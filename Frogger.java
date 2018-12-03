import objectdraw.*;
import java.awt.*;

// allows the user to play the game Frogger
public class Frogger extends WindowController {
    
    // Constants defining the sizes of the background components.
    private static final int HIGHWAY_LENGTH = 700;
    private static final int LANE_WIDTH = 100;
    private static final int NUM_LANES = 4;
    private static final int HIGHWAY_WIDTH = LANE_WIDTH * NUM_LANES;
    private static final int LINE_WIDTH = LANE_WIDTH / 10;
    
    // Constants defining the locations of the background components
    private static final int HIGHWAY_LEFT = 50;
    private static final int HIGHWAY_RIGHT = HIGHWAY_LEFT + HIGHWAY_LENGTH;
    private static final int HIGHWAY_TOP = 100;
    private static final int HIGHWAY_BOTTOM = HIGHWAY_TOP + HIGHWAY_WIDTH;
    private static final int LINE_SPACING = LINE_WIDTH / 2;
    
    private static final int DASH_LENGTH = LANE_WIDTH / 3;
    private static final int DASH_SPACING = DASH_LENGTH / 2;
    
    
    // The frog that tries to jump across the road.
    private Frog theFrog;
    
    // Arrays of car images
    private Image leftCars[] = new Image[10];
    private Image rightCars[] = new Image[10];
    
    // Remembers if the mouse is in the window.  Ignore mouse releases 
    // outside the window.
    private boolean inWindow = true;
    
    public void begin() {
        // fetch the car images
        for (int carNum = 0; carNum < 10; carNum++) {
            leftCars[carNum] = getImage("leftcar"+carNum+".gif");
            rightCars[carNum] = getImage("rightcar"+carNum+".gif");
        }
        
        // Draw the background
        FilledRect highway = new FilledRect (HIGHWAY_LEFT, HIGHWAY_TOP,
                                             HIGHWAY_LENGTH, HIGHWAY_WIDTH,
                                             canvas);
        
        new FilledRect( 0, 0, HIGHWAY_LEFT,
                        canvas.getHeight(),
                        canvas).setColor(Color.white);
        new FilledRect( HIGHWAY_LEFT+highway.getWidth(), 0,
                        canvas.getWidth()-highway.getWidth(),
                        canvas.getHeight(),
                        canvas).setColor(Color.white);
        drawLaneDividers();
        
        // Add the frog
        theFrog = new Frog (getImage ("froggy.gif"), 
                            (HIGHWAY_RIGHT - HIGHWAY_LEFT) / 2, HIGHWAY_BOTTOM,
                            LANE_WIDTH, canvas);
        
        // Get the cars moving
        int lane = 1;
        
        // Create the lanes
        while (lane <= NUM_LANES) {
            // Create the lane telling it where it is, which direction its
            // cars should go, what its cars should look like, and what the 
            // frog is.
            // The bottom half lanes go to the right
            if (lane > NUM_LANES / 2) {
                new Lane (HIGHWAY_TOP + (lane - 1) * LANE_WIDTH, 
                          HIGHWAY_LEFT, HIGHWAY_RIGHT, LANE_WIDTH, 
                          true, rightCars, theFrog, highway, canvas);
            }
            else {
                new Lane (HIGHWAY_TOP + (lane - 1) * LANE_WIDTH,
                          HIGHWAY_LEFT, HIGHWAY_RIGHT, LANE_WIDTH, 
                          false, leftCars, theFrog, highway, canvas);
            }
            
            
            lane = lane + 1;
        }
        
    }
    
    // Draw the lane dividers
    public void drawLaneDividers() {
        int whichLine = 1;
        while (whichLine < NUM_LANES) {
            if (whichLine == NUM_LANES / 2) {
                // The middle line is a no passing line
                drawNoPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - 
                                   (LINE_SPACING / 2 + LINE_WIDTH));
            }
            else {
                drawPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) - 
                                 (LINE_WIDTH / 2));
            }
            whichLine = whichLine + 1;
        }
    }
    
    
    // Draws a pair of solid yellow lines to represent a no passing divider 
    // between lanes
    // Parameter:  y - the top of the top line
    public void drawNoPassingLine (int y) {
        
        // Draw the solid dividing lines
        FilledRect topLine = new FilledRect (HIGHWAY_LEFT, y, HIGHWAY_LENGTH,
                                             LINE_WIDTH, canvas);
        topLine.setColor (Color.yellow);
        
        FilledRect bottomLine = new FilledRect (HIGHWAY_LEFT,
                                                y + LINE_WIDTH + LINE_SPACING, 
                                                HIGHWAY_LENGTH, LINE_WIDTH,
                                                canvas);
        bottomLine.setColor (Color.yellow);
    }
    
    // Draws a dashed white line to represent a passing line dividing two
    // lanes of traffic
    // Parameters:  y - the top of the line.
    public void drawPassingLine (int y) {
        
        FilledRect dash;  
        
        for (int x = HIGHWAY_LEFT; 
             x < HIGHWAY_RIGHT;
             x += DASH_LENGTH + DASH_SPACING
             ) {
            // Draw the next dash.
            dash = new FilledRect (x, y, DASH_LENGTH, LINE_WIDTH, canvas);
            dash.setColor (Color.white);
        }
        
    }
    
    // If the mouse is alive, tell the mouse which direction to move.
    // If the mouse is not alive, ignore mouse releases except for ones in
    // the starting area.  Ignore all mouse releases outside the window.
    public void onMousePress(Location point) {
        if (inWindow) {
            if (theFrog.isAlive ()) {
                theFrog.hopToward (point);
            }
            else if (point.getY() > HIGHWAY_BOTTOM) {
                theFrog.reincarnate();
            }
        }
    }
    
    // Remembers if the user enters the window so we can start paying
    // attention to mouse presses again.
    public void onMouseEnter(Location Location){
        inWindow = true;
    } 
    
    // Remembers if the user leaves the window so we can ignore mouse presses.
    public void onMouseExit(Location point){
        inWindow = false;
    }
    
}
