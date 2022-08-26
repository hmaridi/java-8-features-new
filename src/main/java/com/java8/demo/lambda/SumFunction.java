package com.java8.demo.lambda;

public class SumFunction {

	public static void main(String[] args) {
		Sumable sumable = (x, y) -> x + y;
		int result = sumable.calculate(899, 900);
		System.out.println("Result " + result);
	}

}
