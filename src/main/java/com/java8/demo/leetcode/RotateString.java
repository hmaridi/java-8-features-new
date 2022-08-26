package com.java8.demo.leetcode;

public class RotateString {

	public static void main(String[] args) {
		String x = "hari";
		String y = "ihar";
		boolean boo = rotateString(x, y);
		System.out.println(boo);
	}

	private static boolean rotateString(String x, String y) {
		return (x.length() == y.length() && (x + x).contains(y));
	}

}
