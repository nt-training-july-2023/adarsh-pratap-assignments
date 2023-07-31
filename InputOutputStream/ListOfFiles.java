package InputOutputStream;

import java.io.File;

public class ListOfFiles {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\adars\\eclipse-workspace\\InputOutputStream\\src\\InputOutputStream\\");
		
		String st[] = file.list();
		
		for(String i : st)
			System.out.println(i);

	}

}
