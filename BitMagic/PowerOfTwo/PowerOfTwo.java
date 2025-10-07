/**
 * The PowerOfTwo class provides a method to check
 * whether a given integer is a power of two using
 * bit manipulation.
 *
 * A number is a power of two if it has exactly one bit set in its binary representation.
 * For example: 1 (2^0), 2 (2^1), 4 (2^2), 8 (2^3), etc.
 */
public class PowerOfTwo {

    /**
     * Determines whether a given integer is a power of two.
     * @param n The integer number to check.
     * @return {@code true} if {@code n} is a power of two, otherwise {@code false}.
     */
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    /**
     * The main method is used to test the isPowerOfTwo function
     * with various inputs including positive numbers, negative numbers,
     * zero, and large integers.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] testCases = {
                0,          // Edge case: zero → not a power of two
                1,          // 2^0 → true
                2,          // 2^1 → true
                3,          // not a power of two
                4,          // 2^2 → true
                5,          // not a power of two
                8,          // 2^3 → true
                16,         // 2^4 → true
                31,         // not a power of two
                32,         // 2^5 → true
                64,         // 2^6 → true
                100,        // not a power of two
                -2,         // negative number → false
                -8,         // negative number → false
                Integer.MAX_VALUE, // large number → false
                Integer.MIN_VALUE  // negative large number → false
        };

        System.out.println("Testing PowerOfTwo.isPowerOfTwo() method:\n");

        for (int n : testCases) {
            System.out.printf("Is %d a power of two? → %b%n", n, isPowerOfTwo(n));
        }
    }
}
