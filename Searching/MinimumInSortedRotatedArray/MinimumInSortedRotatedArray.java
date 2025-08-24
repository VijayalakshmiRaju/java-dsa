public class MinimumInSortedRotatedArray {

    // Linear Search approach (O(n))
    public static int findMinimumLinear( int[] arr )
    {
        int min = arr[0];
        for ( int i = 1; i < arr.length; i++ )
        {
            if ( arr[i] < min )
                min = arr[i];
        }

        return min;
    }

    // Binary Search approach (O(log n))
    public static int findMinimumBinarySearch( int[] arr )
    {
        int low = 0; int high = arr.length - 1;

        // If the subarray is already sorted, then arr[low] is the minimum
        while ( low < high )
        {
            if ( arr[low] < arr[high] )
                return arr[low];

            int mid = low + ( high - low ) / 2;

            // If mid element > rightmost, min must be in right half
            if ( arr[mid] > arr[high] )
                low = mid + 1;
            else
                // Min must be in left half (including mid)
                high = mid - 1;
        }

        // At the end, low == high → pointing to the minimum element
        return arr[low];
    }

    public static void main(String[] args) {
        // Test Cases
        int[][] testArrays = {
                {4, 5, 6, 7, 0, 1, 2},   // Rotated, min = 0
                {3, 4, 5, 1, 2},         // Rotated, min = 1
                {11, 13, 15, 17},        // Not rotated, min = 11
                {2, 3, 4, 5, 6, 1},      // Rotated, min = 1
                {1},                     // Single element, min = 1
                {5, 6, 7, 8, 9, 10}      // Already sorted, min = 5
        };

        // Run tests
        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];

            System.out.print("Test case " + (i + 1) + ": ");
            for (int num : arr) System.out.print(num + " ");
            System.out.println();

            int minLinear = findMinimumLinear(arr);
            int minBinary = findMinimumBinarySearch(arr);

            System.out.println("  → Minimum (Linear): " + minLinear);
            System.out.println("  → Minimum (Binary Search): " + minBinary);
            System.out.println();
        }
    }
}
