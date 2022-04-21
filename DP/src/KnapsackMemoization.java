import java.util.Scanner;

public class KnapsackMemoization {

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

		// memoization

		int memoization[][] = new int[n + 1][wt + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < wt + 1; j++) {
				memoization[i][j] = -1;
			}
		}

		int max = knapsack(w, v, wt, n, memoization);
		System.out.println(max);
	}

	private static int knapsack(int[] w, int[] v, int wt, int n, int[][] memoization) {
		int m = 0;
		if (n - 1 <= 0 || wt == 0) {
			return 0;
		}

		if (memoization[n][wt] != -1) {
			return memoization[n][wt];
		} else if (w[n - 1] <= wt) {
			return memoization[n][wt] = Math.max(v[n - 1] + knapsack(w, v, wt - (w[n - 1]), n - 1, memoization),
					knapsack(w, v, wt, n - 1, memoization));
		} else {
			return memoization[n][wt] = knapsack(w, v, wt, n - 1, memoization);
		}
	}
}
