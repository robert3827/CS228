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
	public Town(String inputFileName) throws FileNotFoundException {//TODO make this work
		
		File file = new File(inputFileName);
		Scanner scan = new Scanner(file);
		
			length = scan.nextInt();
			width = scan.nextInt();

		for(int i=0;i<length;i++) {
			for(int j=0;j<width;j++) {
				String s = scan.next();
				System.out.println(s);
				grid[i][j] = setTownCell(whatState(s));
				
			}
			
		}
			
		scan.close();	
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
		//Get a random number
		
		;//TODO make this an if statement that tells us what to do
		for(int i=0;i<length;i++) {
			for(int j=0;j<width;j++) {
				 
			TownCell cell = numToCell(rand.nextInt(4), i, j);
			grid[i][j] = cell;
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
		
		for(int i=0;i<length;i++) {
			for(int j=0;j<width;j++) {
				s += whatLetter(grid[i][j].who());
				s += " ";
			}
			s+="\n";
		}
		return s;
	}
	/**
	 * Returns the first letter of the desired state
	 * @param state the state you want the initial for
	 * @return a letter to add to the board string
	 */
	private String whatLetter(State state) {
		String letter = null;
		switch (state) {
		case RESELLER: letter = "R";
			break;
		case CASUAL: letter = "C";
			break;
		case EMPTY: letter = "E";
			break;
		case OUTAGE: letter = "O";
			break;
		case STREAMER: letter = "S";
			break;
		default:
			break;
		}
		return letter;
	}
	
	/**
	 * Given a letter string returns the corresponding State 
	 * @param String letter of the first state 
	 * @return State starting with the given string
	 */
	private State whatState(String s) {//get state from letter
		State state = null;
		switch (s) {
		case "R": state = State.RESELLER;
			break;
		case "C": state = State.CASUAL;
			break;
		case "E": state = State.EMPTY;
			break;
		case "O": state = State.OUTAGE;
			break;
		case "S": state = State.STREAMER;
			break;
		default:
			break;
		}
		return state;
	}
	
	/**
	 * Creates a cell given a state
	 * @param state that you want to become a TownCell object
	 * @return TownCell representing the state given
	 */
	private TownCell setTownCell(State state) {
		TownCell cellNow = null;
		switch (state) {
		case RESELLER: cellNow = new Reseller(this, length, width);
			break;
		case CASUAL: cellNow = new Casual(this, length, width);
			break;
		case EMPTY: cellNow = new Empty(this, length, width);
			break;
		case OUTAGE: cellNow = new Outage(this, length, width);
			break;
		case STREAMER: cellNow = new Streamer(this, length, width);
			break;
		default:
			break;
		}
		return cellNow;
	}
	
	/**
	 * Returns the state specified by the given a random number between 1 and 5
	 * @param Rhe random number between 1 and the number of states
	 * @param r - Row of the cell you want to change
	 * @param c - Column of the cell you want to change
	 * @return The cell you want to set.
	 */
	private TownCell numToCell(int randNum, int r, int c) {
		TownCell cellNow = null;
		
		switch(randNum) {
		case 0: cellNow = new Reseller(this, r, c);
		break;
		case 1: cellNow = new Casual(this, r, c);
		break;
		case 2: cellNow = new Empty(this, r, c);
		break;
		case 3: cellNow = new Outage(this, r, c);
		break;
		case 4: cellNow = new Streamer(this, r, c);
		break;
		
		}
		return cellNow;
	}
	
	
	
	
	
}
