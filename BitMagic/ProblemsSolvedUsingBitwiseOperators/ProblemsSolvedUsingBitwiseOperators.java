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

    // Main method with test cases
    public static void main(String[] args) {
        int num1 = 5;  // Binary: 0101
        int bitPos1 = 2;

        int num2 = 15; // Binary: 1111
        int bitPos2 = 4;

        System.out.println("----- Bitwise Operations -----\n");

        // Test case 1: Setting a bit
        int setResult = setBit(num1, bitPos1);
        System.out.println("Original number: " + num1 + " (Binary: " + Integer.toBinaryString(num1) + ")");
        System.out.println("After setting bit " + bitPos1 + ": " + setResult + " (Binary: " + Integer.toBinaryString(setResult) + ")\n");

        // Test case 2: Unsetting a bit
        int unsetResult = unsetBit(num2, bitPos2);
        System.out.println("Original number: " + num2 + " (Binary: " + Integer.toBinaryString(num2) + ")");
        System.out.println("After unsetting bit " + bitPos2 + ": " + unsetResult + " (Binary: " + Integer.toBinaryString(unsetResult) + ")");
    }
}
