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
        // Define an array of test cases (including edge cases)
        int[] testCases = {5, 1, 6, 0, -3};

        // Iterate through all test cases using a for loop
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": n = " + testCases[i]);
            printPattern(testCases[i]);
            System.out.println("-------------------------");
        }
    }
}
