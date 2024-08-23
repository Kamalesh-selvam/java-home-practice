package practice_java;

import java.util.Scanner;

public class EvenNumbersPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        // Get 10 numbers from the user
        System.out.println("Please enter 10 numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Print even numbers
        System.out.println("\nEven numbers in the array:");

        boolean foundEven = false;
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
                foundEven = true;
            }
        }

        if (!foundEven) {
            System.out.println("No even numbers found.");
        }

        scanner.close();
    }
}
