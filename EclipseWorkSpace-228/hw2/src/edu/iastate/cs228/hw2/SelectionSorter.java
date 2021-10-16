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
 * This class implements selection sort.   
 *
 */

public class SelectionSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts  
	 */
	public SelectionSorter(Point[] pts)  
	{
		super(pts);
		
		
	}	

	
	/** 
	 * Apply selection sort on the array points[] of the parent class AbstractSorter.  
	 * 
	 */
	@Override 
	public void sort()
	{
		
		Point smallestAfter = points[0];//will hold the value of the new smallest point you've seen so far
		int smallestIndex = 0;//will hold the location/index of the smallest smallest
		
		for(int i=0;i<points.length;i++) {
			smallestAfter = points[i];
			smallestIndex = i;
			for(int j=i+1;j<points.length;j++) {
				if(points[j].compareTo(smallestAfter)<0) {//strictly less than to keep stability
					smallestAfter = points[j];
					smallestIndex = j;
				}
			}
			//now you've found the smallest
			points[smallestIndex] = points[i];
			points[i] = smallestAfter;
			
		}
//		for(int i=0;i<points.length;i++) {
//			System.out.println(points[i].toString());
//		}
//		System.out.println("----END of Sort----");
	}	
}
