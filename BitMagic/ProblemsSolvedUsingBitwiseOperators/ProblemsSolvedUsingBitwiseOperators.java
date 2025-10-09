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

    // Multiply number by 2 using bitwise left shift
    public static int multiplyByTwo(int num) {
        // Left shift by 1 bit → equivalent to num * 2
        return num << 1;
    }

    // Divide number by 2 using bitwise right shift
    public static int divideByTwo(int num) {
        // Right shift by 1 bit → equivalent to num / 2
        return num >> 1;
    }

    // Function to swap two numbers using XOR (without temporary variable)
    public static void swapNumbers(int num1, int num2) {
        System.out.println("Before swapping → num1: " + num1 + ", num2: " + num2);
        // XOR-based swap
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println("After swapping  → num1: " + num1 + ", num2: " + num2);
    }

    // Main method to test all bitwise operations
    public static void main(String[] args) {
        System.out.println("========== Bitwise Operations ==========\n");

        // ---- Test 1: Set Bit ----
        int num1 = 5;    // Binary: 0101
        int bitPos1 = 2;
        int setResult = setBit(num1, bitPos1);
        System.out.println("SET BIT OPERATION:");
        System.out.println("Original Number : " + num1 + " (Binary: " + Integer.toBinaryString(num1) + ")");
        System.out.println("After setting bit " + bitPos1 + " : " + setResult + " (Binary: " + Integer.toBinaryString(setResult) + ")\n");

        // ---- Test 2: Unset Bit ----
        int num2 = 15;   // Binary: 1111
        int bitPos2 = 4;
        int unsetResult = unsetBit(num2, bitPos2);
        System.out.println("UNSET BIT OPERATION:");
        System.out.println("Original Number : " + num2 + " (Binary: " + Integer.toBinaryString(num2) + ")");
        System.out.println("After unsetting bit " + bitPos2 + " : " + unsetResult + " (Binary: " + Integer.toBinaryString(unsetResult) + ")\n");

        // ---- Test 3: Check if Bit is Set ----
        int num3 = 5;    // Binary: 0101
        int bitPos3 = 3;
        boolean isSet = isKthBitSet(num3, bitPos3);
        System.out.println("CHECK BIT OPERATION:");
        System.out.println("Number : " + num3 + " (Binary: " + Integer.toBinaryString(num3) + ")");
        System.out.println("Is bit " + bitPos3 + " set? : " + (isSet ? "YES" : "NO") + "\n");

        // ---- Test 4: Toggle Bit ----
        int num4 = 9;    // Binary: 1001
        int bitPos4 = 1;
        int toggleResult = toggleKthBit(num4, bitPos4);
        System.out.println("TOGGLE BIT OPERATION:");
        System.out.println("Original Number : " + num4 + " (Binary: " + Integer.toBinaryString(num4) + ")");
        System.out.println("After toggling bit " + bitPos4 + " : " + toggleResult + " (Binary: " + Integer.toBinaryString(toggleResult) + ")\n");

        // ---- Test 5: Multiply and Divide by 2 ----
        int num5 = 8;
        int multiplied = multiplyByTwo(num5);
        int divided = divideByTwo(num5);
        System.out.println("MULTIPLY & DIVIDE OPERATION:");
        System.out.println("Original Number : " + num5 + " (Binary: " + Integer.toBinaryString(num5) + ")");
        System.out.println("After multiplying by 2 : " + multiplied + " (Binary: " + Integer.toBinaryString(multiplied) + ")");
        System.out.println("After dividing by 2    : " + divided + " (Binary: " + Integer.toBinaryString(divided) + ")\n");

        // ---- Test 6: Swap Numbers ----
        System.out.println("SWAP OPERATION:");
        swapNumbers(4, 7);
        System.out.println("\n========================================");
    }
}
