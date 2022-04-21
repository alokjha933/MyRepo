import java.util.HashSet;

class Pair {
	public int indexNo;
	public int value;

	public Pair(int indexNo, int value) {
		this.indexNo = indexNo;
		this.value = value;
	}
}

public class ReverseString {

	public static void main(String[] args) {

		Pair[] p = new Pair[4];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Pair(i + 1, i + 2);
		}

		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < p.length; i++) {
			set.add(p[i].indexNo + " , " + p[i].value);
		}

		for (String s : set) {
			System.out.println(s);
		}

	}
}
