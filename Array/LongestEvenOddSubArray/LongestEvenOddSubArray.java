import java.util.Arrays;

public class LongestEvenOddSubArray {

    /**
     * Function to find the length of the longest subarray
     * where elements alternate between even and odd numbers.
     *
     * Approach (Naive - O(n^2)):
     * - For every starting index i, expand j forward.
     * - Check if arr[j] and arr[j-1] have opposite parity (even/odd alternation).
     * - Keep counting until the alternation breaks.
     * - Track the maximum alternating subarray length found.
     *
     * Example:
     * arr = [10, 12, 14, 7, 8]
     * Longest alternating subarray = [14, 7, 8] → length = 3
     */
    public static int longestEvenOddSubArray(int[] arr) {
        int result = 1; // Minimum subarray length possible
        int n = arr.length;

        // Outer loop: pick each element as starting point
        for (int i = 0; i < n; i++) {
            int count = 1; // Start counting from current element

            // Inner loop: check alternating pattern from arr[i]
            for (int j = i + 1; j < n; j++) {
                // If consecutive elements have opposite parity, increase count
                if ((arr[j - 1] % 2 == 0 && arr[j] % 2 != 0)
                        || (arr[j - 1] % 2 != 0 && arr[j] % 2 == 0)) {
                    count++;
                } else {
                    // Pattern breaks, stop counting further
                    break;
                }
            }

            // Track maximum length found so far
            result = Math.max(result, count);
        }

        // If no alternating pair exists, return 0 as per convention
        return (result == 1) ? 0 : result;
    }

    /**
     * Optimized function to find the length of the longest even-odd subarray.
     *
     * Approach (Optimized - O(n)):
     * - Traverse the array once.
     * - If current and previous elements have opposite parity, increase count.
     * - Else, reset count to 1.
     * - Keep track of maximum alternating length.
     *
     * This is a single-pass approach similar to Kadane's algorithm.
     */
    public static int longestEvenOddSubArrayOptimized(int[] arr) {
        int n = arr.length;

        // Edge case: empty array
        if (n == 0)
            return 0;

        int maxLength = 1; // Maximum alternating subarray length found so far
        int curLen = 1;    // Current alternating subarray length

        for (int i = 1; i < n; i++) {
            // Check if consecutive elements have opposite parity
            if (arr[i] % 2 != arr[i - 1] % 2) {
                curLen++; // Alternation continues
            } else {
                // Alternation breaks, update max length and reset count
                maxLength = Math.max(maxLength, curLen);
                curLen = 1;
            }
        }

        // Final check for last segment
        maxLength = Math.max(maxLength, curLen);

        // Return 0 if all numbers have same parity
        return (maxLength == 1) ? 0 : maxLength;
    }

    public static void main(String[] args) {

        // Define multiple test cases including edge cases
        int[][] testCases = {
                {10, 12, 14, 7, 8},             // Alternation starts late → [14, 7, 8] → length = 3
                {7, 10, 13, 14, 15},            // Alternation throughout → [7,10,13,14,15] → length = 5
                {10, 12, 14, 16},               // All even → no alternation → 0
                {1, 3, 5, 7, 9},                // All odd → no alternation → 0
                {5, 10, 20, 6, 3, 8},           // Alternation breaks mid-way → [6,3,8] → length = 3
                {1, 2},                         // Simple 2-element alternating → 2
                {2, 4},                         // 2-element same parity → 0
                {2},                            // Single element → 0
                {},                             // Empty array → 0 (edge case)
                {2, 3, 4, 5, 6, 7, 8, 9},       // Perfect alternation → length = 8
                {1, 2, 3, 4, 5, 6},             // Perfect alternation → length = 6
                {2, 3, 5, 7, 8, 10, 11, 12, 13}, // Partial alternation → [5,7,8,10,11,12,13] → 7
                {0, 1, 2, 3, 4, 5},             // Alternation with zero (even) → length = 6
                {2, 3, 5, 8, 10, 13, 15, 16},   // Multiple breaks → longest = 4 ([8,10,13,15])
                {1, 2, 4, 7, 8, 9, 10, 13, 14}  // Mixed pattern → longest = 5 ([7,8,9,10,13])
        };

        System.out.println("====================================================");
        System.out.println("     Longest Even-Odd Subarray Length (Naive vs Optimized)");
        System.out.println("====================================================");
        System.out.println();

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];

            // Defensive check for empty array
            if (arr.length == 0) {
                System.out.printf("Test Case %02d: %-40s → Naive: %d | Optimized: %d%n",
                        (i + 1), "[]", 0, 0);
                continue;
            }

            int resultNaive = longestEvenOddSubArray(arr);
            int resultOptimized = longestEvenOddSubArrayOptimized(arr);

            System.out.printf("Test Case %02d: %-40s → Naive: %d | Optimized: %d%n",
                    (i + 1), Arrays.toString(arr), resultNaive, resultOptimized);
        }

        System.out.println();
        System.out.println("====================================================");
        System.out.println("All test cases executed successfully.");
        System.out.println("====================================================");
    }
}
