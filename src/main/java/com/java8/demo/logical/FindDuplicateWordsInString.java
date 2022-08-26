package com.java8.demo.logical;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateWordsInString {

	public static void main(String[] args) {
		String input = "Google is the most popular search engine in the world. Bing comes at number two.";

		String[] str = input.split("\\s");

		Map<String, Integer> map = new HashMap<String, Integer>();

		int count = 0;

		for (int i = 0; i < str.length; i++) {
			count = 0;
			for (int j = 0; j < str.length; j++) {
				if (str[i].equals(str[j])) {
					count++;
				}

			}
			map.put(str[i], count);
		}
		System.out.println("Duplicate Words " + map);
	}

}
