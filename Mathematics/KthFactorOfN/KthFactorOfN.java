import java.util.ArrayList;
import java.util.List;

public class KthFactorOfN {

    /**
     * Brute-force approach: O(n)
     * Finds the kth factor of num by iterating from 1 to num.
     * @param num The number whose factors are to be checked.
     * @param k The k-th factor to find.
     * @return The k-th factor if exists, otherwise -1.
     */
    public static int kthFactor(int num, int k) {
        // Iterate from 1 to num to find all factors
        for (int i = 1; i <= num; i++) {
            // Check if 'i' is a factor of 'num'
            if (num % i == 0) {
                k--; // Decrement k for each factor found
            }
            // If k becomes 0, we found the kth factor
            if (k == 0) {
                return i;
            }
        }

        // If fewer than k factors exist, return -1
        return -1;
    }

    /**
     * Optimized approach: O(sqrt(n))
     * Finds the kth factor using factor pairs.
     * @param num The number whose factors are to be checked.
     * @param k The k-th factor to find.
     * @return The k-th factor if exists, otherwise -1.
     */
    public static int kthFactorOptimized(int num, int k) {
        List<Integer> largestFactors = new ArrayList<>(); // To store larger paired factors

        // Loop only up to sqrt(num)
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                k--; // Count this factor

                // If kth factor is found among small factors
                if (k == 0)
                    return i;

                // Add the paired factor (num/i) if it's not the same (avoid duplicates for perfect squares)
                if (i != num / i)
                    largestFactors.add(num / i);
            }
        }

        // If kth factor is among the larger factors
        if (k <= largestFactors.size()) {
            return largestFactors.get(largestFactors.size() - k);
        }

        // If fewer than k factors exist
        return -1;
    }

    // Main method with comprehensive test cases
    public static void main(String[] args) {
        int[][] testCases = {
                {12, 3}, // normal case, kth factor exists among small factors
                {7, 2},  // kth factor is the largest factor
                {4, 4},  // k > total factors, should return -1
                {1, 1},  // smallest n, first factor
                {1, 2},  // smallest n, k too large
                {1000, 1}, // largest factor is 1
                {1000, 16}, // largest factor among big numbers
                {36, 9}, // perfect square, testing duplicate factor handling
                {997, 1}, // prime number, first factor
                {997, 2}, // prime number, second factor
        };

        System.out.println("==== Brute-force Approach ====");
        for (int[] test : testCases) {
            int n = test[0], k = test[1];
            System.out.printf("Input: n = %d, k = %d -> Output: %d%n", n, k, kthFactor(n, k));
        }

        System.out.println("\n==== Optimized Approach ====");
        for (int[] test : testCases) {
            int n = test[0], k = test[1];
            System.out.printf("Input: n = %d, k = %d -> Output: %d%n", n, k, kthFactorOptimized(n, k));
        }
    }
}