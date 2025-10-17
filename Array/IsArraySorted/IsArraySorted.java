import java.util.Arrays;

public class IsArraySorted {

    /**
     * Function to check if an array is sorted in non-decreasing order (Naive Approach)
     *
     * The idea:
     * - For every element, compare it with all elements to its right.
     * - If any element is greater than a later element, the array is not sorted.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param arr input array of integers
     * @return true if array is sorted, false otherwise
     */
    public static boolean isSortedNaive(int[] arr) {
        // Traverse each element
        for (int i = 0; i < arr.length - 1; i++) {
            // Compare current element with all elements to its right
            for (int j = i + 1; j < arr.length; j++) {
                // If a smaller element is found later, array is not sorted
                if (arr[i] > arr[j])
                    return false;
            }
        }
        // If no violations found, array is sorted
        return true;
    }

    /**
     * Function to check if an array is sorted (Optimized Approach)
     *
     * The idea:
     * - A single pass is enough: check if every adjacent pair satisfies arr[i] <= arr[i+1].
     * - If any pair violates this, the array is not sorted.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr input array of integers
     * @return true if array is sorted, false otherwise
     */
    public static boolean isSortedOptimized(int[] arr) {
        // Traverse through array once
        for (int i = 0; i < arr.length - 1; i++) {
            // If a current element is greater than next element → not sorted
            if (arr[i] > arr[i + 1])
                return false;
        }
        // If all adjacent pairs are valid → sorted
        return true;
    }

    public static void main(String[] args) {

        // Test cases including edge cases and typical patterns
        int[][] testCases = {
                {},                           // Empty array (edge case)
                {5},                          // Single element (edge case)
                {1, 2, 3, 4, 5},              // Already sorted
                {5, 4, 3, 2, 1},              // Strictly decreasing
                {1, 1, 1, 1, 1},              // All same elements
                {1, 2, 2, 3, 4},              // Non-decreasing (duplicates)
                {1, 3, 2, 4, 5},              // Unsorted in between
                {10, 20, 30, 25, 40, 50},     // One unsorted pair
                {1, 2, 3, 4, 5, 6, 7, 8, 9},  // Large sorted array
                {9, 8, 8, 8, 7, 6},           // Non-increasing array
                {-10, -5, 0, 5, 10},          // Sorted with negatives
                {-10, -20, -30},              // Decreasing with negatives
                {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE}, // Large range sorted
                {1, 2, Integer.MAX_VALUE, Integer.MIN_VALUE}      // Overflow edge case
        };

        System.out.println("=== Checking if Arrays are Sorted ===\n");

        // Iterate through all test cases
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];

            // Run both approaches
            boolean resultNaive = isSortedNaive(arr);
            boolean resultOptimized = isSortedOptimized(arr);

            // Display test case header
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(arr));

            // Print results in formatted way
            System.out.println("Naive Approach Result     -> " + (resultNaive ? "Sorted" : "Not Sorted"));
            System.out.println("Optimized Approach Result -> " + (resultOptimized ? "Sorted" : "Not Sorted"));
            System.out.println("--------------------------------------------------------");
        }
    }
}
