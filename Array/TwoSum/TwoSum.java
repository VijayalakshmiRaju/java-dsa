import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    /**
     * Naive approach: Check every pair (O(n^2))
     */
    public static int[] findTwoSumNaive(int[] nums, int target) {
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
    public static int[] findTwoSumHashMap(int[] nums, int target) {
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
     * 3. Two Pointers Approach (works only for sorted arrays) - O(n)
     */
    public static int[] findTwoSumTwoPointers(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Helper method to print results
     */
    public static void printResult(String approach, int[] nums, int target, int[] indices) {
        System.out.println("Approach: " + approach);
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Output Indices: " + Arrays.toString(indices));
        System.out.println("Numbers: " + nums[indices[0]] + " + " + nums[indices[1]] + " = " + target);
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                {2, 7, 11, 15},    // normal case
                {3, 2, 4},         // numbers not at start
                {3, 3},            // duplicate numbers
                {-1, -2, -3, -4, -5}, // negative numbers
                {0, 4, 3, 0},      // zeros included
                {1, 2}             // minimum length array
        };
        int[] targets = {9, 6, 6, -8, 0, 3};

        // Run for each test case
        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int target = targets[i];

            // Naive
            int[] resultNaive = findTwoSumNaive(nums, target);
            printResult("Naive (Brute Force)", nums, target, resultNaive);

            // HashMap
            int[] resultHashMap = findTwoSumHashMap(nums, target);
            printResult("Optimized (HashMap)", nums, target, resultHashMap);

            // Two Pointers (only works correctly if array is sorted)
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted); // ensure sorted before applying two pointers
            try {
                int[] resultTwoPointers = findTwoSumTwoPointers(sorted, target);
                printResult("Two Pointers (Sorted Array)", sorted, target, resultTwoPointers);
            } catch (IllegalArgumentException e) {
                System.out.println("Approach: Two Pointers (Sorted Array)");
                System.out.println("Input array: " + Arrays.toString(sorted));
                System.out.println("Target: " + target);
                System.out.println("No valid two sum solution found with this approach.");
                System.out.println("---------------------------------------------------");
            }
        }
    }
}
