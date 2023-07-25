package ExceptionHandling;

import java.util.Scanner;

class NotEvenNumberException extends Exception{
	
	public NotEvenNumberException (String message) {
		super(message);
	}
}

public class IsEven {

	public static void main(String[] args) throws NotEvenNumberException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number : ");
		
		String input = sc.next();
		
		try {
			int number = Integer.parseInt(input);
			
			if(number%2 == 0) {
				System.out.println("Its a even number ");
			}
			else {
				throw new NotEvenNumberException("Given number is a odd number");
			}
			
		}
		catch(Exception e){
			throw new NotEvenNumberException("Given number is not a number");
		}
		

	}

}
