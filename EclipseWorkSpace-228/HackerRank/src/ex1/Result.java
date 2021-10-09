package ex1;
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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int numPos = 0;
        int numNeg = 0;
        int numZero = 0;
        int numTotal = arr.size();
        for(int i=0;i<arr.size();i++) {
        	if(arr.get(i)>0) {
        		numPos++;
        	} else if(arr.get(i)<0) {
        		numNeg++;
        	} else {
        		numZero++;
        	}
        }
        double posRat = (double)numPos/numTotal;
        double negRat = (double)numNeg/numTotal;
        double zeroRat = (double)numZero/numTotal;
        
        System.out.printf("%.2f%n%.2f%n%.2f%n", posRat, negRat, zeroRat);


    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	arr.add(1);
    	arr.add(1);
    	arr.add(0);
    	arr.add(-1);
    	arr.add(-1);
		plusMinus(arr);
	}

}

//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        Result.plusMinus(arr);
//
//        bufferedReader.close();
//    }
//}
