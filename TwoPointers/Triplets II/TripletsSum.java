import java.util.*;

public class TripletsSum {

    /**
     * Naive method: O(n^3)
     * - Check every possible triplet using three nested loops.
     * - Sort each triplet and store in a HashSet to avoid duplicates.
     */
    public static List<List<Integer>> findUniqueTripletsNaive(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < n - 2; i++ )
        {
            for ( int j = i+1; j < n - 1; j++ )
            {
                for ( int k = j+1; k < n; k++ )
                {
                    List<Integer> triplets = new ArrayList<>();
                    if (arr[i] + arr[j] + arr[k] == target)
                    {
                        // Create triplet
                        List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
                        // Sort triplet to maintain consistency (e.g., [-1, 2, -1] -> [-1, -1, 2])
                        Collections.sort(triplet);
                        // HashSet ensures uniqueness
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(uniqueTriplets);
    }

    /**
     * Optimized method: O(n^2)
     * - Sort array
     * - Fix one element arr[i], then use two-pointer approach to find pairs that sum to (target - arr[i]).
     * - Skip duplicates for arr[i], arr[left], arr[right].
     */
    public static List<List<Integer>> findUniqueTriplets(int[] arr, int target)
    {
        Arrays.sort(arr);
        int n = arr.length;

        List<List<Integer>> result = new ArrayList<>();
        for ( int i = 0; i < n-1; i++ )
        {
            // Skip duplicate values for arr[i]
            if ( i > 0 && arr[i] == arr[i-1])
                continue;

            List<Integer> triplets = new ArrayList<>();
            int localTarget = target - arr[i];
            int left = i+1, right = n - 1;
            while ( left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if ( sum == target ) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));

                    // Skip duplicate values for arr[left]
                    while ( left < right && arr[left] == arr[left + 1])
                        left++;

                    // Skip duplicate values for arr[right]
                    while ( left < right && arr[right] == arr[right - 1])
                        right--;

                    left++;
                    right--;
                } else if ( sum < target ) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // --------------------- MAIN METHOD WITH TEST CASES ----------------------
    public static void main(String[] args) {
        // Test Case 1: General case with negatives, positives, and duplicates
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1 (General case, target=0)");
        System.out.println("Naive: " + findUniqueTripletsNaive(arr1, 0));
        System.out.println("Two-pointer: " + findUniqueTriplets(arr1, 0));

        // Test Case 2: Array with multiple duplicates
        int[] arr2 = {0, 0, 0, 0};
        System.out.println("\nTest 2 (All zeros, target=0)");
        System.out.println("Naive: " + findUniqueTripletsNaive(arr2, 0));
        System.out.println("Two-pointer: " + findUniqueTriplets(arr2, 0));

        // Test Case 3: Array with no valid triplets
        int[] arr3 = {1, 2, 3, 4};
        System.out.println("\nTest 3 (No triplets, target=0)");
        System.out.println("Naive: " + findUniqueTripletsNaive(arr3, 0));
        System.out.println("Two-pointer: " + findUniqueTriplets(arr3, 0));

        // Test Case 4: Array smaller than size 3
        int[] arr4 = {1, -1};
        System.out.println("\nTest 4 (Too small array, target=0)");
        System.out.println("Naive: " + findUniqueTripletsNaive(arr4, 0));
        System.out.println("Two-pointer: " + findUniqueTriplets(arr4, 0));

        // Test Case 5: All positive numbers (cannot sum to zero)
        int[] arr5 = {5, 7, 3, 9};
        System.out.println("\nTest 5 (All positive numbers, target=0)");
        System.out.println("Naive: " + findUniqueTripletsNaive(arr5, 0));
        System.out.println("Two-pointer: " + findUniqueTriplets(arr5, 0));

        // Test Case 6: Custom target (not zero)
        int[] arr6 = {1, 2, -2, -1, 0, 3};
        int target6 = 2;
        System.out.println("\nTest 6 (Target=2)");
        System.out.println("Naive: " + findUniqueTripletsNaive(arr6, target6));
        System.out.println("Two-pointer: " + findUniqueTriplets(arr6, target6));
    }
}
