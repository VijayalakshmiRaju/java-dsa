public class PalindromeTriangle {

    // Method to print a palindromic number triangle pattern
    public static void printPattern(int number)
    {
        // Outer loop for the number of rows
        for (int i = 1; i <= number; i++) {

            // Print leading spaces for pyramid alignment
            for (int space = 1; space <= number - i; space++)
                System.out.print("  ");

            // Print decreasing numbers (left side of palindrome)
            for (int num = i; num >= 1; num--)
                System.out.print(num + " ");

            // Print increasing numbers (right side of palindrome)
            for (int num = 2; num <= i; num++)
                System.out.print(num + " ");

            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Test Case 1: Standard case
        System.out.println("Test Case 1: n = 6");
        printPattern(6);
        System.out.println("-----------------------------");

        // Test Case 2: Smallest valid input
        System.out.println("Test Case 2: n = 1");
        printPattern(1);
        System.out.println("-----------------------------");

        // Test Case 3: Medium-sized triangle
        System.out.println("Test Case 3: n = 4");
        printPattern(4);
        System.out.println("-----------------------------");

        // Test Case 4: Large input to check spacing alignment
        System.out.println("Test Case 4: n = 9");
        printPattern(9);
        System.out.println("-----------------------------");

        // Edge Case: n = 0 (no output expected)
        System.out.println("Edge Case: n = 0");
        printPattern(0);
        System.out.println("-----------------------------");

        // Edge Case: Negative input (invalid case handling)
        System.out.println("Edge Case: n = -3");
        if (-3 <= 0)
            System.out.println("Invalid input! Number must be positive.");
        else
            printPattern(-3);
        System.out.println("-----------------------------");
    }
}
