package MultiThreading;

class ThreadMessage extends Thread{
	
	String message = null;
	public ThreadMessage(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5 ; i++)
			System.out.println("Thread1 is reading the message : " + message);
	}
	
}

class ThreadMessage2 extends Thread{
	
	String message = null;
	
	public ThreadMessage2(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5 ; i++)
			System.out.println("Thread2 is reading the message : " + message);
	}
}

public class SendingMessage {

	public static void main(String[] args) {
		
		ThreadMessage th1 = new ThreadMessage("Hi thread 1");
		ThreadMessage2 th2 = new ThreadMessage2("Hi thread 2");
		
		th1.start();
		th2.start();
		
	}
}
