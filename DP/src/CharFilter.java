import java.util.*;

public class CharFilter {

	public static void main(String[] args) {

		String[] str = { "Sdf", "1Agt", "T123G", "zhji" };
		String[] s1 = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			String s = str[i];
			if (s.charAt(0) >= 65 && s.charAt(0) <= 123) {
				s1[i] = s;
			}
		}
		for (int i = 0; i < s1.length; i++) {
			if (s1[i] != null) {
				System.out.println(s1[i]);
			}
		}
	}

}
