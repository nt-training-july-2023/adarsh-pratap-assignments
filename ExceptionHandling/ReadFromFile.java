package ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\adars\\eclipse-workspace\\Assignment3\\src\\main\\java\\ExceptionHandling\\file.txt");
		
		
		try {
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}

		}
		catch(Exception e) {
			throw new FileNotFoundException("File Path is not correct or the file is not present ");
		}
	}

}
