package edu.iastate.cs228.hw1;

public class Outage extends TownCell {

	public Outage(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) {
		
		TownCell cell = new Empty(plain, row, col);
		if(nCensus[2]>5) {//TODO Does this still apply
			cell = new Streamer(plain, row, col);
		}
		
		
		return cell;
	}

}
