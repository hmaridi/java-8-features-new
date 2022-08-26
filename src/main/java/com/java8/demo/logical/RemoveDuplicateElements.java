package com.java8.demo.logical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		List<Integer> withDups = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 3, 1, 9, 9, 4, 1, 5);
		List<Integer> withoutDups = withDups.stream().distinct().collect(Collectors.toList());
		System.out.println("Without Duplicates " + withoutDups);

	}

}
