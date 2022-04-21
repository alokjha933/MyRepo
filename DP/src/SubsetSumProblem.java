
public class SubsetSumProblem {

	public static void main(String[] args) {

		int[] a = { 1, 2, 7 };
		int s = 10;
		int n = a.length;

		Boolean memoization[][] = new Boolean[n + 1][s + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < s + 1; j++) {
				if (i == 0) {
					memoization[i][j] = false;
				}
				if (j == 0) {
					memoization[i][j] = true;
				}
			}
		}
		Boolean val = SubsetSumProblemFromMemoization(a, s, n, memoization);
		System.out.println("n: " + n + " " + "s: " + s + "=> " + val);
	}

	private static Boolean SubsetSumProblemFromMemoization(int[] a, int s, int n, Boolean[][] memoization) {
		if (s == 0) {
			return true;
		}
		if (n - 1 < 0) {
			return false;
		}
		if (memoization[n][s] != null && memoization[n][s] != false) {
			return true;
		} else if (a[n - 1] <= s) {
			return memoization[n][s] = SubsetSumProblemFromMemoization(a, s - a[n - 1], n - 1, memoization)
					|| SubsetSumProblemFromMemoization(a, s, n - 1, memoization);
		} else {
			return memoization[n][s] = SubsetSumProblemFromMemoization(a, s, n - 1, memoization);
		}
	}

}
