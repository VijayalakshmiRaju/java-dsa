import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Returns an array where result[i] is the product of all elements except nums[i],
     * without using division and in O(n) time.
     *
     * @param nums Input array of integers
     * @return Array of products except self
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix product for each index
        // result[i] will store product of all elements before index i
        result[0] = 1; // No element before first index, so prefix product = 1
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with suffix product
        // suffixProduct will hold product of all elements after index i
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i]; // Update suffix for next iteration (moving left)
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Normal case
        testCase(new int[]{1, 2, 3, 4}, "Basic Case");

        // Test Case 2: Array with zero (one zero only)
        testCase(new int[]{1, 2, 0, 4}, "Single Zero");

        // Test Case 3: Array with multiple zeros (all products become zero)
        testCase(new int[]{0, 2, 0, 4}, "Multiple Zeros");

        // Test Case 4: Array with negative numbers
        testCase(new int[]{-1, 2, -3, 4}, "Negative Numbers");

        // Test Case 5: Array with one element (edge case)
        testCase(new int[]{10}, "Single Element");

        // Test Case 6: Array with two elements (minimal valid case)
        testCase(new int[]{5, 6}, "Two Elements");

        // Test Case 7: Array with all same elements
        testCase(new int[]{3, 3, 3, 3}, "All Same Elements");
    }

    /**
     * Helper method to run and print test case results with proper formatting.
     */
    private static void testCase(int[] nums, String description) {
        int[] result = productExceptSelf(nums);
        System.out.println("=== " + description + " ===");
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(result));
        System.out.println();
    }
}
