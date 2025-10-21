public class GCD {

    /**
     * Function to find the Greatest Common Divisor (GCD) of two numbers
     * using the recursive subtraction-based Euclidean algorithm.
     *
     * GCD is the largest number that divides both numbers without leaving a remainder.
     *
     * Logic:
     * - Convert inputs to positive (to handle negatives).
     * - If one number becomes 0, return the other (base condition).
     * - If both numbers are equal, return any one of them.
     * - Otherwise, subtract the smaller number from the larger number
     *   and recursively find the GCD.
     *
     * Time Complexity: O(max(num1, num2)) — repeated subtraction.
     * Space Complexity: O(max(num1, num2)) — recursive call stack.
     */
    public static int findGCD(int num1, int num2) {
        // Convert to positive numbers to avoid infinite recursion
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        // Base case: If both are zero, undefined (return 0 for safe handling)
        if (num1 == 0 && num2 == 0)
            return 0;

        // Base case: If one number is 0, return the other
        if (num1 == 0)
            return num2;
        if (num2 == 0)
            return num1;

        // If both numbers are equal, that number itself is the GCD
        if (num1 == num2)
            return num1;

        // If num1 is greater, subtract num2 from num1
        if (num1 > num2)
            return findGCD(num1 - num2, num2);

        // Else subtract num1 from num2
        return findGCD(num1, num2 - num1);
    }

    /**
     * Optimized GCD using Modulo-based Euclidean Algorithm.
     *
     * Time Complexity: O(log(min(num1, num2)))
     * Space Complexity: O(log(min(num1, num2)))
     */
    public static int findGCDOptimized(int num1, int num2) {
        // Convert to positive
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        // Base case
        if (num2 == 0)
            return num1;

        // Recursive step using modulo operation
        return findGCDOptimized(num2, num1 % num2);
    }

    public static void main(String[] args) {
        // Array of test cases (pairs of numbers)
        int[][] testCases = {
                {10, 15},     // Common factors: 1, 5 → GCD = 5
                {35, 10},     // GCD = 5
                {100, 80},    // GCD = 20
                {7, 13},      // Prime numbers → GCD = 1
                {0, 25},      // One number is 0 → GCD = 25
                {25, 0},      // One number is 0 → GCD = 25
                {0, 0},       // Both are 0 → Undefined
                {54, 24},     // GCD = 6
                {48, 180},    // GCD = 12
                {81, 27},     // GCD = 27
                {1, 9999},    // GCD = 1
                {-20, 60},    // Negative number case → GCD = 20
                {270, 192},   // GCD = 6
                {-81, -27},   // Both negative → GCD = 27
                {17, 0},      // GCD = 17
                {-25, 0},     // Negative + zero → GCD = 25
                {120, -48},   // Mixed signs → GCD = 24
        };

        System.out.println("=== GCD (Greatest Common Divisor) Test Results ===\n");

        // Run all test cases using a for loop
        for (int i = 0; i < testCases.length; i++) {
            int a = testCases[i][0];
            int b = testCases[i][1];

            System.out.printf("Test Case %2d: GCD(%d, %d)\n", i + 1, a, b);

            // Handle case where both are zero
            if (a == 0 && b == 0) {
                System.out.println("  → Undefined (both are zero)\n");
                continue;
            }

            // Calculate using both methods
            int gcdRecursive = findGCD(a, b);
            int gcdOptimized = findGCDOptimized(a, b);

            // Display formatted output
            System.out.printf("  → Recursive (Subtraction): %d\n", gcdRecursive);
            System.out.printf("  → Optimized (Modulo):      %d\n\n", gcdOptimized);
        }

        System.out.println("=== End of Test Cases ===");
    }
}
