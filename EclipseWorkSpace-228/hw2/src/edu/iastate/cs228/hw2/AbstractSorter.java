package edu.iastate.cs228.hw2;

/**
 *  Abstract super class for all the sorting algorithms. This class stores one array to be sorted.
 * @author Robert Holeman
 *
 */

import java.util.Comparator;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 * 
 * This abstract class is extended by SelectionSort, InsertionSort, MergeSort, and QuickSort.
 * It stores the input (later the sorted) sequence. 
 *	@author Robert Holeman
 */
public abstract class AbstractSorter
{
	
	protected Point[] points;    // array of points operated on by a sorting algorithm. 
	                             // stores ordered points after a call to sort(). 
	
	protected String algorithm = null; // "selection sort", "insertion sort", "mergesort", or
	                                   // "quicksort". Initialized by a subclass constructor.
		 
	protected Comparator<Point> pointComparator = null;  
	
	class PointComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			//TODO - is this supposed to be used anywhere?????
			//Should be the same as
			//return o1-o2 with Respect to X or Y; or just the Value of compare to. 
			return o1.compareTo(o2);
		}
		
	}
	
	// Add other protected or private instance variables you may need. 
	
	

//	protected AbstractSorter()
//	{
//		// No implementation needed. Provides a default super constructor to subclasses. 
//		// Removable after implementing SelectionSorter, InsertionSorter, MergeSorter, and QuickSorter.
//	}
	
	
	/**
	 * This constructor accepts an array of points as input. Copy the points into the array points[]. 
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	protected AbstractSorter(Point[] pts) throws IllegalArgumentException
	{
		if(pts == null ||pts.length ==0) {
			throw new IllegalArgumentException();
		} else {//else not technically necessary
			points = new Point[pts.length];
			int i=0;
			for(Point p:pts) {
				points[i] = p;
				i++;
			}
			
		}
	}
		
	
	
	

	/**
	 * Generates a comparator on the fly that compares by x-coordinate if order == 0, by y-coordinate
	 * if order == 1. Assign the 
     * comparator to the variable pointComparator. 
     *  
	 * 
	 * @param order  0   by x-coordinate 
	 * 				 1   by y-coordinate
	 * 			    
	 * 
	 * @throws IllegalArgumentException if order is less than 0 or greater than 1
	 *        
	 */
	public void setComparator(int order) throws IllegalArgumentException//TODO what do I need to do with this?????????
	{
		
		boolean compByY = false;
		boolean compByX = true;
		// TODO 
		if(order<0 || order>1) {
			throw new IllegalArgumentException();
		} else {
			if(order ==0) {
				Point.setXorY(compByX);
			} else {//order is 1
				Point.setXorY(compByY);
			}
		}
	}

	

	/**
	 * Use the created pointComparator to conduct sorting.  
	 * 
	 * Should be protected. Made public for testing. 
	 */
	public abstract void sort(); 
	
	
	/**
	 * Obtain the point in the array points[] that has median index 
	 * 
	 * @return	median point 
	 */
	public Point getMedian()
	{
		return points[points.length/2]; 
	}
	
	
	/**
	 * Copys the array points[] onto the array pts[]. 
	 * 
	 * @param pts
	 */
	public void getPoints(Point[] pts)
	{
		int i=0;
		for(Point p: points) {
			pts[i] = p;
			i++;
		}
	}
	

	/**
	 * Swaps the two elements indexed at i and j respectively in the array points[]. 
	 * 
	 * @param i
	 * @param j
	 */
	protected void swap(int i, int j)
	{
		Point temp = points[j];
		points[j] = points[i];
		points[i] = temp;
	}	
}
