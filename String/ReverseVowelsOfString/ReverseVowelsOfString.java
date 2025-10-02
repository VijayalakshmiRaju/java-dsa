public class ReverseVowelsOfString {

    // Function to reverse vowels in a given string
    public static String reverseVowels(String s) {
        // Define all vowels (both lowercase and uppercase)
        String vowels = "aeiouAEIOU";
        char[] charArr = s.toCharArray(); // Convert string to char array for easy manipulation
        int left = 0;                     // Start pointer (leftmost character)
        int right = charArr.length - 1;   // End pointer (rightmost character)

        // Process until two pointers meet
        while (left < right) {
            // Move left pointer forward until a vowel is found
            while (left < right && vowels.indexOf(charArr[left]) == -1) {
                left++;
            }

            // Move right pointer backward until a vowel is found
            while (left < right && vowels.indexOf(charArr[right]) == -1) {
                right--;
            }

            // Swap vowels at left and right
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;

            // Move both pointers inward after swapping
            left++;
            right--;
        }

        // Convert char array back to string
        return new String(charArr);
    }

    // Main method to test multiple cases
    public static void main(String[] args) {
        // Array of input test cases
        String[] testInputs = {
                "hello",        // Normal case
                "rhythm",       // No vowels
                "aeiou",        // Only vowels
                "LeetCode",     // Mixed case
                "a",            // Single vowel
                "z",            // Single consonant
                "",             // Empty string
                " a e i o u ",  // String with spaces
                "madam",        // Palindrome with vowels
                "HELLO",        // Uppercase vowels
                "hEllo, World!" // Sentence with punctuation
        };

        // Expected outputs (for clarity)
        String[] expectedOutputs = {
                "holle",
                "rhythm",
                "uoiea",
                "LeotCede",
                "a",
                "z",
                "",
                " u o i e a ",
                "madam",
                "HOLLE",
                "hOlle, Werld!"
        };

        // Run all test cases using a for loop
        for (int i = 0; i < testInputs.length; i++) {
            String result = reverseVowels(testInputs[i]);
            System.out.println("Input: \"" + testInputs[i] + "\" | Output: \"" + result + "\" | Expected: \"" + expectedOutputs[i] + "\"");
        }
    }
}
