package practice_java;
import java.util.Scanner;

public class LargestNumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        // Get 10 numbers from the user
        System.out.println("Please enter 10 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Find the largest number
        int largest = numbers[0];  // Assume the first number is the largest

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        // Print the largest number
        System.out.println("The largest number in the array is: " + largest);

        scanner.close();
    }
}
