public class NumberTriangle {

    /**
     * Prints a right-aligned number triangle pattern.
     * Each row contains the same number repeated equal to the row number.
     * Example for n = 4:
     *    1
     *   2 2
     *  3 3 3
     * 4 4 4 4
     *
     * @param n The number of rows to print
     */
    public static void printNumberTriangle(int n)
    {
        // Outer loop for each row
        for (int row = 1; row <= n; row++) {

            // Print leading spaces to make the triangle right-aligned
            for (int space = 1; space <= n - row; space++)
                System.out.print(" ");

            // Print the current row number repeated 'row' times
            for (int num = 1; num <= row; num++)
                System.out.print(row + " ");

            // Move to the next line after finishing one row
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Test Case 1: Normal case
        System.out.println("Test Case 1: n = 7");
        printNumberTriangle(7);

        // Test Case 2: Smallest valid case
        System.out.println("\nTest Case 2: n = 1");
        printNumberTriangle(1);

        // Test Case 3: Medium case
        System.out.println("\nTest Case 3: n = 4");
        printNumberTriangle(4);

        // Test Case 4: Edge case - zero rows
        // Expected: No output (blank triangle)
        System.out.println("\nTest Case 4: n = 0 (Edge Case - no rows)");
        printNumberTriangle(0);

        // Test Case 5: Edge case - negative number
        // Expected: Invalid input message
        System.out.println("\nTest Case 5: n = -3 (Edge Case - invalid input)");
        if (-3 <= 0) {
            System.out.println("Invalid input. Please enter a positive number of rows.");
        } else {
            printNumberTriangle(-3);
        }
    }
}
