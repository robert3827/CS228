package edu.iastate.cs228.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Run this method to input a file name, and recieve the results.
 * @author Robert Holeman
 *
 */
public class RunMe {
	/**
	 * Helper method to grab the data from the given file. If the file has two lines 
	 * then it will be read as is, if it has 3 lines the first two will be concatenated 
	 * with a newline char between them.
	 * @param fileName name of the file you wish to read from
	 * @param lines array holding the 2 or 3 strings from the file. 
	 */
	private static void getDataFromFile(String fileName, ArrayList<String> lines) {
		File file = new File(fileName);
		Scanner scan;
		try {
			
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				lines.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("The given file does not exist please try again.");
//			e.printStackTrace();
		}
		finally {
			
		}
		
	}
	
	/**
	 * Run this method and input a valid arch file to this program.
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter filename to decode:");
		fileName = scan.next();
//		fileName = "monalisa.arch";//TODO Change this
		scan.close();
		ArrayList<String> lines = new ArrayList<String>();
		getDataFromFile(fileName, lines);
		if(lines.size() ==2) {
			
			MsgTree tree = new MsgTree(lines.get(0));
			System.out.println("character code");
			System.out.println("--------------");
			MsgTree.printCodes(tree, "");
			System.out.println(tree.decode(tree, lines.get(1)));
			
		} else if (lines.size() == 3) {
			char c = '\n';
			MsgTree tree = new MsgTree(lines.get(0) + c + lines.get(1));
			System.out.println("character code");
			System.out.println("--------------");
			MsgTree.printCodes(tree, "");
			System.out.println(tree.decode(tree, lines.get(2)));
		}
		
		

	}
	
	
	
}
