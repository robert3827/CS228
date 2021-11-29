package edu.iastate.cs228.hw4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Run this method to input a file name, and recieve the results.
 * @author Robert Holeman
 *
 */
public class RunMe {
	
	
	public static void main(String[] args) {
		String fileName;
		Scanner scan = new Scanner(System.in);
		ReadFile rf = new ReadFile();
		
		
//		System.out.println("Enter the name of the file.");
//		fileName = scan.next();
		fileName = "monalisa.arch";//TODO Change this
		scan.close();
		ArrayList<String> lines = new ArrayList<String>();
		rf.getDataFromFile(fileName, lines);
		rf.printArray(lines);
		if(lines.size() ==2) {
			
			MsgTree tree = new MsgTree(lines.get(0));
			System.out.println("character code");
			System.out.println("--------------");
			MsgTree.printCodes(tree, "");
//			System.out.println(tree.decode(tree, lines.get(1)));
			
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
