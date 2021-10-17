package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;




/**
 * 
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 * @author Robert Holeman
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
	 * Public facing sort method. Carries out QuickSort on the array points[] of the AbstractSorter class.  
	 * 
	 */
	@Override 
	public void sort()
	{
		quickSortRec(0, points.length-1); 
		
//		for(int i=0;i<points.length;i++) {
//		System.out.println(points[i].toString());
//	}
//	System.out.println("----END of Sort----");
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
//	private int partition(int first, int last)
//	{
//			
//		return 0; 
//	}
	/**
	 * 
	 * @param pts - sub-array through which to sort
	 * @param first - where to start looking when sorting through the array
	 * @param last - where to stop looking when sorting through the array
	 */
	private void myQuickSortRec(Point[] pts, int first, int last) {
		if(first>=last) {//because you have 1 element
			return;
		}//else 
		int p = myPartition(pts, first, last);//the pivot from previous partition
		myQuickSortRec(pts, first, p-1);
		myQuickSortRec(pts, p+1, last);
	}
	/**
	 * 
	 * @param pts - sub-array through which to sort
	 * @param first - where the partition begins
	 * @param last - where the partition ends
	 * @return - index of the partition. Everything smaller than partition is to the left. Everything larger is to the right
	 */
	private int myPartition(Point[] pts, int first, int last) {
		//puts the pivot(which was at the end) into the middle
		//meaning anything smaller to the left anything bigger to the right
		Point pivot = pts[last];
		Point temp;
		int i=first-1;//this will be the counter at the end of the pivot
		for(int j=first;j<last;j++) {//while something is less than
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
		return i+1;
	}
		


	
	// Other private methods if needed ...
}
