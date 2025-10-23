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

    public static void main(String[] args) {

        // Define multiple test cases including edge cases
        int[][] testCases = {
                {10, 12, 14, 7, 8},             // Alternation starts late → [14, 7, 8] → length = 3
                {7, 10, 13, 14, 15},            // Alternation through almost all → [7,10,13,14,15] → 5
                {10, 12, 14, 16},               // All even → no alternation → 0
                {1, 3, 5, 7, 9},                // All odd → no alternation → 0
                {5, 10, 20, 6, 3, 8},           // Alternation breaks mid-way → [6,3,8] → 3
                {1, 2},                         // Simple 2-element alternating → 2
                {2, 4},                         // 2-element same parity → 0
                {2},                            // Single element → 0
                {},                             // Empty array → 0 (edge case)
                {2, 3, 4, 5, 6, 7, 8, 9},       // Full alternation → length = 8
                {1, 2, 3, 4, 5, 6},             // Perfect alternation → 6
                {2, 3, 5, 7, 8, 10, 11, 12, 13} // Partial alternation → longest [5,7,8,10,11,12,13] → 7
        };

        System.out.println("---- Longest Even-Odd Subarray Length ----");
        System.out.println();

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];

            // Defensive check for empty array
            if (arr.length == 0) {
                System.out.printf("Test Case %d: %-30s → Result: %d%n",
                        (i + 1), "[]", 0);
                continue;
            }

            int result = longestEvenOddSubArray(arr);
            System.out.printf("Test Case %d: %-30s → Longest Alternating Subarray Length = %d%n",
                    (i + 1), Arrays.toString(arr), result);
        }
    }
}
