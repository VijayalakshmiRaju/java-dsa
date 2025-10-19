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

        // Check divisibility from 2 up to √n
        for (int i = 2; i * i <= n; i++) {
            // If divisible by any number, it's not a prime
            if (n % i == 0)
                return false;
        }

        // If no divisors found, it's prime
        return true;
    }

    /**
     * Function to print all prime numbers less than or equal to n (Naive Approach)
     * Time Complexity: O(n√n)
     */
    public static void printPrimesUpToN(int n) {
        System.out.println("Prime numbers <= " + n + " (Naive Approach):");

        boolean found = false; // Track if any prime exists

        // Check each number from 2 to n
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }

        // Handle cases where no primes exist
        if (!found)
            System.out.print("No prime numbers found.");

        System.out.println("\n"); // Line break for readability
    }

    /**
     * Function to print all prime numbers <= n using the Sieve of Eratosthenes
     * Time Complexity: O(n log log n)
     */
    public static void printPrimesUsingSieve(int n) {
        System.out.println("Prime numbers <= " + n + " (Sieve of Eratosthenes):");

        if (n < 2) {
            System.out.println("No prime numbers found.\n");
            return;
        }

        // Create a boolean array where true indicates a prime number
        boolean[] prime = new boolean[n + 1];

        // Initialize all entries as true
        for (int i = 2; i <= n; i++)
            prime[i] = true;

        // Sieve logic: Mark multiples of each prime as non-prime
        for (int val = 2; val * val <= n; val++) {
            if (prime[val]) {
                // Start marking multiples from val²
                for (int i = val * val; i <= n; i += val)
                    prime[i] = false;
            }
        }

        boolean found = false;

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found)
            System.out.print("No prime numbers found.");

        System.out.println("\n"); // Line break for readability
    }

    /**
     * Main method to test both approaches with multiple test cases.
     */
    public static void main(String[] args) {

        System.out.println("=== PRIME NUMBERS UP TO N ===\n");

        // Test Case 1: Smallest possible input (edge case)
        // Expect: No primes
        printPrimesUpToN(0);
        printPrimesUsingSieve(0);

        // Test Case 2: Negative input (edge case)
        // Expect: No primes
        printPrimesUpToN(-10);
        printPrimesUsingSieve(-10);

        // Test Case 3: Input = 1 (edge case)
        // Expect: No primes (since 1 is not prime)
        printPrimesUpToN(1);
        printPrimesUsingSieve(1);

        // Test Case 4: Input = 2 (first prime)
        // Expect: 2
        printPrimesUpToN(2);
        printPrimesUsingSieve(2);

        // Test Case 5: Input = 10 (small range)
        // Expect: 2 3 5 7
        printPrimesUpToN(10);
        printPrimesUsingSieve(10);

        // Test Case 6: Input = 20 (normal range)
        // Expect: 2 3 5 7 11 13 17 19
        printPrimesUpToN(20);
        printPrimesUsingSieve(20);

        // Test Case 7: Input = 50 (larger range)
        // Expect: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
        printPrimesUpToN(50);
        printPrimesUsingSieve(50);

        // Test Case 8: Input = 100 (stress test for larger input)
        printPrimesUpToN(100);
        printPrimesUsingSieve(100);
    }
}
