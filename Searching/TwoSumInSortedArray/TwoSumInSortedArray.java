public class TwoSumInSortedArray {

    /**
     * Naive Approach (Brute Force)
     * - Check every pair to see if sum equals target
     * - Time Complexity: O(n^2)
     * - Space Complexity: O(1)
     */
    public static boolean findTwoSumNaive( int[] arr, int target )
    {
        for ( int i = 0; i < arr.length - 1; i++ )
        {
            for ( int j = i+1; j < arr.length; j++ )
            {
                if ( arr[i] + arr[j] == target )
                    return true;
            }
        }
        return false;
    }

    /**
     * Optimized Approach (Two-Pointer)
     * - Uses the fact that array is sorted
     * - Move pointers based on sum comparison with target
     * - Time Complexity: O(n)
     * - Space Complexity: O(1)
     */
    public static boolean findTwoSumTwoPointerApproach(int[] arr, int target)
    {
        int i = 0; int j = arr.length - 1;
        while ( i < j )
        {
            if ( arr[i] + arr[j] == target )
                return true;
            else if ( arr[i] + arr[j] < target )
                i++; // need larger value
            else
                j--; // need smaller value
        }
        return false;
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
                {1, 2, 3, 4, 6},      // Normal sorted array
                {2, 5, 8, 12, 30},    // Larger gaps
                {1, 1, 1, 1},         // Duplicate values
                {5},                  // Single element (edge case)
                {}                    // Empty array (edge case)
        };

        int[] targets = {6, 17, 2, 5, 10};

        // Run tests
        for (int t = 0; t < testArrays.length; t++) {
            int[] arr = testArrays[t];
            int target = targets[t];

            System.out.println("Test Case " + (t + 1));
            System.out.print("Array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println("\nTarget: " + target);

            boolean resultNaive = findTwoSumNaive(arr, target);
            boolean resultTwoPointer = findTwoSumTwoPointerApproach(arr, target);

            System.out.println("Naive Result       : " + resultNaive);
            System.out.println("Two-Pointer Result : " + resultTwoPointer);
            System.out.println("---------------------------------");
        }
    }
}
