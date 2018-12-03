package edu.ncsu.csc.csc216.rectangles;
import java.awt.Point;

/**
 * Stores information about a Rectangle object
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 */
public class Rectangle {
	
	/** x value of upper left corner */
	private int x;
	/** y value of upper left corner */
	private int y;
	/** Rectangle width */
	private int width;
	/** Rectangle height */
	private int height;
	
	/**
	 * Creates a rectangle with the given parameters
	 * @param x value of upper left corner on x-axis
	 * @param y value of upper left corner on y-axis
	 * @param width rectangle width
	 * @param height rectangle height
	 */
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a rectangle with the given parameters 
	 * @param p Point of upper left corner
	 * @param width rectangle width
	 * @param height rectangle height
	 */
	public Rectangle(Point p, int width, int height) {
		this(p.x, p.y, width, height);
	}

	/**
	 * Returns the x value of the upper left corner
	 * @return the x value of the upper left corner
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y value of the upper left corner
	 * @return the y value of the upper left corner
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns the width of the rectangle
	 * @return the width of the rectangle
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of the rectangle
	 * @return the height of the rectangle
	 */
	public int getHeight() {
		return height;
	}

	/** 
	 * Returns true if the rectangle contains the 
	 * specified point.  The rectangle contains the point
	 * if the point is inside the rectangle or on the line
	 * that makes up the rectangle's boundaries.
	 * @param x coordinate on x-axis
	 * @param y coordinate on y-axis
	 * @return true if the rectangle contains the point
	 */
	public boolean contains(int x, int y) {
		return  x >= this.x &&
				x <= this.x + width &&
				y >= this.y &&
				y <= this.y + height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Rectangle))
			return false;
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + ", x=" + x
				+ ", y=" + y + "]";
	}
}
