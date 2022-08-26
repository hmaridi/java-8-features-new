package com.java8.demo.logical;

import java.util.Arrays;

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 6 };
		int n = 6;
		int idealSum = (n * (n + 1) / 2);
		int sum = Arrays.stream(numbers).sum();
		int missingNum = idealSum - sum;
		System.out.println("Missing Number is " + missingNum);

	}

}
