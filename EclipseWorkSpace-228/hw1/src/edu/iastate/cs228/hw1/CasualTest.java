package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Robert Holeman
 *
 */
class CasualTest {

	@Test
	void testName() {
		Town town = new Town(1,1);
		town.grid[0][0] = new Casual(town, 0, 0);
		 
		assertEquals(State.CASUAL, town.grid[0][0].who());
	}
	@Test
	void testNext() {
		
		int[] arr = {0,0,0,0,0};	
		Town town = new Town(3, 3);
		town.grid[1][1] = new Casual(town, 1, 1);
		Casual c = (Casual) town.grid[1][1];
		
		town.grid[0][0] = new Reseller(town, 0, 0);		
		town.grid[0][1] = new Reseller(town, 0, 1);		
		town.grid[0][2] = new Reseller(town, 0, 2);		
		town.grid[1][0] = new Reseller(town, 1, 0);		
		town.grid[1][2] = new Reseller(town, 1, 2);		
		town.grid[2][0] = new Reseller(town, 2, 0);		
		town.grid[2][1] = new Outage(town, 2, 1);		
		town.grid[2][2] = new Empty(town, 2, 2);		
		c.census(arr);
		
		assertEquals(State.OUTAGE, c.next(town).who());
		//Test Becoming Reseller
		town.grid[0][0] = new Reseller(town, 0, 0);		
		town.grid[0][1] = new Reseller(town, 0, 1);		
		town.grid[0][2] = new Reseller(town, 0, 2);		
		town.grid[1][0] = new Reseller(town, 1, 0);		
		town.grid[1][2] = new Reseller(town, 1, 2);		
		town.grid[2][0] = new Reseller(town, 2, 0);		
		town.grid[2][1] = new Reseller(town, 2, 1);		
		town.grid[2][2] = new Reseller(town, 2, 2);		
		c.census(arr);
		
		assertEquals(State.RESELLER, c.next(town).who());
		//become Streamer because of streamers
		town.grid[0][0] = new Streamer(town, 0, 0);		
		town.grid[0][1] = new Streamer(town, 0, 1);		
		town.grid[0][2] = new Streamer(town, 0, 2);		
		town.grid[1][0] = new Streamer(town, 1, 0);		
		town.grid[1][2] = new Streamer(town, 1, 2);		
		town.grid[2][0] = new Streamer(town, 2, 0);		
		town.grid[2][1] = new Outage(town, 2, 1);		
		town.grid[2][2] = new Outage(town, 2, 2);		
		c.census(arr);
		
		assertEquals(State.STREAMER, c.next(town).who());
		
		//become Streamer because of streamers
			town.grid[0][0] = new Casual(town, 0, 0);		
			town.grid[0][1] = new Casual(town, 0, 1);		
			town.grid[0][2] = new Casual(town, 0, 2);		
			town.grid[1][0] = new Casual(town, 1, 0);		
			town.grid[1][2] = new Casual(town, 1, 2);		
			town.grid[2][0] = new Casual(town, 2, 0);		
			town.grid[2][1] = new Outage(town, 2, 1);		
			town.grid[2][2] = new Outage(town, 2, 2);		
			c.census(arr);
			
			assertEquals(State.STREAMER, c.next(town).who());
				
		
	}

}
