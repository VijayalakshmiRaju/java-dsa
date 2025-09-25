public class FactorialTrailingZeroes {

    // Function to count trailing zeroes in n!
    public static int trailingZeroes(int n) {
        int result = 0;

        // Loop through powers of 5: 5, 25, 125, ...
        for (int i = 5; i <= n; i *= 5) {
            result += (n / i); // Count how many numbers <= n are divisible by i
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases including edge cases
        int[] testCases = {0, 1, 5, 10, 25, 50, 100, 125, 1000};

        // Using a for loop to run through all test cases
        for (int n : testCases) {
            System.out.println("Trailing zeroes in " + n + "! = " + trailingZeroes(n));
        }
    }
}
