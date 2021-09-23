package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Robert Holeman
 *
 */
class TownCellTest {

	@Test
	void testCensus() {
		int[] cen = new int[5];

		try {
			Town town = new Town("ISP4x4.txt");
			town.grid[1][1].census(cen);
			
			System.out.println(town.toString());
		} catch (Exception e) {
			System.out.println("That File Doesn't Exist");
			e.printStackTrace();
		}
		int[] real = {1, 2, 1, 3, 1};
		assertArrayEquals(real, cen);
		
	}
	//All other methods are abstract so they will be tested in their private classes

}
