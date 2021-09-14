package rec3;

import java.io.File;

public class ExceptionHandling {
	//Can't operate on null. sad :(
	//
	
	public static void main(String[] args) {
		try {
			File file = new File("someFile.txt");
		} catch (Exception e) {
			System.out.println("No File Here");
		}
		
		finally {
			
			System.out.println("Done");
		}
		//legal but not particularly useful
		try {
			
		}
		finally {
			
		}
		
		
	}
	
	
}