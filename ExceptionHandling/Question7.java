package ExceptionHandling;

import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) throws NullPointerException , IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		
		
		
		int[] numbers = {1,2,3,4,5,6,7,8};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the index to get the element : ");
		
		int index = sc.nextInt();
		
		try {
			System.out.println("Given number at position "+ index + " is : " + numbers[index]);
		}
		catch(Exception e ) {
			throw new IndexOutOfBoundsException("Give the correct Index of array");
		}
		
		int[] array = null;
		
		
		try {
			int size = array.length;
		}
		catch(Exception e){
			throw new NullPointerException("Given reference is null");
		}
		

	}

}
