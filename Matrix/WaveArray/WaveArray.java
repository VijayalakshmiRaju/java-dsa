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
        // Step 1: Sort the array first
        Arrays.sort(arr);

        // Step 2: Swap adjacent elements in pairs
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args) {

        // ---------- TEST CASE 1: General case ----------
        int[] arr1 = {10, 90, 49, 2, 1, 5, 23};
        waveArray(arr1);
        System.out.println("Test Case 1 - General Case:");
        System.out.println("Wave Array: " + Arrays.toString(arr1));
        System.out.println();

        // ---------- TEST CASE 2: Already sorted array ----------
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        waveArray(arr2);
        System.out.println("Test Case 2 - Already Sorted Array:");
        System.out.println("Wave Array: " + Arrays.toString(arr2));
        System.out.println();

        // ---------- TEST CASE 3: Reverse sorted array ----------
        int[] arr3 = {10, 9, 8, 7, 6, 5};
        waveArray(arr3);
        System.out.println("Test Case 3 - Reverse Sorted Array:");
        System.out.println("Wave Array: " + Arrays.toString(arr3));
        System.out.println();

        // ---------- TEST CASE 4: Array with duplicate elements ----------
        int[] arr4 = {4, 4, 4, 4, 4, 4};
        waveArray(arr4);
        System.out.println("Test Case 4 - Duplicate Elements:");
        System.out.println("Wave Array: " + Arrays.toString(arr4));
        System.out.println();

        // ---------- TEST CASE 5: Single element ----------
        int[] arr5 = {42};
        waveArray(arr5);
        System.out.println("Test Case 5 - Single Element:");
        System.out.println("Wave Array: " + Arrays.toString(arr5));
        System.out.println();

        // ---------- TEST CASE 6: Two elements ----------
        int[] arr6 = {100, 20};
        waveArray(arr6);
        System.out.println("Test Case 6 - Two Elements:");
        System.out.println("Wave Array: " + Arrays.toString(arr6));
        System.out.println();

        // ---------- TEST CASE 7: Negative numbers ----------
        int[] arr7 = {-5, -10, 0, 5, 10};
        waveArray(arr7);
        System.out.println("Test Case 7 - Includes Negative Numbers:");
        System.out.println("Wave Array: " + Arrays.toString(arr7));
        System.out.println();

        // ---------- TEST CASE 8: Empty array ----------
        int[] arr8 = {};
        waveArray(arr8);
        System.out.println("Test Case 8 - Empty Array:");
        System.out.println("Wave Array: " + Arrays.toString(arr8));
        System.out.println();
    }
}
