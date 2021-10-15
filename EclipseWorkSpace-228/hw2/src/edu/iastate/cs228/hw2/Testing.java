package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * Testing methods for all the other classes
 * @author Robert
 *
 */
public class Testing {
	public static void main(String[] args) {
//		testSetXORY();
//		pointString();
//		testCompareTo();
//		testPointScanner();
//		howDoesTimeWork();
//		testInsertionSort();
		testMergeSort();
	}
	private static void pointString() {
		Point p = new Point(3,4);
		System.out.println(p.toString());
		
	}
	private static void testSetXORY() {
		Point p = new Point(3,4);
		System.out.println(Point.xORy);//starts as false
		Point.setXorY(true);
		System.out.println(Point.xORy);
		Point.setXorY(false);
		System.out.println(Point.xORy);
	}
	/*
	 * Testing Methods
	 */
	
	
	
	public static void testCompareTo() {
		Point p = new Point(3,4);
		Point.xORy = true;
		Point q;
		q = new Point(3,4);
		System.out.println(p.compareTo(q));//should return zero when same
		q = new Point(0,4);
		System.out.println(p.compareTo(q));//should return positive when p is greater
		q = new Point(4,4);
		System.out.println(p.compareTo(q));//should return negative when p is smaller

		p.xORy = false;
		q = new Point(3,4);
		System.out.println(p.compareTo(q));
		q = new Point(3,5);
		System.out.println(p.compareTo(q));
		q = new Point(3,2);
		System.out.println(p.compareTo(q));
		
		q = new Point(5,2);
		System.out.println(p.compareTo(q));
		

	}
	
	

	public static void testPointScanner() {
		try {
			PointScanner ps = new PointScanner("points.txt", Algorithm.SelectionSort);
			ps.scan();
			System.out.println(ps.stats());
			System.out.println(ps.toString());//SHould be (0,1)
			ps.writeMCPToFile();
			
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void howDoesTimeWork() {
		long startTime = System.nanoTime();
		for(int i=0;i<100000;i++) {
			if(i%1000==0) {
				System.err.println(System.nanoTime());
			}
		}
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
	}
	
	public static void testInsertionSort() {
		try {
			PointScanner ps = new PointScanner("points.txt", Algorithm.InsertionSort);
			ps.scan();
			System.out.println(ps.stats());
			System.out.println(ps.toString());//SHould be (0,1)
			ps.writeMCPToFile();
			
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testMergeSort() {
		try {
			PointScanner ps = new PointScanner("points.txt", Algorithm.MergeSort);
			ps.scan();
			System.out.println(ps.stats());
			System.out.println(ps.toString());//SHould be (0,1)
			ps.writeMCPToFile();
			
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
