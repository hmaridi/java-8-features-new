package com.java8.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		boolean b = containsDuplicate(nums);
		System.out.println("status  -" + b);

	}

	private static boolean containsDuplicate(int[] nums) {
		Set<Integer> temp = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i])) {
				return true;
			}
			temp.add(nums[i]);
		}
		return false;
	}

}
