import java.util.Arrays;

public class RepeatingElement {

    /**
     * Naive O(n^2) approach
     * Compares every pair of elements to find the first repeating one.
     */
    public static int findRepeatingElementNaive1(int[] arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n - 1; i++ )
        {
            for ( int j = i+1; j < n; j++ )
            {
                if ( arr[i] == arr[j] )
                    return arr[i];
            }
        }

        return -1; // No repeating element
    }

    /**
     * Sorting-based approach O(n log n)
     * Sorts the array and checks adjacent elements.
     * Modifies the input array.
     */
    public static int findRepeatingElementSorting(int[] arr)
    {
        int[] arrClone = Arrays.copyOf(arr, arr.length); // to avoid modifying original
        Arrays.sort(arrClone);
        for ( int i = 0; i < arrClone.length - 1; i++ )
        {
            if ( arrClone[i] == arrClone[i+1] )
                return arrClone[i];
        }

        return -1; // No repeating element
    }

    /**
     * Hashing approach O(n)
     * Uses a boolean visited[] array to mark seen elements.
     * Works only if values are in range [0..n-1]
     */
    public static int findRepeatingElementUsingBooleanArray( int[] arr )
    {
        boolean[] visited = new boolean[arr.length];

        for (int j : arr) {
            if (visited[j])
                return j;
            visited[j] = true;
        }

        return -1;
    }

    /**
     * Floyd’s Cycle Detection (Tortoise and Hare) O(n)
     * Assumes:
     * - Array length = n+1
     * - Elements are in range [0..n-1]
     * - At least one duplicate exists
     */
    public static int findRepeatingElementTwoPointer(int[] arr)
    {
        int slow = arr[0] + 1;
        int fast = arr[0] + 1;

        // Phase 1: Detect cycle
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while ( slow != fast);

        // Phase 2: Find entry point of cycle (duplicate element)
        slow = arr[0] + 1;
        while ( slow != fast )
        {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }

        return slow - 1; // Subtract 1 to undo the earlier +1 offset
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases1 = {
                {1, 2, 3, 4, 2},          // Single duplicate
                {3, 1, 3, 4, 2},          // Duplicate at start
                {1, 2, 3, 4, 5},          // No duplicate
                {0, 0},                   // Minimum size with duplicate
                {2, 5, 1, 3, 5, 4}        // Larger case
        };

        int[][] testCases = {
                {1, 3, 4, 2, 2, 0},         // repeating 2
                {3, 1, 0, 3, 4, 2},         // repeating 3
                {1, 0, 1},                  // repeating 1 (edge case: smallest n)
                {2, 5, 9, 6, 9, 3, 8, 9, 0, 7, 1}, // repeating 9 (appears multiple times)
                {1, 0, 2, 2, 2},
                {0,2,1,3,5,4,6,2},
                {0, 0}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(arr));

            System.out.println("  Naive1: " + findRepeatingElementNaive1(arr.clone()));
            System.out.println("  Sorting: " + findRepeatingElementSorting(arr.clone()));

            try {
                System.out.println("  Boolean Array: " + findRepeatingElementUsingBooleanArray(arr.clone()));
            } catch (Exception e) {
                System.out.println("  Boolean Array: ERROR (out of range values)");
            }

            try {
                System.out.println("  Two Pointer: " + findRepeatingElementTwoPointer(arr.clone()));
            } catch (Exception e) {
                System.out.println("  Two Pointer: ERROR (invalid input for Floyd’s algorithm)");
            }

            System.out.println();
        }
    }
}
