public class PalindromeTriangle {

    // Method to print a palindromic number triangle pattern
    public static void printPattern(int number)
    {
        // Handle invalid input (zero or negative)
        if (number <= 0) {
            System.out.println("Invalid input! Number must be positive.");
            return;
        }

        // Outer loop for the number of rows
        for (int i = 1; i <= number; i++) {

            // Print leading spaces to create pyramid alignment
            for (int space = 1; space <= number - i; space++)
                System.out.print("  ");

            // Print decreasing numbers (left side of palindrome)
            for (int num = i; num >= 1; num--)
                System.out.print(num + " ");

            // Print increasing numbers (right side of palindrome)
            for (int num = 2; num <= i; num++)
                System.out.print(num + " ");

            // Move to next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Define test cases, including normal and edge cases
        int[] testCases = {6, 1, 4, 9, 0, -3};

        // Iterate through all test cases using for loop
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            System.out.println("Test Case " + (i + 1) + ": n = " + n);
            printPattern(n);
            System.out.println("-----------------------------");
        }
    }
}
