package edu.iastate.cs228.hw1;
/**
 * 
 * @author Robert Holeman
 *
 */
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
		cell = new Casual(plain, row, col);

		
		//Is only supposed to become casual
		if((nCensus[EMPTY] + nCensus[OUTAGE]) <=1) {//TODO does this take precedence over original rules. If its supposed to then Ill put it first in list of ELIF
			cell = new Reseller(plain, row, col);
		}
//		else if(nCensus[CASUAL]<=5){//TODO is the correct order
//			cell = new Casual(plain, row, col);
//		}else if(nCensus[CASUAL]>=5) {
//			cell = new Streamer(plain, row, col);
//		}
		return cell;
	}
}
