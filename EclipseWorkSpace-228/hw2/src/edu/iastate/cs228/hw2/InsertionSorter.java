package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements insertion sort.   
 *
 */

public class InsertionSorter extends AbstractSorter 
{
	// Other private instance variables if you need ... 
	
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 * 
	 * @param pts  
	 */
	public InsertionSorter(Point[] pts) 
	{
		super(pts);
	}	

	
	/** 
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.  
	 */
	@Override 
	public void sort()
	{
		Point smallestAfter;//will hold the value of the new smallest point you've seen so far
		int smallestIndex;//will hold the location/index of the smallest smallest
		Point temp;
		Point nextElement;
		for(int i=0;i<points.length;i++) {//for each element
			smallestAfter = points[i];
			smallestIndex = i;
			for(int j=i+1;j<points.length;j++) {//you take the smallest element after it, insert it wherever it belongs, slide everything else to the right
					if(points[j].compareTo(smallestAfter) <0) {
						smallestAfter = points[j];
						smallestIndex = j;
					}
				}
			//now I've found the smallest
			temp = points[i];
			points[i] = smallestAfter;//inserts the element into the correct place in the array
			//now I need to slide all elements to the right
			for(int k=i+1;k<=smallestIndex;k++) {//you will slide each element to the right until you hit the spot you just emptied
				nextElement = points[k];
				points[k] = temp;
				temp = nextElement;
			}
		}
		for(int i=0;i<points.length;i++) {
			System.out.println(points[i].toString());
		}
		System.out.println("----END of Sort----");
	}		
}
