public class CountTwoRepeatedNumbers {

    /**
     * Naive method: O(n^2)
     * Check each pair and find repeated elements.
     */
    public static int[] countRepeatedNaive (int[] arr)
    {
        int[] result = new int[2];// to store 2 repeated numbers
        int dupIdx = -1; // index of last duplicate found
        for ( int i = 0; i < arr.length; i++ )
        {
            for ( int j = i+1; j < arr.length; j++ )
            {
                if ( arr[i] == arr[j] )
                {
                    if ( dupIdx != -1 )
                    {
                        // Ensure correct ordering: earlier repeated first
                        if (dupIdx > j)
                        {
                            int temp = result[0];
                            result[0] = arr[j];
                            result[1] = temp;
                        }
                        else {
                            result[1] = arr[j];
                        }
                    }
                    else {
                        result[0] = arr[j];
                        dupIdx = j;
                    }
                    break;
                }
            }
        }

        return result;
    }


    /**
     * Efficient method using extra space: O(n), O(n) space
     * Uses a boolean array to track seen numbers.
     */
    public static int[] countRepeated(int[] arr)
    {
        int n = arr.length - 2; // array contains numbers 1..n, with 2 numbers repeated
        boolean[] seen = new boolean[n+1];
        int idx = 0;
        int[] result = new int[2];

        for ( int num : arr )
        {
            if ( seen[num])
            {
                result[idx++] = num;
                if ( idx == 2 ) // stop after finding 2 repeated numbers
                    break;
            }
            else
                seen[num] = true;
        }

        return result;
    }

    /**
     * Optimized method: O(n), O(1) extra space
     * Modifies the input array to mark visited elements.
     */
    public static int[] countRepeatedOptimized(int[] arr)
    {
        int[] result = new int[2];
        int idx = 0;

        for ( int i = 0; i< arr.length; i++ )
        {
            int val = Math.abs(arr[i]);
            int pos = val - 1;

            if (arr[pos] < 0) {
                result[idx++] = val; // number is repeated
                if (idx == 2) break; // stop after 2
            } else {
                arr[pos] = -arr[pos]; // mark as visited
            }
        }

        return result;
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {1, 2, 1, 3, 4, 2},   // Expected: [1, 2]
                {2, 4, 5, 2, 3, 1, 4}, // Expected: [2, 4]
                {1, 2, 3, 4, 2, 5, 3}, // Expected: [2, 3]
                {1, 2, 2, 1},          // Expected: [2, 1]
                {3, 1, 3, 4, 2, 5, 2}  // Expected: [3, 2]
        };

        System.out.println("==== Finding Two Repeated Numbers in Arrays ====\n");

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];

            // Run each method
            int[] naive = countRepeatedNaive(arr.clone());
            int[] space = countRepeated(arr.clone());
            int[] optimized = countRepeatedOptimized(arr.clone());

            System.out.println("Test Case " + (i + 1) + ": ");
            System.out.print("Input Array: ");
            for (int num : arr) System.out.print(num + " ");
            System.out.println();

            System.out.println("Naive Result      : " + naive[0] + ", " + naive[1]);
            System.out.println("Extra Space Result: " + space[0] + ", " + space[1]);
            System.out.println("Optimized Result  : " + optimized[0] + ", " + optimized[1]);
            System.out.println("--------------------------------------\n");
        }
    }
}
