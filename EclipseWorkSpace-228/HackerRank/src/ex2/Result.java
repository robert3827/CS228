package ex2;

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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    
    ArrayList<Integer> maxList = new ArrayList<Integer>();
    ArrayList<Integer> minList = new ArrayList<Integer>();
    maxList.addAll(arr);
    minList.addAll(arr);
    maxList.remove(smallest(arr));
    minList.remove(biggest(arr));
    System.out.println(sum(minList) +" "+ sum(maxList));
    System.out.println();
    
    }
    public static int biggest(List<Integer> arr) {
    	int biggest = arr.get(0);//indice of biggest
    	int biggestInd = 0;
    	for(int i=0;i<arr.size();i++) {
        	if(arr.get(i) > biggest) {
        		biggest = arr.get(i);
        		biggestInd = i;
        	}
    	}
    	return biggestInd;
    }
    public static int smallest(List<Integer> arr) {
    	int smallest = arr.get(0);//indice of biggest
    	int smallestInd = 0;
    	for(int i=0;i<arr.size();i++) {
        	if(arr.get(i) < smallest) {
        		smallest = arr.get(i);
        		smallestInd = i;
        	}
    	}
    	return smallestInd;
    }
    public static long sum(List<Integer> arr) {
		long sum = 0;
		for(int i=0;i<arr.size();i++) { 
			sum += arr.get(i);
		}
    	
    	return sum;	
    }

    public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(7);//22 max // 16 min
		a.add(6);
		a.add(4);
		a.add(5);
		a.add(1);
		
		miniMaxSum(a);
		
	}
}

