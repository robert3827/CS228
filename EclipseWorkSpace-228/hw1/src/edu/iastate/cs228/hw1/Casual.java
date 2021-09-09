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
		// I'll do this once I have the state checker done
		return null;
	}

}
