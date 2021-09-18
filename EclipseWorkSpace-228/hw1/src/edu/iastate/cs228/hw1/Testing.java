package edu.iastate.cs228.hw1;



public class Testing {
	
	public static void main(String[] args) {
//		testLengthAndWidth();
//		testPrintArray();
//		testRandInit();
//		testFileRead();
		
		testUpdate();
//		testProfit();
		
		
	}
	private static void testProfit() {
		ISPBusiness bus = new ISPBusiness();
		int len = 5;
		int wid = 5;
		Town town = new Town(len, wid);
		town.randomInit(2);
		int profit = bus.getProfit(town);
		System.out.println("$" + profit);
		
	}
	private static void testUpdate() {
		ISPBusiness bus = new ISPBusiness();
		int len = 5;
		int wid = 5;
		Town town = new Town(len, wid);
		town.randomInit(2);
		System.out.println(town.toString());
		Town newTown = new Town(len, wid);
		newTown = bus.updatePlain(town);
		System.out.println(newTown.toString());	
		
	}
	
	private static void testLengthAndWidth() { //correctly returns length and width
		Town town = new Town(6, 9);
		int width = town.getWidth();
		int length = town.getLength();
		System.out.println("Length:" + length +" Width:"+ width);
	}
	private static void testPrintArray() { //can print an array
		Town town = new Town(2, 2);
		TownCell cell = new Empty(town, 0, 0);
		town.grid[0][0] = cell;

		TownCell cell1 = new Streamer(town, 0, 1);
		town.grid[0][1] = cell1;
		
		TownCell cell2 = new Casual(town, 1, 0);
		town.grid[1][0] = cell2;
		
		TownCell cell3 = new Empty(town, 1, 1);
		town.grid[1][1] = cell3;
		
		String out = town.toString();
		System.out.println(out);
	}
	private static void testFileRead() {//throws file not found exception not sure why?
		
		try {
				
			
			Town town = new Town("ISP4x4.txt");
			
			System.out.println(town.toString());
		} catch (Exception FileNotFoundException) {
			System.out.println("That File Doesn't Exist");
		}
		finally {
			
		}
		
	}
	
	
	
	
	private static void testRandInit() { //can init randomly in any size
		int length = 2;
		int width = 8;
		Town town = new Town(length, width);
		town.randomInit(2);
		System.out.println(town.toString());
		town.randomInit(3);
		System.out.println(town.toString());
		
	}
		
		
		
}


