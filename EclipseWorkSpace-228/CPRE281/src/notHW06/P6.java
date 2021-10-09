package notHW06;

import java.util.ArrayList;
import java.util.Scanner;

public class P6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(correctAns(input));
		ArrayList<Integer> bin = new ArrayList<>();// array that will hold the binary digits
//		decToBinary(input, bin);
//		System.out.println(binToHex(bin));

		scan.close();
	}

	private static void decToBinary(int input, ArrayList<Integer> bin) {
		int remainder;// either 1 or zero
		ArrayList<Integer> flipBin = new ArrayList<Integer>();
		while (input >= 2) {
			remainder = input % 2;
			input /= 2;
			bin.add(remainder);
		}
		if (input == 0) {
			bin.add(0);
		} else {
			bin.add(1);
		}
		for (int i = bin.size() - 1; i >= 0; i--) {
			flipBin.add(bin.get(i));
		}
		bin.removeAll(bin);
		bin.addAll(flipBin);
	}

	private static String correctAns(int input) {
		return Integer.toHexString(input);
	}

	private static String binToHex(ArrayList<Integer> bin) {
		String hex = "";
		String digits = "";
		while ((bin.size() % 4) != 0) {
			bin.add(0, 0);

		}
		for (int i = 0; i < bin.size(); i += 4) {// each 4 bits
			for (int j = 0; j < 4; j++) {
				digits += bin.get(i);
				hex += getHex(digits);
			}
		}
		return hex;
	}

	private static String getHex(String fourBin) {
		String hex = "";
		switch (fourBin) {
		case "0000":
			hex = "0";
		case "0001":
			hex = "1";
		case "0010":
			hex = "2";
		case "0011":
			hex = "3";
		case "0100":
			hex = "4";
		case "0101":
			hex = "5";
		case "0110":
			hex = "6";
		case "0111":
			hex = "7";
		case "1000":
			hex = "8";
		case "1001":
			hex = "9";
		case "1010":
			hex = "a";
		case "1011":
			hex = "b";
		case "1100":
			hex = "c";
		case "1101":
			hex = "d";
		case "1110":
			hex = "e";
		case "1111":
			hex = "f";

		}
		return hex;
	}

}
