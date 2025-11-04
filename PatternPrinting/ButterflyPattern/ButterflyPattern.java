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

        System.out.println("=== BUTTERFLY PATTERN TEST CASES ===\n");

        // Test Case 1: Smallest valid input
        int n1 = 1;
        System.out.println("Test Case 1: n = " + n1);
        System.out.println("--------------------------------");
        printButterfly(n1);
        System.out.println("--------------------------------\n");

        // Test Case 2: Moderate input
        int n2 = 3;
        System.out.println("Test Case 2: n = " + n2);
        System.out.println("--------------------------------");
        printButterfly(n2);
        System.out.println("--------------------------------\n");

        // Test Case 3: Larger input
        int n3 = 5;
        System.out.println("Test Case 3: n = " + n3);
        System.out.println("--------------------------------");
        printButterfly(n3);
        System.out.println("--------------------------------\n");

        // Test Case 4: Even number of rows
        int n4 = 6;
        System.out.println("Test Case 4: n = " + n4);
        System.out.println("--------------------------------");
        printButterfly(n4);
        System.out.println("--------------------------------\n");
    }
}
