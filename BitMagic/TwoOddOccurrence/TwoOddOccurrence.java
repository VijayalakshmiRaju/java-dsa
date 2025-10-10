public class TwoOddOccurrence {

    // Naive method: O(n²)
    // Finds two numbers that occur an odd number of times in the array
    public static int[] getTwoOddOccurrenceNaive(int[] arr) {
        int[] result = new int[2];  // To store two odd-occurring numbers
        int idx = 0;                // Index to track result position

        // Outer loop - pick each element one by one
        for (int i = 0; i < arr.length; i++) {
            int count = 0; // Count occurrences of arr[i]

            // Inner loop - count how many times arr[i] appears
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }

            // If this element occurs an odd number of times
            if (count % 2 != 0) {
                // Check if it's already added
                boolean alreadyAdded = false;
                for (int k = 0; k < idx; k++) {
                    if (result[k] == arr[i]) {
                        alreadyAdded = true;
                        break;
                    }
                }

                // Add only if not already added and space available
                if (!alreadyAdded && idx < 2) {
                    result[idx++] = arr[i];
                }
            }

            // Stop early if both numbers are found
            if (idx == 2)
                break;
        }

        return result;
    }

    // Optimized method: O(n)
    // Uses XOR to find two odd-occurring numbers efficiently
    public static int[] getTwoOddOccurrenceXOR(int[] arr) {
        int xor = 0;

        // Step 1: XOR all elements → result = num1 ^ num2
        for (int num : arr) {
            xor ^= num;
        }

        // Step 2: Find the rightmost set bit (where num1 and num2 differ)
        int rightMostSetBit = xor & (-xor);

        int num1 = 0, num2 = 0;

        // Step 3: Divide numbers into two groups and XOR each group
        for (int num : arr) {
            if ((num & rightMostSetBit) != 0)
                num1 ^= num;  // Group 1: bit set
            else
                num2 ^= num;  // Group 2: bit not set
        }

        // Step 4: num1 and num2 are the two odd-occurring numbers
        return new int[]{num1, num2};
    }

    // Utility method for printing formatted test results
    public static void printResult(String methodName, int[] arr, int[] result) {
        System.out.print(methodName + " → Array: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();

        if (result != null && result.length == 2)
            System.out.println("  Odd occurring numbers: " + result[0] + " and " + result[1] + "\n");
        else
            System.out.println("  Invalid or no odd-occurring numbers found.\n");
    }

    public static void main(String[] args) {

        // Define multiple test cases
        int[][] testCases = {
                {4, 2, 4, 5, 2, 3, 3, 1},             // Normal case
                {9, 4, 4, 6, 6, 3, 3, 9, 1},          // Odd elements at edges
                {7, 8},                                // Only two elements, both odd
                {1, 1, 2, 2, 3, 3},                    // All even elements (invalid)
                {5, 5, 7, 7, 7, 8, 8, 9, 9, 9},        // Two odd elements 7, 9
                {10, 10, 10, 10, 5, 6, 6, 6, 6, 7},    // 5 and 7 are odd
                {4, -1, 2, -1, 2, 5, 4, 7, 7, 9}       // Contains negatives
        };

        System.out.println("===== TWO ODD OCCURRENCE PROBLEM =====\n");

        // Iterate through each test case using a for loop
        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            System.out.println("Test Case " + (i + 1) + ":");

            // Run and print results for Naive method
            int[] naiveResult = getTwoOddOccurrenceNaive(arr);
            printResult("[Naive O(n²)]", arr, naiveResult);

            // Run and print results for Optimized XOR method
            int[] xorResult = getTwoOddOccurrenceXOR(arr);
            printResult("[Optimized XOR O(n)]", arr, xorResult);

            System.out.println("------------------------------------------\n");
        }
    }
}
