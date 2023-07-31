package MultiThreading;

class Thread11 extends Thread
{
	private int number;
	 Thread11(int number){
		 this.number = number;
	 }
	 
	 public void run() {
		 //Revering the number 
		 
		 for(int i = number ; i >=0 ; i--)
			 System.out.println("Reverse numbers : " + i);
	 }
}

class Thread12 extends Thread{
	 
	private int number;
	 Thread12(int number){
		 this.number = number;
	 }
	 public void run() {
		 
		 //Addition of number 
		 int sum = 0;
		 for(int i = 1 ; i < number ; i++)
			 sum += i;
		 
		 System.out.println("Sum of nuumbers are : " + sum );
	 }
}

public class Question3 extends Thread{
	
	private int number;
	 public Question3(int number){
		 this.number = number;
	 }
	
	public void run() {
		int a=0,b=1,c;
		System.out.println("Fibonacci series is : " +a);
		System.out.println("Fibonacci series is : " +b);
		for(int i = 0 ; i < number ; i++) {
			c = a+b;
			a=b;
			b=c;
			System.out.println("Fibonacci series is : " + c);
		}
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread11 t1 = new Thread11(10);
		
		Thread12 t2 = new Thread12(10);
		
		Question3 t3 = new Question3(10);
		
		t1.start();
		t2.start();
		t3.start();

	}

}
