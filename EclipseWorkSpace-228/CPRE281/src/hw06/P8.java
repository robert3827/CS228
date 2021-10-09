package hw06;

import java.util.Scanner;

public class P8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		if(input.charAt(0) == '0') {
			System.out.println(getPosValues(input));
		} else {//first digit is 1
			System.out.println(getPosValues(input)-128);
			
		}
		
		
		scan.close();
		
	}
	
	
	public static int getPosValues(String s) {
		int total = 0;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)=='1') {
				total += Math.pow(2, (s.length()-i-1));
			}
		}
	return total;
	}
}
