package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class ISPBusinessTest {

	@Test
	void testUpdatePlain() {
		try {	
			Town town = new Town("ISP4x4.txt");
			ISPBusiness isp = new ISPBusiness();
			String s;
			
			Town newT = isp.updatePlain(town);
			for(int x=0;x<town.getLength();x++) {
				for(int y=0;y<town.getWidth();y++) {
					town.grid[x][y] = newT.grid[x][y];
					
				}
			}
			s = "E E E E \n"
					+ "C C O E \n"
					+ "C O E O \n"
					+ "C E E E \n";	
			assertEquals(s, newT.toString());
		} catch (Exception e) {
			System.out.println("That File Doesn't Exist");
			e.printStackTrace();
		}
	}
	@Test
	void testgetProfit() {
		try {
			Town town = new Town("ISP4x4.txt");
			ISPBusiness isp = new ISPBusiness();
			int d = isp.getProfit(town);
			
			assertEquals(1, d);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
