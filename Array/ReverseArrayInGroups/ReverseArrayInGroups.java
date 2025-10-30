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
     * - For each chunk, reverse the subarray from index 'i' to 'i + k - 1' (or the array end if fewer elements remain).
     * - Swap elements from both ends moving toward the center.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) — in-place reversal
     */
    public static void reverseArrayInGroups(int[] arr, int k)
    {
        int n = arr.length;

        // Traverse array in groups of 'k' elements
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // handle case when remaining elements < k

            // Reverse current group
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
        // ---------- Test Case 1: Normal Case ----------
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int k1 = 3;
        reverseArrayInGroups(arr1, k1);
        System.out.println("Test Case 1:");
        System.out.println("Input: [1, 2, 3, 4, 5, 6, 7, 8], k = 3");
        System.out.println("Output: " + Arrays.toString(arr1));
        System.out.println("---------------------------------------");

        // ---------- Test Case 2: k = 1 (no change expected) ----------
        int[] arr2 = {10, 20, 30, 40};
        int k2 = 1;
        reverseArrayInGroups(arr2, k2);
        System.out.println("Test Case 2:");
        System.out.println("Input: [10, 20, 30, 40], k = 1");
        System.out.println("Output: " + Arrays.toString(arr2));
        System.out.println("---------------------------------------");

        // ---------- Test Case 3: k > array length (entire array reversed) ----------
        int[] arr3 = {5, 10, 15};
        int k3 = 5;
        reverseArrayInGroups(arr3, k3);
        System.out.println("Test Case 3:");
        System.out.println("Input: [5, 10, 15], k = 5");
        System.out.println("Output: " + Arrays.toString(arr3));
        System.out.println("---------------------------------------");

        // ---------- Test Case 4: Array length not multiple of k ----------
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7};
        int k4 = 4;
        reverseArrayInGroups(arr4, k4);
        System.out.println("Test Case 4:");
        System.out.println("Input: [1, 2, 3, 4, 5, 6, 7], k = 4");
        System.out.println("Output: " + Arrays.toString(arr4));
        System.out.println("---------------------------------------");

        // ---------- Test Case 5: Single-element array ----------
        int[] arr5 = {42};
        int k5 = 2;
        reverseArrayInGroups(arr5, k5);
        System.out.println("Test Case 5:");
        System.out.println("Input: [42], k = 2");
        System.out.println("Output: " + Arrays.toString(arr5));
        System.out.println("---------------------------------------");

        // ---------- Test Case 6: Empty array ----------
        int[] arr6 = {};
        int k6 = 3;
        reverseArrayInGroups(arr6, k6);
        System.out.println("Test Case 6:");
        System.out.println("Input: [], k = 3");
        System.out.println("Output: " + Arrays.toString(arr6));
        System.out.println("---------------------------------------");

        // ---------- Test Case 7: k = array length ----------
        int[] arr7 = {9, 8, 7, 6, 5};
        int k7 = 5;
        reverseArrayInGroups(arr7, k7);
        System.out.println("Test Case 7:");
        System.out.println("Input: [9, 8, 7, 6, 5], k = 5");
        System.out.println("Output: " + Arrays.toString(arr7));
        System.out.println("---------------------------------------");
    }
}
