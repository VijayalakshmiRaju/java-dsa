public class SearchInAnInfiniteArray {

    public static int binarySearch(int[] arr, int target, int low, int high )
    {
        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;
            if ( arr[mid] == target )
                return mid;
            else if ( arr[mid] > target )
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static int findTarget(int[] arr, int target)
    {
        // Initial start and end range
        int start = 0;

        // Initially the search window is of size 2
        int end = 1;

        while ( target > arr[end] )
        {
            int temp = end + 1; // new start

            // double the window size -> end = previous window end + window size * 2
            end = end + ( end - start + 1 ) * 2;

            start = temp;

        }

        return binarySearch(arr, target, start, end);
    }
}
