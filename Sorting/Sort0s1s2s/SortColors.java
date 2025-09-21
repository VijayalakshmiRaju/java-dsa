import java.util.Arrays;

public class SortColors {

    /**
     * Naive approach: Counting method
     * 1. Count number of 0's, 1's, and 2's
     * 2. Overwrite array with that many 0's, then 1's, then 2's
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void countingSortColors(int[] arr) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // Count frequency of 0, 1, and 2
        for (int num : arr) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
            else cnt2++;
        }

        // Overwrite array with 0's
        int idx = 0;
        for (int i = 0; i < cnt0; i++) {
            arr[idx++] = 0;
        }

        // Overwrite array with 1's
        for (int i = 0; i < cnt1; i++) {
            arr[idx++] = 1;
        }

        // Overwrite array with 2's
        for (int i = 0; i < cnt2; i++) {
            arr[idx++] = 2;
        }
    }

    /**
     * Optimized approach: Dutch National Flag Algorithm
     * 1. Use 3 pointers: low, mid, high
     * 2. Place 0's before low, 1's in the middle, and 2's after high
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void dutchNationalFlagSort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        // Process elements until mid crosses high
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[mid] and arr[low]
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;

                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Element 1 is already in correct place
                mid++;
            } else { // arr[mid] == 2
                // Swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
                // Don't increment mid here, because swapped value needs checking
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Naive method
        int[] arr1 = {0, 2, 2, 1, 0, 2, 2, 1, 0, 1};
        System.out.println("Naive Method:");
        System.out.println("Original: " + Arrays.toString(arr1));
        countingSortColors(arr1);
        System.out.println("Sorted  : " + Arrays.toString(arr1));

        // Test Case 2: Optimized method
        int[] arr2 = {0, 2, 2, 1, 0, 2, 2, 1, 0, 0};
        System.out.println("\nOptimized Method:");
        System.out.println("Original: " + Arrays.toString(arr2));
        dutchNationalFlagSort(arr2);
        System.out.println("Sorted  : " + Arrays.toString(arr2));

        // Edge Case 1: Already sorted
        int[] arr3 = {0, 0, 1, 1, 2, 2};
        System.out.println("\nAlready Sorted Array:");
        System.out.println("Original: " + Arrays.toString(arr3));
        dutchNationalFlagSort(arr3);
        System.out.println("Sorted  : " + Arrays.toString(arr3));

        // Edge Case 2: Reverse sorted
        int[] arr4 = {2, 2, 1, 1, 0, 0};
        System.out.println("\nReverse Sorted Array:");
        System.out.println("Original: " + Arrays.toString(arr4));
        dutchNationalFlagSort(arr4);
        System.out.println("Sorted  : " + Arrays.toString(arr4));

        // Edge Case 3: All zeros
        int[] arr5 = {0, 0, 0, 0};
        System.out.println("\nAll Zeros:");
        System.out.println("Original: " + Arrays.toString(arr5));
        dutchNationalFlagSort(arr5);
        System.out.println("Sorted  : " + Arrays.toString(arr5));

        // Edge Case 4: All twos
        int[] arr6 = {2, 2, 2, 2};
        System.out.println("\nAll Twos:");
        System.out.println("Original: " + Arrays.toString(arr6));
        dutchNationalFlagSort(arr6);
        System.out.println("Sorted  : " + Arrays.toString(arr6));

        // Edge Case 5: Single element
        int[] arr7 = {1};
        System.out.println("\nSingle Element:");
        System.out.println("Original: " + Arrays.toString(arr7));
        dutchNationalFlagSort(arr7);
        System.out.println("Sorted  : " + Arrays.toString(arr7));

        // Edge Case 6: Empty array
        int[] arr8 = {};
        System.out.println("\nEmpty Array:");
        System.out.println("Original: " + Arrays.toString(arr8));
        dutchNationalFlagSort(arr8);
        System.out.println("Sorted  : " + Arrays.toString(arr8));
    }
}
