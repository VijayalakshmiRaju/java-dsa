public class SearchInAnInfiniteArray {

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

    // Find target in an infinite array
    public static int findTarget(int[] arr, int target)
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
            }

            start = temp;

        }

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

        // Multiple test cases
        int[] testTargets = {15, 40, 150, 17, 2, 120, 200};

        for (int target : testTargets) {
            int result = findTarget(arr, target);
            System.out.println("Searching for " + target + " → Index: " + result);
        }
    }
}
