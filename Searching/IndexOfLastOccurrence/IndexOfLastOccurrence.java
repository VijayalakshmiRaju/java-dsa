public class IndexOfLastOccurrence {

    // Linear search method to find last occurrence
    public static int findLastOccurrenceLinear(int[] arr, int x) {
        // Traverse the array and check for last occurrence manually
        int result = -1; // keeps track of the last found index
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result = i; // update whenever we find x
            }
        }
        return result;
    }

    // Binary Search method (Optimized for sorted arrays)
    public static int findLastOccurrenceBinarySearch(int[] arr, int x )
    {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;
            if ( arr[mid] < x )
                low = mid + 1;  // move right
            else if ( arr[mid] > x )
                high = mid - 1; // move left
            else {
                result =  mid;
                low = mid + 1;
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 5};

        int x1 = 2;
        int x2 = 5;
        int x3 = 7;

        System.out.println("Array: [1, 2, 2, 2, 3, 4, 5, 5, 5, 6]\n");

        // Testing Linear Search
        System.out.println("Using Linear Search:");
        System.out.println("Last occurrence of " + x1 + " is at index: " + findLastOccurrenceLinear(arr, x1));
        System.out.println("Last occurrence of " + x2 + " is at index: " + findLastOccurrenceLinear(arr, x2));
        System.out.println("Last occurrence of " + x3 + " is at index: " + findLastOccurrenceLinear(arr, x3));

        // Testing Binary Search
        System.out.println("\nUsing Binary Search (Optimized for sorted array):");
        System.out.println("Last occurrence of " + x1 + " is at index: " + findLastOccurrenceBinarySearch(arr, x1));
        System.out.println("Last occurrence of " + x2 + " is at index: " + findLastOccurrenceBinarySearch(arr, x2));
        System.out.println("Last occurrence of " + x3 + " is at index: " + findLastOccurrenceBinarySearch(arr, x3));
    }
}
