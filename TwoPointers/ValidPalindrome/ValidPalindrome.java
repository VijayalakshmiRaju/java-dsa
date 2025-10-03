public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // Use StringBuilder to build a cleaned version of the string
        // containing only alphanumeric characters (letters + digits).
        StringBuilder sb = new StringBuilder();

        // Iterate through each character of the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is lowercase letter (a–z) or digit (0–9), keep it
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);

                // If the character is uppercase (A–Z), convert to lowercase by adding 32
                // (since in ASCII, 'A' (65) + 32 = 'a' (97), etc.)
            } else if (ch >= 'A' && ch <= 'Z') {
                char lowerCase = (char)(ch + 32);
                sb.append(lowerCase);
            }
            // Ignore all other characters (spaces, punctuation, symbols, etc.)
        }

        // Convert the StringBuilder to a string → cleaned, lowercase, only alphanumeric
        String cleanedString = sb.toString();

        // Two pointers: one at the start, one at the end
        int left = 0;
        int right = cleanedString.length() - 1;

        // Compare characters from both ends moving inward
        while (left < right) {
            // If mismatch found, it's not a palindrome
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }

            // Move pointers inward
            left++;
            right--;
        }

        // If loop finishes without mismatches → it’s a palindrome
        return true;
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Array of test inputs
        String[] testCases = {
                "A man, a plan, a canal: Panama", // true
                "racecar", // true
                "Madam", // true
                "No 'x' in Nixon", // true
                "12321", // true
                "Was it a car or a cat I saw?", // true
                "hello", // false
                "world", // false
                "palindrome", // false
                "12345", // false
                "", // true
                " ", // true
                "!!!", // true
                "a", // true
                "0", // true
                "aa", // true
                "ab", // false
                "Able was I, ere I saw Elba" // true
        };

        // Run all test cases using a for loop
        for (String test : testCases) {
            boolean result = isPalindrome(test);
            System.out.println("Input: \"" + test + "\" -> " + result);
        }
    }
}
