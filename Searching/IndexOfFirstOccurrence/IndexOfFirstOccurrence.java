public class IndexOfFirstOccurrence {

    // Linear search: checks each element one by one
    public static int findFirstOccurrenceLinear(int[] arr, int x )
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            if ( arr[i] == x ) // if match found, return index immediately
                return i;
        }

        return -1; // element not found
    }

    // Binary search: efficient way to find first occurrence in sorted array
    public static int findFirstOccurrenceBinary(int[] arr, int x )
    {
        int low = 0;
        int high =  arr.length - 1;
        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2; // prevent integer overflow

            if ( arr[mid] > x )
                // Target lies in the left half
                high = mid -1 ;
            else if ( arr[mid] < x )
                // Target lies in the right half
                low = mid + 1;
            else {
                // arr[mid] == x, found a match
                // Now check if this is the FIRST occurrence
                if ( (mid == 0 || arr[mid-1] < x) && arr[mid] == x)
                    return mid; // this is the first occurrence
                else
                    // there is another occurrence on the left
                    high = mid - 1;
            }
        }

        return -1; // element not found
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 1, 1, 1};
        int[] arr3 = {2, 4, 6, 8, 10};
        int[] arr4 = {}; // empty array

        // Test cases
        System.out.println("Linear Search Tests:");
        System.out.println(findFirstOccurrenceLinear(arr1, 2)); // Expected 1
        System.out.println(findFirstOccurrenceLinear(arr2, 1)); // Expected 0
        System.out.println(findFirstOccurrenceLinear(arr3, 7)); // Expected -1
        System.out.println(findFirstOccurrenceLinear(arr4, 5)); // Expected -1

        System.out.println("\nBinary Search Tests:");
        System.out.println(findFirstOccurrenceBinary(arr1, 2)); // Expected 1
        System.out.println(findFirstOccurrenceBinary(arr2, 1)); // Expected 0
        System.out.println(findFirstOccurrenceBinary(arr3, 7)); // Expected -1
        System.out.println(findFirstOccurrenceBinary(arr4, 5)); // Expected -1
    }
}
