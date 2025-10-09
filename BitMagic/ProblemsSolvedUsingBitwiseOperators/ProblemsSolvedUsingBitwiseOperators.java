public class ProblemsSolvedUsingBitwiseOperators {

    // Function to set (turn ON) the k-th bit of a number
    public static int setBit(int num, int k) {
        // Create a mask by left-shifting 1 by (k-1) positions
        // Example: k=3 → 0001 << 2 = 0100
        int mask = 1 << (k - 1);

        // Bitwise OR sets the k-th bit to 1
        // Example: num=5(0101), mask=0100 → result=0101|0100=0101 (bit already set)
        return num | mask;
    }

    // Function to unset (turn OFF) the k-th bit of a number
    public static int unsetBit(int num, int k) {
        // Create a mask by left-shifting 1 by (k-1) positions
        int mask = 1 << (k - 1);

        // Bitwise NOT (~mask) flips bits, then AND keeps all bits same except k-th which becomes 0
        // Example: num=7(0111), mask=0100 → ~mask=1011 → result=0111 & 1011 = 0011 (4th bit unset)
        return num & (~mask);
    }

    // Function to check whether the k-th bit is set (1) or not
    public static boolean isKthBitSet(int num, int k) {
        // Create a mask with 1 at k-th position
        int mask = 1 << (k - 1);
        // Perform AND; if result > 0, bit is set
        return (num & mask) != 0;
    }

    // Function to toggle (flip) the k-th bit of a number
    public static int toggleKthBit(int num, int k) {
        // Create a mask with 1 at k-th position
        int mask = 1 << (k - 1);
        // XOR flips the k-th bit (1→0 or 0→1)
        return num ^ mask;
    }

    // Main method to test all bitwise operations
    public static void main(String[] args) {

        // Example 1: Set bit
        int num1 = 5;    // Binary: 0101
        int bitPos1 = 2; // We’ll set the 2nd bit

        // Example 2: Unset bit
        int num2 = 15;   // Binary: 1111
        int bitPos2 = 4; // We’ll unset the 4th bit

        // Example 3: Check bit
        int num3 = 5;    // Binary: 0101
        int bitPos3 = 3; // We’ll check if the 3rd bit is set

        // Example 4: Toggle bit
        int num4 = 9;    // Binary: 1001
        int bitPos4 = 1; // We’ll toggle the 1st bit

        System.out.println("========== Bitwise Operations ==========\n");

        // ---- Test 1: Set Bit ----
        int setResult = setBit(num1, bitPos1);
        System.out.println("SET BIT OPERATION:");
        System.out.println("Original Number : " + num1 + " (Binary: " + Integer.toBinaryString(num1) + ")");
        System.out.println("After setting bit " + bitPos1 + " : " + setResult + " (Binary: " + Integer.toBinaryString(setResult) + ")\n");

        // ---- Test 2: Unset Bit ----
        int unsetResult = unsetBit(num2, bitPos2);
        System.out.println("UNSET BIT OPERATION:");
        System.out.println("Original Number : " + num2 + " (Binary: " + Integer.toBinaryString(num2) + ")");
        System.out.println("After unsetting bit " + bitPos2 + " : " + unsetResult + " (Binary: " + Integer.toBinaryString(unsetResult) + ")\n");

        // ---- Test 3: Check if Bit is Set ----
        boolean isSet = isKthBitSet(num3, bitPos3);
        System.out.println("CHECK BIT OPERATION:");
        System.out.println("Number : " + num3 + " (Binary: " + Integer.toBinaryString(num3) + ")");
        System.out.println("Is bit " + bitPos3 + " set? : " + (isSet ? "YES" : "NO") + "\n");

        // ---- Test 4: Toggle Bit ----
        int toggleResult = toggleKthBit(num4, bitPos4);
        System.out.println("TOGGLE BIT OPERATION:");
        System.out.println("Original Number : " + num4 + " (Binary: " + Integer.toBinaryString(num4) + ")");
        System.out.println("After toggling bit " + bitPos4 + " : " + toggleResult + " (Binary: " + Integer.toBinaryString(toggleResult) + ")\n");

        System.out.println("========================================");
    }
}
