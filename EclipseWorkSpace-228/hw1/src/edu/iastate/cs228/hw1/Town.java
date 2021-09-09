package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Robert Holeman
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	//DO I create a town variable. If so what does it do??
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
		//TODO: Write your code here.
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		//TODO: Write your code here.
	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		//TODO: Write your code here.
		rand.nextInt(5);//Get a random number
		
		State chosen = State.EMPTY;//TODO make this an if statement that tells us what to do
		
		
		for(int i=0;i<length;i++) {//number of rows
			for(int j=0;j<width;j++) {//number of columns
				switch (chosen) {
				case EMPTY: grid[i][j] = new Empty(null, i, j) ;
					break;
				case CASUAL: grid[i][j] = (Casual)grid[i][j] ;
					break;
				case OUTAGE: grid[i][j] = (Outage)grid[i][j] ;
					break;
				case RESELLER: grid[i][j] = (Reseller)grid[i][j] ;
					break;
				case STREAMER: grid[i][j] = (Streamer)grid[i][j] ;
					break;
				default: 
					break;
				}
					
				
			}
		}
		
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		//TODO: Write your code here.
		return s;
	}
}
