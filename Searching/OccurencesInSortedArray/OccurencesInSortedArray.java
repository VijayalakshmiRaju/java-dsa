/**
 * OccurrencesInSortedArray.java
 * This program finds the number of occurrences of a given element
 * in a sorted array using two approaches:
 * 1. Linear Search
 * 2. Binary Search (optimized for sorted arrays)
 */
public class OccurencesInSortedArray {
    // Linear search approach: O(n)
    public static int findNumberOfOccurrencesLinearSearch( int[] arr, int x )
    {
        int count = 0;
        for ( int i = 0; i < arr.length; i++ )
        {
            if ( arr[i] == x )
                count++;
        }
        return count;
    }

    // Binary search approach: O(log n)
    public static int findNumberOfOccurrencesBinarySearch( int[] arr, int x )
    {
        int n = arr.length;
        int firstIndex = findFirstIndex(arr, x, 0, n-1);
        if (firstIndex == -1)
            // Element not present
            return 0;
        int lastIndex = findLastIndex(arr, x, 0, n-1, n);
        return lastIndex - firstIndex + 1;
    }

    // Find first occurrence of x in sorted array
    private static int findFirstIndex(int[] arr, int x , int low, int high)
    {
        if ( low <= high )
        {
            int mid = low + ( high - low ) / 2;

            if ( ( mid == 0 || arr[mid - 1] < x ) && arr[mid] == x)
                return mid;
            else if ( arr[mid] < x )
                return findFirstIndex(arr, x, mid+1, high);
            else
                return findFirstIndex(arr, x, low, mid-1);
        }
        return -1;
    }

    private static int findLastIndex(int[] arr, int x , int low, int high, int n)
    {
        if ( low <= high )
        {
            int mid = low + ( high - low ) / 2;

            if ( ( mid == n-1 || x < arr[mid + 1] ) && arr[mid] == x)
                return mid;
            else if ( arr[mid] > x )
                return findLastIndex(arr, x, low, mid-1, n);
            else
                return findLastIndex(arr, x, mid+1, high, n);
        }
        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int x = 2;

        System.out.println("Array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nElement to find: " + x);

        int countLinear = findNumberOfOccurrencesLinearSearch(arr, x);
        System.out.println("Occurrences (Linear Search): " + countLinear);

        int countBinary = findNumberOfOccurrencesBinarySearch(arr, x);
        System.out.println("Occurrences (Binary Search): " + countBinary);
    }
}
