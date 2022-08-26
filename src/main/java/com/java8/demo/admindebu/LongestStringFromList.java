package com.java8.demo.admindebu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LongestStringFromList {

	public static void main(String[] args) {
		List<String> wordsList = Arrays.asList("Debu", "morning", "hi", "hi", "hello");
		Optional<String> biggestStr = wordsList.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
		biggestStr.ifPresent(s -> System.out.println(s));
	}

}
