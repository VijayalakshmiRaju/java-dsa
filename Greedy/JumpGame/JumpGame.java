public class JumpGame {

    // Function to check if we can reach the last index
    public static boolean jumpGame( int[] nums ) {
        int farthest = 0; // farthest block we can reach

        for ( int i = 0; i < nums.length; i++ ) {
            if ( i > farthest )
                return false; // can't even reach this block, stop

            // Update the farthest we can reach from this block
            farthest = Math.max(farthest, i + nums[i]);

            // If farthest already covers the last block, we are done
            if ( farthest >= nums.length - 1 )
                return true;
        }

        // After finishing loop, check if we covered last block
        return farthest >= nums.length - 1;
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test case 1: Example from problem statement
        int[] nums1 = {2, 3, 1, 1, 4}; // Expected: true
        // Test case 2: Stuck before last index
        int[] nums2 = {3, 2, 1, 0, 4}; // Expected: false
        // Test case 3: Single element (already at last index)
        int[] nums3 = {0};             // Expected: true
        // Test case 4: Large jump at the beginning
        int[] nums4 = {5, 0, 0, 0, 0}; // Expected: true
        // Test case 5: All zeros except first element
        int[] nums5 = {0, 0, 0, 0};    // Expected: false
        // Test case 6: Exact jumps required
        int[] nums6 = {1, 1, 1, 1};    // Expected: true
        // Test case 7: Last index is unreachable due to zero in between
        int[] nums7 = {2, 0, 0, 0};    // Expected: false

        // Run tests
        test(nums1);
        test(nums2);
        test(nums3);
        test(nums4);
        test(nums5);
        test(nums6);
        test(nums7);
    }

    // Helper method to print result for each test case
    private static void test(int[] nums) {
        System.out.print("Input: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.print("] -> ");

        boolean result = jumpGame(nums);
        System.out.println("Can reach last index? " + result);
    }
}
