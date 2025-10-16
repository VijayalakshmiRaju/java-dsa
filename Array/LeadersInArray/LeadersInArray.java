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
        // All test cases
        int[][] testCases = {
                {16, 17, 4, 3, 5, 2},     // Standard case
                {5, 5, 5, 5, 5},          // All elements equal
                {10, 9, 8, 7, 6},         // Strictly decreasing
                {1, 2, 3, 4, 5},          // Strictly increasing
                {42},                     // Single element
                {},                       // Empty array
                {-1, -2, -3, 0, -4},      // Negative numbers
                {100, 50, 60, 30, 20, 10} // Mixed large/small numbers
        };

        String[] descriptions = {
                "Standard array",
                "All elements equal",
                "Strictly decreasing array",
                "Strictly increasing array",
                "Single element array",
                "Empty array",
                "Array with negative numbers",
                "Mixed large and small numbers"
        };

        System.out.println("=== Leaders in Array: Naive vs Optimized Approaches ===\n");

        // Iterate using a for loop to run all test cases
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": " + descriptions[i]);
            printLeadersNaive(testCases[i]);
            printLeadersOptimized(testCases[i]);
            System.out.println();
        }
    }
}
