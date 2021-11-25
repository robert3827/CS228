package edu.iastate.cs228.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Reads File and takes in the lines as a list so they can be decoded.
 * @author Robert Holeman
 *
 */
public class ReadFile {
	
	
	
	/**
	 * Testing method prints out the lines in the array.
	 * @param lines list of the lines given
	 */
	public void printArray(ArrayList<String> lines) {
		for(String line: lines) {
			System.out.println(line);
		}
	}
	/**
	 * Scans through the file to read the data then puts it in the list of strings.
	 * @param fileName name of the file to read from
	 * @param lines array to hold the parsed data
	 */
	public void getDataFromFile(String fileName, ArrayList<String> lines) {
		File file = new File(fileName);
		Scanner scan;
		try {
			
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				lines.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Given File Does not Exist");
			e.printStackTrace();
		}
		finally {
			
		}
		
	}
}
