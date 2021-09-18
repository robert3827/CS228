package edu.iastate.cs228.hw1;

public class Casual extends TownCell{
	
	
	public Casual(Town p, int r, int c) {
		super(p, r, c);
		
	}

	@Override
	public State who() {
		
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO read through logic to update the casual user. 
		census(nCensus);
		if(nCensus[2]>0) {
			plain.grid[row][col] = new Outage(plain, row, col);
		}
		
		
		return null;
	}

}
