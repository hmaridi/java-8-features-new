package com.java8.demo.logical;

import java.util.Arrays;

public class MoveAllZerosEndOfArray {
	public static void main(String[] args) {
		int[] arr = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
		int k = 0;
		int output[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				output[k++] = arr[i];
			}
		}

		System.out.println(Arrays.toString(output));
	}

}
