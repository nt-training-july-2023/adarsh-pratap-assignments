package InputOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteFromFIle {

	public static void main(String[] args) {
		
		try {
			BufferedInputStream bio = new BufferedInputStream(new FileInputStream("C:\\Users\\adars\\eclipse-workspace\\InputOutputStream\\src\\InputOutputStream\\Read.txt"));
			
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("C:\\Users\\adars\\eclipse-workspace\\InputOutputStream\\src\\InputOutputStream\\write.txt"));
			
			String st = "";
			
			
			
			int i = 0 ;
			
			
			while((i = bio.read())!=-1) {
				st += (char)i;
				
			}
			
			byte[] b = st.getBytes();
			
			output.write(b);
			
			System.out.println("Copied!!");
			bio.close();
			output.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
