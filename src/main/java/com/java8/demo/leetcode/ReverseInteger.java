package com.java8.demo.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		int intx = -765;
		int i = reverseInteger(intx);
		System.out.println("Reverse Integer is " + i);
	}

	private static int reverseInteger(int intx) {
		long r = 0;
		while (intx != 0) {
			int temp = intx % 10;
			r = (r * 10) + temp;
			intx = intx / 10;
		}
		if (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) r;

	}

}
