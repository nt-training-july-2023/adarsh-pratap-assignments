package ExceptionHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class AccessingList {

	public static void main(String[] args) throws IndexOutOfBoundsException , NullPointerException {
		
		String st[] = {"Adarsh", "Singh" , "Parihar"};
		
//		ArrayList<String> arraylist = new ArrayList<>();
 		
		System.out.println("Enter Index to get the element at that position : ");
		Scanner sc = new Scanner(System.in);
		
		
		
		int n = sc.nextInt();
		
		if(n<0 || n > st.length) {
			throw new IndexOutOfBoundsException("You are entering the index out of range of the array");
		}
		else {
			System.out.println(st[n]);
		}
		
		
	}

}
