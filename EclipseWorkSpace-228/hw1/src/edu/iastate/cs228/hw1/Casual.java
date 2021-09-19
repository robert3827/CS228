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
		
			if(nCensus[0]>0) { //this takes precedence
				cell = new Outage(plain, row, col);
			} else if(nCensus[4]>0) {
				cell = new Streamer(plain, row, col);
			} else if(nCensus[2]>5) {
				cell = new Streamer(plain, row, col);
			}
			if(nCensus[1] + nCensus[3] <=1) {//does this take precedence over origional rules. If its supposed to then Ill put it first in list of ELIF
				cell = new Reseller(plain, row, col);
			}
		
		
		
		return cell;
	}

}
