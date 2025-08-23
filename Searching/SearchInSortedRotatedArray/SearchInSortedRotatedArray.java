public class SearchInSortedRotatedArray {
    public static int search(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;
        while ( low <= high )
        {
            int mid = low + ( high - low ) / 2;
            if ( arr[mid] == target )
                return mid;

            // If we can’t decide because of duplicates
//            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
//                low++;
//                high--;
//                continue;
//            }

            // Check if left half is sorted
            if ( arr[low] <= arr[mid] )
            {
                if ( target >= arr[low] && target < arr[mid] ) {
                    high = mid - 1; // search left half
                } else {
                    low = mid + 1; // search right half
                }
            }
            // Else right half must be sorted
            else
            {
                if ( target > arr[mid] && target <= arr[high] ) {
                    low = mid + 1; // search right half
                } else
                    high = mid - 1; // search left half
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        // Test Case 1: Basic example
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Case 1: " + java.util.Arrays.toString(arr1));
        System.out.println("Target 0 → Index: " + search(arr1, 0));  // Expected 4
        System.out.println("Target 3 → Index: " + search(arr1, 3));  // Expected -1
        System.out.println();

        // Test Case 2: No rotation
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println("Case 2: " + java.util.Arrays.toString(arr2));
        System.out.println("Target 4 → Index: " + search(arr2, 4));  // Expected 3
        System.out.println("Target 7 → Index: " + search(arr2, 7));  // Expected -1
        System.out.println();

        // Test Case 3: Single element
        int[] arr3 = {1};
        System.out.println("Case 3: " + java.util.Arrays.toString(arr3));
        System.out.println("Target 1 → Index: " + search(arr3, 1));  // Expected 0
        System.out.println("Target 0 → Index: " + search(arr3, 0));  // Expected -1
        System.out.println();

        // Test Case 4: Two elements
        int[] arr4 = {3, 1};
        System.out.println("Case 4: " + java.util.Arrays.toString(arr4));
        System.out.println("Target 3 → Index: " + search(arr4, 3));  // Expected 0
        System.out.println("Target 1 → Index: " + search(arr4, 1));  // Expected 1
        System.out.println("Target 2 → Index: " + search(arr4, 2));  // Expected -1
        System.out.println();

        // Test Case 5: Rotation at last element
        int[] arr5 = {2, 3, 4, 5, 6, 1};
        System.out.println("Case 5: " + java.util.Arrays.toString(arr5));
        System.out.println("Target 1 → Index: " + search(arr5, 1));  // Expected 5
        System.out.println("Target 2 → Index: " + search(arr5, 2));  // Expected 0
        System.out.println();

        // Test Case 6: Large array with rotation
        int[] arr6 = {30, 40, 50, 10, 20};
        System.out.println("Case 6: " + java.util.Arrays.toString(arr6));
        System.out.println("Target 10 → Index: " + search(arr6, 10)); // Expected 3
        System.out.println("Target 40 → Index: " + search(arr6, 40)); // Expected 1
        System.out.println("Target 25 → Index: " + search(arr6, 25)); // Expected -1
        System.out.println();

        // Test Case 7: Negative numbers
        int[] arr7 = {-4, -3, -2, 0, 2, 3, -10};
        System.out.println("Case 7: " + java.util.Arrays.toString(arr7));
        System.out.println("Target -10 → Index: " + search(arr7, -10)); // Expected 6
        System.out.println("Target -3 → Index: " + search(arr7, -3));   // Expected 1
        System.out.println("Target 5 → Index: " + search(arr7, 5));     // Expected -1
        System.out.println();

        // Test Case 8: With Duplicates
        int[] arr8 = {2, 5, 6, 0, 0, 1, 2};
        System.out.println("Case 8: " + java.util.Arrays.toString(arr8));
        System.out.println("Target 0 → Index: " + search(arr8, 0));  // Could be 3 or 4
        System.out.println("Target 3 → Index: " + search(arr8, 3));  // Expected -1
        System.out.println("Target 2 → Index: " + search(arr8, 2));  // Could be 0 or 6
        System.out.println();

        // Test Case 8: With Duplicates
        int[] arr9 = {2, 2, 2, 2, 3, 4, 2, 2};
        System.out.println("Case 9: " + java.util.Arrays.toString(arr9));
        System.out.println("Target 0 → Index: " + search(arr9, 4));  // Expected 5
        System.out.println("Target 3 → Index: " + search(arr9, 3));  // Expected 4
        System.out.println("Target 2 → Index: " + search(arr9, 2));  // Expected 3
        System.out.println();
    }
}
