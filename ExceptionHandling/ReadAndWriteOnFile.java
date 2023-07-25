package ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadAndWriteOnFile {

	public static void main(String[] args) throws FileNotFoundException , Exception {
		
//		FileReader fr = new FileReader(C:\Users\adars\eclipse-workspace\Assignment3\src\main\java\ExceptionHandling\file.txt);
//		
//		FileWriter fw = new FileWriter(C:\Users\adars\eclipse-workspace\Assignment3\src\main\java\ExceptionHandling\Untitled2.txt);
		
		
		
		Scanner s = new Scanner(System.in);
		
		try {
		System.out.println("Enter the first file name : ");
		
		String file1 = s.next();
		
		File file = new File("C:\\Users\\adars\\eclipse-workspace\\Assignment3\\src\\main\\java\\ExceptionHandling\\"+file1);
		
		System.out.println("Enter the second file name : ");
		
		String file2 = s.next();
		
		
		
		
		Scanner sc = new Scanner(file);
		String st = "";
		
		while(sc.hasNextLine()) {
			st +=sc.nextLine();
			st += System.lineSeparator();
		}
		
		
		System.out.println(st);
		sc.close();
		FileWriter toWrite = new FileWriter("C:\\Users\\adars\\eclipse-workspace\\Assignment3\\src\\main\\java\\ExceptionHandling\\"+file2);
		
		toWrite.write(st);
		toWrite.close();
		
		}
		catch(Exception e) {
			throw new FileNotFoundException("Provide correct file  name : ");
		}
		
		
		
		
	}

}
