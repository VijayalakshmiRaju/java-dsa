public class ReverseString {

    /**
     * Reverses the given character array in-place using Two Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverseString(char[] s) {
        // Pointer at the beginning
        int left = 0;

        // Pointer at the end
        int right = s.length - 1;

        // Swap characters until pointers cross
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    // Helper method to print input and output clearly
    private static void test(char[] input, String testCaseName) {
        System.out.println(testCaseName);
        System.out.println("Input  : " + new String(input));
        reverseString(input);
        System.out.println("Output : " + new String(input));
        System.out.println();
    }

    public static void main(String[] args) {

        test(new char[]{'h', 'e', 'l', 'l', 'o'}, "Test Case 1: Normal string");
        test(new char[]{'a', 'b', 'c', 'd'}, "Test Case 2: Even length string");
        test(new char[]{'x'}, "Test Case 3: Single character (edge case)");
        test(new char[]{}, "Test Case 4: Empty array (edge case)");
        test(new char[]{'m', 'a', 'd', 'a', 'm'}, "Test Case 5: Palindrome");
        test(new char[]{'@', '#', '$', '%'}, "Test Case 6: Special characters");
    }
}
