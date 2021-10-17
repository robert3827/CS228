package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  Sorts the given array of points with the Quicksort method.
 * @author Robert Holeman
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 *
 */

public class QuickSorter extends AbstractSorter
{
	
	// Other private instance variables if you need ... 
		
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *   
	 * @param pts   input array of integers
	 */
	public QuickSorter(Point[] pts)
	{
		super(pts);
	}
		

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.  
	 * 
	 */
	@Override 
	public void sort()
	{
		quickSortRec(0, points.length-1); 
		
		for(int i=0;i<points.length;i++) {
		System.out.println(points[i].toString());
	}
	System.out.println("----END of Sort----");
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last. 
	 * 
	 * @param first  starting index of the subarray
	 * @param last   ending index of the subarray
	 */
	private void quickSortRec(int first, int last)
	{
		// TODO
		myQuickSortRec(points, first, last);
	}
	
	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last)
	{
			
		return 0; 
	}
	
	private void myQuickSortRec(Point[] pts, int first, int last) {
		if(first>=last) {//because you have 1 element
			return;
		}//else 
		int middle = myPartition(pts, first, last);//the pivot from previous partition
		myQuickSortRec(pts, first, middle);
		myQuickSortRec(pts, middle+1, last);
	}
	private int myPartition(Point[] pts, int first, int last) {
		//puts the pivot(which was at the end) into the middle
		//meaning anything smaller to the left anything bigger to the right
		Point pivot = pts[last];
		Point temp;
		int i=first-1;//this will be the counter at the end of the pivot
		for(int j=0;j<pts.length;j++) {//while something is less than
			//the pivot swap it to the front of the array
			if(pts[j].compareTo(pivot)<0) {
				i++;
				temp = pts[i];
				pts[i] = pts[j];
				pts[j] = temp; 
			}
		}
		temp = pts[i+1];
		pts[i+1] = pts[last];
		pts[last] = temp;
		return i;
	}
		


	
	// Other private methods if needed ...
}
