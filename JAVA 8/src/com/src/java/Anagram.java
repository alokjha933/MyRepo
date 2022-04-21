package com.src.java;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Anagram {

	public static void main(String[] args) {

		String str1 = "heart";
		String str2 = "earth";

		boolean flag = false;

		if (str1.length() != str2.length()) {
			flag = false;
		} else {

			/*
			 * char[] c1 = str1.toCharArray(); char[] c2 = str2.toCharArray();
			 * 
			 * Arrays.sort(c1); Arrays.sort(c2); flag = Arrays.equals(c1, c2);
			 */
			Character ch;
			Map<Character, Integer> mapForStr1 = new TreeMap<Character, Integer>();
			for (int i = 0; i < str1.length(); i++) {
				ch = str1.charAt(i);
				if (mapForStr1.get(ch) == null) {
					mapForStr1.put(ch, 1);
				} else {
					mapForStr1.put(ch, (mapForStr1.get(ch) + 1));

				}
			}
			Map<Character, Integer> mapForStr2 = new HashMap<Character, Integer>();
			for (int i = 0; i < str2.length(); i++) {
				ch = str2.charAt(i);
				if (mapForStr2.get(ch) == null) {
					mapForStr2.put(ch, 1);
				} else {
					mapForStr2.put(ch, (mapForStr2.get(ch) + 1));

				}
			}
			flag = mapForStr1.equals(mapForStr2);
		}

		if (flag) {
			System.out.println(str1 + " and " + str2 + " are Anagrams");
		} else {
			System.out.println("Not Anagram");
		}
	}
}
