public class CheckKthBitSetOrNot {

    /**
     * Function to check whether the k-th bit of a given number 'n' is set (1) or not (0).
     * @param n - the number to check
     * @param k - the bit position to test (0-based index)
     * @return true if k-th bit is set, false otherwise
     * Example:
     *   n = 5 (binary: 101)
     *   k = 0 → 1st bit → 1 → true
     *   k = 1 → 2nd bit → 0 → false
     *   k = 2 → 3rd bit → 1 → true
     */
    public static boolean isKthBitSet(int n, int k) {
        // (1 << k) shifts 1 to the left by k positions
        // Example: if k = 2 → (1 << 2) = 100 (binary)
        // Bitwise AND (&) checks if the k-th bit in n is set
        // If result ≠ 0 → bit is set, else not set
        return (n & (1 << k)) != 0;
    }

    public static void main(String[] args) {
        // ---- Test Case 1: Normal case ----
        int n1 = 5; // binary: 101
        System.out.println("Number: " + n1 + " (Binary: 101)");
        System.out.println("Is 0th bit set? " + isKthBitSet(n1, 0)); // true (1)
        System.out.println("Is 1st bit set? " + isKthBitSet(n1, 1)); // false (0)
        System.out.println("Is 2nd bit set? " + isKthBitSet(n1, 2)); // true (1)
        System.out.println();

        // ---- Test Case 2: Number = 0 ----
        int n2 = 0; // binary: 0000
        System.out.println("Number: " + n2 + " (Binary: 0000)");
        System.out.println("Is 0th bit set? " + isKthBitSet(n2, 0)); // false
        System.out.println("Is 3rd bit set? " + isKthBitSet(n2, 3)); // false
        System.out.println();

        // ---- Test Case 3: Large number ----
        int n3 = 1024; // binary: 10000000000
        System.out.println("Number: " + n3 + " (Binary: 10000000000)");
        System.out.println("Is 10th bit set? " + isKthBitSet(n3, 10)); // true
        System.out.println("Is 9th bit set? " + isKthBitSet(n3, 9));   // false
        System.out.println();

        // ---- Test Case 4: Edge case - negative number ----
        int n4 = -1; // binary (two's complement): all bits are 1
        System.out.println("Number: " + n4 + " (Binary: all bits set)");
        System.out.println("Is 0th bit set? " + isKthBitSet(n4, 0)); // true
        System.out.println("Is 31st bit set? " + isKthBitSet(n4, 31)); // true (sign bit)
        System.out.println();

        // ---- Test Case 5: Edge case - high k value ----
        int n5 = 8; // binary: 1000
        int k = 10; // k exceeds set bit positions
        System.out.println("Number: " + n5 + " (Binary: 1000)");
        System.out.println("Is 10th bit set? " + isKthBitSet(n5, k)); // false
        System.out.println();

        // ---- Test Case 6: Random check ----
        int n6 = 19; // binary: 10011
        System.out.println("Number: " + n6 + " (Binary: 10011)");
        System.out.println("Is 0th bit set? " + isKthBitSet(n6, 0)); // true
        System.out.println("Is 1st bit set? " + isKthBitSet(n6, 1)); // true
        System.out.println("Is 4th bit set? " + isKthBitSet(n6, 4)); // true
    }
}
