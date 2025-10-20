public class Factorial {

    /**
     * Recursive function to calculate factorial of a given number.
     * Base Case:
     * - factorial(0) = 1
     * Recursive Case:
     * - factorial(n) = n * factorial(n - 1)
     * Time Complexity: O(n)
     * Space Complexity: O(n) (due to recursion call stack)
     */
    public static int factorialRecursive(int number) {
        // Handle base case: 0! is defined as 1
        if (number == 0)
            return 1;

        // Recursive call: multiply current number with factorial of (number - 1)
        return number * factorialRecursive(number - 1);
    }

    /**
     * Main method to test the factorialRecursive() function
     */
    public static void main(String[] args) {

        // Array of test cases including edge cases
        int[] testCases = {0, 1, 2, 5, 7, 10, -3};

        System.out.println("---- Factorial Test Cases ----");

        for (int num : testCases) {

            // Handle negative input separately (factorial undefined for negative numbers)
            if (num < 0) {
                System.out.printf("Factorial of %d: Undefined (Negative number)\n", num);
                continue;
            }

            // Calculate factorial for valid input
            int result = factorialRecursive(num);

            // Print formatted result
            System.out.printf("Factorial of %d = %d\n", num, result);
        }

        System.out.println("------------------------------");
    }
}
