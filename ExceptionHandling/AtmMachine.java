package ExceptionHandling;

import java.util.Scanner;

class InvalidException  extends Exception{
	
	public InvalidException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	
}

public class AtmMachine {
	
	String accountbalance;
	
	String withdrawlAmount;
	
	
	

	public static void main(String[] args) throws InvalidException {
		
		AtmMachine atm = new AtmMachine();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Account Balance :");
		
		String accountBalance  = sc.nextLine();
		
		System.out.println("Enter the Account Withdrawl amount :");
		
		String withdrawlAmount  = sc.nextLine();
		
		try {
			int balance = Integer.parseInt(accountBalance);
		
			int withdraw = Integer.parseInt(withdrawlAmount);
			
			if(balance <= 0 || withdraw < 0 || withdraw > balance) {
				throw new InvalidException("Give the correct balance and withdrawal amount ");
			}
		
		}
		catch(NumberFormatException e) {
			throw new InvalidException("Give correct format ");
		}
	}

}
