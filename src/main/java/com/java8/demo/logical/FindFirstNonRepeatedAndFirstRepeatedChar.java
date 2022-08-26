package com.java8.demo.logical;

public class FindFirstNonRepeatedAndFirstRepeatedChar {

	public static void main(String[] args) {
		String s = "sadbsjda";
		char nonRepeat = findFirstNonRepeatableChar(s);
		char repeat = findFirstRepeatableChar(s);
		System.out.println("First Non-Repeated Character In - " + nonRepeat);
		System.out.println("First Repeated Character In - " + repeat );
	}

	public static Character findFirstNonRepeatableChar(String str) {
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (str.lastIndexOf(str.charAt(i)) == i) {
				return str.charAt(i);
			}
		}
		return 0;
	}

	public static Character findFirstRepeatableChar(String str) {
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (str.lastIndexOf(str.charAt(i)) > i) {
				return str.charAt(i);
			}
		}
		return 0;
	}

}