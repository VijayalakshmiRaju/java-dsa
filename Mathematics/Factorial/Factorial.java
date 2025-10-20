public class Factorial {

    /**
     * Recursive function to calculate the factorial of a given number.
     *
     * Base Case:
     * - factorial(0) = 1
     *
     * Recursive Case:
     * - factorial(n) = n * factorial(n - 1)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) (due to recursive call stack)
     */
    public static int factorialRecursive(int number) {
        // Base case: factorial(0) is defined as 1
        if (number == 0)
            return 1;

        // Recursive case: multiply current number with factorial of (number - 1)
        return number * factorialRecursive(number - 1);
    }

    /**
     * Iterative function to calculate the factorial of a given number.
     *
     * The idea:
     * - Start with result = 1
     * - Multiply result by every number from 2 up to 'number'
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int factorialIterative(int number) {
        int result = 1;

        // For negative numbers, factorial is undefined; handle separately
        if (number < 0)
            throw new IllegalArgumentException("Factorial is undefined for negative numbers.");

        // Multiply numbers from 2 up to n
        for (int i = 2; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    /**
     * Main method to test both recursive and iterative factorial functions.
     */
    public static void main(String[] args) {

        // Test cases including all valid and edge cases
        int[] testCases = {0, 1, 2, 3, 5, 7, 10, 12, -1, -5};

        System.out.println("---- Factorial Test Cases ----\n");

        for (int num : testCases) {

            // Negative number case
            if (num < 0) {
                System.out.printf("Factorial of %d: Undefined (Negative number)\n\n", num);
                continue;
            }

            // Calculate factorial using recursion
            int recursiveResult = factorialRecursive(num);

            // Calculate factorial using iteration
            int iterativeResult = factorialIterative(num);

            // Print formatted results for comparison
            System.out.printf("Number: %d\n", num);
            System.out.printf("Recursive Result: %d\n", recursiveResult);
            System.out.printf("Iterative Result: %d\n", iterativeResult);
            System.out.println("---------------------------------\n");
        }

        System.out.println("---- End of Test Cases ----");
    }
}
