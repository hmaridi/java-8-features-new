package com.java8.demo.logical;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StringFrequency {
	public static void main(String... args) {
		String[] wordArray = { "House", "House", "House", "Dog", "Dog", "Dog", "Dog" };
		Map<Object, Long> freq = Arrays.stream(wordArray).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(freq);
	}
}
