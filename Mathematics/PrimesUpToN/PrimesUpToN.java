public class PrimesUpToN {

    /**
     * Function to check if a number is prime.
     * A prime number is greater than 1 and has no divisors other than 1 and itself.
     */
    public static boolean isPrime(int n) {
        // Numbers <= 1 are not prime
        if (n <= 1)
            return false;

        // 2 and 3 are prime numbers
        if (n <= 3)
            return true;

        // Check divisibility up to √n
        for (int i = 2; i * i <= n; i++) {
            // If divisible, not a prime
            if (n % i == 0)
                return false;
        }

        // If no divisor found, it's a prime
        return true;
    }

    /**
     * Function to print all prime numbers less than or equal to n.
     */
    public static void printPrimesUpToN(int n) {
        System.out.println("Prime numbers less than or equal to " + n + ":");

        boolean found = false; // To track if any prime exists

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found)
            System.out.print("No prime numbers found.");

        System.out.println("\n"); // Add line break after each test case
    }

    /**
     * Main method to test the prime printing function with multiple test cases.
     */
    public static void main(String[] args) {

        System.out.println("=== Prime Numbers Up To N ===\n");

        // Test Case 1: Small number (edge case)
        // Expect: No primes because 1 is not prime
        printPrimesUpToN(1);

        // Test Case 2: N = 2 (first prime)
        // Expect: 2
        printPrimesUpToN(2);

        // Test Case 3: N = 10 (normal range)
        // Expect: 2 3 5 7
        printPrimesUpToN(10);

        // Test Case 4: N = 20
        // Expect: 2 3 5 7 11 13 17 19
        printPrimesUpToN(20);

        // Test Case 5: N = 50 (larger range)
        // Expect: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
        printPrimesUpToN(50);

        // Test Case 6: Negative number (edge case)
        // Expect: No primes
        printPrimesUpToN(-10);

        // Test Case 7: Zero (edge case)
        // Expect: No primes
        printPrimesUpToN(0);
    }
}
