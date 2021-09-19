package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{

	public Reseller(Town p, int r, int c) {
		super(p, r, c);
		
	}

	@Override
	public State who() {
		
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell cell = plain.grid[row][col];
		super.census(nCensus);
		
		if(nCensus[CASUAL]<=3) { //this takes precedence
			cell = new Empty(plain, row, col);
		} else if(nCensus[EMPTY]>=3) {
			cell = new Empty(plain, row, col);
		} else if(nCensus[CASUAL]>5) {
			cell = new Streamer(plain, row, col);
		}
		return cell;
	}

}
