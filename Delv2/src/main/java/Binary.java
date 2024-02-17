package com.ontariotechu.sofe3980U;

public class Binary {
	private String number; // Binary value as a string

	public Binary(String number) {
		this.number = number.matches("[01]+") ? number.replaceAll("^0+(?!$)", "") : "0";
	}

	public String getValue() {
		return this.number;
	}

	public static Binary or(Binary num1, Binary num2) {
		return performOperation(num1, num2, (a, b) -> a | b);
	}

	public static Binary and(Binary num1, Binary num2) {
		return performOperation(num1, num2, (a, b) -> a & b);
	}

	public static Binary multiply(Binary num1, Binary num2) {
		Binary result = new Binary("0");		for (int i = num2.number.length() - 1; i >= 0; i--) {
			if (num2.number.charAt(i) == '1') {
				String temp = num1.number + "0".repeat(num2.number.length() - 1 - i);
				result = add(result, new Binary(temp));
			}
		}
		return result;
	}

	public static Binary add(Binary num1, Binary num2) {
		StringBuilder result = new StringBuilder();
		int carry = 0;

		int maxLength = Math.max(num1.number.length(), num2.number.length());
		for (int i = 0; i < maxLength; i++) {
			int bit1 = i < num1.number.length() ? num1.number.charAt(num1.number.length() - 1 - i) - '0' : 0;
			int bit2 = i < num2.number.length() ? num2.number.charAt(num2.number.length() - 1 - i) - '0' : 0;
			int sum = bit1 + bit2 + carry;
			result.insert(0, sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			result.insert(0, carry);
		}
		return new Binary(result.toString());
	}

	private static Binary performOperation(Binary num1, Binary num2, BinaryOperator op) {
		StringBuilder result = new StringBuilder();
		int maxLength = Math.max(num1.number.length(), num2.number.length());

		for (int i = 0; i < maxLength; i++) {
			int bit1 = i < num1.number.length() ? num1.number.charAt(num1.number.length() - 1 - i) - '0' : 0;
			int bit2 = i < num2.number.length() ? num2.number.charAt(num2.number.length() - 1 - i) - '0' : 0;
			int operationResult = op.apply(bit1, bit2);
			result.insert(0, operationResult);
		}
		return new Binary(result.toString());
	}

	@FunctionalInterface
	private interface BinaryOperator {
		int apply(int a, int b);
	}
}
