package edu.iastate.cs228.hw1;

/**
 * 
 * @author Robert Holeman
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}
	
	/**
	 * Checks all neigborhood cell types in the neighborhood.
	 * Refer to homework pdf for neighbor definitions (all adjacent
	 * neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 *  
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		for(int i=0;i<nCensus.length;i++) {
			nCensus[i] = 0;
		}
		
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0; 

		//TODO: Write your code here.
		//check the neighbors
		//I have cell r,c
		//check 1 cell away
		
		if(row-1 >= 0) {//check if row on top exists
			if(col==0) {
				for(int i=col; i<plain.getWidth();i++) {//if its in the first column then start there
					nCensus[plain.grid[row-1][col].who().ordinal()]++;
				}
			} else {
				for(int i = col-1; i<plain.getWidth();i++) {//or start diagonally up and left 1
					nCensus[plain.grid[row-1][col].who().ordinal()]++;
				}	
			}	
		}
		//check the current row
		if(col-1>=0) {//check neighbor to the left
			nCensus[plain.grid[row][col-1].who().ordinal()]++;
		}
		if(col+1<plain.getWidth()) {//check neighbor to the right
			nCensus[plain.grid[row][col+1].who().ordinal()]++;
		}
		//Check if row on below exists
		if(row+1 < plain.getLength()) {//check if row on below exists
			if(col==0) {
				for(int i=col; i<plain.getWidth();i++) {//if its in the first column then start there
					nCensus[plain.grid[row-1][col].who().ordinal()]++;
				}
			} else {
				for(int i = col-1; i<plain.getWidth();i++) {//or start diagonally down and left 1
					nCensus[plain.grid[row-1][col].who().ordinal()]++;
				}	
			}	
		}
		
}
		
		


	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();
		
	
	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
