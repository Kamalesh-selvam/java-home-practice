package practice_java;
public class fibo {

    // Recursive method to calculate the Fibonacci number at position n
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;  // Base cases: fibonacci(0) = 0 and fibonacci(1) = 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);  // Recursive case
        }
    }

    // Method to print Fibonacci sequence up to the nth term
    public static void printFibonacciSequence(int n) {
        System.out.println("Fibonacci sequence up to the " + n + "th term:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;  // Change this value to generate more or fewer terms
        printFibonacciSequence(n);
    }
}
