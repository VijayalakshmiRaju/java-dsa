public class HammingWeight {

    // Function to calculate the number of set bits (1s) in the binary representation of an integer
    public static int hammingWeight(int n) {
        // Special case: if n is 0, binary representation is all 0s → weight is 0
        if (n == 0)
            return 0;

        // Special case: if n is 1 or 2, both have exactly 1 set bit (1 -> 1, 2 -> 10)
        if (n <= 2)
            return 1;

        int cnt = 0; // counter to store number of set bits

        // Brian Kernighan’s algorithm:
        // Each operation "n = n & (n - 1)" removes the rightmost set bit from n
        // Loop runs exactly as many times as there are set bits in n
        while (n != 0) {
            n = n & (n - 1); // remove the lowest set bit
            cnt++;           // increment counter
        }

        return cnt; // return total number of set bits
    }

    // Main method to test various scenarios including edge cases
    public static void main(String[] args) {
        // Edge Case: Zero
        System.out.println("hammingWeight(0) = " + hammingWeight(0)); // Expected: 0

        // Small Numbers
        System.out.println("hammingWeight(1) = " + hammingWeight(1)); // Binary: 1 → Expected: 1
        System.out.println("hammingWeight(2) = " + hammingWeight(2)); // Binary: 10 → Expected: 1
        System.out.println("hammingWeight(3) = " + hammingWeight(3)); // Binary: 11 → Expected: 2
        System.out.println("hammingWeight(4) = " + hammingWeight(4)); // Binary: 100 → Expected: 1
        System.out.println("hammingWeight(5) = " + hammingWeight(5)); // Binary: 101 → Expected: 2
        System.out.println("hammingWeight(7) = " + hammingWeight(7)); // Binary: 111 → Expected: 3

        // Larger Numbers
        System.out.println("hammingWeight(15) = " + hammingWeight(15)); // Binary: 1111 → Expected: 4
        System.out.println("hammingWeight(16) = " + hammingWeight(16)); // Binary: 10000 → Expected: 1
        System.out.println("hammingWeight(31) = " + hammingWeight(31)); // Binary: 11111 → Expected: 5
        System.out.println("hammingWeight(32) = " + hammingWeight(32)); // Binary: 100000 → Expected: 1
        System.out.println("hammingWeight(1023) = " + hammingWeight(1023)); // Binary: 1111111111 → Expected: 10

        // Edge Cases with large values
        System.out.println("hammingWeight(Integer.MAX_VALUE) = " + hammingWeight(Integer.MAX_VALUE));
        // Integer.MAX_VALUE = 2147483647, binary has 31 ones → Expected: 31

        System.out.println("hammingWeight(Integer.MIN_VALUE) = " + hammingWeight(Integer.MIN_VALUE));
        // Integer.MIN_VALUE = -2147483648 (binary: 100...0) → Expected: 1
    }
}
