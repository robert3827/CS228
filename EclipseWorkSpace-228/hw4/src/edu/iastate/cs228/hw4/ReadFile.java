package edu.iastate.cs228.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Reads File and takes in the lines as a list so they can be decoded.
 * @author Robert 
 *
 */
public class ReadFile {
	
	
	

	public void printArray(ArrayList<String> lines) {
		for(String line: lines) {
			System.out.println(line);
		}
	}

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
