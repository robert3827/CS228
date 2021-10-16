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
		if(first>=last) {//can't do that
			return;
		} else {
			int p = myPartition(points, first, last);
			myQuickSortRec(points, first, p-1);
			myQuickSortRec(points, p+1, last);
		}
	}
	private void myQuickSortRec(Point[] pts, int first, int last) {//TODO
		Point pivot = pts[last];
		Point temp;
		int i = first-1;
		for(int j=first;j<last;j++) {
			if(pts[j].compareTo(pivot)<0) {
				i++;
				temp = pts[i];
				pts[i] = pts[j];
				pts[j] = temp;
			}
			temp = pts[i+1];
			pts[i+1] = pts[last];
			pts[last] = pts[last];
		}
	}
	private int myPartition(Point[] pts, int first, int last) {
		
		
		return 0;//TODO
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
		// TODO 
		return 0; 
	}	
		


	
	// Other private methods if needed ...
}
