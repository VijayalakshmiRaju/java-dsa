public class RemoveDuplicatesFromSortedArray {

    // Function to remove duplicates from a sorted array in-place
    public static int removeDuplicates(int[] arr) {

        // Edge cases: Empty or single element array
        if (arr.length == 0) return 0;
        if (arr.length == 1) return 1;

        int idx = 1; // Points to the next position for unique element

        // Traverse from 2nd element
        for (int i = 1; i < arr.length; i++) {

            // Compare with the previous unique element
            if (arr[idx - 1] != arr[i]) {
                arr[idx] = arr[i]; // Move unique element forward
                idx++; // Move idx to next slot
            }
        }

        // Return count of unique elements
        return idx;
    }

    // Helper method to print array up to a given length
    public static void printArray(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method with multiple test cases
    public static void main(String[] args) {

        // Store all test cases in a 2D array
        int[][] testCases = {
                {1, 1, 2, 2, 3, 4, 4},   // Normal case with duplicates
                {5, 5, 5, 5, 5},         // All elements same
                {1, 2, 3, 4, 5},         // Already unique
                {},                      // Empty array
                {7}                      // Single element
        };

        // Iterate over test cases using a for loop
        for (int t = 0; t < testCases.length; t++) {
            int[] arr = testCases[t];

            System.out.println("Test Case " + (t + 1) + ":");
            System.out.print("Initial array: ");
            printArray(arr, arr.length);

            int len = removeDuplicates(arr);

            System.out.print("After removing duplicates: ");
            printArray(arr, len);
            System.out.println("New length: " + len);
            System.out.println("------------------------------");
        }
    }
}
