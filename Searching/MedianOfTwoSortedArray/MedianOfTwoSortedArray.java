import java.util.Arrays;

public class MedianOfTwoSortedArray {

    /**
     * Naive Approach:
     * 1. Merge both arrays into a new array
     * 2. Sort the merged array
     * 3. Find the median based on length (odd/even)
     * Time Complexity: O((m+n) log(m+n))  due to sorting
     * Space Complexity: O(m+n) for merged array
     */
    public static double findMedianNaive ( int[] arr1, int[] arr2 )
    {
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Create a temporary array to hold elements of both arrays
        int[] temp = new int[n1+n2];

        // Copy arr1 into temp
        for ( int i = 0; i < n1; i++ )
        {
            temp[i] = arr1[i];
        }

        // Copy arr2 into temp (starting from index n1)
        for ( int i = 0; i < n2; i++ )
        {
            temp[n1+i] = arr2[i];
        }

        // Sort the combined array
        Arrays.sort(temp);

        // Find middle index
        int len = temp.length;
        int mid = len / 2;

        // If odd, return middle element
        if ( len % 2 == 1 )
        {
            return temp[mid];
        }
        else // If even, return average of middle two elements
            return (temp[mid - 1] + temp[mid]) / 2.0;
    }

    /**
     * Optimized Approach (Binary Search Partition Method):
     * 1. Always binary search on the smaller array
     * 2. Partition both arrays such that:
     *    - left side contains half of total elements
     *    - all left elements <= all right elements
     * 3. Median is either:
     *    - max(left) if odd length
     *    - average of max(left) & min(right) if even length
     * Time Complexity: O(log(min(m, n)))
     * Space Complexity: O(1)
     */
    public static double findMedianOptimized(int[] arr1, int[] arr2)
    {
        // Ensure arr1 is smaller for efficient binary search
        if ( arr1.length > arr2.length )
            return findMedianOptimized(arr2, arr1);

        int n1 = arr1.length; int n2 = arr2.length;
        int low = 0; int high = n1;

        // Binary search on smaller array
        while ( low <= high )
        {
            // Partition indices
            int partitionX = (low + high) / 2;
            int partitionY = ( ( n1 + n2 + 1 ) / 2 ) - partitionX;

            // Edge cases: if partition at the boundary
            int maxLeftX = (partitionX == 0 ) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = (partitionX == n1) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = (partitionY == n2) ? Integer.MAX_VALUE : arr2[partitionY];

            // Check if valid partition
            if ( maxLeftX <= minRightY && maxLeftY <= minRightX )
            {
                // If even total length → median is average of two middle values
                if ( (n1 + n2) % 2 == 0 ) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else { // If odd total length → median is max of left partition
                    return Math.max(maxLeftX, maxLeftY);
                }
            }
            else if ( maxLeftX > minRightY ) // Move binary search window
            {
                high = partitionX - 1;  // Move left
            }
            else
            {
                low = partitionX + 1; // Move right
            }
        }

        throw new IllegalArgumentException("Input arrays not sorted");
    }

    public static void main(String[] args) {
        // Basic test
        test(new int[]{1, 3}, new int[]{2});            // Odd total length - Expected: 2.0 (merged [1,2,3], middle = 2)
        test(new int[]{1, 2}, new int[]{3, 4});         // Even total length - Expected: 2.5 (merged [1,2,3,4], median = (2+3)/2)

        // One empty array
        test(new int[]{}, new int[]{1});                 // Only one element - Expected: 1.0 (only one element)
        test(new int[]{}, new int[]{2, 3});              // Even number in one array - Expected: 2.5 (median of [2,3] = (2+3)/2)
        test(new int[]{1, 2, 3}, new int[]{});           // First non-empty - Expected: 2.0 (median of [1,2,3])

        // Different sizes
        test(new int[]{1, 3, 8}, new int[]{7, 9, 10, 11}); // Expected: 8.0 (merged [1,3,7,8,9,10,11], middle = 8)
        test(new int[]{23, 26, 31, 35}, new int[]{3, 5, 7, 9, 11, 16}); // Expected: 13.5 (merged length=10, median = (11+16)/2)

        // Disjoint arrays (all elements of one < other)
        test(new int[]{1, 2, 3}, new int[]{10, 11, 12}); // Expected: 6.5 (merged [1,2,3,10,11,12], median = (3+10)/2)
        test(new int[]{5, 6, 7}, new int[]{1, 2, 3, 4}); // Expected: 4.0 (merged [1,2,3,4,5,6,7], middle = 4)

        // Arrays with duplicates
        test(new int[]{1, 2, 2}, new int[]{2, 2, 3});    // Expected: 2.0 (merged [1,2,2,2,2,3], middle = (2+2)/2)
        test(new int[]{1, 1, 1}, new int[]{1, 1, 1, 1}); // Expected: 1.0 (all elements are 1)

        // Edge case: both arrays empty (should error)
        try {
            test(new int[]{}, new int[]{}); // Expected: Exception
        } catch (Exception e) {
            System.out.println("Test case [] + [] -> Exception: " + e.getMessage());
        }
    }

    private static void test(int[] arr1, int[] arr2) {
        double naive = findMedianNaive(arr1, arr2);
        double optimized = findMedianOptimized(arr1, arr2);
        System.out.println("Arrays: " + Arrays.toString(arr1) + " + " + Arrays.toString(arr2));
        System.out.println("Naive Median: " + naive + ", Optimized Median: " + optimized);
        System.out.println("--------------------------------------------------");
    }
}
