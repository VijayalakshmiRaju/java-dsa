public class RemoveDuplicatesFromSortedArray {

    // Method to remove duplicates in-place and return new length
    public static int removeDuplicates(int[] arr) {
        // If array is empty or has only one element, no duplicates possible
        if (arr.length == 0) return 0;
        if (arr.length == 1) return 1;

        int idx = 1; // Points to next unique element's position

        // Traverse the array starting from 2nd element
        for (int i = 1; i < arr.length; i++) {

            // If current element is different from previous unique element
            if (arr[idx - 1] != arr[i]) {
                arr[idx] = arr[i]; // Move unique element to idx position
                idx++; // Increment index for next unique slot
            }
        }

        return idx; // idx = count of unique elements
    }

    // -------------------------------
    // Main method to test the function
    // -------------------------------
    public static void main(String[] args) {
        // Test Case 1: Normal sorted array with duplicates
        int[] arr1 = {1, 1, 2, 2, 3, 4, 4};
        int len1 = removeDuplicates(arr1);
        System.out.print("Unique elements: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\nNew length: " + len1);

        // Test Case 2: All elements same
        int[] arr2 = {5, 5, 5, 5, 5};
        int len2 = removeDuplicates(arr2);
        System.out.print("Unique elements: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\nNew length: " + len2);

        // Test Case 3: Already unique elements
        int[] arr3 = {1, 2, 3, 4, 5};
        int len3 = removeDuplicates(arr3);
        System.out.print("Unique elements: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println("\nNew length: " + len3);

        // Test Case 4: Empty array
        int[] arr4 = {};
        int len4 = removeDuplicates(arr4);
        System.out.println("New length (empty array): " + len4);

        // Test Case 5: Single element array
        int[] arr5 = {7};
        int len5 = removeDuplicates(arr5);
        System.out.print("Unique elements: ");
        for (int i = 0; i < len5; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println("\nNew length: " + len5);
    }
}
