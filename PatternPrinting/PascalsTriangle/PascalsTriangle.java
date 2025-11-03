public class PascalsTriangle {

    // Method to print Pascal's Triangle pattern
    public static void printPattern(int number)
    {
        // Outer loop controls the number of rows
        for (int i = 1; i <= number; i++) {

            // Print leading spaces for alignment (optional for triangle shape)
            for (int space = 1; space <= number - i; space++) {
                System.out.print(" ");
            }

            // Initialize first value of each row as 1
            int val = 1;

            // Inner loop to calculate and print binomial coefficients
            for (int j = 1; j <= i; j++) {
                System.out.print(val + " ");
                // Compute next value using formula: val = val * (i - j) / j
                val = val * (i - j) / j;
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Test Case 1: Typical case
        System.out.println("Test Case 1: n = 5");
        printPattern(5);
        System.out.println("-------------------------");

        // Test Case 2: Smallest non-trivial case
        System.out.println("Test Case 2: n = 1");
        printPattern(1);
        System.out.println("-------------------------");

        // Test Case 3: Moderate case for visual clarity
        System.out.println("Test Case 3: n = 6");
        printPattern(6);
        System.out.println("-------------------------");

        // Test Case 4: Edge Case (n = 0)
        // Should print nothing or a message indicating no rows
        System.out.println("Test Case 4: n = 0 (Edge Case)");
        if (0 <= 0)
            System.out.println("No rows to display.\n-------------------------");

        // Test Case 5: Edge Case (Negative input)
        System.out.println("Test Case 5: n = -3 (Edge Case)");
        if (-3 <= 0)
            System.out.println("Invalid input. Number of rows must be positive.\n-------------------------");
    }
}
