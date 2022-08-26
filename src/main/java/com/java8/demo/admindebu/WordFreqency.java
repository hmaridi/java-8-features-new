package com.java8.demo.admindebu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Date: 13/8/2022 2:26 PM
 */
public class WordFreqency {

	public static void main(String[] args) {
		List<String> wordsList = Arrays.asList("Debu", "morning", "hi", "hi", "hello", "morning");

		Map<String, Long> collect = wordsList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
	}

}
