package MultiThreading;

class StateOfThread implements Runnable{

	@Override
	public void run() {
		
		System.out.println("State of thread is : " + Thread.currentThread().getState()) ;
		
	}
	
}

public class ThreadState {

	public static void main(String[] args) {
		Runnable st = new StateOfThread();
		Thread t1 = new Thread(st);
		
		
		System.out.println("State of thread is : " + t1.getState()) ;
		t1.start();
		
		System.out.println("State of thread is : " + t1.getState()) ;
		
		try {
			t1.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
			System.out.println("State of thread is : " + t1.getState()) ;

		

	}

}
