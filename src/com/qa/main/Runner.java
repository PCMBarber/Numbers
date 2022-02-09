package com.qa.main;

public class Runner {
	public static void main(String[] args) {
		Numbers num = new Numbers();
		System.out.println(num.twoDigits(14));
		
		for(int i = 0; i<100000; i++) {
			System.out.println(num.convertToString(i));
		}
	}
}
