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
		TownCell cell = plain.grid[row][col];
		super.census(nCensus);
		
			if(nCensus[RESELLER]>0) { //this takes precedence
				cell = new Outage(plain, row, col);
			} else if(nCensus[STREAMER]>0) {
				cell = new Streamer(plain, row, col);
			} else if(nCensus[EMPTY] + nCensus[OUTAGE] <=1) {//does this take precedence over origional rules. If its supposed to then Ill put it first in list of ELIF
				cell = new Reseller(plain, row, col);
			} else if(nCensus[CASUAL]>5) {
				cell = new Streamer(plain, row, col);
			}
			
		
		
		
		return cell;
	}

}
