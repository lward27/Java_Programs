/*
 * AsteroidsDriver.java
 *
 * Created on September 16, 2001, 7:25 PM
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author  Chris Schmidt
 * @version 
 */
public class AsteroidsDriver {

    /** Creates new AsteroidsDriver */
    public AsteroidsDriver() {
    }

    public static void main(java.lang.String[] args) {
        // Read in input from the user until a null is passed in.
        String line = " ";
        // Used to read in from standard input
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // Size of the 'galaxy'AsteroidsDriver
        int size;
        // The galaxy object itself
        Galaxy galaxy;
        // Starting coordinate vars
        String sStart;
        // Ending coordinate vars
        String sEnd;
        // Ship
        Ship ship;
        
        int loop, loop2;
        int distance;
        
        while(line != null) {
            try {
                line = buf.readLine();
                if (line != null) {
                    // This line should be 'START x'                    
                    size = new Integer(line.substring(6,line.length())).intValue();
                    // Create the galaxy the user will venture through
                    galaxy = new Galaxy(size);
                    // Step through the input to build the asteroid information
                    for (loop = 0; loop < size; loop++) {
                        for (loop2 = 0; loop2 < size; loop2++) {
                            line = buf.readLine();
                            galaxy.addLine(loop,loop2,line);
                        }
                    }
                    // Get the starting coordinate
                    sStart = buf.readLine();
                    // Get the ending coordinate
                    sEnd = buf.readLine();
                    // Get the END modifier
                    line = buf.readLine();   
                    
                    ship = new Ship(galaxy,size,sStart,sEnd);
                    distance = ship.findDistance(0);
                    
                    if (distance > -1) {
                        System.out.println(size + " " + distance);
                    } else {
                        System.out.println("NO ROUTE");
                    }
                }
            } catch (IOException ioerr) {
                // Fatal Error caught, print the stack trace and exit
                ioerr.printStackTrace();
                line = null;
            } catch (NumberFormatException numerr) {
                // Oops, didn't parse the size out properly probably
                numerr.printStackTrace();
            }
        }
    }
}

/** 
 * @Author Chris Schmidt
 * Holds information on the 'universe' 
 */
class Galaxy {
    // Galaxy represented as a boolean
    // - true means an asteroid is present
    // - false means clear space
    private boolean space[][][];
    private int size;
    
    /** Create a new Galaxy object */
    public Galaxy(int size) {
        // size is how big the 'galaxy' will be 1 ... 10
        space = new boolean[size][size][size];
        this.size = size;
    }
    
    /** Adds a line of the galaxy
     *  The galaxy is a cube, where <0,0,0> is the farthest to the
     *  left point away from the 'viewer' 
     */
    public void addLine(int z, int y, String sRow) {
        int loop;
        for (loop = 0; loop < sRow.length(); loop++) {
            if (sRow.substring(loop,loop+1).compareTo("X") == 0) {
                // This is an asteroid
                space[loop][y][z] = true;
            } else {
                space[loop][y][z] = false;
            }   
        }
    }
    
    /** Returns true if a particular point has an asteroid in it */
    public boolean hasAsteroid(int x, int y, int z) {
        if (x >= size || y >= size || z >= size) {
            return false;
        } else {
            return space[x][y][z];
        }
    }
}

/** Object that holds a 'ships' information for moving through the space.
 *  It contains the ships' vector coordinate and and point, determining if it is
 *  possible to get to the end point through the asteroid field
 */
class Ship {
    // Starting Coordinates:
    private int startX, startY, startZ;
    // Ending Coordinates:
    private int endX, endY, endZ;
    // Holder for the galaxy information to determine the path
    private Galaxy galaxy;
    // Our own internal array to know where we have been
    int paths[][][];
    int size;
    
    // Constructor
    public Ship(Galaxy galaxy, int size, String sStart, String sEnd) { 
        int loop,loop2,loop3;
        
        this.galaxy = galaxy;
        this.startX = new Integer(sStart.substring(0,1)).intValue();
        this.startY = new Integer(sStart.substring(2,3)).intValue();
        this.startZ = new Integer(sStart.substring(4,5)).intValue();
        this.endX = new Integer(sEnd.substring(0,1)).intValue();
        this.endY = new Integer(sEnd.substring(2,3)).intValue();
        this.endZ = new Integer(sEnd.substring(4,5)).intValue();
        this.size = size;
        paths = new int[size][size][size];
        
        for (loop = 0; loop < size; loop++) {
            for (loop2 = 0; loop2 < size; loop2++) {
                for (loop3 = 0; loop3 < size; loop3++) {
                    paths[loop][loop2][loop3] = 32768;
                }
            }
        }
    }
    
    // Method to find the distance to the ending point
    public int findDistance(int depth) {
        // Determine if the starting point is the ending point
        if (startX == endX && startY == endY && startZ == endZ) {
            return depth; // Should be 0
        }
        else {
            return findDistance(startX,startY,startZ,depth);
        }
        
    }
    
    public int findDistance(int x, int y, int z, int depth) {
        int distance;
        int finalDist = 32768;
        
        // Set this point to visited
        paths[x][y][z] = depth;
        // Check to see if this position is the ending point
        if (x == endX && y == endY && z == endZ) {
            return depth;
        } else {
            // Try each position that hasn't been moved to yet
            // Try each point that can be accessed from this point
            // - "UP" one (Z - 1)
            if ((z - 1) > -1 && !galaxy.hasAsteroid(x,y,z-1) && (depth + 1) < paths[x][y][z-1]) {
                distance = findDistance(x,y,z-1,depth+1);
                if (distance != -1 && distance < finalDist) {
                    finalDist = distance;
                }
            }
           // - "DOWN" one (Z + 1)
            if ((z + 1) < size && !galaxy.hasAsteroid(x,y,z+1) && (depth + 1) < paths[x][y][z+1]) {
                distance = findDistance(x,y,z+1,depth+1);
                if (distance != -1 && distance < finalDist) {
                    finalDist = distance;
                }
            }
           // - "FORWARD" one (Y + 1)
            if ((y + 1) < size && !galaxy.hasAsteroid(x,y+1,z) && (depth + 1) < paths[x][y+1][z]) {
                distance = findDistance(x,y+1,z,depth+1);
                if (distance != -1 && distance < finalDist) {
                    finalDist = distance;
                }
            }
           // - "BACK" one (Y - 1)
            if ((y - 1) > -1 && !galaxy.hasAsteroid(x,y-1,z) && (depth + 1) < paths[x][y-1][z]) {
                distance = findDistance(x,y-1,z,depth+1);
                if (distance != -1 && distance < finalDist) {
                    finalDist = distance;
                }
            }
           // - "RIGHT" one (X + 1)
            if ((x + 1) < size && !galaxy.hasAsteroid(x+1,y,z) && (depth + 1) < paths[x+1][y][z]) {
                distance = findDistance(x+1,y,z,depth+1);
                if (distance != -1 && distance < finalDist) {
                    finalDist = distance;
                }
            }
            // - "LEFT" one (X - 1)
            if ((x - 1) > -1 && !galaxy.hasAsteroid(x-1,y,z) && (depth + 1) < paths[x-1][y][z]) {
                distance = findDistance(x-1,y,z,depth+1);
                if (distance != -1 && distance < finalDist) {
                    finalDist = distance;
                }
            }            
        }
        
        // We may have the shortest path distance, or not (if finalDist is 32768)
        if (finalDist == 32768) {
            finalDist = -1;            
        }
        return finalDist;
    }
}
