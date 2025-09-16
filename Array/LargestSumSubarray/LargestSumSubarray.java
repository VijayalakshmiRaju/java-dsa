public class LargestSumSubarray {

    /**
     * Function to find the maximum subarray sum using Kadane's Algorithm.
     *
     * @param nums Input array (may contain positive, negative, or zero values)
     * @return Maximum subarray sum
     */
    public static int maxSumSubArray(int[] nums) {
        int n = nums.length;

        int curSum = nums[0];  // Stores sum of current subarray being considered
        int maxSum = nums[0];  // Stores maximum sum found so far

        for (int i = 1; i < n; i++) {
            // Either start a new subarray from current element OR extend previous subarray
            curSum = Math.max(nums[i], curSum + nums[i]);

            // Update maxSum if curSum is greater
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Array of test cases
        int[][] testCases = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},  // Mixed pos/neg
                {1, 2, 3, 4, 5},                  // All positives
                {-8, -3, -6, -2, -5, -4},         // All negatives
                {10},                             // Single positive
                {-10},                            // Single negative
                {-5, -4, -1, 2, 3, 4, 5},         // Large subarray at end
                {5, 4, -10, 1, 2, -1},            // Large subarray at start
                {0, -1, 2, 3, 0, -2, 4}           // Contains zeros
        };

        String[] descriptions = {
                "Mixed Pos/Neg",
                "All Positive",
                "All Negative",
                "Single Positive",
                "Single Negative",
                "Subarray at End",
                "Subarray at Start",
                "Contains Zeros"
        };

        // Iterate over all test cases using a loop
        for (int i = 0; i < testCases.length; i++) {
            int result = maxSumSubArray(testCases[i]);
            System.out.println("Test Case " + (i + 1) + " (" + descriptions[i] + "): " + result);
        }
    }
}
