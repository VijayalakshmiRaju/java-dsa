import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveMissingNumber {

    /**
     * Approach 1: Using HashSet (O(n) time, O(n) space)
     * - Store all positive numbers in a set
     * - Check from 1 to n+1 which is missing
     */
    public static int findSmallestPositiveMissingNumberHashSet(int [] arr)
    {
        Set<Integer> nums = new HashSet<>();
        int n = arr.length;

        // Step 1: Store all positive numbers
        for ( int num : arr )
        {
            if ( num > 0 )
                nums.add(num);
        }

        // Step 2: Smallest missing will be between 1 and n+1
        for ( int i = 1; i <= n+1; i++ )
        {
            if (!nums.contains(i))
                return i;
        }

        return n+1; // fallback
    }

    /**
     * Approach 2: Cyclic Sort / Index Mapping (O(n) time, O(1) space)
     * - Place each number at its correct index (value → index = value-1)
     * - Find the first index where arr[i] != i+1
     */
    public static int findSmallestPositiveMissingNumberCyclicSort(int [] arr)
    {
        int n = arr.length;
        // Step 1: Place each valid number in its correct position
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                // Swap arr[i] with arr[arr[i]-1]
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where arr[i] != i+1
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // missing number found
            }
        }

        // Step 3: If all numbers are placed correctly, answer is n+1
        return n + 1;
    }

    // Main method with sample test cases
    public static void main(String[] args) {
        int[][] testCases = {
                {2, -3, 4, 1, 1, 7},
                {5, 3, 2, 5, 1},
                {-8, 0, -1, -4, -3},
                {1, 2, 3, 4, 5},  // Edge: all consecutive
                {7, 8, 9, 11, 12} // Edge: missing 1
        };

        System.out.println("Smallest Positive Missing Number Test Cases:");
        for (int[] test : testCases) {
            System.out.print("Input: [");
            for (int i = 0; i < test.length; i++) {
                System.out.print(test[i]);
                if (i < test.length - 1) System.out.print(", ");
            }
            int naive = findSmallestPositiveMissingNumberHashSet(test.clone());
            int optimized = findSmallestPositiveMissingNumberCyclicSort(test.clone());
            System.out.println("] | Naive Method = " + naive + " | Optimized Method = " + optimized);
        }
    }
}
