package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
/**
 * 
 * @author Robert Holeman
 *
 */
class TownTest {
	
	@Test
	void testLW() {
		Town town = new Town(2, 2);
		assertEquals(2, town.getLength());
		assertEquals(2, town.getWidth());
	}
	@Test
	void testToString() {
		Town town = new Town(2,2);
		for(int i=0;i<town.getLength();i++) {
			for (int j=0;j<town.getWidth();j++) {
				town.grid[i][j] = new Casual(town, i, j);
			}
		}
		String s =		"C C \n"
					+ "C C \n";
		assertEquals(s, town.toString());
	}

	@Test
	void testConstructors() {
		//correctly returns length and width
			Town town = new Town(6, 9);
			
			int length = town.getLength();
			int width = town.getWidth();
			assertEquals(6, length);
			assertEquals(9, width);
			try {	
				town = new Town("ISP4x4.txt");
				String s = "4 4\n"
						+ "O R O R \n"
						+ "E E C O \n"
						+ "E S O S \n"
						+ "E O R R \n";
				
				assertEquals(s, town.getLength() +" "+ town.getWidth() + "\n"+ town.toString());
			} catch (Exception e) {
				System.out.println("That File Doesn't Exist");
				e.printStackTrace();
			}
	}
	@Test
	void testRandomInit() {
			Town town = new Town(2, 8);
			town.randomInit(2);
			String s =		"O E R E S R C S \n"
						+ "E O S C S S S C \n";
			assertEquals(s, town.toString());
			town.randomInit(3);
			s = 	"S R R C O E S S \n"
					+ "S C R E E S C C \n";
			assertEquals(s, town.toString());
		}
	
	
	
	
	
}
