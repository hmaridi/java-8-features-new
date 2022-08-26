package com.java8.demo.leetcode;

public class RemovedDuplicateSortedArray {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int num = removeDuplicates(nums);
		System.out.println("Removed Duplicate Numbers " + num);

	}

	public static int removeDuplicates(int[] nums) {
		int currIndex = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != nums[currIndex])
				nums[++currIndex] = nums[i];
		return currIndex + 1;
	}

}
