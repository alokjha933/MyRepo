import java.util.*;

public class Knapsack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int w[] = new int[3];
		int v[] = new int[3];

		for (int i = 0; i < w.length; i++) {
			w[i] = sc.nextInt();
		}
		for (int i = 0; i < w.length; i++) {
			v[i] = sc.nextInt();
		}
		int wt = sc.nextInt();
		int n = w.length;
		int max = knapsack(w, v, wt, n);
		System.out.println(max);
	}

	private static int knapsack(int[] w, int[] v, int wt, int n) {
		int m = 0;
		if (n - 1 <= 0 || wt == 0) {
			return 0;
		} else if (w[n - 1] <= wt) {
			return Math.max(v[n - 1] + knapsack(w, v, wt - (w[n - 1]), n - 1), knapsack(w, v, wt, n - 1));
		} else {
			return knapsack(w, v, wt, n - 1);
		}
	}
}
