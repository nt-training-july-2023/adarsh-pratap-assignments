package MultiThreading;

class bank{
	int balance;
	
	public bank( int balance){
		this.balance = balance;
	}
	
	synchronized void creadit( int amount) {
		balance += amount;
		System.out.println("Balance is  :  " + balance +" "+ Thread.currentThread().getName());
	}
	
	synchronized void withdrawl( int amount) {
		balance -= amount;
		System.out.println("Balance is  :  " + balance+" "+ Thread.currentThread().getName());
	}
	
	void accountBalance() {
		System.out.println("FInal account Balance is  :  " + balance);
	}
	
}

public class BankingSystem extends Thread {
	
	int amount;
	bank b;
	
	
	
	public BankingSystem(int amount , bank b) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
		this.b = b;
		
	}
	
	
	
	public void run() {
		if(amount > 0 ) {
			b.creadit(amount);
		}
		else if(amount < 0) {
			b.withdrawl(-amount);
		}
		else {
			b.accountBalance();
		}
	}
	
	public static void main(String[] args) {
		
		bank b = new bank(100);
		
		BankingSystem bankingSystem1 = new BankingSystem(10, b);
		BankingSystem bankingSystem2 = new BankingSystem(-20, b);
		BankingSystem bankingSystem3 = new BankingSystem(50, b);
		BankingSystem bankingSystem4 = new BankingSystem(-30, b);
		BankingSystem bankingSystem5 = new BankingSystem(0, b);
		
		bankingSystem1.start();
		bankingSystem2.start();
		bankingSystem3.start();
		bankingSystem4.start();
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.accountBalance();
	}
	

}
