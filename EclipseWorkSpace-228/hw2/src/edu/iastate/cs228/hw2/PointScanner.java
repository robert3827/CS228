package edu.iastate.cs228.hw2;

import java.io.File;

/**
 * 
 * @author 
 *
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This class sorts all the points in an array of 2D points to determine a
 * reference point whose x and y coordinates are respectively the medians of the
 * x and y coordinates of the original points.
 * 
 * It records the employed sorting algorithm as well as the sorting time for
 * comparison.
 * @author Robert Holeman
 *
 */
public class PointScanner {
	private Point[] points;

	private Point medianCoordinatePoint; // point whose x and y coordinates are respectively the medians of
											// the x coordinates and y coordinates of those points in the array
											// points[].
	private Algorithm sortingAlgorithm;
	/**
	 * Holds the value of System.nanotime() which records the amount of time needed to execute the given algorithm.
	 */
	protected long scanTime; // execution time in nanoseconds.

	/**
	 * This constructor accepts an array of points and one of the four sorting
	 * algorithms as input. Copy the points into the array points[].
	 * 
	 * @param pts input array of points
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException {
		points = new Point[pts.length];
		sortingAlgorithm = algo;
		int i = 0;
		for (Point p : pts) {
			points[i] = p;
			i++;
		}
	}

	/**
	 * This constructor reads points from a file.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 * @throws InputMismatchException if the input file contains an odd number of
	 *                                integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException {
		sortingAlgorithm = algo;
		File file = new File(inputFileName);
		Scanner scan = new Scanner(file);
		// count the points
		int numCoords = 0;
		while (scan.hasNextInt()) {
			numCoords++;
			scan.next();
		}
		scan.close();
		if (numCoords % 2 == 1) {
			throw new InputMismatchException();

		} else {
			scan = new Scanner(file);
			Point p;
			int numPoints = numCoords / 2;
			points = new Point[numPoints];
			int x;
			int y;
			for (int i = 0; i < numPoints; i++) {

				x = scan.nextInt();
				y = scan.nextInt();
				p = new Point(x, y);
				points[i] = p;
//				System.out.println(p.toString());
			}
//			System.out.println("----END of Initial Print----");
			scan.close();
		}

	}

	/**
	 * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.     
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting.       
	 * 
	 */
	public void scan()
	{
		
		AbstractSorter aSorter; 
		int x;
		int y;
		
		// create an object to be referenced by aSorter according to sortingAlgorithm. for each of the two 
		// rounds of sorting, have aSorter do the following: 
		// 
		//     a) call setComparator() with an argument 0 or 1. 
		//
		//     b) call sort(). 		
		// 
		//     c) use a new Point object to store the coordinates of the medianCoordinatePoint
		//
		//     d) set the medianCoordinatePoint reference to the object with the correct coordinates.
		//
		//     e) sum up the times spent on the two sorting rounds and set the instance variable scanTime. 
		
		switch(sortingAlgorithm) {
		case SelectionSort: 
			aSorter = new SelectionSorter(points);
			
			break;
		case InsertionSort: aSorter = new InsertionSorter(points);
			
			break;
		case MergeSort: aSorter = new MergeSorter(points);
			
			break;
			//default is QS(quickSort) because sure
		default: aSorter = new QuickSorter(points);
			break;
			
		} 
		aSorter.setComparator(0);
		long startX = System.nanoTime();
		aSorter.sort();
		long stopX = System.nanoTime();
		x = aSorter.getMedian().getX();
		aSorter.setComparator(1);
		long startY = System.nanoTime();
		aSorter.sort();
		long stopY = System.nanoTime();
		y = aSorter.getMedian().getY();
		medianCoordinatePoint = new Point(x,y);
		scanTime = (stopX - startX ) + (stopY - startY);
		
		
	}

	/**
	 * Outputs performance statistics in the format:
	 * 
	 * <sorting algorithm> <size> <time>
	 * 
	 * For instance,
	 * 
	 * selection sort 1000 9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description.
	 */
	public String stats() {
		String s = "";
		s+= "" + who(sortingAlgorithm);
		s+= "		" + points.length;
		s+= "		"+ scanTime;
		return s;
		// TODO
	}

	/**
	 * Write MCP after a call to scan(), in the format "MCP: (x, y)" The x and y
	 * coordinates of the point are displayed on the same line with exactly one
	 * blank space in between.
	 */
	@Override
	public String toString() {
		String s = "MCP: ";
		s+= medianCoordinatePoint.toString();
		return s;
	}

	/**
	 * 
	 * This method, called after scanning, writes point data into a file by
	 * outputFileName. The format of data in the file is the same as printed out
	 * from toString(). The file can help you verify the full correctness of a
	 * sorting result and debug the underlying algorithm.
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeMCPToFile() throws FileNotFoundException {
		File file = new File("output.txt");
			try {
				file.createNewFile();
				FileWriter myWriter = new FileWriter("output.txt");
				myWriter.write(this.toString());
			    myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	     
	}
	private String who(Algorithm algo) {
		String s = "";
		switch(algo) {
		case SelectionSort: s = "Selection Sort";
		break;
		case InsertionSort: s = "Insertion Sort";
		break;
		case MergeSort: s = "Merge Sort";
		break;
		case QuickSort: s = "QuickSort";
		break;
		}
		return s;
	}

}
