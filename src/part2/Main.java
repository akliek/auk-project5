package src.part2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
function printString(str)
    output str

function getUserString(scanner)
    return scanner.nextLine()

function getUserInt(scanner)
    while true
        try
            input = scanner.nextInt()
            return input
        catch InputMismatchException e
            scanner.nextLine()
            printString("It is not a number. Try again: ")

function continueDialog(scanner)
    printString("Press 'y' or 'Y' to continue: ")
    input = getUserString(scanner)
    return input equals "y" or input equals "Y"

function ifFunk(age)
    if age < 16
        printString("\"Autonomy\" by Brother Moving will be a great choice for you.")
    else if age < 50
        printString("\"Blood Sugar Sex Magic\" by Red Hot Chili Peppers will be a great choice for you.")
    else
        printString("\"Raise!\" by Earth, Wind & Fire will be a great choice for you.")

function ifBlues(age)
    if age < 16
        printString("\"El Camino\" by The Black Keys will be a great choice for you.")
    else if age < 50
        printString("\"Abbey Road\" by The Beatles will be a great choice for you.")
    else
        printString("\"Morrison Hotel\" by The Doors will be a great choice for you.")

function unknownGenre(age)
    printString("We are not familiar with this genre, but you can try these albums: ")
    if age < 16
        printString("\"The Dark Side of the Moon\" by Pink Floyd")
    else if age < 50
        printString("\"The Empyrean\" by John Frusciante")
    else
        printString("\"In The Court Of The Crimson King\" by King Crimson")

function main()
    scanner = createScanner(System.in)

    printString("This program recommends a music album based on your age and asked genre.")
    repeat
        printString("Please, enter a music genre: ")
        genre = getUserString(scanner)

        printString("Please, enter your age: ")
        age = getUserInt(scanner)

        if age < 0
            printString("Welcome stranger, we don't have any music for non-human species, sorry.")
        else if genre equals "funk"
            ifFunk(age)
        else if genre equals "blues"
            ifBlues(age)
        else
            unknownGenre(age)

        getUserString(scanner)  // Consume the newline character
    until not continueDialog(scanner)

    close(scanner)  // close the scanner to avoid memory leak
 */

public class Main {
	public static void printString(String str) {
		System.out.print(str);
	}

	public static String getUserString(Scanner scanner) {
		return  scanner.nextLine();
	}

	public static int getUserInt(Scanner scanner) {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				printString("\u001B[31mIt is not a number. Try again: \u001B[0m");
			}
		}
	}

	public static boolean continueDialog(Scanner scanner) {
		printString("Press 'y' or 'Y' to continue: ");
		String input = getUserString(scanner);
		return input.equals("y") || input.equals("Y");
	}

	public static void ifFunk(int age) {
		if (age < 16) {
			printString("\"Autonomy\" by Brother Moving will be a great choice for you.\n");
		} else if (age < 50) {
			printString("\"Blood Sugar Sex Magic\" by Red Hot Chili Peppers will be a great choice for you.\n");
		} else {
			printString("\"Raise!\" by Earth, Wind & Fire will be a great choice for you.\n");
		}
	}

	public static void ifBlues(int age) {
		if (age < 16) {
			printString("\"El Camino\" by The Black Keys will be a great choice for you.\n");
		} else if (age < 50) {
			printString("\"Abbey Road\" by The Beatles will be a great choice for you.\n");
		} else {
			printString("\"Morrison Hotel\" by The Doors will be a great choice for you.\n");
		}
	}

	public static void unknownGenre(int age) {
		printString("We are not familiar with this genre, but you can try this albums: ");
		if (age < 16) {
			printString("\"The Dark Side of the Moon\" by Pink Floyd\n");
		} else if (age < 50) {
			printString("\"The Empyrean\" by John Frusciante\n");
		} else {
			printString("\"In The Court Of The Crimson King\" by King Crimson\n");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		printString("This program recommends a music album based on your age and asked genre.\n");
		do {
			printString("Please, enter a music genre: ");
			String genre = getUserString(scanner);

			printString("Please, enter your age: ");
			int age = getUserInt(scanner);

			if (age < 0) {
				printString("Welcome stranger, we don't have any music for non human species, sorry.");
			} else if (genre.equals("funk")) {
				ifFunk(age);
			} else if (genre.equals("blues")) {
				ifBlues(age);
			} else {
				// if the genre is not blues or funk
				unknownGenre(age);
			}

			scanner.nextLine();
		} while (continueDialog(scanner));

		// close scanner to avoid memory leak
		scanner.close();
	}
}
