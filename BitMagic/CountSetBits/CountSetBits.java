public class CountSetBits {

    /**
     * Function to count the number of set bits (1s) in the binary representation of an integer.
     * @param n - The integer whose set bits are to be counted.
     * @return The number of set bits (1s) in n.
     * Example:
     *   n = 5 (binary: 101)
     *   Output = 2
     */
    public static int countSetBits(int n) {
        int count = 0; // Counter to track number of 1 bits

        // Loop runs until all bits are processed (n becomes 0)
        while (n != 0) {
            // Bitwise AND with 1 extracts the last bit (LSB)
            // If it's 1 → increment count
            count += n & 1;

            // Right shift n by one position to process next bit
            // Using unsigned right shift for correctness with negative numbers
            n >>>= 1;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println("========== Count Set Bits in a Number ==========\n");

        // ---- Test Case 1: Normal case ----
        int n1 = 5; // Binary: 101
        System.out.println("Input: " + n1 + " (Binary: 101)");
        System.out.println("Set Bits Count: " + countSetBits(n1)); // Expected: 2
        System.out.println();

        // ---- Test Case 2: Zero ----
        int n2 = 0; // Binary: 0
        System.out.println("Input: " + n2 + " (Binary: 0)");
        System.out.println("Set Bits Count: " + countSetBits(n2)); // Expected: 0
        System.out.println();

        // ---- Test Case 3: All bits set (e.g., 7 = 111) ----
        int n3 = 7; // Binary: 111
        System.out.println("Input: " + n3 + " (Binary: 111)");
        System.out.println("Set Bits Count: " + countSetBits(n3)); // Expected: 3
        System.out.println();

        // ---- Test Case 4: Large number ----
        int n4 = 1023; // Binary: 1111111111 (10 bits set)
        System.out.println("Input: " + n4 + " (Binary: 1111111111)");
        System.out.println("Set Bits Count: " + countSetBits(n4)); // Expected: 10
        System.out.println();

        // ---- Test Case 5: Power of 2 ----
        int n5 = 16; // Binary: 10000
        System.out.println("Input: " + n5 + " (Binary: 10000)");
        System.out.println("Set Bits Count: " + countSetBits(n5)); // Expected: 1
        System.out.println();

        // ---- Test Case 6: Negative number ----
        int n6 = -1;
        // In Java, -1 is represented as all bits set (32-bit: 11111111 11111111 11111111 11111111)
        System.out.println("Input: " + n6 + " (Binary: all bits set)");
        System.out.println("Set Bits Count: " + countSetBits(n6)); // Expected: 32
        System.out.println();

        // ---- Test Case 7: Random number ----
        int n7 = 19; // Binary: 10011
        System.out.println("Input: " + n7 + " (Binary: 10011)");
        System.out.println("Set Bits Count: " + countSetBits(n7)); // Expected: 3
        System.out.println();

        System.out.println("===============================================");
    }
}
