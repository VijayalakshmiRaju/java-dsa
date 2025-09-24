public class LongestPalindromicSubstring {

    // Function to return the longest palindromic substring in 's'
    public static String longestPalindrome(String s) {
        // Edge case: empty or null string
        if (s == null || s.length() < 1)
            return "";

        // Indices of the longest palindrome substring found so far
        int startIdx = 0, endIdx = 0;

        // Loop through each index to consider it as a "center"
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (center at i)
            int oddPalindromeLen = expandPalindrome(s, i, i);

            // Case 2: Even length palindrome (center between i and i+1)
            int evenPalindromeLen = expandPalindrome(s, i, i + 1);

            // Take the longer palindrome length
            int maxLen = Math.max(oddPalindromeLen, evenPalindromeLen);

            // If we found a longer palindrome, update the start & end indices
            if (maxLen > endIdx - startIdx) {
                // Compute start index (adjust left half of palindrome)
                startIdx = i - (maxLen - 1) / 2;
                // Compute end index (adjust right half of palindrome)
                endIdx = i + (maxLen / 2);
            }
        }

        // Return the longest palindromic substring
        return s.substring(startIdx, endIdx + 1);
    }

    // Helper function to expand around a potential palindrome center
    public static int expandPalindrome(String s, int left, int right) {
        // Expand while left and right are valid and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;   // move left pointer outwards
            right++;  // move right pointer outwards
        }
        // Length of palindrome = (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "babad",          // Example 1
                "cbbd",           // Example 2
                "a",              // Single char
                "",               // Empty string
                "ab",             // Two different chars
                "aa",             // Two same chars
                "racecar",        // Odd length palindrome
                "abccba",         // Even length palindrome
                "forgeeksskeegfor", // Palindrome in middle
                "abcda",          // Multiple single char palindromes
                "aaaa",           // All same chars
                "bananas"         // Mixed case
        };

        System.out.println("=== Longest Palindromic Substring Test Cases ===\n");
        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            String result = longestPalindrome(input);
            System.out.printf("Test %2d | Input: %-15s | Longest Palindrome: %s%n",
                    (i + 1), "\"" + input + "\"", "\"" + result + "\"");
        }
    }

}
