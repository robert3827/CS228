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
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
		
		pts = Partition(pts, 0, pts.length);
		
		for(int i=0;i<points.length;i++) {
			System.out.println(points[i].toString());
		}
		System.out.println("----END of Sort----");
		
	}
	
	// Other private methods if needed ...
	private Point[] Partition(Point[] pts, int start, int end) {
		
		int mid = (start+end)/2;
		int lhsLen = mid - start;
		int rhsLen = end - mid;
		Point[] lhs = new Point[mid - start];
		Point[] rhs = new Point[rhsLen];
		if(pts.length>=1) {
			lhs[0] = pts[start];
			return lhs;
		}
			lhs = Partition(pts, start, mid);
			rhs = Partition(pts, mid+1, end);
			return Merge(lhs, rhs);
	
		
		
	}
	private Point[] Merge(Point[] lhs, Point[] rhs) {
		Point[] merged = new Point[lhs.length+rhs.length];
		int i=0;
		int j=0;
		int t=0;
		while(i<lhs.length&& j<rhs.length) {
			if(lhs[i].compareTo(rhs[j])<=0) {//to keep stability
				merged[t] = lhs[i];
				i++;
				t++;
			} else {
				merged[t] = rhs[j];
				j++;
				t++;
			}
		}
		if(i==lhs.length) {//lhs is already exhausted
			while(j<rhs.length) {
				merged[t] = rhs[j];
				j++;
			}
		} else {//rhs is already exhausted
			while(i<lhs.length) {
				merged[t] = lhs[i];
				i++;
			}
		}
		return merged;
	}
	
}
