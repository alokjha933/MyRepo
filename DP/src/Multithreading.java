
public class Multithreading implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " is running");
	}

	public static void main(String[] args) {
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			Thread obj = new Thread(new Multithreading());
			obj.start();
		}
	}
}
