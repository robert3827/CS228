package edu.iastate.cs228.hw1;

import java.util.Iterator;

public class Testing {
	
	public static void main(String[] args) {
		testMain();
		testRandInit();
	}
	public static void testMain() {
		Town town = new Town(6, 9);
		int width = town.getWidth();
		int length = town.getLength();
		System.out.println(length +" "+ width);
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


