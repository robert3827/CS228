package hw06;

import java.util.ArrayList;
import java.util.Scanner;

public class P9 {
	public P9() {
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		P9 p9 = new P9();
		
		System.out.println(p9.reverseString(p9.invertTwos(input)));
		scan.close();

	}

	public String invertTwos(String s) {
		String inverted = "";
		boolean seenFirst1 = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!seenFirst1) {
				inverted+=s.charAt(i);
				if (s.charAt(i) == '1') {
					seenFirst1 = true;
					
				}
			} else if (seenFirst1) {
				if (s.charAt(i) == '1') {
					inverted += 0;
				} else {// its 0
					inverted += 1;
				}
			}
		}

		return inverted;
	}
	public String reverseString(String s) {
		String reverse = "";
		for(int i=s.length()-1;i>=0;i--) {
			reverse+= s.charAt(i);
		}
		
		return reverse;
	}
	

}
