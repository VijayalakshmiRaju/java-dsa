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

        // Test Case 1: Normal case with duplicates
        int[] arr1 = {1, 1, 2, 2, 3, 4, 4};
        System.out.print("Initial array: ");
        printArray(arr1, arr1.length);
        int len1 = removeDuplicates(arr1);
        System.out.print("After removing duplicates: ");
        printArray(arr1, len1);
        System.out.println("New length: " + len1);
        System.out.println("------------------------------");

        // Test Case 2: All elements same
        int[] arr2 = {5, 5, 5, 5, 5};
        System.out.print("Initial array: ");
        printArray(arr2, arr2.length);
        int len2 = removeDuplicates(arr2);
        System.out.print("After removing duplicates: ");
        printArray(arr2, len2);
        System.out.println("New length: " + len2);
        System.out.println("------------------------------");

        // Test Case 3: All elements unique (no duplicates)
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.print("Initial array: ");
        printArray(arr3, arr3.length);
        int len3 = removeDuplicates(arr3);
        System.out.print("After removing duplicates: ");
        printArray(arr3, len3);
        System.out.println("New length: " + len3);
        System.out.println("------------------------------");

        // Test Case 4: Empty array
        int[] arr4 = {};
        System.out.print("Initial array: ");
        printArray(arr4, arr4.length);
        int len4 = removeDuplicates(arr4);
        System.out.print("After removing duplicates: ");
        printArray(arr4, len4);
        System.out.println("New length: " + len4);
        System.out.println("------------------------------");

        // Test Case 5: Single element array
        int[] arr5 = {7};
        System.out.print("Initial array: ");
        printArray(arr5, arr5.length);
        int len5 = removeDuplicates(arr5);
        System.out.print("After removing duplicates: ");
        printArray(arr5, len5);
        System.out.println("New length: " + len5);
        System.out.println("------------------------------");
    }
}
