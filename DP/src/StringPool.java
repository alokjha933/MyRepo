
public class StringPool {

	enum abc {
		max, min;
	}

	public static void main(String[] args) {

		int[] a = { 2, 3, 6, 4, 1 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		int n = a[a.length - 1];
		int sum = n * (n + 1) / 2;
		int m = 0;

		for (int i1 = 0; i1 < a.length; i1++) {
			m = m + a[i1];
		}
		System.out.println(sum - m);
	}

}
