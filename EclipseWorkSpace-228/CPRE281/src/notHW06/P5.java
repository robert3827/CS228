package notHW06;

import java.util.ArrayList;
import java.util.Scanner;

public class P5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		
		System.out.println(builtIn(input));
		System.out.println(decToBinary(input));
		
		scan.close();

	}
	public static String builtIn(int input) {
		return Integer.toBinaryString(input);
	}
	
	public static String decToBinary(int input) {
		ArrayList<Integer> bin = new ArrayList<>();
		String flipBin = "";
		int remainder;//either 1 or zero
		
		while(input >= 2) {
			remainder = input%2;
			input/=2;
			bin.add(remainder);
		} 
		if(input==0) {
			bin.add(0);
		} else {
			bin.add(1);
		}
		for(int i=bin.size()-1;i>=0;i--) {
			flipBin+=bin.get(i);
		}
		
		return flipBin;
		
		
	}
	
}
