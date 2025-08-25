public class LongestIncreasingSteps {
    public static int findMaxSteps ( int[] arr )
    {
        int n = arr.length;
        if (n <= 1) return 0; // Only one building, no steps possible

        int count = 0;
        int maxSteps = 0;

        for ( int i = 0; i < n - 1; i++ )
        {
            if ( arr[i+1] > arr[i] )
            {
                count++; // valid increasing step
                maxSteps = Math.max(maxSteps, count);
            }
            else
            {
                count = 0;  // reset count
            }
        }

        return maxSteps;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 2};
        int[] arr2 = {1, 2, 3, 4};

        System.out.println(findMaxSteps(arr1)); // Output: 1
        System.out.println(findMaxSteps(arr2)); // Output: 3
    }
}
