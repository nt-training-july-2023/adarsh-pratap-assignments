package ExceptionHandling;

import java.util.Scanner;

class InvalidDimensionException extends Exception{
	
	public InvalidDimensionException(String message ){
		
		super(message);
	}
	
}

public class AreaOfRectangle  {
	
	static double area(int length , int breadth ) throws InvalidDimensionException{
		
		if(length <= 0 || breadth <= 0) {
			throw new InvalidDimensionException("Give correct length breadth to get the Area of rectangle ");
		}
		
		return length*breadth;
	}
	

	public static void main(String[] args) throws InvalidDimensionException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the length of the rectangle : ");
		
		int length = sc.nextInt();
		
		System.out.println("Enter the breadth of the rectangle : ");
		
		int breadth = sc.nextInt();
		
		System.out.println(AreaOfRectangle.area(length, breadth));
		
		
	}

}
