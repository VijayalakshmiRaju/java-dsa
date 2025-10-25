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
        // Test Case 1: Example case
        int n1 = 17, a1 = 10, b1 = 11, c1 = 3;
        System.out.println("Test Case 1 (n=17, a=10, b=11, c=3): " + maximumCut(n1, a1, b1, c1));
        // Expected Output: 3 (cuts: 10 + 3 + 3 + 1 invalid, but 11 + 3 + 3 = 17)

        // Test Case 2: Rope can be cut evenly
        int n2 = 9, a2 = 2, b2 = 2, c2 = 2;
        System.out.println("Test Case 2 (n=9, a=2, b=2, c=2): " + maximumCut(n2, a2, b2, c2));
        // Expected Output: -1 (cannot make 9 from 2s)

        // Test Case 3: All possible cuts allowed
        int n3 = 9, a3 = 2, b3 = 3, c3 = 4;
        System.out.println("Test Case 3 (n=9, a=2, b=3, c=4): " + maximumCut(n3, a3, b3, c3));
        // Expected Output: 3 (cuts: 3 + 3 + 3)

        // Test Case 4: n equals one of the cut sizes
        int n4 = 5, a4 = 5, b4 = 3, c4 = 2;
        System.out.println("Test Case 4 (n=5, a=5, b=3, c=2): " + maximumCut(n4, a4, b4, c4));
        // Expected Output: 1 (single cut of size 5)

        // Test Case 5: No valid cut possible
        int n5 = 7, a5 = 5, b5 = 2, c5 = 6;
        System.out.println("Test Case 5 (n=7, a=5, b=2, c=6): " + maximumCut(n5, a5, b5, c5));
        // Expected Output: 2 (cuts: 5 + 2)

        // Test Case 6: Edge case (n = 0)
        int n6 = 0, a6 = 2, b6 = 3, c6 = 4;
        System.out.println("Test Case 6 (n=0, a=2, b=3, c=4): " + maximumCut(n6, a6, b6, c6));
        // Expected Output: 0 (no cuts needed)

        // Test Case 7: Edge case (negative n)
        int n7 = -5, a7 = 2, b7 = 3, c7 = 4;
        System.out.println("Test Case 7 (n=-5, a=2, b=3, c=4): " + maximumCut(n7, a7, b7, c7));
        // Expected Output: -1 (invalid length)

        // Test Case 8: Large number but divisible nicely
        int n8 = 24, a8 = 12, b8 = 8, c8 = 4;
        System.out.println("Test Case 8 (n=24, a=12, b=8, c=4): " + maximumCut(n8, a8, b8, c8));
        // Expected Output: 6 (cuts of 4+4+4+4+4+4)
    }
}
