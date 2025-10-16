public class LeadersInArray {

    /**
     * Function to print all the leaders in an array (Naive Approach)
     * A leader is an element that is strictly greater than all elements to its right.
     */
    public static void printLeadersNaive(int[] arr) {
        // Outer loop picks each element one by one
        for (int i = 0; i < arr.length; i++) {

            int j;
            // Inner loop checks elements to the right of current element
            for (j = i + 1; j < arr.length; j++) {

                // If any element to the right is greater or equal,
                // then current element cannot be a leader
                if (arr[i] <= arr[j])
                    break;
            }

            // If we reached the end (j == arr.length),
            // it means no element to the right was greater
            if (j == arr.length)
                System.out.print(arr[i] + " ");
        }

        System.out.println(); // Move to next line after printing all leaders
    }

    public static void main(String[] args) {

        // Test Case 1: Standard case
        System.out.println("Test Case 1: Standard array");
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        // Leaders are 17, 5, 2
        printLeadersNaive(arr1);

        // Test Case 2: All elements are equal
        System.out.println("Test Case 2: All elements equal");
        int[] arr2 = {5, 5, 5, 5, 5};
        // Only the last element is a leader
        printLeadersNaive(arr2);

        // Test Case 3: Strictly decreasing array
        System.out.println("Test Case 3: Strictly decreasing array");
        int[] arr3 = {10, 9, 8, 7, 6};
        // Every element is a leader
        printLeadersNaive(arr3);

        // Test Case 4: Strictly increasing array
        System.out.println("Test Case 4: Strictly increasing array");
        int[] arr4 = {1, 2, 3, 4, 5};
        // Only the last element is a leader
        printLeadersNaive(arr4);

        // Test Case 5: Single element array (edge case)
        System.out.println("Test Case 5: Single element array");
        int[] arr5 = {42};
        // The single element itself is a leader
        printLeadersNaive(arr5);

        // Test Case 6: Empty array (edge case)
        System.out.println("Test Case 6: Empty array");
        int[] arr6 = {};
        // Should print nothing
        printLeadersNaive(arr6);

        // Test Case 7: Random case with negative numbers
        System.out.println("Test Case 7: Array with negative numbers");
        int[] arr7 = {-1, -2, -3, 0, -4};
        // Leaders are 0, -4
        printLeadersNaive(arr7);

        // Test Case 8: Array with mixed large and small numbers
        System.out.println("Test Case 8: Mixed large and small numbers");
        int[] arr8 = {100, 50, 60, 30, 20, 10};
        // Leaders are 100, 60, 30, 20, 10
        printLeadersNaive(arr8);
    }
}
