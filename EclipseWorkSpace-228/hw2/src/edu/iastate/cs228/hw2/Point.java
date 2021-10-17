 package edu.iastate.cs228.hw2;

/**
 *  Represents a point object. Also handles comparing two points with Comparable(compareTo) method.
 * @author Robert Holeman
 *
 */

public class Point implements Comparable<Point>
{
	private int x; 
	private int y;
	
	public static boolean xORy;  // compare x coordinates if xORy == true and y coordinates otherwise 
	                             // To set its value, use Point.xORy = true or false. 
	
	/**
	 * Creates a point at (0,0) by default.
	 */
	public Point()  // default constructor
	{
		// x and y get default value 0
	}
	/**
	 * Creates at the given point (x,y).
	 * @param x - x-coordinate
	 * @param y - y-coordinate
	 */
	public Point(int x, int y)
	{
		this.x = x;  
		this.y = y;   
	}
	/**
	 * Creates a copy of the given point P.
	 * @param p - point you want to copy.
	 */
	public Point(Point p) { // copy constructor
		x = p.getX();
		y = p.getY();
	}
	/**
	 * 
	 * @return the x-coordinate
	 */
	public int getX()   
	{
		return x;
	}
	/**
	 * 
	 * @return the y-coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/** 
	 * Set the value of the static instance variable xORy. 
	 * @param xORy - Set to true to sort by x-coordinate or false to sort by y-coordinate.
	 */
	public static void setXorY(boolean xORy)
	{
		Point.xORy = xORy;
	}
	
	
	@Override
	/**
	 * @return - true if the coordinates are equal.
	 */
	public boolean equals(Object obj)
	{
		if (obj == null || obj.getClass() != this.getClass())
		{
			return false;
		}
    
		Point other = (Point) obj;
		return x == other.x && y == other.y;   
	}

	/**
	 * Compare this point with a second point q depending on the value of the static variable xORy 
	 * @param 	q 
	 * @return  -1  if (xORy == true && (this.x < q.x || (this.x == q.x && this.y < q.y))) 
	 *                || (xORy == false && (this.y < q.y || (this.y == q.y && this.x < q.x)))
	 * 		    0   if this.x == q.x && this.y == q.y)  
	 * 			1	otherwise 
	 */
	public int compareTo(Point q)
	{
		if( (xORy == true && (this.x < q.x || (this.x == q.x&&this.y<q.y)))
				|| (xORy==false && (this.y <q.y || this.y==q.y&&this.x<q.x)) ) {
			return -1;
		} else if(this.x == q.x && this.y == q.y) {
			return 0;
		} else {
			return 1; 
		}
		 
	}
	
	
	/**
	 * Output a point in the standard form (x, y). 
	 * @return a point in the standard form (x, y).
	 */
	@Override
    public String toString() 
	{
		return "(" + this.x +", "+ this.y + ")"; 
	}
}
