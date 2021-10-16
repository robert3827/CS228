package edu.iastate.cs228.hw2;

import java.io.File;

/**
 * @author Robert Holeman
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random; 

/**
 * Holds the main methods for interacting with the sorting algorithms. This class will allow the user
 * to choose to randomly generate points or read them from a file. The points will then be sorted by
 * each algorithm and the times will be recorded for the user to compare them.
 * @author Robert Holeman
 *
 */
public class CompareSorters 
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{		
		Scanner scan = new Scanner(System.in);
		int seed = 0;//TODO
		Random rand = new Random(seed);
		Point[] points;
		
		// TODO 
		// 
		// Conducts multiple rounds of comparison of four sorting algorithms.  Within each round, 
		// set up scanning as follows: 
		// 
		//    a) If asked to scan random points, calls generateRandomPoints() to initialize an array 
		//       of random points. 
		// 
		//    b) Reassigns to the array scanners[] (declared below) the references to four new 
		//       PointScanner objects, which are created using four different values  
		//       of the Algorithm type:  SelectionSort, InsertionSort, MergeSort and QuickSort. 
		// 		
		// 
		int keys = 0;
		int trials = 0;
		String fileName;
		PointScanner[] scanners = new PointScanner[4];
		while(keys !=3) {
			System.out.println("Keys: 1 (random integers) 2 (file input) 3 (exit)");
			 keys = scan.nextInt();
			 trials+=1;
			
			if(keys == 3) {
				break;
			}
			if(keys == 1) {
				System.out.println("Trial " + trials);
				System.out.println("Enter number of random points: ");
				int numPoints = scan.nextInt();
				points = generateRandomPoints(numPoints, rand);
				initScannersPoints(scanners, points);
				scanThem(scanners);
				
				
			} else if(keys == 2) {
				System.out.println("Input file path: ");
				fileName = scan.next();
				initScannersFile(scanners, fileName);
				scanThem(scanners);
				
			}
		}
		
		
		// For each input of points, do the following. 
		// 
		//     a) Initialize the array scanners[].  
		//
		//     b) Iterate through the array scanners[], and have every scanner call the scan() 
		//        method in the PointScanner class.  
		//
		//     c) After all four scans are done for the input, print out the statistics table from
		//		  section 2.
		//
		// A sample scenario is given in Section 2 of the project description. 
		scan.close();
	}
	
	
	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] � [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{ 
		Point[] pts = new Point[numPts];
		if(numPts<1) {
			throw new IllegalArgumentException();
		} else {
			for(int i=0;i<numPts;i++) {
				int x = rand.nextInt(101)-50;
				int y = rand.nextInt(101)-50;
				Point p = new Point(x, y);
				pts[i] = p;
			}
		}
		return pts; 
	}
	private static void initScannersPoints(PointScanner[] scanners, Point[] pts) {
		scanners[0] = new PointScanner(pts, Algorithm.SelectionSort);
		scanners[1] = new PointScanner(pts, Algorithm.InsertionSort);
		scanners[2] = new PointScanner(pts, Algorithm.MergeSort);
		scanners[3] = new PointScanner(pts, Algorithm.SelectionSort);
	}
	private static void initScannersFile(PointScanner[] scanners, String file) throws InputMismatchException, FileNotFoundException {
		scanners[0] = new PointScanner(file, Algorithm.SelectionSort);
		scanners[1] = new PointScanner(file, Algorithm.InsertionSort);
		scanners[2] = new PointScanner(file, Algorithm.MergeSort);
		scanners[3] = new PointScanner(file, Algorithm.SelectionSort);
	}
	private static void scanThem(PointScanner[] scanners) {
		System.out.println("");//Empty Line
		System.out.println("algorithm		size		time(ns)");
		System.out.println("-----------------------------------------------------");
		for(int i=0;i<4;i++) {
			scanners[i].scan();
			System.out.println(scanners[i].stats());
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("");
	}
	
}
