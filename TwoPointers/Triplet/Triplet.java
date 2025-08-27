import java.util.Arrays;

public class Triplet {

    /**
     * Naive approach to check if there exists a triplet
     * in the array whose sum equals the target.
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static boolean isTripletNaive( int[] arr, int target )
    {
        int n = arr.length;
        for ( int i = 0; i < n-2; i++ )
        {
            for ( int j = i+1; j < n - 1; j++ )
            {
                for ( int k = j+1; k < n; k++ )
                {
                    if ( arr[i] + arr[j] + arr[k] == target ) {
                        System.out.printf("Triplet found (Naive): (%d, %d, %d)%n", arr[i], arr[j], arr[k]);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Helper method: Checks if there exists a pair in arr[startIdx..n-1]
     * that sums to the given target using the two-pointer approach.
     * Assumes the array is sorted.
     */
    public static boolean formPair( int[] arr, int target, int startIdx )
    {
        int i = startIdx;
        int j = arr.length - 1;
        while ( i < j )
        {
            if ( arr[i] + arr[j] == target )
                return true;
            else if ( arr[i] + arr[j] < target )
                i++;
            else
                j--;
        }

        return false;
    }

    /**
     * Optimized Two-Pointer Approach
     * 1. Sort the array
     * 2. For each element, use two-pointer method to check for pair
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (ignoring sorting cost)
     */
    public static boolean isTripletTwoPointers ( int[] arr, int target )
    {
        int n = arr.length;
        Arrays.sort(arr); // Sorting required for two-pointer approach
        for ( int i = 0; i < n-2; i++ )
        {
            int required = target - arr[i];
            System.out.printf("Checking for triplet with first element %d%n", arr[i]);
            if (formPair(arr, required, i + 1)) {
                System.out.printf("Triplet found (Two Pointers) with %d included%n", arr[i]);
                return true;
            }
        }

        return false;
    }

    // ------------------ Test Cases ------------------
    public static void main(String[] args) {
        int[][] testArrays = {
                {1, 4, 45, 6, 10, 8},    // Normal case
                {1, 2, 3, 4, 5},         // Multiple triplets possible
                {5, 5, 5},               // Exactly one triplet (edge)
                {1, 2},                  // Not enough elements
                {-1, 0, 1, 2, -1, -4},   // Array with negatives
                {100, 200, 300},         // Large numbers
        };

        int[] targets = {22, 9, 15, 3, 0, 600};

        for (int t = 0; t < testArrays.length; t++) {
            int[] arr = testArrays[t];
            int target = targets[t];

            System.out.println("\n=====================================");
            System.out.println("Array: " + Arrays.toString(arr) + ", Target = " + target);

            boolean resultNaive = isTripletNaive(arr, target);
            System.out.println("Naive Result: " + (resultNaive ? "Triplet Exists" : "No Triplet Found"));

            boolean resultTwoPointers = isTripletTwoPointers(arr, target);
            System.out.println("Two Pointers Result: " + (resultTwoPointers ? "Triplet Exists" : "No Triplet Found"));
        }
    }
}
