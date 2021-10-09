package hw06;

import java.util.Scanner;

public class P7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		System.out.println(getValues(input));
		
		scan.close();
	}
	
	public static int getValues(String s) {
		int total = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1') {
				total += Math.pow(2, (s.length()-i-1));
			}
		}
	return total;
	}
}
