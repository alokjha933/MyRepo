package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DupilicateElement {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 1, 4, 3, 2, 3, 1, 5, 6, 5, 7, 6, 9 };
		String word = "Hey Alok";
		List<String> str1 = Arrays.asList(word.split(" "));

		str1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.forEach(i -> {
					System.out.println(i.getKey() + " " + i.getValue());
				});
		Long a = str1.stream().collect(Collectors.counting());
		System.out.println(a);
		List<String> listContainingDuplicates = new LinkedList<String>();
		for (int i = 0; i < arr.length; i++) {
			listContainingDuplicates.add(String.valueOf(arr[i]));
		}

		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();

		for (String yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				setToReturn.add(yourInt);
			}
		}

		System.out.println(setToReturn);
	}
}
