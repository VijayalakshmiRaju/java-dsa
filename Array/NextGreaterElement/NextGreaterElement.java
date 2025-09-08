import java.util.Arrays;

public class NextGreaterElement {

    /**
     * Naive O(N^2) approach:
     * For every element, traverse its right side and find the maximum.
     */
    public static void findNextGreaterElement(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int greaterElement = Integer.MIN_VALUE;

            // Traverse the right side to find the maximum element
            for (int j = i + 1; j < arr.length; j++) {
                greaterElement = Math.max(greaterElement, arr[j]);
            }

            arr[i] = greaterElement;
        }

        // Last element should always be -1
        arr[arr.length - 1] = -1;
    }

    /**
     * Optimized O(N) approach:
     * Traverse from right to left keeping track of the maximum seen so far.
     */
    public static void findGreaterElement(int[] arr) {
        int maxRight = -1;                // Initialize with -1 for the last element
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];            // Store current element
            arr[i] = maxRight;            // Replace current with max on the right
            maxRight = Math.max(maxRight, temp); // Update maxRight
        }
    }

    public static void main(String[] args) {
        // Define multiple test cases including edge cases
        int[][] testCases = {
                {16, 17, 4, 3, 5, 2},       // Example from problem
                {16, 17, 5, 3, 2, 1},       // Strictly decreasing after a peak
                {1, 2, 3, 4, 5},            // Strictly increasing
                {5, 4, 3, 2, 1},            // Strictly decreasing
                {10},                       // Single element
                {}                          // Empty array
        };

        // Run both approaches on each test case
        for (int[] testCase : testCases) {
            System.out.println("Original Array: " + Arrays.toString(testCase));

            // Clone arrays to avoid modifying the same array
            int[] naiveArr = testCase.clone();
            int[] optimizedArr = testCase.clone();

            if (naiveArr.length > 0) {
                findNextGreaterElement(naiveArr);
                findGreaterElement(optimizedArr);

                System.out.println("Naive Result     : " + Arrays.toString(naiveArr));
                System.out.println("Optimized Result : " + Arrays.toString(optimizedArr));
            } else {
                System.out.println("Naive Result     : []");
                System.out.println("Optimized Result : []");
            }

            System.out.println("--------------------------------------------------");
        }
    }
}
