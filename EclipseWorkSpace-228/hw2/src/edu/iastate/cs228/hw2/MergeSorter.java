package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 *  
 * @author Robert Holeman
 *
 */

/**
 * 
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if needed
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);  
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		mergeSortRec(points);
		//Print Stuff
			
			
			for(int i=0;i<points.length;i++) {
				System.out.println(points[i].toString());
			}
			System.out.println("----END of Sort----");
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts) {
		if(pts.length==1) {
			return;
		} else {
			int mid = pts.length/2;			
			merge(pts, 0, mid, pts.length);
			int i=pts.length+1;
		}
		
	}
	
	// Other private methods if needed ...
	
	/**
	 * 
	 * @param total - array to be split
	 * @param lhs - will hold the first half 
	 * @param rhs - will hold the second half
	 */
	private void putInto2Arrays(Point[] total, Point[] lhs, Point[] rhs) {
		int mid = total.length/2;
		int i;
		for(i=0;i<mid;i++) {
			lhs[i] = total[i];
		}
		int j = 0;
		while(j+i < total.length) {
			rhs[j] = total[j+i];
			j++;
		}
		
	}
	
	private void merge(Point[] pts, int i, int j, int k) {//Believe this works well
		
		int size = k-1+1;
		int mergedCursor = 0;
		int leftCursor = 0;
		int rightCursor = 0;
		Point[] merged = new Point[size];
		
		while(leftCursor<j&& rightCursor<k) {
			if(pts[leftCursor].compareTo(pts[rightCursor]) < 0) {//strictly less than to keep stability
				merged[mergedCursor] = pts[leftCursor];
				mergedCursor++;
				leftCursor++;
			} else {
				merged[mergedCursor] = pts[rightCursor];
				mergedCursor++;
				rightCursor++;
			}
		}
		while(leftCursor<j) {
			merged[mergedCursor] = pts[leftCursor];
			leftCursor++;
		}
		while(rightCursor<k) {
			merged[mergedCursor] = pts[rightCursor];
			rightCursor++;
		}
			
		for(int z = 0; z<merged.length;z++) {
			pts[z] = merged[z];
		}
	}
	
}
