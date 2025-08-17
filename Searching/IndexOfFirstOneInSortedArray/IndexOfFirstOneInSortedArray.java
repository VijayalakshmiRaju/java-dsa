/**
 * This program finds the first index of 1 in a sorted binary array.
 * A binary array contains only 0s and 1s and is sorted in non-decreasing order.
 */
public class IndexOfFirstOneInSortedArray {

    // Finds the first occurrence of 1 in a sorted binary array using Binary Search.
    public static int findFirstIndexOfOne(int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;

        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;

            // Check if mid is the first 1
            if ( arr[mid] == 1 && (mid == 0 || arr[mid-1] == 0))
                return mid;
            // If mid is 1 but not the first, search left side
            else if ( arr[mid] == 1 )
                high = mid - 1;
            // If mid is 0, search right side
            else
                low = mid + 1;
        }

        // If 1 is not found
        return -1;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1},
                {1},
                {0}
        };

        for (int i = 0; i < testCases.length; i++) {
            int index = findFirstIndexOfOne(testCases[i]);
            System.out.print("Test Case " + (i + 1) + ": ");
            if (index != -1) {
                System.out.println("First occurrence of 1 is at index " + index);
            } else {
                System.out.println("No 1 found in the array");
            }
        }
    }
}
