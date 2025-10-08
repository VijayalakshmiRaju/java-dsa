public class OneOddOccurrence {

    /**
     * Function to find the element that occurs an odd number of times
     * using the Naive (Brute Force) approach.
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static int getOddOccurrenceNaive(int[] arr) {
        // Outer loop → pick each element one by one
        for (int i = 0; i < arr.length; i++) {
            int count = 0; // Initialize count for the current element

            // Inner loop → count how many times arr[i] appears in the array
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++; // Increment count if a match is found
                }
            }

            // After counting occurrences, check if the count is odd
            if (count % 2 != 0)
                return arr[i]; // Return the element that occurs odd number of times
        }

        // If no element occurs an odd number of times, return -1
        return -1;
    }

    /**
     * Function to find the element that occurs an odd number of times
     * using the Optimized XOR approach.
     * XOR properties used:
     * 1. a ^ a = 0  (same numbers cancel out)
     * 2. a ^ 0 = a  (XOR with 0 gives the number itself)
     * 3. XOR is commutative and associative (order doesn’t matter)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int getOddOccurrenceOptimized(int[] arr) {
        int result = 0; // Initialize result as 0

        // XOR all elements in the array
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i]; // Repeated elements cancel out (a ^ a = 0)
        }

        // The remaining number is the one that occurred odd times
        return result;
    }

    public static void main(String[] args) {
        // Define test cases
        int[][] testCases = {
                {1, 2, 3, 2, 3, 1, 3},      // odd = 3
                {10, 10, 20, 20, 30, 30, 40}, // odd = 40
                {2, 2, 4, 4, 6, 6},         // no odd
                {99},                       // single element
                {5, 5, 5, 5, 5},            // same element odd times
                {-1, -1, -2, -2, -3},       // negative numbers
                {0, 1, 0, 1, 0}             // includes zero
        };

        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-5s %-30s %-15s %-15s%n", "No.", "Input Array", "Naive", "Optimized");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int naive = getOddOccurrenceNaive(arr);
            int optimized = getOddOccurrenceOptimized(arr);

            System.out.printf("%-5d %-30s %-15d %-15d%n", (i + 1), java.util.Arrays.toString(arr), naive, optimized);
        }

        System.out.println("--------------------------------------------------------------------");
    }
}
