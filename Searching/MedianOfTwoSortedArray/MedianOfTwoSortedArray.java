import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static double findMedianNaive ( int[] arr1, int[] arr2 )
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] temp = new int[n1+n2];

        for ( int i = 0; i < n1; i++ )
        {
            temp[i] = arr1[i];
        }

        for ( int i = 0; i < n2; i++ )
        {
            temp[n1+i] = arr2[i];
        }

        Arrays.sort(temp);

        int len = temp.length;
        int mid = len / 2;

        if ( (n1 + n2) % 2 == 1 )
        {
            return (double) (temp[mid]);
        }
        else
            return (double) (temp[mid - 1] + temp[mid]) / 2.0;
    }


    public static double findMedianOptimized(int[] arr1, int[] arr2)
    {
        if ( arr1.length > arr2.length )
            return findMedianOptimized(arr2, arr1);

        int n1 = arr1.length; int n2 = arr2.length;

        int low = 0; int high = n1;

        while ( low <= high )
        {
            int partitionX = (low + high) / 2;
            int partitionY = ( ( n1 + n2 + 1 ) / 2 ) - partitionX;

            int maxLeftX = (partitionX == 0 ) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = (partitionX == n1) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = (partitionY == n2) ? Integer.MAX_VALUE : arr2[partitionY];

            if ( maxLeftX <= minRightY && maxLeftY <= minRightX )
            {
                if ( (n1 + n2) % 2 == 0 ) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }
            else if ( maxLeftX > minRightY )
            {
                high = partitionX - 1;
            }
            else
            {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays not sorted");
    }

    public static void main(String[] args) {
        // Basic test
        test(new int[]{1, 3}, new int[]{2});            // Odd total length
        test(new int[]{1, 2}, new int[]{3, 4});         // Even total length

        // One empty array
        test(new int[]{}, new int[]{1});                 // Only one element
        test(new int[]{}, new int[]{2, 3});              // Even number in one array
        test(new int[]{1, 2, 3}, new int[]{});           // First non-empty

        // Different sizes
        test(new int[]{1, 3, 8}, new int[]{7, 9, 10, 11});
        test(new int[]{23, 26, 31, 35}, new int[]{3, 5, 7, 9, 11, 16});

        // Disjoint arrays (all elements of one < other)
        test(new int[]{1, 2, 3}, new int[]{10, 11, 12});
        test(new int[]{5, 6, 7}, new int[]{1, 2, 3, 4});

        // Arrays with duplicates
        test(new int[]{1, 2, 2}, new int[]{2, 2, 3});
        test(new int[]{1, 1, 1}, new int[]{1, 1, 1, 1});

        // Edge case: both arrays empty (should error)
        try {
            test(new int[]{}, new int[]{});
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
