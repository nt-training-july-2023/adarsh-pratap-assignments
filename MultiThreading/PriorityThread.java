package MultiThreading;

class Test extends Thread{
	public void run() {
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println(Thread.currentThread().getName() + " is running !!");
		}
	}
}

public class PriorityThread implements Runnable {

	public static void main(String[] args) {
		
		
		Thread t1 = new Thread(new PriorityThread());
		t1.setName("Adarsh");
		t1.setPriority(10);
		t1.start();
		

		Test t2 = new Test();
		t2.setName("Sachin");
		t2.setPriority(1);
		t2.start();

	}

	@Override
	public void run() {
		  for(int i = 0 ; i  <5 ; i++)
			  	System.out.println(Thread.currentThread().getName() + " is running !!");
		
	}

}
