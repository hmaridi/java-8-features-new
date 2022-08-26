package com.java8.demo.logical;

import java.util.Arrays;
import java.util.List;

public class StartOneForGivenArray {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(10, 12, 50, 30, 18, 19);
		numbers.stream().map(x -> x + "").filter(x -> x.startsWith("1")).forEach(System.out::println);
	}

}
