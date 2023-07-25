package ExceptionHandling;

import java.util.Scanner;

class InvalidPasswordException extends Exception{
	
	InvalidPasswordException(String message)
	{
		super(message);
	}
}

public class CheckPassword {

	public static void main(String[] args) throws InvalidPasswordException{
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the password : ");
		
		String password = sc.nextLine();
		
		if(password.length() < 8 ) {
			throw new InvalidPasswordException("password length is less than 8 characters type strong password!!");
		}
		else if(!checkValid(password)){
			throw new InvalidPasswordException("password is not valid!!");
			
		}
		else {
			System.out.println("Valid Password!!");
		}

	}

	/**
	 * This method is checking the password have the character and digit type value only
	 * if its so it returns true if its false it returns false 
	 * 
	 * 
	 * @param password is the first parameter
	 * @return boolean value
	 */
	private static boolean checkValid(String password) {
		
		boolean isDigitPresent = false;
		boolean isAlphaPresent = false;
		
		for(int i = 0 ; i < password.length() ; i++) {
			
			
			if(Character.isDigit(password.charAt(i))){
//				System.out.println("number");
				isDigitPresent = true;
				continue;
			}
			else if(Character.isAlphabetic(password.charAt(i))) {
//				System.out.println("character");
				isAlphaPresent = true;
				continue;
				
			}
			else {
//				System.out.println("symbol");
				return false;
			}
			
			
		}
		
		
		return (isAlphaPresent && isDigitPresent);
	}
}
