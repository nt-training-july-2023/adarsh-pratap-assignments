package InputOutputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseTheString {

	public static void main(String[] args) {
		
		try {
			BufferedReader fin = new BufferedReader(new FileReader("C:\\Users\\adars\\eclipse-workspace\\InputOutputStream\\src\\InputOutputStream\\Read.txt"));
			BufferedWriter fout = new BufferedWriter(new FileWriter("C:\\Users\\adars\\eclipse-workspace\\InputOutputStream\\src\\InputOutputStream\\write.txt"));
			
			int i;
			
			String st = "";
			
			String ans = "";
			
			while((st = fin.readLine() )!= null) {
//				System.out.print(st);
				st = st+System.lineSeparator();
				ans = st+ans;

			}
			System.out.println(ans);
			
			fout.write(ans);
			fin.close();
			fout.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
