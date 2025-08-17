public class PeakElementInUnsortedArray {

    /**
     * Linear search to find a peak element.
     * Returns the value of a peak element.
     * Time Complexity: O(n)
     */
    public static int findPeakElementLinear(int[] arr, int n)
    {
        // Only one element
        if ( n == 1 )
            return arr[0];

        // Check first element
        if ( arr[0] >= arr[1] )
            return arr[0];

        // Check last element
        if ( arr[n-1] >= arr[n-2])
            return arr[n-1];

        // Check middle elements
        for ( int i = 1; i < n-1; i++ )
        {
            if ( arr[i] >= arr[i-1] && arr[i] >= arr[i+1])
                return arr[i];
        }

        // Default return (should not reach here)
        return -1;
    }

    /**
     * Iterative Binary Search to find a peak element.
     * Returns the value of a peak element.
     * Time Complexity: O(log n)
     */
    public static int findPeakElementUsingBinarySearch( int[] arr, int n )
    {
        int low = 0;
        int high = n - 1;

        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;

            // Check if mid is a peak
            if ( (mid == 0 || arr[mid-1] <= arr[mid]) && ( mid == n-1 || arr[mid +1 ] <= arr[mid] ))
                return arr[mid];

            // If left neighbor is bigger, move left
            if ( mid > 0 && arr[mid - 1] > arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                {1, 3, 20, 4, 1, 0},           // general case
                {10, 20, 15, 2, 23, 90, 67},   // multiple peaks
                {5},                            // single element
                {1, 2, 3, 4, 5},                // strictly increasing
                {5, 4, 3, 2, 1},                // strictly decreasing
                {1, 2, 3, 2, 1},                // peak in middle
                {2, 2, 2, 2, 2},                // all elements same
                {1, 2},                          // two elements increasing
                {2, 1}                           // two elements decreasing
        };

        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int n = arr.length;

            int peakLinear = findPeakElementLinear(arr, n);
            int peakBinary = findPeakElementUsingBinarySearch(arr, n);

            System.out.println("Test case " + (i + 1) + ": " + java.util.Arrays.toString(arr));
            System.out.println("  Peak (Linear Search) : " + peakLinear);
            System.out.println("  Peak (Binary Search) : " + peakBinary);
            System.out.println("------------------------------------------------");
        }
    }
}
