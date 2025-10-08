public class OneOddOccurrence {

    // Function to find the element that occurs an odd number of times (Naive Approach)
    public static int getOddOccurrenceNaive(int[] arr) {
        // Outer loop → pick each element one by one
        for (int i = 0; i < arr.length; i++) {
            int count = 0; // Initialize count for current element

            // Inner loop → count occurrences of arr[i]
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++; // Increment count if match found
                }
            }

            // If count is odd, return the current element
            if (count % 2 != 0)
                return arr[i];
        }

        // If no such element found, return -1
        return -1;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test case 1: Single odd-occurrence element
        int[] arr1 = {1, 2, 3, 2, 3, 1, 3};
        System.out.println("Odd occurring element: " + getOddOccurrenceNaive(arr1));
        // Expected output → 3

        // Test case 2: Multiple pairs and one odd element
        int[] arr2 = {10, 10, 20, 20, 30, 30, 40};
        System.out.println("Odd occurring element: " + getOddOccurrenceNaive(arr2));
        // Expected output → 40

        // Test case 3: All elements occur even times
        int[] arr3 = {2, 2, 4, 4, 6, 6};
        System.out.println("Odd occurring element: " + getOddOccurrenceNaive(arr3));
        // Expected output → -1 (no element occurs odd number of times)

        // Test case 4: Single element array
        int[] arr4 = {99};
        System.out.println("Odd occurring element: " + getOddOccurrenceNaive(arr4));
        // Expected output → 99
    }
}
