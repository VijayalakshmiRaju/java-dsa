public class LongestSubstringWithoutRepeatingCharacters {

    // Function to find the length of the longest substring
    // without repeating characters using Sliding Window technique
    public static int findSubstring(String s) {
        // Handle edge cases: null or empty string → length = 0
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Array to store the last seen index of each character
        // Assuming ASCII characters → array size = 128
        int[] seen = new int[128];

        // Initialize all characters as unseen (using -1)
        for (int i = 0; i < 128; i++) {
            seen[i] = -1;
        }

        // 'left' → start index of the current sliding window
        int left = 0;

        // 'maxLength' → stores the maximum substring length found so far
        int maxLength = 0;

        // Traverse through the string using 'right' as the end pointer
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right); // Current character

            // If this character was seen before AND
            // the previous index is within the current window
            // → Move the 'left' boundary right after its previous position
            if (seen[ch] >= left) {
                left = seen[ch] + 1;
            }

            // Update the last seen index for the current character
            seen[ch] = right;

            // Update the maximum length found so far
            // (current window size = right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the longest substring length found
        return maxLength;
    }

    // Test the function with sample inputs
    public static void main(String[] args) {
        // Array of test cases (input, expected output)
        String[][] tests = {
                {"abcabcbb", "3"},   // "abc"
                {"bbbbb", "1"},      // "b"
                {"pwwkew", "3"},     // "wke"
                {"au", "2"},         // "au"
                {"", "0"},           // empty
                {"a", "1"},          // single char
                {"aa", "1"},         // repeated char
                {"abba", "2"},       // "ab"
                {"tmmzuxt", "5"},    // "mzuxt"
                {"abcdef", "6"},     // all unique
                {"abcabc", "3"},   // "$%abc"
                {"a b c a b", "3"},  // "a b"
                {"a1b2c3a1", "6"},   // "1b2c3a"
                {"abcdabcdabcdabcd", "4"}, // repeating pattern
                {"aAbBcC", "6"},     // case-sensitive unique
                {"dvdf", "3"},       // "vdf"
                {"aaaaaaaab", "2"},  // "ab"
                {"abababab", "2"},   // "ab"
                {"xxabcdeffghxx", "7"}, // "xabcdef"
                {"xxabcdefgxx", "8"}    // "xabcdefg"
        };

        // Loop through and test each case
        for (int i = 0; i < tests.length; i++) {
            String input = tests[i][0];
            int expected = Integer.parseInt(tests[i][1]);
            int result = findSubstring(input);

            System.out.println("Test " + (i + 1) + ": Input=\"" + input + "\" → Output=" + result
                    + " | Expected=" + expected + (result == expected ? " PASS" : " FAIL"));
        }
    }
}
