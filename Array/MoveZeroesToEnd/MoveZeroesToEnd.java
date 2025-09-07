public class MoveZeroesToEnd {

    // Naive Approach - Uses extra space
    public static void moveZeroesNaive(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int idx = 0;

        // Copy non-zero elements
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[idx++] = arr[i];
            }
        }

        // Copy back into original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // Optimized Approach - In-place (your approach)
    public static void moveZeroesOptimized(int[] arr) {
        int idx = 0; // index for placing non-zero elements

        // Place non-zero elements in order
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[idx] = arr[i];
                idx++;
            }
        }

        // Fill remaining with zero
        for (int i = idx; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    // Helper function to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {0, 1, 0, 3, 12},
                {1, 0, 2, 0, 0, 5, 7},
                {0, 0, 0, 0},
                {4, 5, 6, 7}
        };

        System.out.println("=== Naive Approach ===");
        for (int[] test : testCases) {
            int[] arr = test.clone(); // clone so original doesn't get modified
            System.out.print("Before: ");
            printArray(arr);
            moveZeroesNaive(arr);
            System.out.print("After:  ");
            printArray(arr);
            System.out.println();
        }

        System.out.println("=== Optimized Approach ===");
        for (int[] test : testCases) {
            int[] arr = test.clone(); // clone for independent testing
            System.out.print("Before: ");
            printArray(arr);
            moveZeroesOptimized(arr);
            System.out.print("After:  ");
            printArray(arr);
            System.out.println();
        }
    }
}
