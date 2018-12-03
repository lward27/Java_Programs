import objectdraw.*;
import java.awt.*;

// Vehicle defines the actions of a car driving on the highway.  
// Cars stay in a single lane and drive at a constant speed from one end to
// the other.  Along the way, they may kill the frog by running into it.
public class Vehicle extends ActiveObject {
    
    // Delay between car movements in milliseconds.
    private static final int DELAY = 30;
    
    // The image of the frog on the screen.
    private VisibleImage vehicleImage;
    
    // The speed that the vehicle goes in pixels/millisecond.  A positive 
    // speed results in the car going from left to right.  A negative speed 
    // results in the car going from right to left.
    private double speed;
    
    // The distance that the car has moved since it was created.  This is 
    // negative for cars moving from right to left.
    private double totalDistance = 0;
    
    // The location of the far end of the lane that the car is driving on.
    private double laneEnd;
    
    // The frog that the car might hit
    private Frog theFrog;
    
    
    // Construct a new car and start it moving across the screen.
    // Parameters:
    //    vehiclePic - the depiction of the vehicle to display
    //    speed - the speed of the vehicle in pixels/millisecond
    //    laneTop - the top of the lane that the vehicle should drive in
    //    laneLeft - the left edge of the lane
    //    laneRight - the right edge of the lane
    //    laneWidth - the width of the lane that the car drives in.  
    //                This is interpreted in the sense of the real world width.
    //                Since lanes go across the screen, the width is the 
    //                up-down distance
    //    frog - the frog that the car might hit
    //    canvas - the canvas to draw on
    public Vehicle(Image vehiclePic, double speed, int laneTop, int laneLeft,
                   int laneRight, int laneWidth, Frog frog, FilledRect highway,
                   DrawingCanvas canvas ) {
       
        // Remember the frog and speed for later.
        theFrog = frog;
        this.speed = speed;
        
        // Figure out which end is the starting and finishing end.  
        // Put the car on the starting end.
        if (speed > 0) {
            vehicleImage = new VisibleImage (vehiclePic, laneLeft, laneTop,
                                             canvas); 
            vehicleImage.move(-vehicleImage.getWidth(),0);
            this.laneEnd = laneRight + vehicleImage.getWidth();
        }
        else {
            vehicleImage = new VisibleImage (vehiclePic, laneRight, laneTop,
                                             canvas); 
            this.laneEnd = laneLeft  - vehicleImage.getWidth();;
            
        }
        
        // Center the vehicle in the lane
        vehicleImage.move (0, (laneWidth - vehicleImage.getHeight()) / 2);
        
        vehicleImage.sendToBack();
        highway.sendToBack();
        // Start the car moving.
        start();  
    }
    
    
    // Move the car across the screen in a straight line until it reaches 
    // the end.  Kill the frog if you hit it.
    public void run() {
        
        // The last time the car was moved.
        double lastTime = System.currentTimeMillis();
        
        // The distance we should move the car this time to get smooth 
        // motion at the desired speeed.
        double distance;
        
        // Loop until the active object is told to stop or the car reaches 
        // the end of the lane.
        while (true && !atLaneEnd ()) {
            // Compute how far the car should move for the amount of time 
            // it was paused and the speed it should appear to move at.
            double currentTime = System.currentTimeMillis();
            distance = (currentTime - lastTime) * speed; 
            
            // Move the car
            vehicleImage.move (distance, 0);
            totalDistance = totalDistance + distance;
            
            // See if it killed the frog
            if (theFrog.isAlive() && 
                vehicleImage.overlaps (theFrog.getBody())) {
                theFrog.kill();
            }
            
            // Remember the time for the next iteration and wait.
            lastTime = currentTime;
            pause (DELAY);
        }
        
        // The vehicle should disappear when it reaches the end or the 
        // applet is stopped.
        vehicleImage.removeFromCanvas();
    }
    
    // Returns true if the vehicle has reached the end of the lane that 
    // it is driving towards.
    public boolean atLaneEnd () {
        if (speed > 0) {
            return getRight() > laneEnd;
        }
        else {
            return getLeft() < laneEnd;
        }
    }
    
    // Returns the location of the left edge of the vehicle
    public double getLeft () {
        return vehicleImage.getX ();
    }
    
    // Returns the location of the right edge of the vehicle    
    public double getRight () {
        return vehicleImage.getX () + getLength();
    }
    
    // Returns the length of the vehicle from the front bumper of the car 
    // to the rear bumper.
    public double getLength () {
        return vehicleImage.getWidth();
    }
    
    // Return the total distance the vehicle has moved since it was created.
    public double distanceTraveled () {
        if (speed > 0) {
            return totalDistance;
        }
        else {
            return -totalDistance;
        }
    }
}
