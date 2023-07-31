package MultiThreading;

public class AnonymousThread {
	
	public static void main(String[] args) {
		new  Thread() {
			public void run() {
				System.out.println("Running");
			}}.start();
	
	}

}
