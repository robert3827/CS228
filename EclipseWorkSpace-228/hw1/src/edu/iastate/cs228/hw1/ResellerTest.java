package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Robert Holeman
 *
 */
class ResellerTest {

	@Test
	void testWho() {
		Town town = new Town(1,1);
		town.grid[0][0] = new Reseller(town, 0, 0);
		 
		assertEquals(State.RESELLER, town.grid[0][0].who());
	}
	@Test
	void testNext() {
		int[] arr = {0,0,0,0,0};	
		Town town = new Town(3, 3);
		town.grid[1][1] = new Reseller(town, 1, 1);
		Reseller c = (Reseller) town.grid[1][1];
		
		//Less than 3 casuals
		town.grid[0][0] = new Casual(town, 0, 0);		
		town.grid[0][1] = new Casual(town, 0, 1);		
		town.grid[0][2] = new Casual(town, 0, 2);		
		town.grid[1][0] = new Outage(town, 1, 0);		
		town.grid[1][2] = new Reseller(town, 1, 2);		
		town.grid[2][0] = new Reseller(town, 2, 0);		
		town.grid[2][1] = new Reseller(town, 2, 1);		
		town.grid[2][2] = new Reseller(town, 2, 2);		
		c.census(arr);
		
		assertEquals(State.EMPTY, c.next(town).who());

		//Become at least 3 empties
		town.grid[0][0] = new Empty(town, 0, 0);		
		town.grid[0][1] = new Empty(town, 0, 1);		
		town.grid[0][2] = new Reseller(town, 0, 2);		
		town.grid[1][0] = new Reseller(town, 1, 0);		
		town.grid[1][2] = new Reseller(town, 1, 2);		
		town.grid[2][0] = new Reseller(town, 2, 0);		
		town.grid[2][1] = new Outage(town, 2, 1);		
		town.grid[2][2] = new Empty(town, 2, 2);		
		c.census(arr);
		
		assertEquals(State.EMPTY, c.next(town).who());
	}

}
