/*
 * public class ThreadDemo extends Thread { public void run() {
 * System.out.println("thread running"); }
 * 
 * public static void main(String[] args) {
 * 
 * ThreadDemo t1 = new ThreadDemo(); t1.start(); }
 * 
 * }
 */

public class ThreadDemo implements Runnable {
	public void run() {
		System.out.println("thread running");
	}

	public static void main(String[] args) {

		int n = 10;
		for (int i = 0; i < n; i++) {
			ThreadDemo t1 = new ThreadDemo();
			Thread t = new Thread(t1);
			t.start();
		}

	}

}