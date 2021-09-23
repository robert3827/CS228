package edu.iastate.cs228.hw1;
/**
 * 
 * @author Robert Holeman
 *
 */
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
		super.census(nCensus);

		TownCell cell = new Empty(plain, row, col);
//		if(nCensus[STREAMER]>5) {//TODO Does this still apply
//			cell = new Streamer(plain, row, col);
//		}
		
		
		return cell;
	}

}
