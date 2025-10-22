public class Divisors {

    /**
     * Function to print all divisors of a given number (Naive Approach)
     *
     * Logic:
     * - A divisor of 'number' is any integer 'i' such that (number % i == 0)
     * - Loop through all numbers from 1 to 'number'
     * - Print 'i' if it divides the number evenly
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void printDivisorsNaive(int number) {
        // Handle invalid input (numbers less than or equal to 0)
        if (number <= 0) {
            System.out.println("No divisors exist for " + number);
            return;
        }

        System.out.print("Divisors of " + number + ": ");
        // Check every number from 1 to 'number' for divisibility
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)  // If 'i' divides 'number' evenly
                System.out.print(i + " ");
        }
        System.out.println(); // Move to next line after printing divisors
    }

    public static void main(String[] args) {
        // Test Cases

        System.out.println("=== Test Case 1: Positive Number (Normal Case) ===");
        printDivisorsNaive(10);
        // Expected Output: Divisors of 10: 1 2 5 10

        System.out.println("\n=== Test Case 2: Prime Number ===");
        printDivisorsNaive(13);
        // Expected Output: Divisors of 13: 1 13

        System.out.println("\n=== Test Case 3: Perfect Square ===");
        printDivisorsNaive(16);
        // Expected Output: Divisors of 16: 1 2 4 8 16

        System.out.println("\n=== Test Case 4: Smallest Positive Number (Edge Case) ===");
        printDivisorsNaive(1);
        // Expected Output: Divisors of 1: 1

        System.out.println("\n=== Test Case 5: Negative Number (Invalid Input) ===");
        printDivisorsNaive(-12);
        // Expected Output: No divisors exist for -12

        System.out.println("\n=== Test Case 6: Zero (Edge Case) ===");
        printDivisorsNaive(0);
        // Expected Output: No divisors exist for 0
    }
}
