package com.java8.demo.leetcode;

public class ToLowerCaseString {

	public static void main(String[] args) {
		String str = "HarI";
		String toLowerCase = toLoweCase(str);
		System.out.println("LowerCase String is -> " + toLowerCase);

	}

	private static String toLoweCase(String str) {
		String result = "";
		for (char ch : str.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				result = result + (char) (ch + 32);
			} else {
				result = result + ch;
			}
		}
		return result;
	}

}
