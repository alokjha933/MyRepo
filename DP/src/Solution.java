import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int n = 6;
		int[] mem = new int[n + 1];
		int val = fact(n, mem);
		System.out.println(val);
		for (int i = 0; i < n; i++) {
			System.out.print(mem[i] + " ");

		}
	}

	private static int fact(int n, int[] mem) {

		if (n <= 0) {
			return 1;
		}
		if (mem[n] == n) {
			return n * fact(n - 1, mem);
		} else {
			return mem[n] = n * fact(n - 1, mem);
		}
	}

}
