public class RopeCuttingProblem {

    /**
     * Function to find the maximum number of pieces a rope of length 'n'
     * can be cut into, such that each piece has length either a, b, or c.
     *
     * Approach: Recursive (Brute Force)
     * - Base Case 1: If n == 0 → rope completely cut → 0 pieces.
     * - Base Case 2: If n < 0 → invalid cut → return -1.
     * - Otherwise:
     *     Recursively cut rope by lengths a, b, and c.
     *     Take the maximum of all three possible cuts.
     *     If no valid cut found (i.e., all return -1), return -1.
     *     Else return 1 + max_of_subcuts.
     *
     * Time Complexity: O(3^n) in worst case (since three recursive calls at each step)
     * Space Complexity: O(n) (due to recursion stack)
     */
    public static int maximumCut(int n, int a, int b, int c) {
        // Base Case 1: Rope completely cut
        if (n == 0)
            return 0;

        // Base Case 2: Invalid cut (length below 0)
        if (n < 0)
            return -1;

        // Try all three possible cuts (a, b, and c)
        int resA = maximumCut(n - a, a, b, c);
        int resB = maximumCut(n - b, a, b, c);
        int resC = maximumCut(n - c, a, b, c);

        // Take the maximum of all three results
        int result = Math.max(resA, Math.max(resB, resC));

        // If all results are -1, then no valid cut is possible
        if (result == -1)
            return -1;

        // Otherwise, return 1 + maximum of valid subcuts
        return result + 1;
    }

    public static void main(String[] args) {
        // Each test case: {n, a, b, c}
        int[][] testCases = {
                {17, 10, 11, 3},  // Expected: 3 (11 + 3 + 3)
                {9, 2, 2, 2},     // Expected: -1 (cannot make 9 with 2s)
                {9, 2, 3, 4},     // Expected: 4 (3 + 2 + 2 + 2)
                {5, 5, 3, 2},     // Expected: 2 (3 + 2)
                {7, 5, 2, 6},     // Expected: 2 (5 + 2)
                {0, 2, 3, 4},     // Expected: 0 (no cuts needed)
                {-5, 2, 3, 4},    // Expected: -1 (invalid rope length)
                {24, 12, 8, 4}    // Expected: 6 (4 + 4 + 4 + 4 + 4 + 4)
        };

        // Iterate through all test cases
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i][0];
            int a = testCases[i][1];
            int b = testCases[i][2];
            int c = testCases[i][3];

            int result = maximumCut(n, a, b, c);
            System.out.println("Test Case " + (i + 1) +
                    " (n=" + n + ", a=" + a + ", b=" + b + ", c=" + c + "): " + result);
        }
    }
}
