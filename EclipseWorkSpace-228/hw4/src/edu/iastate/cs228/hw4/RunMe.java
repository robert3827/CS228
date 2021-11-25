package edu.iastate.cs228.hw4;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMe {
	public static void main(String[] args) {
		String fileName;
		Scanner scan = new Scanner(System.in);
		ReadFile rf = new ReadFile();
		
		
//		System.out.println("Enter the name of the file.");
//		fileName = scan.next();
		fileName = "cadbard.arch";//TODO Change this
		scan.close();
		ArrayList<String> lines = new ArrayList<String>();
		rf.getDataFromFile(fileName, lines);
		rf.printArray(lines);
		if(lines.size() ==2) {
			CreateTree tree = new CreateTree(lines.get(0));
		} else if (lines.size() == 3) {
			CreateTree tree = new CreateTree(lines.get(0), lines.get(1));
		}
		
		

	}
}
