package com.java8.demo.logical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharcterFrequencyInWord {

	public static void main(String[] args) {
		String data = "HelloWorld";

		// Logic-1
		Map<String, Long> longCount = Arrays.asList(data.split("")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Counting - " + longCount); // Java 8 Logic
		
		// Logic-2
		Stream.of(data.toLowerCase().split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet()
			  .stream().map(e -> e.getKey() + "=" + e.getValue() + " ").forEach(System.out::print);

		// Logic-3
		char[] charArray = data.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : charArray) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		System.out.println("Counting - " + map); // Normal Logic

	}
}