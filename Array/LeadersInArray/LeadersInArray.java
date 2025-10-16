import java.util.Arrays;

public class LeadersInArray {

    /**
     * Function to print all the leaders in an array (Naive Approach)
     * A leader is an element that is strictly greater than all elements to its right.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static void printLeadersNaive(int[] arr) {
        // Handle empty array edge case
        if (arr.length == 0) {
            System.out.println("Leaders: (No leaders - empty array)");
            return;
        }

        System.out.print("Leaders (Naive): ");
        boolean found = false;

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
            if (j == arr.length) {
                System.out.print(arr[i] + " ");
                found = true;
            }
        }

        if (!found)
            System.out.print("(No leaders)");
        System.out.println(); // Move to next line after printing all leaders
    }

    /**
     * Function to print leaders using Optimized Approach (Right-to-Left Scan)
     * Traverse from right side and keep track of the maximum seen so far.
     * If current element is greater than maxFromRight, it’s a leader.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void printLeadersOptimized(int[] arr) {
        int n = arr.length;

        // Handle empty array edge case
        if (n == 0) {
            System.out.println("Leaders: (No leaders - empty array)");
            return;
        }

        System.out.print("Leaders (Optimized, reverse order): ");
        int maxFromRight = arr[n - 1];
        System.out.print(maxFromRight + " "); // The rightmost element is always a leader

        // Traverse array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }

        System.out.println(); // Move to next line after printing all leaders
    }

    public static void main(String[] args) {

        // --- Test Case 1: Standard array ---
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        System.out.println("Test Case 1: Standard array " + Arrays.toString(arr1));
        printLeadersNaive(arr1);
        printLeadersOptimized(arr1);
        System.out.println();

        // --- Test Case 2: All elements equal ---
        int[] arr2 = {5, 5, 5, 5, 5};
        System.out.println("Test Case 2: All elements equal " + Arrays.toString(arr2));
        printLeadersNaive(arr2);
        printLeadersOptimized(arr2);
        System.out.println();

        // --- Test Case 3: Strictly decreasing array ---
        int[] arr3 = {10, 9, 8, 7, 6};
        System.out.println("Test Case 3: Strictly decreasing array " + Arrays.toString(arr3));
        printLeadersNaive(arr3);
        printLeadersOptimized(arr3);
        System.out.println();

        // --- Test Case 4: Strictly increasing array ---
        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 4: Strictly increasing array " + Arrays.toString(arr4));
        printLeadersNaive(arr4);
        printLeadersOptimized(arr4);
        System.out.println();

        // --- Test Case 5: Single element array ---
        int[] arr5 = {42};
        System.out.println("Test Case 5: Single element array " + Arrays.toString(arr5));
        printLeadersNaive(arr5);
        printLeadersOptimized(arr5);
        System.out.println();

        // --- Test Case 6: Empty array ---
        int[] arr6 = {};
        System.out.println("Test Case 6: Empty array " + Arrays.toString(arr6));
        printLeadersNaive(arr6);
        printLeadersOptimized(arr6);
        System.out.println();

        // --- Test Case 7: Array with negative numbers ---
        int[] arr7 = {-1, -2, -3, 0, -4};
        System.out.println("Test Case 7: Array with negative numbers " + Arrays.toString(arr7));
        printLeadersNaive(arr7);
        printLeadersOptimized(arr7);
        System.out.println();

        // --- Test Case 8: Mixed large and small numbers ---
        int[] arr8 = {100, 50, 60, 30, 20, 10};
        System.out.println("Test Case 8: Mixed large and small numbers " + Arrays.toString(arr8));
        printLeadersNaive(arr8);
        printLeadersOptimized(arr8);
        System.out.println();
    }
}
