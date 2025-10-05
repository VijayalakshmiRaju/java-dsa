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
        System.out.println(findSubstring("abcabcbb")); // Output: 3 ("abc")
        System.out.println(findSubstring("bbbbb"));    // Output: 1 ("b")
        System.out.println(findSubstring("pwwkew"));   // Output: 3 ("wke")
        System.out.println(findSubstring(""));         // Output: 0
        System.out.println(findSubstring("au"));       // Output: 2 ("au")
    }
}
