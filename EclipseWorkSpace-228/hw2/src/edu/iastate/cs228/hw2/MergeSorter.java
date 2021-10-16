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
			
			
//			for(int i=0;i<points.length;i++) {
//				System.out.println(points[i].toString());
//			}
//			System.out.println("----END of Sort----");
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
			Point[] lhs = new Point[mid];
			Point[] rhs = new Point[pts.length - mid];
			putInto2Arrays(pts, lhs, rhs);
			mergeSortRec(lhs);
			mergeSortRec(rhs);
			merge(pts, lhs, rhs);
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
	
	private void merge(Point[] total, Point[] lhs, Point[] rhs) {//Believe this works well
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
				t++;
			}
		} else {//rhs is already exhausted
			while(i<lhs.length) {
				merged[t] = lhs[i];
				i++;
				t++;
			}
		}
		for(int z=0;z<merged.length;z++) {
			total[z] = merged[z];
		}
	}
	
}
