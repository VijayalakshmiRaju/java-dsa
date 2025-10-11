import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    // Function to generate all subsets (power set) of the given array
    public static void generatePowerSet(int[] arr) {
        int n = arr.length;

        // Total subsets = 2^n
        int totalSubsets = 1 << n; // left shift: 1 << n = 2^n

        // Loop through all possible subset representations (binary numbers)
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>(); // current subset

            // Check each bit position
            for (int j = 0; j < n; j++) {
                // If j-th bit of i is set, include arr[j] in subset
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            // Print current subset
            System.out.println(subset);
        }
    }

    public static void main(String[] args) {
        // Array of test cases
        int[][] testCases = {
                {1, 2, 3},      // Normal case
                {5},            // Single element
                {},             // Empty array
                {-1, 0, 2},     // Negative numbers
                {10, 20, 30, 40} // Larger array
        };

        // Loop through all test cases
        for (int t = 0; t < testCases.length; t++) {
            System.out.println("Test Case " + (t + 1) + ": " + java.util.Arrays.toString(testCases[t]));
            generatePowerSet(testCases[t]);
            System.out.println();
        }
    }
}
