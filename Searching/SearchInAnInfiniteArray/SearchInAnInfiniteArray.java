public class SearchInAnInfiniteArray {

    /**
     * Standard Binary Search on a given range [low, high]
     * Returns index if target is found, else -1
     */
    public static int binarySearch(int[] arr, int target, int low, int high )
    {
        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;
            if ( arr[mid] == target )
                return mid; // target found
            else if ( arr[mid] > target )
                high = mid - 1; // move left
            else
                low = mid + 1;  // move right
        }

        return -1; // target not found
    }

    /**
     * Naive approach: Linearly check elements until target is found
     * OR until an element > target is encountered
     */
    public static int findTargetNaive ( int[] arr, int target )
    {
        int i = 0;
        while ( true )
        {
            if ( arr[i] == target )
                return i; // target found
            if (arr[i] > target)
                return -1; // no need to check further
            i++;
            if (i == arr.length) break; // prevent infinite loop in finite array
        }

        return -1;
    }

    /**
     * Optimized approach: Find the target in an "infinite array"
     * by expanding the search window exponentially
     * Steps:
     * 1. Start with a small window [0, 1]
     * 2. Keep expanding window exponentially until target <= arr[end]
     * 3. Perform binary search inside the found window
     */
    public static int findTargetOptimized(int[] arr, int target)
    {
        // Initial window: [0, 1]
        int start = 0;

        // Initially the search window is of size 2
        int end = 1;

        // Expand window until target <= arr[end]
        while ( target > arr[end] )
        {
            int temp = end + 1; // new start = previous end + 1

            // Expand window size exponentially
            // double the window size -> end = previous window end + window size * 2
            end = end + ( end - start + 1 ) * 2;

            // To avoid going beyond array length in finite test case
            if (end >= arr.length) {
                end = arr.length - 1;
                start = temp;   // update start before breaking
                break;
            }

            start = temp;

        }

        // easy implementation of optimized method
//        if ( arr[0] == target )
//            return 0;
//        int i = 1;
//        while ( arr[i] < target && i*2 < arr.length )
//        {
//            i = i*2;
//        }
//
//        if(arr[i] == target )
//            return i;
//
//        return binarySearch(arr, target, i/2 + 1, i-1);


        // Now the target must be between [start, end]
        return binarySearch(arr, target, start, end);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 10, 15, 20, 25, 40, 60, 80, 100, 120, 150};

        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // Test multiple targets
        int[] testTargets = {15, 40, 150, 17, 2, 120, 200};

        System.out.println("=== Searching Targets in Infinite Array ===");
        for (int target : testTargets) {
            int naiveResult = findTargetNaive(arr, target);
            int optimizedResult = findTargetOptimized(arr, target);

            System.out.println("Target " + target + " → " +
                    "Naive Index: " + naiveResult +
                    " | Optimized Index: " + optimizedResult);
        }
    }
}
