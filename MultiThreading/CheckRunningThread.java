package MultiThreading;

import java.util.concurrent.ThreadPoolExecutor;

class Thread1 extends Thread{
	
	public void run() {
		for(int i = 0 ; i < 5 ; i++)
			System.out.println(Thread.currentThread().getName());
	}
	
}

class Thread2 extends Thread{
	public void run() {
		for(int i = 0 ; i < 5 ; i++)
			System.out.println(Thread.currentThread().getName());
	}
}

public class CheckRunningThread implements Runnable{

	public static void main(String[] args) {
		
		Runnable r = new CheckRunningThread();
		Thread t = new Thread(r);
	
		
		t.start();
		
		
		
		Thread t1 = new Thread1();
		t1.start();
		
		Thread2 t2 = new Thread2();
		t2.start();
		
		

	}

	@Override
	public void run() {
		for(int i = 0 ; i < 5 ; i++)
			System.out.println(Thread.currentThread().getName());
		
		
	}

}
