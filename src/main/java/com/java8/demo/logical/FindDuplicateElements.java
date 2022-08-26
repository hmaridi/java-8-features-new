package com.java8.demo.logical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElements {

	public static void main(String[] args) {
		// First Approach
		Integer[] numbers = new Integer[] { 5, 3, 4, 1, 3, 7, 2, 3, 1, 9, 9, 4, 1, 5 };
		Set<Integer> setNumx = new HashSet<Integer>();
		Set<Integer> duplicates = Arrays.stream(numbers).filter(x -> !setNumx.add(x)).collect(Collectors.toSet());
		System.out.println("Duplicates " + duplicates);

	}

}
