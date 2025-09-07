public class EquilibriumPoint {

    // Naive approach: O(n^2) time complexity
    public static int findEquilibriumPointNaive(int[] arr) {
        for ( int i = 0; i < arr.length; i++ ) {
            int leftSum = 0;
            int rightSum  = 0;

            // Sum of elements on the left of index i
            for ( int left = 0; left < i; left++ ) {
                leftSum += arr[left];
            }

            // Sum of elements on the right of index i
            for ( int right = i+1; right < arr.length; right++ ) {
                rightSum += arr[right];
            }

            // Check if equilibrium point found
            if ( leftSum == rightSum )
                return i;
        }

        // No equilibrium index found
        return -1;
    }

    // Optimized approach using prefix sum: O(n) time complexity
    public static int findEquilibriumPoint(int[] arr )
    {
        int totalSum = 0;

        // Step 1: Calculate total sum of array
        for ( int i = 0; i < arr.length; i++ ) {
            totalSum += arr[i];
        }

        int leftSum = 0;
        // Step 2: Traverse array to find equilibrium
        for ( int i = 0; i < arr.length; i++ ) {
            totalSum -= arr[i]; // totalSum now becomes right sum

            if (leftSum == totalSum )
                return i; // Equilibrium index found

            leftSum += arr[i]; // Update left sum for next index
        }

        return -1; // No equilibrium index
    }

    public static void main(String[] args) {
        // Test cases including edge cases
        int[][] testCases = {
                {1, 3, 5, 2, 2},           // Equilibrium at index 2
                {1, 2, 3},                 // No equilibrium (-1)
                {2, 4, 6, 4, 2},           // Equilibrium at index 2
                {1},                        // Single element, equilibrium at index 0
                {},                         // Empty array, should return -1
                {0, 0, 0, 0},               // All zeros, equilibrium at index 0
                {3, -1, 2, -1, 3}           // Equilibrium at index 2 (negative numbers)
        };

        // Running all test cases
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            System.out.println("Test Case " + (i + 1) + ": " + java.util.Arrays.toString(arr));

            int naiveResult = findEquilibriumPointNaive(arr);
            int optimizedResult = findEquilibriumPoint(arr);

            System.out.println("Naive Method Equilibrium Index: " + naiveResult);
            System.out.println("Optimized Method Equilibrium Index: " + optimizedResult);
            System.out.println("---------------------------------------------------");
        }
    }
}
