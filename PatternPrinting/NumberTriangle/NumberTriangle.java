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
        // Define test cases
        int[] testCases = {7, 1, 4, 0, -3};

        // Iterate through each test case using a for loop
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\nTest Case " + (i + 1) + ": n = " + testCases[i]);
            printNumberTriangle(testCases[i]);
        }
    }
}
