package hw06;

import java.util.ArrayList;
import java.util.Scanner;

public class P6 {
	public P6() {
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a decimal value to be converted to hexadecimal:");
		int input = scan.nextInt();
//		System.out.println(correctAns(input));
		P6 p6 = new P6();
		
		P5 p5 = new P5();
		String binInput = p5.decToBinary(input);
		String fixed = p6.fixInput(binInput);
		
		
		String hex = p6.toHex(fixed);
		System.out.println(hex);
		scan.close();
	}
	
	

	private static String correctAns(int input) {
		return Integer.toHexString(input);
	}
	
	public String fixInput(String bin) {

		String fixed = "";
		P9 p9 = new P9();
		fixed = bin;
		while(fixed.length()%4 != 0) {
			fixed = p9.reverseString(fixed);
			fixed+="0";
			fixed = p9.reverseString(fixed);
		}
		
		
		
		return fixed;
	}
	public String toHex(String s) {
		
		
		String hexString = "";
		int numHexDigits = s.length()/4;
		for(int i=0;i<s.length();i+=4) {
			String shrt = "";
			for(int j=i;j<i+4;j++) {
				shrt+=s.charAt(j);
			}
			hexString += getHex(shrt);
		}
		
		
		
		return hexString;
	}
	private static String getHex(String fourBin) {
		
		String hex = "";
		switch (fourBin) {
		case "0000":
			hex = "0";
			break;
		case "0001":
			hex = "1";
			break;
		case "0010":
			hex = "2";
			break;
		case "0011":
			hex = "3";
			break;
		case "0100":
			hex = "4";
			break;
		case "0101":
			hex = "5";
			break;
		case "0110":
			hex = "6";
			break;
		case "0111":
			hex = "7";
			break;
		case "1000":
			hex = "8";
			break;
		case "1001":
			hex = "9";
			break;
		case "1010":
			hex = "a";
			break;
		case "1011":
			hex = "b";
			break;
		case "1100":
			hex = "c";
			break;
		case "1101":
			hex = "d";
			break;
		case "1110":
			hex = "e";
			break;
		case "1111":
			hex = "f";
			break;

		}
		return hex;
	}
	
}
