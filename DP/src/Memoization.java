
public class Memoization {

	public static void main(String[] args) {
		System.out.println(fib(5));
	}

	// 1,1,2,3,5,8,13,21,32,.....
	private static long fib(long n) {
		System.out.println(n);
		long result = 0;
		if (n <= 2) {
			return 1;
		} else {
			result = fib(n - 1) + fib(n - 2);
			return result;
		}
	}
}
