package com.qa.main;

public class Numbers {

	private String[] oneDigit = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

	private String[] teen = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	private String[] tens = { "Zero", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	private String[] zeros = { "Hundred", "Thousand", "Million" };

	public String convertToString(int number) {
		if (number >= 0) {
			String numberString = String.valueOf(number);
			switch (numberString.length()) {
			case 1:
				return singleDigit(number);
			case 2:
				return twoDigits(number);
			case 3:
				return threeDigits(number);
			case 4:
				return fourDigits(number);
			case 5:
				return fiveDigits(number);
			}
		}
		return "Invalid number";
	}

	public String singleDigit(int number) {
		return oneDigit[number];
	}

	public String twoDigits(int number) {
		int secondDigit = number % 10;
		int firstDigit = (number - secondDigit) / 10;
		if (number < 20) {
			return teen[secondDigit];
		} else {
			return tens[firstDigit] + " " + singleDigit(secondDigit);
		}
	}
	
	public String threeDigits(int number) {
		int lastTwoDigits = number % 100;
		int firstDigit = (number - lastTwoDigits) / 100;
		return oneDigit[firstDigit] + " " + zeros[0] + " and " + twoDigits(lastTwoDigits);
	}
	
	public String fourDigits(int number) {
		int lastThreeDigits = number % 1000;
		int firstDigit = (number - lastThreeDigits) / 1000;
		return oneDigit[firstDigit] + " " + zeros[1] + " " + threeDigits(lastThreeDigits);
	}
	
	public String fiveDigits(int number) {
		int lastFourDigits = number % 10000;
		int lastThreeDigits = lastFourDigits % 1000;
		int firstTwoDigits = (number - lastThreeDigits) / 1000;
		return twoDigits(firstTwoDigits) + " " + zeros[1] + " " + threeDigits(lastThreeDigits);
	}
}
