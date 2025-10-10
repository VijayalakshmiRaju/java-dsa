public class TwoOddOccurrence {

    // Function to find two numbers that occur odd number of times in the array
    public static int[] getTwoOddOccurrenceNaive(int[] arr) {
        int[] result = new int[2];  // Array to store the two odd-occurring numbers
        int idx = 0;                // Index to track result array position

        // Outer loop - pick each element
        for (int i = 0; i < arr.length; i++) {
            int count = 0;          // Count occurrences of arr[i]

            // Inner loop - count how many times arr[i] appears
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }

            // If the count is odd, this element occurs an odd number of times
            if (count % 2 != 0) {
                // Before adding, check if we've already stored this element
                boolean alreadyAdded = false;
                for (int k = 0; k < idx; k++) {
                    if (result[k] == arr[i]) {
                        alreadyAdded = true;
                        break;
                    }
                }

                // Add only if not already added and space is available
                if (!alreadyAdded && idx < 2) {
                    result[idx++] = arr[i];
                }
            }

            // If both odd-occurring numbers are found, we can stop early
            if (idx == 2) break;
        }

        return result;
    }

    // Example test
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 3, 1};
        int[] result = getTwoOddOccurrenceNaive(arr);

        System.out.println("The two odd occurring elements are: "
                + result[0] + " and " + result[1]);
    }
}
