import java.util.ArrayList;
import java.util.List;

public class Divisors {

    /**
     * Function to print all divisors of a given number (Naive Approach)
     *
     * Logic:
     * - A divisor of 'number' is any integer 'i' such that (number % i == 0)
     * - Loop through all numbers from 1 to 'number'
     * - Print 'i' if it divides the number evenly
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void printDivisorsNaive(int number) {

        // Handle invalid input (numbers less than or equal to 0)
        if (number <= 0) {
            System.out.println("No divisors exist for " + number);
            return;
        }

        // Display the number being processed
        System.out.print("Divisors of " + number + " (Naive): ");

        // Check every number from 1 to 'number' for divisibility
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)  // If 'i' divides 'number' evenly
                System.out.print(i + " ");
        }

        System.out.println(); // Move to next line after printing divisors
    }


    /**
     * Function to print all divisors of a number (Optimized Approach)
     *
     * Logic:
     * - Divisors come in pairs: (i, number/i)
     * - Loop only until sqrt(number)
     * - If i divides number evenly, print both i and number/i
     * - For perfect squares, print the divisor only once
     *
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     */
    public static void printDivisorsOptimized(int number) {

        // Handle invalid input
        if (number <= 0) {
            System.out.println("No divisors exist for " + number);
            return;
        }

        System.out.print("Divisors of " + number + " (Optimized): ");

        // Traverse numbers from 1 to sqrt(number)
        for (int i = 1; i <= Math.sqrt(number); i++) {
            // If 'i' divides 'number' evenly
            if (number % i == 0) {
                // If both divisors are same (perfect square), print once
                if (number / i == i)
                    System.out.print(i + " ");
                else
                    // Print both divisors
                    System.out.print(i + " " + (number / i) + " ");
            }
        }

        System.out.println(); // Move to next line after output
    }


    /**
     * Function to print all divisors of a number in sorted order (Optimized Approach)
     *
     * Logic:
     * - Similar to optimized method but uses a list to store larger divisors
     * - First prints all small divisors up to sqrt(number)
     * - Then prints the stored large divisors in reverse order for ascending output
     *
     * Time Complexity: O(√n)
     * Space Complexity: O(√n)
     */
    public static void printDivisorsUsingList(int number) {

        // Handle invalid input
        if (number <= 0) {
            System.out.println("No divisors exist for " + number);
            return;
        }

        // List to store the larger divisors
        List<Integer> largeDivisors = new ArrayList<>();

        System.out.print("Divisors of " + number + " (Sorted Optimized): ");

        // Traverse from 1 to sqrt(number)
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) { // If i divides number evenly
                if (number / i == i) {
                    // If perfect square, print only once
                    System.out.print(i + " ");
                } else {
                    // Print smaller divisor immediately
                    System.out.print(i + " ");
                    // Store larger divisor for later printing
                    largeDivisors.add(number / i);
                }
            }
        }

        // Print the larger divisors in reverse order (to maintain ascending order)
        for (int i = largeDivisors.size() - 1; i >= 0; i--) {
            System.out.print(largeDivisors.get(i) + " ");
        }

        System.out.println(); // Move to next line
    }


    public static void main(String[] args) {

        // === Test Cases for Naive, Optimized, and Sorted Optimized approaches ===

        System.out.println("=== Test Case 1: Positive Number (Normal Case) ===");
        printDivisorsNaive(10);
        printDivisorsOptimized(10);
        printDivisorsUsingList(10);
        // Expected Output:
        // Divisors of 10 (Naive): 1 2 5 10
        // Divisors of 10 (Optimized): 1 10 2 5
        // Divisors of 10 (Sorted Optimized): 1 2 5 10

        System.out.println("\n=== Test Case 2: Prime Number ===");
        printDivisorsNaive(13);
        printDivisorsOptimized(13);
        printDivisorsUsingList(13);
        // Expected Output:
        // Divisors of 13 (Naive): 1 13
        // Divisors of 13 (Optimized): 1 13
        // Divisors of 13 (Sorted Optimized): 1 13

        System.out.println("\n=== Test Case 3: Perfect Square ===");
        printDivisorsNaive(16);
        printDivisorsOptimized(16);
        printDivisorsUsingList(16);
        // Expected Output:
        // Divisors of 16 (Naive): 1 2 4 8 16
        // Divisors of 16 (Optimized): 1 16 2 8 4
        // Divisors of 16 (Sorted Optimized): 1 2 4 8 16

        System.out.println("\n=== Test Case 4: Smallest Positive Number (Edge Case) ===");
        printDivisorsNaive(1);
        printDivisorsOptimized(1);
        printDivisorsUsingList(1);
        // Expected Output:
        // Divisors of 1 (Naive): 1
        // Divisors of 1 (Optimized): 1
        // Divisors of 1 (Sorted Optimized): 1

        System.out.println("\n=== Test Case 5: Large Number (Performance Check) ===");
        printDivisorsOptimized(100);
        printDivisorsUsingList(100);
        // Expected Output (Optimized): 1 100 2 50 4 25 5 20 10
        // Expected Output (Sorted Optimized): 1 2 4 5 10 20 25 50 100

        System.out.println("\n=== Test Case 6: Negative Number (Invalid Input) ===");
        printDivisorsNaive(-12);
        printDivisorsOptimized(-12);
        printDivisorsUsingList(-12);
        // Expected Output:
        // No divisors exist for -12

        System.out.println("\n=== Test Case 7: Zero (Edge Case) ===");
        printDivisorsNaive(0);
        printDivisorsOptimized(0);
        printDivisorsUsingList(0);
        // Expected Output:
        // No divisors exist for 0
    }
}
