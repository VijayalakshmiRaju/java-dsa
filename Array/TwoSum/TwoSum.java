import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    /**
     * Naive approach: Check every pair (O(n^2))
     */
    public int[] findTwoSumNaive(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If the pair sums to target, store indices
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result; // return immediately after finding the solution
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Optimized approach using HashMap (O(n))
     */
    public static int[] findTwoSumOptimized(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the current number and its index
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Helper method to print the result
     */
    public static void printResult(int[] nums, int target, int[] indices) {
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Indices of numbers adding up to target: " + Arrays.toString(indices));
        System.out.println("Numbers: " + nums[indices[0]] + " + " + nums[indices[1]] + " = " + target);
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
                {2, 7, 11, 15},    // normal case
                {3, 2, 4},         // numbers not at start
                {3, 3},            // duplicate numbers
                {-1, -2, -3, -4, -5}, // negative numbers
                {0, 4, 3, 0},      // zeros included
                {1, 2}             // minimum length array
        };
        int[] targets = {9, 6, 6, -8, 0, 3};

        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int target = targets[i];
            int[] result = findTwoSumOptimized(nums, target);
            printResult(nums, target, result);
        }
    }
}
