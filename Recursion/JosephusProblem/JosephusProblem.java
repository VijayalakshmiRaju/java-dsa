public class JosephusProblem {

    /**
     * Recursive function to find the position of the survivor in the Josephus Problem.
     *
     * @param n Number of people in the circle
     * @param k Step count — every k-th person is eliminated
     * @return The position (1-indexed) of the survivor
     */
    public static int josephus(int n, int k) {
        // Base case: when only one person remains, they are the survivor
        if (n == 1)
            return 1;

        // Recursive relation:
        // Survivor position shifts by (k - 1) each time a person is eliminated.
        // The modulo ensures we wrap around the circle.
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        // Define test cases in a 2D array: {n, k}
        int[][] testCases = {
                {7, 3},    // Normal case
                {1, 5},    // Edge case: only one person
                {2, 1},    // Eliminating every 1st person
                {2, 2},    // Eliminating every 2nd person
                {5, 12},   // k > n
                {10, 3},   // Larger group
                {20, 7},   // Large n test
                {10, 1000} // Very large k
        };

        // Iterate through each test case using a for loop
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i][0];
            int k = testCases[i][1];
            int result = josephus(n, k);

            System.out.println("Test Case " + (i + 1) +
                    " -> (n=" + n + ", k=" + k + ") => Survivor: " + result);
        }
    }
}
