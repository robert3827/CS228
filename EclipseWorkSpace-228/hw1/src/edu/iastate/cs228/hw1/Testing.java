package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Testing {
	
	public static void main(String[] args) {
		testLengthAndWidth();
		testPrintArray();
		testFileRead();
		
		
	}
	public static void testLengthAndWidth() {
		Town town = new Town(6, 9);
		int width = town.getWidth();
		int length = town.getLength();
		System.out.println("Length:" + length +" Width:"+ width);
	}
	public static void testPrintArray() {
		Town town = new Town(2, 2);
		TownCell cell = new Empty(town, 0, 0);
		town.grid[0][0] = cell;

		TownCell cell1 = new Streamer(town, 0, 1);
		town.grid[0][1] = cell1;
		
		TownCell cell2 = new Casual(town, 1, 0);
		town.grid[1][0] = cell2;
		
		TownCell cell3 = new Empty(town, 1, 1);
		town.grid[1][1] = cell3;
		
		String out = town.toString();
		System.out.println(out);
	}
	public static void testFileRead() {
		
		
		
		try {
				
			
			Town town = new Town("ISP4x4.txt");
			
			System.out.println(town.toString());
		} catch (Exception FileNotFoundException) {
			System.out.println("That File Doesn't Exist");
		}
		finally {
			
		}
		
	}
	
	
	
	
	public static void testRandInit() {
		int size = 4;
		Town town = new Town(size, size);
		town.randomInit(2);
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.println(town.grid[i][j].who());
			}
		}
		
	}
		
		
		
}


