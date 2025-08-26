import java.util.Arrays;

public class IndexOfSubarraySum {

    /**
     * Naive Approach: O(n^2)
     * Checks all possible subarrays by starting at each index i
     * and extending to the right until sum == target (or end of array).
     */
    public static int[] findIndexOfSubarraySumNaive(int[] arr, int target)
    {
        int n = arr.length;
        int sum = 0;
        for ( int i = 0; i < n; i++ )
        {
            sum = 0; // reset sum for each new i
            for ( int j = i; j < n; j++ )
            {
                sum += arr[j];
                if ( sum == target )
                    // return 1-based indices
                    return new int[] {i+1, j+1};
            }
        }

        // No subarray found
        return new int[]{-1};
    }

    /**
     * Optimized Sliding Window Approach: O(n)
     * Expands and shrinks a window to maintain sum.
     * Works ONLY for non-negative integers.
     */
    public static int[] findIndexOfSubarraySumSlidingWindow(int[] arr, int target)
    {
        int n = arr.length;
        int left = 0, sum = 0;

        for ( int right = 0; right < n; right++ )
        {
            sum += arr[right];  // expand window

            // shrink window while sum is too large
            while ( sum > target && left <= right )
            {
                sum -= arr[left];
                left++;
            }

            // check if window sum matches target
            if ( sum == target )
                return new int[] { left+1, right+1 }; // 1-based
        }

        // No subarray found
        return new int[] { -1 };
    }

    public static void main(String[] args) {
        // Test arrays and targets
        int[][] testArrays = {
                {1, 2, 3, 7, 5},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {5, 3, 4},
                {1, 8, 2, 3, 8, 5}
        };
        int[] targets = {12, 15, 2, 13};

        // Run tests for both approaches
        for (int t = 0; t < testArrays.length; t++) {
            int[] arr = testArrays[t];
            int target = targets[t];

            System.out.println("\n===============================");
            System.out.println("Array: " + Arrays.toString(arr));
            System.out.println("Target: " + target);

            // Naive approach
            int[] naiveResult = findIndexOfSubarraySumNaive(arr, target);
            if (naiveResult.length == 1 && naiveResult[0] == -1) {
                System.out.println("Naive Approach: No subarray found");
            } else {
                System.out.println("Naive Approach: Subarray found from index "
                        + naiveResult[0] + " to " + naiveResult[1]);
            }

            // Sliding Window approach
            int[] slidingResult = findIndexOfSubarraySumSlidingWindow(arr, target);
            if (slidingResult.length == 1 && slidingResult[0] == -1) {
                System.out.println("Sliding Window: No subarray found");
            } else {
                System.out.println("Sliding Window: Subarray found from index "
                        + slidingResult[0] + " to " + slidingResult[1]);
            }
        }
    }
}
