public class FloorInSortedArray {
    public static int floorInSortedArray(int[] arr, int element)
    {
        int low = 0;
        int high = arr.length - 1;
        int floorValue = -1;

        while ( low <= high )
        {
            int mid = low + (high - low) / 2;
            if ( arr[mid] == element )
            {
                floorValue = mid;
                low = mid + 1;
            }
            else if ( arr[mid] < element )
            {
                floorValue = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return floorValue;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};

        int x1 = 5;
        int x2 = 10;
        int x3 = 0;

        System.out.println("Floor of " + x1 + " is at index: " + floorInSortedArray(arr, x1)); // Expected: 1
        System.out.println("Floor of " + x2 + " is at index: " + floorInSortedArray(arr, x2)); // Expected: 4 (last occurrence of 10)
        System.out.println("Floor of " + x3 + " is at index: " + floorInSortedArray(arr, x3)); // Expected: -1 (no floor exists)
    }
}
