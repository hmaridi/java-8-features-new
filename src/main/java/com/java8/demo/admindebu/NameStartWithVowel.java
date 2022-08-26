package com.java8.demo.admindebu;

import java.util.Arrays;
import java.util.List;

public class NameStartWithVowel {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Debu", "Tech", "India", "Bengal", "Apple", "Elephant");
		list.stream().map(str ->  str.toUpperCase()).filter(st -> (st.startsWith("A") || st.startsWith("E") || st.startsWith("I") || st.startsWith("O") || st.startsWith("U")))
        .forEach(s -> System.out.print(s + " ,"));

	}

}
