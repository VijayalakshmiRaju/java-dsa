public class TrappingRainWater {

    /**
     * Function to calculate the total amount of trapped rainwater between bars.
     *
     * Approach (Two Pointer Technique - Optimized O(n) Time, O(1) Space):
     * - Use two pointers: left and right, starting from both ends of the array.
     * - Maintain leftMax and rightMax to store the maximum bar height seen so far from both sides.
     * - Water trapped at any point depends on the smaller of leftMax and rightMax.
     * - Move the pointer from the side having the smaller max height.
     */
    public static int maxWater(int[] arr) {
        // Base condition: if array has less than 3 bars, no water can be trapped
        if (arr == null || arr.length < 3)
            return 0;

        // Initialize pointers
        int left = 1;               // Start from second element
        int right = arr.length - 2; // Start from second last element

        // Initialize maximums on both ends
        int leftMax = arr[left - 1];
        int rightMax = arr[right + 1];

        int result = 0; // To store total trapped water

        // Traverse until both pointers meet
        while (left <= right) {

            // Process the side with smaller max height
            if (rightMax < leftMax) {
                // Water trapped at 'right' depends on rightMax
                result += Math.max(0, rightMax - arr[right]);

                // Update rightMax if current bar is taller
                rightMax = Math.max(rightMax, arr[right]);

                // Move right pointer inward
                right--;
            } else {
                // Water trapped at 'left' depends on leftMax
                result += Math.max(0, leftMax - arr[left]);

                // Update leftMax if current bar is taller
                leftMax = Math.max(leftMax, arr[left]);

                // Move left pointer inward
                left++;
            }
        }

        return result;
    }

    // ---------------------------------------------------------
    // Main method with multiple test cases and formatted output
    // ---------------------------------------------------------
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {3, 0, 2, 0, 4},             // Standard example -> Expected: 7
                {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2}, // Multiple pits -> Expected: 8
                {5, 4, 3, 2, 1},             // Strictly decreasing -> Expected: 0
                {1, 2, 3, 4, 5},             // Strictly increasing -> Expected: 0
                {2, 0, 2},                   // Single pit -> Expected: 2
                {4, 2, 0, 3, 2, 5},          // Mixed heights -> Expected: 9
                {1, 1, 1, 1},                // All same height -> Expected: 0
                {1, 0, 1},                   // Small pit -> Expected: 1
                {5},                         // Single element -> Expected: 0 (edge)
                {},                          // Empty array -> Expected: 0 (edge)
                null                         // Null array -> Expected: 0 (edge)
        };

        // Run all test cases
        System.out.println("=== Trapping Rain Water Problem ===\n");
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int result = maxWater(arr);

            // Display input array nicely
            System.out.printf("Test Case %2d: ", i + 1);
            if (arr == null)
                System.out.print("Input: null");
            else if (arr.length == 0)
                System.out.print("Input: []");
            else
                System.out.print("Input: " + java.util.Arrays.toString(arr));

            System.out.printf(" -> Trapped Water = %d\n", result);
        }
    }
}
