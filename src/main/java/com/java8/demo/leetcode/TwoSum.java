package com.java8.demo.leetcode;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) throws IllegalAccessException {
		int[] nums = { 2, 7, 11,15 };
		int target = 17;
		TwoSum twoSumX = new TwoSum();
		System.out.println(Arrays.toString(twoSumX.twoSum(nums, target)));
	}

	public int[] twoSum(int[] nums, int target) throws IllegalAccessException {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalAccessException("No such numbers found");
	}
}
