package hw3.iastate.edu.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {
	private int curRank = 0;
	public static void main(String[] args) {
		InfixToPostFix ipf = new InfixToPostFix();
		Scanner scan = new Scanner(System.in);
		System.out.println("Input File Name");
		String fileName = scan.next();
		ipf.inputFile(fileName);
		
		
		scan.close();
	}

	
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

	private ArrayList<String> convertInfixToPostfix(ArrayList<String> ifList) throws Exception {
		ArrayList<String> pfList = new ArrayList<>();
		for(String s: ifList) {
			convert(s);
		}
	
	
	
		return pfList;
	}
	private String convert(String infix) throws Exception {
		infix.trim();
		String postFix = "";
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<infix.length();i++) {
			char c = infix.charAt(i);
			curRank += rank(c);//as soon as I see the char I want to make sure the rank is ok.
			if(curRank > 1 ) {
				throw new Exception("Too Many Operands" + " (" + c + ")");
			} else if(curRank<-1) {
				throw new Exception("Too Many Operators" + " (" + c + ")");
			}
			if(Character.isLetterOrDigit(c)) {
				postFix += c;
			} else {//c is an operator
				;
				int ropOfStackPrec = precedenceInStack(stack.peek());
				int cPrec;
				
			}
		}
		
		
		
		return postFix;
	}
	private int rank(char c) {
		int rank;
		switch (c) {
		case '+': rank = -1;break;
		case '-': rank = -1;break;
		case '*': rank = -1;break;
		case '/': rank = -1;break;
		case '%': rank = -1;break;
		case '^': rank = -1;break;//Is this Correct
		//All Parentheses are Equivalent
		case '(': rank = 0;break;
		case ')': rank = 0;break;
		
		
		default:
			rank = 1;//this is anything that is not an op is treated as a num/let
		}
		return rank;
	}
	
	private int precedenceAsInput(char c) {
		int prec;
		switch (c) {
		
		case '+': prec = 1;break;
		case '-': prec = 1;break;
		
		case '*': prec = 2;break;
		case '/': prec = 2;break;
		case '%': prec = 2;break;
		
		case '^': prec = 4;break;//Is this Correct
		//All Parentheses are Equivalent
		case '(': prec = 5;break;
		case ')': prec = 0;break;
		
		default:
			throw new IllegalArgumentException("Invalid Operator: " + c);
		}
		return prec;
	}
	private int precedenceInStack(char c) {
		int prec;
		switch (c) {
		case '+': prec = 1;break;
		case '-': prec = 1;break;
		
		case '*': prec = 2;break;
		case '/': prec = 2;break;
		case '%': prec = 2;break;
		
		case '^': prec = 3;break;//Is this Correct
		//All Parentheses are Equivalent
		case '(': prec = -1;break;
		case ')': prec = -0;break;
		
		
		default:
			throw new IllegalArgumentException("Invalid Operator: " + c);
		}
		return prec;
	}
	

}

