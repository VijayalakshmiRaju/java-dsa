public class ButterflyPattern {

    // Method to print a butterfly pattern for a given number of rows
    public static void printButterfly(int number) {
        // Upper half of the butterfly
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= 2 * number; j++) {
                // Condition to print spaces in the middle gap
                if (j > i && j <= 2 * number - i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println(); // Move to the next line after each row
        }

        // Lower half of the butterfly
        for (int i = number; i >= 1; i--) {
            for (int j = 1; j <= 2 * number; j++) {
                // Same logic for spaces in reverse order
                if (j > i && j <= 2 * number - i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
    }

    public static void main(String[] args) {
        // Test cases to validate butterfly pattern behavior for different inputs
        int[] testCases = {1, 3, 5, 6};

        System.out.println("=== BUTTERFLY PATTERN TEST CASES ===\n");

        for (int n : testCases) {
            System.out.println("Test Case: n = " + n);
            System.out.println("--------------------------------");
            printButterfly(n);
            System.out.println("--------------------------------\n");
        }
    }
}
