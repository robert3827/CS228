package hw06;

import java.util.Scanner;

public class P10 {
	public static void main(String[] args) {
		
		addAll3Bit();
	}
	
	
	
	public static void addAll3Bit() {
		
		
	}
	
	public static void addUp(int[] arr1, int[] arr2) {
		int carry1;
		int carry2;
		int carry3;
		int[] sum = new int[3];
		int[] response = addDigits(arr1[2], arr1[2], 0);
		sum[2] = response[0];
		carry1 = response[1];
		
		
	}
	public static int[] addDigits(int first, int second, int carry) {
		int[] arr = new int[2];
		//{sum, carry}
		if(first + second + carry ==3) {
			arr[0] = 1;
			arr[1] = 1;
		} else if (first + second ==2) {
			arr[0] = 0;
			arr[1] = 1;
		} else if (first+second ==1){
			arr[0] = 1;
			arr[1] = 0;
		} else {//1st + 2nd ==0
			arr[0] = 0;
			arr[1] = 0;
		}
		return arr;
	}
	
	
}
