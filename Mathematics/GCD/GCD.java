public class GCD {

    /**
     * Function to find the Greatest Common Divisor (GCD) of two numbers
     * using the recursive subtraction-based Euclidean algorithm.
     *
     * GCD is the largest number that divides both numbers without leaving a remainder.
     *
     * Logic:
     * - If one number becomes 0, return the other (base condition).
     * - If both numbers are equal, return any one of them.
     * - Otherwise, subtract the smaller number from the larger number
     *   and recursively find the GCD.
     *
     * Time Complexity: O(max(num1, num2)) — due to repeated subtraction.
     * Space Complexity: O(max(num1, num2)) — due to recursion call stack.
     */
    public static int findGCD(int num1, int num2) {
        // Base case: If one of the numbers is 0, return the other
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

    public static void main(String[] args) {
        // Array of test cases (pairs of numbers)
        int[][] testCases = {
                {10, 15},     // Common factors: 1, 5 → GCD = 5
                {35, 10},     // Common factors: 1, 5 → GCD = 5
                {100, 80},    // Common factors: 1, 2, 4, 5, 10, 20 → GCD = 20
                {7, 13},      // Prime numbers → GCD = 1
                {0, 25},      // One number is 0 → GCD = 25
                {25, 0},      // One number is 0 → GCD = 25
                {0, 0},       // Both are 0 → mathematically undefined (handle gracefully)
                {54, 24},     // GCD = 6
                {48, 180},    // GCD = 12
                {81, 27},     // GCD = 27
                {1, 9999}     // Edge case with 1 → GCD = 1
        };

        System.out.println("=== GCD (Greatest Common Divisor) Test Results ===\n");

        // Run all test cases using a for loop
        for (int i = 0; i < testCases.length; i++) {
            int a = testCases[i][0];
            int b = testCases[i][1];

            // Handle special case where both numbers are 0
            if (a == 0 && b == 0) {
                System.out.printf("Test Case %d: GCD(%d, %d) → Undefined (both are zero)\n", i + 1, a, b);
                continue;
            }

            int gcd = findGCD(Math.abs(a), Math.abs(b)); // Use absolute values to handle negatives
            System.out.printf("Test Case %d: GCD(%d, %d) = %d\n", i + 1, a, b, gcd);
        }

        System.out.println("\n=== End of Test Cases ===");
    }
}
