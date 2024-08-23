package practice_java;
import java.util.Scanner;

public class SecondSmallestNumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        // Get 10 numbers from the user
        System.out.println("Please enter 10 numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Initialize the smallest and second smallest
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        // Find the smallest and second smallest numbers
        for (int number : numbers) {
            if (number < smallest) {
                secondSmallest = smallest;
                smallest = number;
            } else if (number < secondSmallest && number != smallest) {
                secondSmallest = number;
            }
        }

        // Print the second smallest number
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("There is no second smallest number in the array.");
        } else {
            System.out.println("The second smallest number in the array is: " + secondSmallest);
        }

        scanner.close();
    }
}