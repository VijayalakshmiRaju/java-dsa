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
        System.out.print("Divisors of " + number + ": ");

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
            if (number % i == 0) { // If 'i' divides 'number'
                if (number / i == i)
                    System.out.print(i + " ");   // Print only once for perfect square
                else
                    System.out.print(i + " " + (number / i) + " "); // Print both divisors
            }
        }

        System.out.println(); // Move to next line after output
    }


    public static void main(String[] args) {

        // === Test Cases for Naive and Optimized approaches ===

        System.out.println("=== Test Case 1: Positive Number (Normal Case) ===");
        printDivisorsNaive(10);
        printDivisorsOptimized(10);
        // Expected Output:
        // Divisors of 10: 1 2 5 10
        // Divisors of 10 (Optimized): 1 10 2 5

        System.out.println("\n=== Test Case 2: Prime Number ===");
        printDivisorsNaive(13);
        printDivisorsOptimized(13);
        // Expected Output:
        // Divisors of 13: 1 13
        // Divisors of 13 (Optimized): 1 13

        System.out.println("\n=== Test Case 3: Perfect Square ===");
        printDivisorsNaive(16);
        printDivisorsOptimized(16);
        // Expected Output:
        // Divisors of 16: 1 2 4 8 16
        // Divisors of 16 (Optimized): 1 16 2 8 4

        System.out.println("\n=== Test Case 4: Smallest Positive Number (Edge Case) ===");
        printDivisorsNaive(1);
        printDivisorsOptimized(1);
        // Expected Output:
        // Divisors of 1: 1
        // Divisors of 1 (Optimized): 1

        System.out.println("\n=== Test Case 5: Large Number (Performance Check) ===");
        printDivisorsOptimized(100);
        // Expected Output (Optimized): 1 100 2 50 4 25 5 20 10

        System.out.println("\n=== Test Case 6: Negative Number (Invalid Input) ===");
        printDivisorsNaive(-12);
        printDivisorsOptimized(-12);
        // Expected Output:
        // No divisors exist for -12

        System.out.println("\n=== Test Case 7: Zero (Edge Case) ===");
        printDivisorsNaive(0);
        printDivisorsOptimized(0);
        // Expected Output:
        // No divisors exist for 0
    }
}
