public class NonOverlappingMaxEvents {

    // Function to find maximum number of non-overlapping events
    public static int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;

        // Sort events by end time using custom merge sort
        mergeSort(events, 0, events.length - 1);

        int count = 0;
        int lastEndTime = Integer.MIN_VALUE;

        for (int i = 0; i < events.length; i++) {
            int start = events[i][0];
            int end = events[i][1];

            if (start >= lastEndTime) {
                count++;
                lastEndTime = end;
            }
        }

        return count;
    }

    // Merge Sort to sort by event end times
    private static void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort both halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge them
            merge(arr, left, mid, right);
        }
    }

    // merges two sorted halves: arr[left..mid] and arr[mid+1..right]
    // result is sorted by END TIME in arr[left..right]
    // Merge step: combine two sorted halves into one
    private static void merge(int[][] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;// size of left half
        int n2 = right - mid;   // size of right half

        // temp arrays to avoid overwriting data we still need to compare
        int[][] leftArr = new int[n1][2];
        int[][] rightArr = new int[n2][2];

        // copy arr[left..mid] → leftArr
        for ( int i = 0; i < n1; i++ )
        {
            leftArr[i][0] = arr[left + i][0];
            leftArr[i][1] = arr[left + i][1];
        }

        // copy arr[mid+1..right] → rightArr
         for ( int i = 0; i < n2; i++ )
         {
             rightArr[i][0] = arr[mid + 1 + i][0];
             rightArr[i][1] = arr[mid + 1 + i][1];
         }

         int i = 0, j = 0, k = left;
         while ( i < n1 && j < n2 ) {
             // compare END times (index 1)
             if ( leftArr[i][1] <= rightArr[j][1] ) { // <= makes it stable
                 arr[k][0] = leftArr[i][0];
                 arr[k][1] = leftArr[i][1];
                 i++;
             }
             else {
                 arr[k][0] = rightArr[j][0];
                 arr[k][1] = rightArr[j][1];
                 j++;
             }
             k++;
         }

        // copy leftovers (only one of these loops will run)
         while ( i < n1 ) {
             arr[k][0] = leftArr[i][0];
             arr[k][1] = leftArr[i][1];
             i++;
             k++;
         }
         while ( j < n2 ) {
             arr[k][0] = rightArr[j][0];
             arr[k][1] = rightArr[j][1];
             j++;
             k++;
         }
    }

    // -------------------- MAIN METHOD --------------------
    public static void main(String[] args) {
        // Array of test cases (each is a 2D array of events)
        int[][][] testCases = {
                {{3, 3}, {4, 7}, {4, 5}, {3, 4}, {1, 2}},   // Normal case
                {{1, 10}, {2, 9}, {3, 8}, {4, 7}},          // All overlapping
                {{1, 2}, {3, 4}, {5, 6}, {7, 8}},           // All non-overlapping
                {{1, 3}, {2, 3}, {3, 3}, {4, 5}},           // Same end times
                {{5, 10}},                                  // Single event
                {},                                         // Empty input
                {{100, 200}, {300, 400}, {500, 600}},       // Large start times
                {{1, 1}, {2, 2}, {2, 2}, {3, 3}},           // Equal start=end
                {{1,2}, {3,4}, {5,6}, {7,8}},
                {{1,5}, {2,6}, {3,7}, {4, 8}},
                {{1,3}, {2,4}, {3,5}, {7,8}}
        };

        // Run each test case in a loop
        for (int i = 0; i < testCases.length; i++) {
            int result = maxEvents(testCases[i]);
            System.out.println("Test " + (i + 1) + ": Max events = " + result);
        }
    }
}
