public class OneOddOccurrence {

    /**
     * Function to find the element that occurs an odd number of times
     * using the Naive (Brute Force) approach.
     *
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
     *
     * XOR properties used:
     * 1. a ^ a = 0  (same numbers cancel out)
     * 2. a ^ 0 = a  (XOR with 0 gives the number itself)
     * 3. XOR is commutative and associative (order doesn’t matter)
     *
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

    // Main method to test both functions
    public static void main(String[] args) {
        // Test case 1: Single odd-occurrence element
        int[] arr1 = {1, 2, 3, 2, 3, 1, 3};
        System.out.println("Odd occurring element (Naive): " + getOddOccurrenceNaive(arr1));
        System.out.println("Odd occurring element (Optimized): " + getOddOccurrenceOptimized(arr1));
        // Expected output → 3

        // Test case 2: Multiple pairs and one odd element
        int[] arr2 = {10, 10, 20, 20, 30, 30, 40};
        System.out.println("Odd occurring element (Naive): " + getOddOccurrenceNaive(arr2));
        System.out.println("Odd occurring element (Optimized): " + getOddOccurrenceOptimized(arr2));
        // Expected output → 40

        // Test case 3: All elements occur even times
        int[] arr3 = {2, 2, 4, 4, 6, 6};
        System.out.println("Odd occurring element (Naive): " + getOddOccurrenceNaive(arr3));
        System.out.println("Odd occurring element (Optimized): " + getOddOccurrenceOptimized(arr3));
        // Expected output → 0 for XOR method (since all cancel out), -1 for Naive

        // Test case 4: Single element array
        int[] arr4 = {99};
        System.out.println("Odd occurring element (Naive): " + getOddOccurrenceNaive(arr4));
        System.out.println("Odd occurring element (Optimized): " + getOddOccurrenceOptimized(arr4));
        // Expected output → 99
    }
}
