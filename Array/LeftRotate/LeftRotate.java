import java.util.Arrays;

public class LeftRotate {

    /**
     * Function to left rotate the array by one position.
     * Example: [1,2,3,4,5] -> [2,3,4,5,1]
     */
    public static void leftRotate(int[] arr) {
        // Store the first element temporarily
        int temp = arr[0];

        // Shift remaining elements one position to the left
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the end
        arr[arr.length - 1] = temp;
    }

    /**
     * Naive approach to rotate an array by k positions.
     * Calls leftRotate() k times.
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     */
    public static void leftRotateNaive(int[] arr, int k) {
        int n = arr.length;
        // Handle cases where k >= n
        k = k % n;

        for (int i = 0; i < k; i++) {
            leftRotate(arr);
        }
    }

    /**
     * Optimized approach using an auxiliary array.
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public static void leftRotateOptimized(int[] arr, int k) {
        int n = arr.length;
        // Handle cases where k >= n
        k = k % n;

        // Step 1: Store first k elements in temp array
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        // Step 2: Shift the rest of the elements to the left
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }

        // Step 3: Copy stored elements to the end
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
    }

    /**
     * Utility function to print array with formatting
     */
    public static void printArray(String label, int[] arr) {
        System.out.println(label + " " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("=========== LEFT ROTATION TESTS ===========");

        // Test Case 1: Basic rotation
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("\nTest Case 1: Rotate by 3 positions (Naive)");
        printArray("Before:", arr1);
        leftRotateNaive(arr1, 3);
        printArray("After :", arr1);

        // Test Case 2: Optimized rotation with same k
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nTest Case 2: Rotate by 3 positions (Optimized)");
        printArray("Before:", arr2);
        leftRotateOptimized(arr2, 3);
        printArray("After :", arr2);

        // Test Case 3: Rotate by 0 (no rotation)
        int[] arr3 = {10, 20, 30, 40};
        System.out.println("\nTest Case 3: Rotate by 0 (No Change)");
        printArray("Before:", arr3);
        leftRotateOptimized(arr3, 0);
        printArray("After :", arr3);

        // Test Case 4: Rotate by array length (full rotation -> same array)
        int[] arr4 = {5, 10, 15, 20};
        System.out.println("\nTest Case 4: Rotate by array length (4)");
        printArray("Before:", arr4);
        leftRotateOptimized(arr4, arr4.length);
        printArray("After :", arr4);

        // Test Case 5: Rotate by more than array length
        int[] arr5 = {9, 8, 7, 6, 5};
        System.out.println("\nTest Case 5: Rotate by 7 (> length)");
        printArray("Before:", arr5);
        leftRotateOptimized(arr5, 7);
        printArray("After :", arr5);

        // Test Case 6: Single element array
        int[] arr6 = {42};
        System.out.println("\nTest Case 6: Single element array");
        printArray("Before:", arr6);
        leftRotateOptimized(arr6, 3);
        printArray("After :", arr6);

        // Test Case 7: Two-element array
        int[] arr7 = {1, 2};
        System.out.println("\nTest Case 7: Two-element array (Rotate by 1)");
        printArray("Before:", arr7);
        leftRotateOptimized(arr7, 1);
        printArray("After :", arr7);

        // Test Case 8: Empty array (Edge Case)
        int[] arr8 = {};
        System.out.println("\nTest Case 8: Empty array");
        printArray("Before:", arr8);
        if (arr8.length > 0)
            leftRotateOptimized(arr8, 2);
        printArray("After :", arr8);

        System.out.println("\n=========== END OF TESTS ===========");
    }
}
