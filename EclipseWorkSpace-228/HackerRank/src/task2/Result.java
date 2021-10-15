package task2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'braces' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY values as parameter.
     */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("{[]}");
		list.add("{[}]");
		list.add("[[[[[[[[]]]]]]]]");
		
		System.out.println(braces(list));
	}
    public static List<String> braces(List<String> values) {
		List<String> isBalenced = new ArrayList<>();
		String each;
		for(int i=0;i<values.size();i++) {
			each = values.get(i);
			isBalenced.add(boolToString(checkBalence(each)));
		}
    	
    	
    	
    	return isBalenced;
    }
    
    public static boolean checkBalence(String input) {
    	
    	String shrt = "";
    	String theRest = "";
    	for(int i=0;i<input.length();i++) {
    		if(isOpenChar(input.charAt(i))) {
    			shrt+=input.charAt(i);
    			for(int j=i;j<input.length();j++) {
    				shrt+=input.charAt(j);
    				if(input.contains(shrt)) {
    					recCheckBalence(input.getChars(j, input.length()-1, theRest, 0));
    				}
    			}
    			
    		}
    	}
    	
    	return true;
    }
public static boolean recCheckBalence(String shrt) {
    	if(shrt.)
    	
    	return false;
    }
    
    
    public static String boolToString(boolean isBalenced) {
    	String output;

    	if(isBalenced) {
    		output = "YES";
    	} else {
    		output = "NO";
    	}
    	return output;
    }
    public static char matches(char brace) {//returns the corresponding char for each opening brace
    	char match = 'x';
    	
    	if(brace == '[') {
    		match = ']';
    	} else if(brace == '{') {
    		match = '}';
    	} else if(brace == '(') {
    		match = ')';
    	}
    	
    	
    	return match;
    }
    public boolean lookAhead(char c) {//say there is now something open need to find its corresponding close
    	boolean foundClose = false;
    	
    	
    	return foundClose;
    }
    public static boolean isOpenChar(char c) {
    	if(c == '{' || c=='[' || c=='(') {
    		return true;
    	} else {
    		return false;
    	}
    }

}
