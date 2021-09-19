package edu.iastate.cs228.hw1;

public class Empty extends TownCell{

	public Empty(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew) {		
		TownCell cell = plain.grid[row][col];
		super.census(nCensus);
	
		if((nCensus[1] + nCensus[3]) <=1) {//does this take precedence over origional rules. If its supposed to then Ill put it first in list of ELIF
			cell = new Reseller(plain, row, col);
		} else if(nCensus[CASUAL]>=5) {
			cell = new Streamer(plain, row, col);
		} else {//TODO is the correct order
			cell = new Casual(plain, row, col);
		}
		return cell;
	}
}
