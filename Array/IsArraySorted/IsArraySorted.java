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
        // Loop through each element
        for (int i = 0; i < arr.length - 1; i++) {
            // Compare arr[i] with all elements to its right
            for (int j = i + 1; j < arr.length; j++) {
                // If a smaller element is found later, array is not sorted
                if (arr[i] > arr[j])
                    return false;
            }
        }
        // If no violations found, array is sorted
        return true;
    }

    public static void main(String[] args) {

        // Test cases
        int[][] testCases = {
                {},                          // Empty array (edge case)
                {5},                         // Single element array (edge case)
                {1, 2, 3, 4, 5},             // Already sorted array
                {5, 4, 3, 2, 1},             // Reverse sorted array
                {1, 1, 1, 1, 1},             // All elements same (sorted)
                {1, 2, 2, 3, 4},             // Non-decreasing array (sorted)
                {1, 3, 2, 4, 5},             // Unsorted in between
                {10, 20, 30, 25, 40, 50},    // One unsorted pair
                {1, 2, 3, 4, 5, 6, 7, 8, 9}, // Large sorted array
                {9, 8, 8, 8, 7, 6}           // Non-increasing array
        };

        System.out.println("=== Checking if Arrays are Sorted (Naive Approach) ===\n");

        // Iterate through all test cases
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            boolean result = isSortedNaive(arr);

            // Print array and result in readable format
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(arr));
            System.out.println("Is Sorted? -> " + result);
            System.out.println("-------------------------------------------");
        }
    }
}
