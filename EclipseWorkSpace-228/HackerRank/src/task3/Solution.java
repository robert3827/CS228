package task3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Solution {
    /*
     * Complete the function below.
     */
    static int getNumberOfMovies(String substr) {
        /*
         * Endpoint: "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr"
         */
    	int number = -1;
    	String name = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
    	
    	try {
			URL url = new URL(name);
			InputStream input = url.openStream();
			System.out.println(input);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        return number;
    }
    public static void main(String[] args) {
		getNumberOfMovies("maze");
	}
}
