
public class PartitionEqualSumProblem {

	public static void main(String[] args) {

		int arr[] = { 3, 1, 1, 2, 2, 1 };
		int n = arr.length;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}

		boolean result = sumSubSet(arr, n, sum);
		System.out.println(result);
	}

	private static Boolean sumSubSet(int[] arr, int n, int sum) {

		boolean result = false;
		if (sum % 2 != 0) {
			return false;
		} else if (sum % 2 == 0) {
			sum = sum / 2;
			Boolean m[][] = new Boolean[n + 1][sum + 1];

			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < sum + 1; j++) {
					if (i == 0) {
						m[i][j] = false;
					}
					if (j == 0) {
						m[i][j] = true;
					}
				}
			}
			result = sumSubSetMemoixation(arr, n - 1, sum, m);
		}
		return result;
	}

	private static Boolean sumSubSetMemoixation(int[] arr, int n, int s, Boolean[][] m) {

		if (s == 0) {
			return true;
		}
		if (n - 1 < 0) {
			return false;
		} else if (arr[n - 1] <= s) {
			return m[n][s] = sumSubSetMemoixation(arr, n - 1, s - arr[n - 1], m)
					|| sumSubSetMemoixation(arr, n - 1, s, m);
		} else {
			return sumSubSetMemoixation(arr, n - 1, s, m);
		}

	}

}
