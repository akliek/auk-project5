package src.part3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	public static String getUserString(Scanner scanner) {
		return  scanner.nextLine();
	}

	public static boolean continueCalculation(Scanner scanner) {
		System.out.print("Press 'y' or 'Y' to continue: ");
		String input = getUserString(scanner);
		return input.equals("y") || input.equals("Y");
	}

	public static double getUserDouble(Scanner scanner) {
		while (true) {
			try {
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.print("\u001B[31mIt is not a number. Try again: \u001B[0m");
			}
		}
	}

	public static void main(String[] args) {
		String operation;
		double operand1, operand2;
		Scanner scanner = new Scanner(System.in);

		System.out.println("This program is a simple calculator.");
		do {
			System.out.print("Please, enter the first operand: ");
			operand1 = getUserDouble(scanner);
			scanner.nextLine();

			System.out.print("Please, enter the operation(+, -, *, \\): ");
			operation = getUserString(scanner);

			System.out.print("Please, enter the second operand: ");
			operand2 = getUserDouble(scanner);

			switch (operation) {
				case "+" -> System.out.println(operand1 + " + " + operand2 + " = " + (operand1 + operand2));
				case "-" -> System.out.println(operand1 + " - " + operand2 + " = " + (operand1 - operand2));
				case "*" -> System.out.println(operand1 + " * " + operand2 + " = " + (operand1 * operand2));
				case "\\" -> {
					if (operand2 == 0) {
						System.out.println("Division by zero is not allowed.");
					} else {
						System.out.println(operand1 + " \\ " + operand2 + " = " + (operand1 / operand2));
					}
				}
				default -> System.out.println("Unknown operation.");
			}

			scanner.nextLine();
		} while (continueCalculation(scanner));
	}
}
