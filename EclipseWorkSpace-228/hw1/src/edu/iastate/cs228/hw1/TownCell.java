package edu.iastate.cs228.hw1;

/**
 * 
 * @author Robert Holeman
 *	Generic representation of any cell takes the census but unique functions are left to child cells
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
	 * @param counts of all customers in an array
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0; 

		//TODO: Write your code here.
		//check the neighbors
		//I have cell r,c
		//check 1 cell away
		
		//Check row above
		if(row-1 >=0) {
			if(col-1 >=0) {
				nCensus[stateToNum(plain.grid[row-1][col-1].who())]++;
			}
			nCensus[stateToNum(plain.grid[row-1][col].who())]++;
			if(col+1<plain.getWidth()) {
				nCensus[stateToNum(plain.grid[row-1][col+1].who())]++;
			}
		}
		
		//check current row
		if(col-1>=0) {//Check left neighbor
			int who = stateToNum(plain.grid[row][col-1].who());
			nCensus[who]++;
		}
		if(col+1<plain.getWidth()) {//check right neighbor
			int who = stateToNum(plain.grid[row][col+1].who());
			nCensus[who]++;
		}
			
		//Check Row Below
		if(row+1<plain.getLength()) {
			if(col-1>=0) {
				nCensus[stateToNum(plain.grid[row+1][col-1].who())]++;
			}
			nCensus[stateToNum(plain.grid[row+1][col].who())]++;
			if(col+1<plain.getWidth()) {
				nCensus[stateToNum(plain.grid[row+1][col+1].who())]++;
			}
		}
		
			
		
		
}
	/**
	 * 
	 * @param state that you want to know the index of in nCensus array
	 * @return number associated with the state in the nCensus array
	 */
	private int stateToNum(State state) {
		int num = -1;
		switch(state) {
		case RESELLER: num = 0;
		break;
		case EMPTY: num = 1;
			break;
		case CASUAL: num = 2;
			break;
		case OUTAGE: num = 3;
			break;
		case STREAMER: num = 4;
			break;
		default:
			break;
		}
		return num;
	}
		
		


	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State of the cell
	 */
	public abstract State who();
		
	
	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell that is generated by the next cycle
	 */
	public abstract TownCell next(Town tNew);
}
