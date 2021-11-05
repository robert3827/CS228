package hw3.iastate.edu.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Takes a file from input. Reads the file in infix notation and converts it to postfix notation. 
 * Outputs either the postfix notation if the infix expression is valid, otherwise the first error encountered.
 * @author Robert Holeman
 *
 */
public class InfixToPostFix {
	/**
	 * Handles getting the input and running the code.
	 * @param args
	 */
	public static void main(String[] args) {
		InfixToPostFix ipf = new InfixToPostFix();
		
		ArrayList<String> exprs = ipf.inputFile("input.txt");
		
		ipf.outputFile(exprs, "output.txt");
		}

	/**
	 * Reads from a file. Each line is taken as one expression and added to the list of expressions, which are stored as strings.
	 * @param s the name of the file to read from
	 * @return A list of strings representing individual expressions in infix notation
	 */
	private ArrayList<String> inputFile(String s) {
		ArrayList<String> exprList = new ArrayList<>();
		File file = new File(s);
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String expr = scan.nextLine();
				exprList.add(expr);
				
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		return exprList;
	}
	
	private void outputFile(ArrayList<String> list, String fileName) {
		
				try {
					Files.writeString(Path.of(fileName),"");
					for(String s: list) {
						Files.writeString(Path.of(fileName), s + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
					}
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			// TODO Auto-generated catch block
		}
		
	
	/**
	 * 
	 * @param ifList list of infix expressions to be converted to postfix
	 * @return list of strings representing postfix expressions or error messages
	 */
	private ArrayList<String> convertInfixToPostfix(ArrayList<String> ifList){
		ArrayList<String> pfList = new ArrayList<>();
		for(String s: ifList) {
			try {
				convert(s);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
	
	
	
		return pfList;
	}
	/**
	 * 
	 * @param infix a string representing one infix notation 
	 * @return the correct postfix expression from the given infix expression
	 * @throws Exception Throws exception to stop program execution. Could also just return a string there but TBD on what is better.
	 */
	private String convert(String infix) {
		int curRank = 0;
		Scanner scan = new Scanner(infix);
		String postFix = "";
		Stack<String> stack = new Stack<>();
		while( scan.hasNext()) {
			
			
				String s = scan.next();
				
				curRank += rank(s);//as soon as I see the char I want to make sure the rank is ok.
				if(curRank > 1 ) {
					return ("Too Many Operands" + " (" + s + ")");
				} else if(curRank<-1) {
					return ("Too Many Operators" + " (" + s + ")");
				}
				//TODO Here is the real logic.
				if(rank(s)==1) {//not operator or parentheses
					postFix += s;
				} else {//c is an operator
					int stackOpPrec = precedenceInStack(stack.peek());
					int curOpPrec = precedenceAsInput(s);
					while(stackOpPrec>=curOpPrec) {
						
						String topOfStack = stack.pop();
						if(s.equals("(") && topOfStack.equals(")")) {
							//do nothing
						} else {
							postFix+= topOfStack;
						}
					}
					
					
				}
			}
			
		
		
		
		return postFix;
	}
	private int rank(String s) {
		int rank;
		switch (s) {
		case "+": rank = -1;break;
		case "-": rank = -1;break;
		case "*": rank = -1;break;
		case "/": rank = -1;break;
		case "%": rank = -1;break;
		case "^": rank = -1;break;//Is this Correct
		
		case "(": rank = 0;break;
		case ")": rank = 0;break;
		
		
		default:
			rank = 1;//this is anything that is not an op is treated as a num/let
		}
		return rank;
	}
	
	private int precedenceAsInput(String s) {
		int prec;
		switch (s) {
		case "+": prec = 1;break;
		case "-": prec = 1;break;
		
		case "*": prec = 2;break;
		case "/": prec = 2;break;
		case "%": prec = 2;break;
		
		case "^": prec = 4;break;//Is this Correct

		case "(": prec = 5;break;
		case ")": prec = 0;break;
		
		default:
			throw new IllegalArgumentException("Invalid Operator: " + s);
		}
		return prec;
	}
	private int precedenceInStack(String s) {
		int prec;
		switch (s) {
		case "+": prec = 1;break;
		case "-": prec = 1;break;
		
		case "*": prec = 2;break;
		case "/": prec = 2;break;
		case "%": prec = 2;break;
		
		case "^": prec = 3;break;//Is this Correct
		
		case "(": prec = -1;break;
		case ")": prec = -0;break;
		
		
		default:
			throw new IllegalArgumentException("Invalid Operator: " + s);
		}
		return prec;
	}
	

}

