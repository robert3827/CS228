package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Robert Holeman
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		
		//TODO: Write your code here.
		for(int i=0;i<tOld.getLength();i++) {
			for(int j=0; j< tOld.getWidth();j++) {
				TownCell cell = tOld.grid[i][j].next(tNew);
				tNew.grid[i][j] = cell;
			
			}
		}
		
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return $1 * the number of casual users
	 */
	public static int getProfit(Town town) {
		int profit = 0;
		for(int i=0;i<town.getLength();i++) {
			for(int j=0;j<town.getWidth();j++) {
				if(town.grid[i][j].who() == State.CASUAL) {
					profit++;
				}
				
			}
		}
		
		return profit;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) {
		Town town = null;
		
		System.out.println("How to populate grid (type 1 or 2) : 1: from a file. 2: randomly with seed ");
		
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		//Option 1
		if(option == 1) {
			System.out.println("Please enter file path:");
			String fileName = scan.next();
			try {
				town = new Town(fileName);
			} catch (FileNotFoundException e) {
				System.out.println("That File Doesn't Exist. Please Try Again.");
				//e.printStackTrace();
			}
		}
		//Option 2
		if(option == 2) {
			System.out.println("Provide rows, cols and seed integer separated by spaces:");
			int len = scan.nextInt();
			int wid = scan.nextInt();
			int seed = scan.nextInt();
			town = new Town(len, wid);
			town.randomInit(seed);
			System.out.println("Your town is: \n" + town.toString());
		}
		scan.close();
		//Calc Profit
		int moneyCollected = 0;
		for(int month = 0; month<12; month++) {
			moneyCollected += getProfit(town);
			updatePlain(town);
		}
		double percentProfit = (double)moneyCollected/(town.getLength()*town.getWidth());
		
		System.out.printf("%.2f%%", percentProfit);
	}

	private static double profitPercent() {
		double profitPercent = 0;
		
		return profitPercent;
	}
}
