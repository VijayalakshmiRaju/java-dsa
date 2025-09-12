public class DecodeString {

    /**
     * Decodes the encoded string by reversing each chunk of size k.
     *
     * @param s The encoded string
     * @param k The chunk size used during encoding
     * @param n The length of the string (s.length())
     * @return Decoded string (original string)
     */
    public static String decode(String s, int k, int n) {
        if (k <= 0) return s; // If k is invalid, return as is

        String result = ""; // Will store decoded result

        // Process string in chunks of size k
        for (int i = 0; i < n; i += k) {
            // Calculate the last index for this chunk
            int endIndex = (i + k - 1 > n - 1) ? n - 1 : i + k - 1;

            // Append characters from this chunk in reverse order
            for (int j = endIndex; j >= i; j--) {
                result += s.charAt(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Each test case: { inputString, k, expectedOutput }
        String[][] testCases = {
                {"cbafedgh", "3", "abcdefgh"},  // Normal case
                {"A", "1", "A"},               // Single char
                {"abcd", "1", "abcd"},         // k=1, no change
                {"abcd", "10", "dcba"},        // k > length, reverse whole string
                {"", "3", ""},                 // Empty string
                {"xyz", "0", "xyz"},           // k=0, return as is
                {"cbafedhg", "3", "abcdefgh"}, // Last chunk smaller than k
                {"cbade", "3", "abcde"},       // Odd length string
                {"ccbbaa", "2", "aabbcc"}      // Repeating characters
        };

        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i][0];
            int k = Integer.parseInt(testCases[i][1]);
            String expected = testCases[i][2];

            String output = decode(input, k, input.length());

            System.out.println("Test " + (i + 1) +
                    " | Input: \"" + input + "\", k=" + k +
                    " | Output: \"" + output + "\"" +
                    " | Expected: \"" + expected + "\"" +
                    " | " + (output.equals(expected) ? "PASS" : "FAIL"));
        }
    }
}
