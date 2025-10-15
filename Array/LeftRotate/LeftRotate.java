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
        System.out.println("=========== LEFT ROTATION TESTS (Using for loop) ===========");

        // --- Define test cases ---
        int[][] testArrays = {
                {1, 2, 3, 4, 5},     // basic case
                {1, 2, 3, 4, 5},     // same array for optimized
                {10, 20, 30, 40},    // rotate by 0
                {5, 10, 15, 20},     // rotate by array length
                {9, 8, 7, 6, 5},     // rotate > length
                {42},                // single element
                {1, 2},              // two elements
                {}                   // empty array
        };

        int[] rotations = {3, 3, 0, 4, 7, 3, 1, 2};
        String[] descriptions = {
                "Rotate by 3 (Naive)",
                "Rotate by 3 (Optimized)",
                "Rotate by 0 (No Change)",
                "Rotate by array length (4)",
                "Rotate by 7 (> length)",
                "Single element array",
                "Two-element array (Rotate by 1)",
                "Empty array"
        };

        // --- Run test cases in loop ---
        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ": " + descriptions[i]);

            // Copy original array to preserve it for printing
            int[] arr = Arrays.copyOf(testArrays[i], testArrays[i].length);
            printArray("Before:", arr);

            // Handle empty array
            if (arr.length == 0) {
                printArray("After :", arr);
                continue;
            }

            // Use naive for first test, optimized for others
            if (i == 0) {
                leftRotateNaive(arr, rotations[i]);
            } else {
                leftRotateOptimized(arr, rotations[i]);
            }

            printArray("After :", arr);
        }

        System.out.println("\n=========== END OF TESTS ===========");
    }
}
