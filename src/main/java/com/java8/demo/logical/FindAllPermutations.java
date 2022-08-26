package com.java8.demo.logical;

public class FindAllPermutations {

	public static void main(String[] args) {
		String str=Permutations(0, "HARI");
		System.out.println(str);
	}

	private static String Permutations(int fixed, String str) {
		char[] charx = str.toCharArray();
		if (fixed == str.length()) {
			System.out.println(str);
			for (int i = fixed; i < str.length(); i++) {
				char c = charx[i];
				charx[i] = charx[fixed];
				charx[fixed] = c;
				Permutations(fixed + 1, new String(charx));

			}
		}
		return str;
	}

}
