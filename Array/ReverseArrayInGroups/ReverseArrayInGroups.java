import java.util.Arrays;

public class ReverseArrayInGroups {

    /**
     * Function to reverse elements of an array in groups of size 'k'.
     *
     * Example:
     * Input:  arr = [1, 2, 3, 4, 5, 6, 7, 8], k = 3
     * Output: [3, 2, 1, 6, 5, 4, 8, 7]
     *
     * Logic:
     * - Traverse the array in chunks of size 'k'.
     * - For each chunk, reverse the subarray from index 'i' to 'i + k - 1'
     *   (or until the end if remaining elements are less than k).
     * - Swap elements from both ends moving toward the center.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) — In-place reversal
     */
    public static void reverseArrayInGroups(int[] arr, int k)
    {
        int n = arr.length;

        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // handle leftover group smaller than k

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args)
    {
        // Each test case: { array, k }
        Object[][] testCases = {
                { new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3 },
                { new int[]{10, 20, 30, 40}, 1 },
                { new int[]{5, 10, 15}, 5 },
                { new int[]{1, 2, 3, 4, 5, 6, 7}, 4 },
                { new int[]{42}, 2 },
                { new int[]{}, 3 },
                { new int[]{9, 8, 7, 6, 5}, 5 }
        };

        System.out.println("===== Reverse Array in Groups - Test Results =====");

        // Loop through all test cases
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = ((int[]) testCases[i][0]).clone(); // clone to avoid mutation between cases
            int k = (int) testCases[i][1];

            System.out.println("\nTest Case " + (i + 1) + ":");
            System.out.println("Input Array: " + Arrays.toString((int[]) testCases[i][0]));
            System.out.println("Group Size (k): " + k);

            reverseArrayInGroups(arr, k);

            System.out.println("Output Array: " + Arrays.toString(arr));
            System.out.println("---------------------------------------");
        }
    }
}
