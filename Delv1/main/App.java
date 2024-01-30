package com.ontariotechu.sofe3980U;

import java.util.Scanner;
import org.joda.time.LocalTime;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		System.out.println("Enter the first binary number:");
		String input1 = scanner.nextLine();
		System.out.println("Enter the second binary number:");
		String input2 = scanner.nextLine();

		Binary binary1 = new Binary(input1);
		Binary binary2 = new Binary(input2);

		Binary sum = Binary.add(binary1, binary2);
		Binary orResult = Binary.or(binary1, binary2);
		Binary andResult = Binary.and(binary1, binary2);
		Binary multiplyResult = Binary.multiply(binary1, binary2);

		System.out.println("First binary number is " + binary1.getValue());
		System.out.println("Second binary number is " + binary2.getValue());
		System.out.println("Their summation is " + sum.getValue());
		System.out.println("Their bitwise OR is " + orResult.getValue());
		System.out.println("Their bitwise AND is " + andResult.getValue());
		System.out.println("Their multiplication is " + multiplyResult.getValue());

		scanner.close();
	}
}
