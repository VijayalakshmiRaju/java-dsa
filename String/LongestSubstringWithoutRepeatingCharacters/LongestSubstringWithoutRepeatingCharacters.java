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
        // Basic Test Cases
        System.out.println("Test 1: " + findSubstring("abcabcbb") + " → Expected: 3"); // "abc"
        System.out.println("Test 2: " + findSubstring("bbbbb") + " → Expected: 1");   // "b"
        System.out.println("Test 3: " + findSubstring("pwwkew") + " → Expected: 3");  // "wke"
        System.out.println("Test 4: " + findSubstring("au") + " → Expected: 2");      // "au"

        // Edge Cases
        System.out.println("Test 5: " + findSubstring("") + " → Expected: 0");        // Empty string
        System.out.println("Test 6: " + findSubstring("a") + " → Expected: 1");       // Single char
        System.out.println("Test 7: " + findSubstring("aa") + " → Expected: 1");      // Repeated same char
        System.out.println("Test 8: " + findSubstring("abba") + " → Expected: 2");    // "ab" or "ba"
        System.out.println("Test 9: " + findSubstring("tmmzuxt") + " → Expected: 5"); // "mzuxt"

        // All unique characters
        System.out.println("Test 10: " + findSubstring("abcdef") + " → Expected: 6"); // Entire string

        // String with special characters
        System.out.println("Test 11: " + findSubstring("abc$%abc") + " → Expected: 6"); // "$%abc"

        // String with spaces
        System.out.println("Test 12: " + findSubstring("a b c a b") + " → Expected: 3"); // "a b" or "b c"

        // String with digits and letters mixed
        System.out.println("Test 13: " + findSubstring("a1b2c3a1") + " → Expected: 6"); // "1b2c3a"

        // Long string with repeating pattern
        System.out.println("Test 14: " + findSubstring("abcdabcdabcdabcd") + " → Expected: 4"); // "abcd"

        // Case sensitivity test
        System.out.println("Test 15: " + findSubstring("aAbBcC") + " → Expected: 6"); // All distinct (case-sensitive)

        // Random mixed string
        System.out.println("Test 17: " + findSubstring("dvdf") + " → Expected: 3");   // "vdf"

        // Long repetitive sequence
        System.out.println("Test 18: " + findSubstring("aaaaaaaab") + " → Expected: 2"); // "ab"

        // String with alternating characters
        System.out.println("Test 19: " + findSubstring("abababab") + " → Expected: 2"); // "ab"

        // Large unique substring in middle
        System.out.println("Test 20: " + findSubstring("xxabcdeffghxx") + " → Expected: 7"); // "abcdeff" -> but repeated 'f', so max = 6 actually
        System.out.println("Test 20 (corrected expected): " + findSubstring("xxabcdefgxx") + " → Expected: 7"); // "abcdefg"

        // Large unique substring in middle
        System.out.println("Test 20: " + findSubstring("xxabcdeffghxx") + " → Expected: 6"); // "abcdef" (length 6)
        System.out.println("Test 21: " + findSubstring("xxabcdefgxx") + " → Expected: 8");   // "abcdefgx" (length 8)
    }
}
