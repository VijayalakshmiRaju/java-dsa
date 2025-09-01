import java.util.Arrays;

public class CountDuplicateElementInSortedArray {

    /**
     * Naive method: Traverse the array and count duplicates linearly.
     * Time: O(n), Space: O(1)
     */
    public static int[] countDuplicateElementNaive (int[] arr)
    {
        int[] result = new int[]{-1, -1};
        int duplicate = -1;
        int count = 0;

        // Check adjacent elements for repetition
        for ( int i = 0; i < arr.length - 1; i++ )
        {
            if ( arr[i] == arr[i+1]) {
                duplicate = arr[i];
                count++;
            }
        }

        // In naive method, we only detect adjacent duplicates.
        // If count > 0, element repeated (count+1 times in total).
        if ( count > 0)
        {
            result[0] = duplicate;
            result[1] = count+1; // add 1 because we counted transitions
        }

        return result;
    }

    /**
     * Optimized method: Use binary search to detect duplicate element.
     * Time: O(log n), Space: O(1)
     */
    public static int[] countDuplicateElementBinarySearch ( int[] arr )
    {
        int n = arr.length;
        int low = 0, high = n - 1;

        int duplicate = -1;

        // Binary search for the point where arr[i] - arr[0] < i
        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;

            if ( arr[mid] - arr[0] < mid ) {
                duplicate = arr[mid];
                high = mid - 1; // look left for first duplicate
            }
            else {
                low = mid + 1;
            }
        }

        if ( duplicate == -1 )
            return new int[] { -1, -1 };

        // Find first and last occurrence of the duplicate
        int firstIndex = findFirstIndexOfDuplicateElement(arr, duplicate);
        int lastIndex = findLastIndexOfDuplicateElement(arr, duplicate);

        int count = lastIndex - firstIndex + 1;

        return new int[] { duplicate, count };
    }

    /**
     * Helper: Binary search for first index of target
     */
    public static int findFirstIndexOfDuplicateElement(int[] arr, int target)
    {
        int low = 0, high = arr.length - 1;

        int result = -1;
        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;

            if ( arr[mid] == target )
            {
                result = mid;
                high = mid - 1; // move left
            }
            else if ( arr[mid] < target )
            {
                low = mid + 1;
            }
            else
            {
                high = mid -1;
            }
        }

        return result;
    }


    /**
     * Helper: Binary search for last index of target
     */
    public static int findLastIndexOfDuplicateElement(int[] arr, int target)
    {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while ( low <= high )
        {
            int mid = low + (high - low) / 2;

            if ( arr[mid] == target )
            {
                result = mid;
                low = mid + 1; // move right
            }
            else if ( arr[mid] < target )
                low = mid + 1;
            else
                high = mid - 1;
        }

        return result;
    }

    /**
     * Driver with test cases (including edge cases)
     */
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3, 3, 4},       // duplicate in middle
                {2, 3, 4, 5, 5, 6},    // duplicate near end
                {2, 2, 3, 4, 5},       // duplicate at start
                {1, 2, 3, 4, 5},       // no duplicate
                {5},                   // single element
                {7, 7},                // only two elements and both duplicate
                {10, 11, 12, 12, 12, 13, 14} // duplicate more than twice
        };

        System.out.println("=== Naive vs Binary Search Duplicate Finder ===");
        for (int[] arr : testCases) {
            int[] resNaive = countDuplicateElementNaive(arr);
            int[] resBinary = countDuplicateElementBinarySearch(arr);

            System.out.println("Array: " + Arrays.toString(arr));
            System.out.println("Naive:  " + Arrays.toString(resNaive));
            System.out.println("Binary: " + Arrays.toString(resBinary));
            System.out.println("-----------------------------------");
        }
    }
}
