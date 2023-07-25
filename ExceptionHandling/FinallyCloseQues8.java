package ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinallyCloseQues8 {

	public static void main(String[] args)throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the file name : ");
		
		String st  = sc.next();
		
		
		
		
		
		try {
			File file = new File("C:\\Users\\adars\\eclipse-workspace\\Assignment3\\src\\main\\java\\ExceptionHandling\\"+st);
				
			readFile(file);
		}
		catch(Exception e) {
			throw new FileNotFoundException("Give correct file name ");
		}
	    
	}

	private static void readFile(File file) throws Exception{
		
		Scanner sc = new Scanner(file);
		try {
		
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			sc.close();
		}
		
		
		
		
	}

}
