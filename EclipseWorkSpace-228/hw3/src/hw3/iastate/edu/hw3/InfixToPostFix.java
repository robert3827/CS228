package hw3.iastate.edu.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


/**
 * Takes a file from input. Reads the file in infix notation and converts it to
 * postfix notation. Outputs either the postfix notation if the infix expression
 * is valid, otherwise the first error encountered.
 * 
 * @author Robert Holeman
 *
 */
public class InfixToPostFix {

	/**
	 * Handles getting the input and running the code.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		InfixToPostFix ipf = new InfixToPostFix();

		ArrayList<String> exprs = ipf.inputFile("input.txt");
		ArrayList<String> answer = ipf.convertInfixToPostfix(exprs);
		ipf.outputFile(answer, "output.txt");
	}

	/**
	 * Reads from a file. Each line is taken as one expression and added to the list
	 * of expressions, which are stored as strings.
	 * 
	 * @param fileName the name of the file to read from
	 * @return A list of strings representing individual expressions in infix
	 *         notation
	 */
	private ArrayList<String> inputFile(String fileName) {
		ArrayList<String> exprList = new ArrayList<>();
		File file = new File(fileName);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String expr = scan.nextLine();
				exprList.add(expr);

			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

		}

		return exprList;
	}

	/**
	 * Prints the given array list to a given file. Any contents previously in the
	 * file will be removed.
	 * 
	 * @param list     the list of strings you wish to remove
	 * @param fileName The name of the file you wish to output to.
	 */
	private void outputFile(ArrayList<String> list, String fileName) {

		try {
			Files.writeString(Path.of(fileName), "");
			for (String s : list) {
				Files.writeString(Path.of(fileName), s + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated catch block
	}

	/**
	 * Calls convert() to convert each each element of the list to postfix.
	 * 
	 * @param ifList list of infix expressions to be converted to postfix
	 * @return list of strings representing postfix expressions or error messages
	 */
	private ArrayList<String> convertInfixToPostfix(ArrayList<String> ifList) {
		ArrayList<String> pfList = new ArrayList<>();
		for (String s : ifList) {
			String answer = checkForEmptyParenthesis(s);
			if(s.equals(answer)) {//if we just returned the same string then 
									//there were no issues and we can convert it
				answer = convert(s);
			}
			
			pfList.add(answer);
		}

		return pfList;
	}
	
	/**
	 * Checks the given string for empty parenthesis one after another.
	 * @param infix the expression in infix notation that you wish to check for empty parenthesis
	 * @return the given string if there were no empty parenthesis or an error if there were
	 */
	private String checkForEmptyParenthesis(String infix) {
		Scanner scan = new Scanner(infix);
		Stack<String> stack = new Stack<>();
		
		while(scan.hasNext()) {
			String s = scan.next();
			if(s.equals("(")) {//if its a paren push it to stack
				stack.push(s);
			} else if (s.equals(")")) {//if its a close paren, 
										//see if it has an open paren immediately before
				if(!stack.isEmpty() && stack.peek().equals("(")) {
					scan.close();
					String returnStr = ("Error: no subexpression detected ()");
					return returnStr;
				}
				//you can just add all the stuff in as well
			} else if(!s.equals("(") && !s.equals(")")) {
				stack.push(s);
			}
			
		}
		scan.close();
		return infix;
	}

	/**
	 * Converts an infix expression into a postfix expression.
	 * 
	 * @param infix a string representing one infix notation
	 * @return the correct postfix expression from the given infix expression
	 * @throws Exception Throws exception to stop program execution. Could also just
	 *                   return a string there but TBD on what is better.
	 */
	private String convert(String infix) {
		int curRank = 0;
		Scanner scan = new Scanner(infix);
		String postFix = "";
		Stack<String> stack = new Stack<>();
		while (scan.hasNext()) {// for each term

			String s = scan.next();
			//Quick handling of empty parenthesis
			
			curRank += rank(s);// as soon as I see the char I want to make sure the rank is ok.
			if (curRank > 1) {
				scan.close();
				return ("Error: too many operands" + " (" + s + ")");
			} else if (curRank < 0) {
				scan.close();
				return ("Error: too many operators" + " (" + s + ")");
			}

			// TODO Here is the real logic.
			if (rank(s) == 1) {// Means s is a number.
				postFix += s;
				postFix += " ";
			} else {// s is an operator

				if (stack.isEmpty()) {// don't compare just push it
					if (s.equals(")")) {
						// You shouldn't have it want to put close parenthesis into empty stack.
						scan.close();
						return ("Error: no opening parenthesis detected");
					} else {
						stack.push(s);
					}
				} else if (!stack.isEmpty()) {
					int precOfS = precedenceAsInput(s);
					if (precOfS > precedenceInStack(stack.peek())) {//precedence of the new
												//char is higher so pile on top
						if (s.equals(")")) {
							scan.close();
							return ("Error: no opening parenthesis detected");
						}
						stack.push(s);
					} else {// precedence Of s is lower so start popping
						
						
						while (!stack.isEmpty()) {	
							if (stack.peek().equals("(")) {// discard parenthesis
								stack.pop();
								break;
							} else if (precedenceInStack(stack.peek()) >= precOfS) {
								// pop anything with higher precedence and add to output
								postFix += stack.pop();
								postFix += " ";


							}
							if (s.equals(")") && stack.isEmpty()) {
								scan.close();
								return ("Error: no opening parenthesis detected");
							}
						}

						if (!s.equals(")")) {
							stack.push(s);
						}
					}

				}
			}

		}
		scan.close();// everything is scanned in.
		// All that is left to do is to pop everything out.
		//
		ArrayList<String> ans = checkFinalRank(infix);
		if (!ans.get(0).equals("1")) {
			scan.close();
			return ("Error: too many operators (" + ans.get(1) + ")");
		}

		while (!stack.isEmpty()) {
			if (stack.peek().equals("(")) {
				scan.close();
				return ("Error: no closing parenthesis detected");
			} else {
				postFix += stack.pop();
				postFix += " ";
			}
		}
		postFix = postFix.trim();
		return postFix;
	}

	/**
	 * Checks the rank at the end to see if the given expression is a valid one.
	 * 
	 * @param infix the postfix expression to check
	 * @return 0 if the given postfix expression has the correct rank
	 */
	public ArrayList<String> checkFinalRank(String infix) {
		ArrayList<String> cFR = new ArrayList<>();
		int rank = 0;
		Scanner scan = new Scanner(infix);
		while (scan.hasNext()) {

			String s = scan.next();
			rank += rank(s);
		}
		scan.close();
		// At the end if rank is one you want to return the offending character(thats
		// actually a string)
		cFR.add(Integer.toString(rank));
		if (!(rank == 1)) {
			cFR.add(Character.toString(infix.charAt(infix.length() - 1)));
		}
		return cFR;
	}

	/**
	 * Returns the rank of the given String input.
	 * 
	 * @param s String token you wish to know the rank of
	 * @return rank of the given String
	 */
	private int rank(String s) {
		int rank;
		switch (s) {
		case "+":
			rank = -1;
			break;
		case "-":
			rank = -1;
			break;
		case "*":
			rank = -1;
			break;
		case "/":
			rank = -1;
			break;
		case "%":
			rank = -1;
			break;
		case "^":
			rank = -1;
			break;// Is this Correct

		case "(":
			rank = 0;
			break;
		case ")":
			rank = 0;
			break;
		case "–":
			rank = -1;
			break;

		default:
			rank = 1;// this is anything that is not an op is treated as a num/let
		}
		return rank;
	}

	/**
	 * Returns the precedence of the given string as a scanned input. If the input
	 * isn't a valid operator it throws an IllegalArgument Exception.
	 * 
	 * @param s A string representing an operator as an input.
	 * @return The precendence of the given operator as an input
	 */
	private int precedenceAsInput(String s) {
		int prec;
		switch (s) {
		case "+":
			prec = 1;
			break;
		case "-":
			prec = 1;
			break;

		case "–":// Why are there two minus signs
			prec = 1;
			break;
		case "*":
			prec = 2;
			break;
		case "/":
			prec = 2;
			break;
		case "%":
			prec = 2;
			break;

		case "^":
			prec = 4;
			break;// Is this Correct

		case "(":
			prec = 5;
			break;
		case ")":
			prec = 0;
			break;

		default:
			throw new IllegalArgumentException("Invalid Operator: " + s);
		}
		return prec;
	}

	/**
	 * Returns the precedence of the given string as the top element of the stack.
	 * If the input isn't a valid operator it throws an IllegalArgument Exception.
	 * 
	 * @param s A string representing an operator from the stack
	 * @return The precedence of the given operator as one from the stack
	 */
	private int precedenceInStack(String s) {
		int prec;
		switch (s) {
		case "+":
			prec = 1;
			break;
		case "-":
			prec = 1;
			break;

		case "–":// Again there are two minus signs
			prec = 1;
			break;

		case "*":
			prec = 2;
			break;
		case "/":
			prec = 2;
			break;
		case "%":
			prec = 2;
			break;

		case "^":
			prec = 3;
			break;// Is this Correct

		case "(":
			prec = -1;
			break;
		case ")":
			prec = -0;
			break;

		default:
			throw new IllegalArgumentException("Invalid Operator: " + s);
		}
		return prec;
	}

}
