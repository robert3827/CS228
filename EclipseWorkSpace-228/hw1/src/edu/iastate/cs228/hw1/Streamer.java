package edu.iastate.cs228.hw1;

public class Streamer extends TownCell{

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell cell = plain.grid[row][col];
		super.census(nCensus);
		
		if(nCensus[RESELLER]>0) { //this takes precedence
			cell = new Outage(plain, row, col);
		} else if(nCensus[OUTAGE]>0) {
			cell = new Empty(plain, row, col);
		} else if(nCensus[CASUAL]>=5) {
			cell = new Streamer(plain, row, col);
		} if(nCensus[EMPTY] + nCensus[OUTAGE] <=1) {//TODO does this take precedence over original rules. If its supposed to then Ill put it first in list of ELIF
				cell = new Reseller(plain, row, col);
			} 
		
		return cell;
	}
	
	

}
