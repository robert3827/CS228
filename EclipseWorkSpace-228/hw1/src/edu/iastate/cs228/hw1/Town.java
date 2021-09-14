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
		
		File file = new File(inputFileName);
		Scanner scan = new Scanner(file);
		
		
		
//		while(scan.hasNext()) {
			length = scan.nextInt();
			width = scan.nextInt();
//		}
		//Start of the grid
//		while(scan.hasNextLine()) {
//			while(scan.hasNext()) {
//				
//				State state = whatState(scan.next());
//				grid[][]
//			}
		for(int i=0;i<length;i++) {
			Scanner scan2 = new Scanner(scan.nextLine());
			for(int j=0;j<width;j++) {
				grid[i][j] = setTownCell(whatState(scan2.next()));
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
		rand.nextInt(5);//Get a random number
		
		State chosen = State.EMPTY;//TODO make this an if statement that tells us what to do
		
		
		
		
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
			for(int j=0;j<length;j++) {
				s += whatLetter(grid[i][j].who());
				s += " ";
			}
			s+="\n";
		}
		return s;
	}
	/**
	 * Matches the state with the corresponding letter
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
	
	
	
	
}
