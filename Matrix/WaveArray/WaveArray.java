import java.util.Arrays;

public class WaveArray {

    /**
     * Function to convert a given array into a wave-like array.
     * Wave pattern: arr[0] >= arr[1] <= arr[2] >= arr[3] ...
     *
     * Naive Approach:
     * 1. Sort the array in ascending order.
     * 2. Swap adjacent pairs (0-1, 2-3, 4-5, ...).
     *
     * Example:
     * Input:  [10, 90, 49, 2, 1, 5, 23]
     * Sorted: [1, 2, 5, 10, 23, 49, 90]
     * Output: [2, 1, 10, 5, 49, 23, 90]
     */
    public static void waveArray(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Swap adjacent elements in pairs
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args) {

        // Helper to run all test cases
        runTest("General Case", new int[]{10, 90, 49, 2, 1, 5, 23});
        runTest("Already Sorted Array", new int[]{1, 2, 3, 4, 5, 6});
        runTest("Reverse Sorted Array", new int[]{10, 9, 8, 7, 6, 5});
        runTest("Duplicate Elements", new int[]{4, 4, 4, 4, 4, 4});
        runTest("Single Element", new int[]{42});
        runTest("Two Elements", new int[]{100, 20});
        runTest("Includes Negative Numbers", new int[]{-5, -10, 0, 5, 10});
        runTest("Empty Array", new int[]{});
    }

    /**
     * Helper method to print the result for each test case with formatting.
     */
    private static void runTest(String testCaseName, int[] arr) {
        System.out.println("========== " + testCaseName + " ==========");

        // Store the original array before transformation
        int[] original = Arrays.copyOf(arr, arr.length);

        // Convert to wave form
        waveArray(arr);

        // Print original and transformed arrays
        System.out.println("Original Array: " + Arrays.toString(original));
        System.out.println("Wave Array    : " + Arrays.toString(arr));
        System.out.println();
    }
}
