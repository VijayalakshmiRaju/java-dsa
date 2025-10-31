import java.util.Stack;

public class ReverseIndividualWords {

    /**
     * Function to reverse individual words in a given sentence.
     *
     * Example:
     * Input  : "Welcome to the club"
     * Output : "emocleW ot eht bulc"
     *
     * Approach:
     * - Use a stack to reverse characters of each word.
     * - Traverse each character of the string.
     * - If the character is not a space, push it into the stack.
     * - When a space is encountered, pop all characters from the stack
     *   and append to the result (this reverses the word).
     * - Append the space, and continue for the next word.
     * - After traversal, pop any remaining characters (for the last word).
     */
    public static String reverseWords(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Traverse through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If not a space, push character onto the stack
            if (ch != ' ') {
                stack.push(ch);
            } else {
                // Pop all characters to form the reversed word
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                // Append space to separate words
                result.append(" ");
            }
        }

        // After the loop, there may be one word left in the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("=== Reverse Individual Words Test Cases ===\n");

        // Test Case 1: Normal sentence
        String str1 = "Welcome to the club";
        System.out.println("Input : " + str1);
        System.out.println("Output: " + reverseWords(str1));
        System.out.println("------------------------------------------");

        // Test Case 2: Single word (should remain reversed as one word)
        String str2 = "Hello";
        System.out.println("Input : " + str2);
        System.out.println("Output: " + reverseWords(str2));
        System.out.println("------------------------------------------");

        // Test Case 3: Multiple spaces between words
        String str3 = "Java   is   fun";
        System.out.println("Input : \"" + str3 + "\"");
        System.out.println("Output: \"" + reverseWords(str3) + "\"");
        System.out.println("------------------------------------------");

        // Test Case 4: Empty string
        String str4 = "";
        System.out.println("Input : \"" + str4 + "\"");
        System.out.println("Output: \"" + reverseWords(str4) + "\"");
        System.out.println("------------------------------------------");

        // Test Case 5: String with leading and trailing spaces
        String str5 = "  Welcome home  ";
        System.out.println("Input : \"" + str5 + "\"");
        System.out.println("Output: \"" + reverseWords(str5) + "\"");
        System.out.println("------------------------------------------");

        // Test Case 6: String with punctuation
        String str6 = "Hello, world!";
        System.out.println("Input : " + str6);
        System.out.println("Output: " + reverseWords(str6));
        System.out.println("------------------------------------------");

        // Test Case 7: String with numbers
        String str7 = "123 456 789";
        System.out.println("Input : " + str7);
        System.out.println("Output: " + reverseWords(str7));
        System.out.println("------------------------------------------");

        // Test Case 8: Only spaces
        String str8 = "     ";
        System.out.println("Input : \"" + str8 + "\"");
        System.out.println("Output: \"" + reverseWords(str8) + "\"");
        System.out.println("------------------------------------------");

        // Test Case 9: Mixed uppercase and lowercase
        String str9 = "HeLLo WoRLd";
        System.out.println("Input : " + str9);
        System.out.println("Output: " + reverseWords(str9));
        System.out.println("------------------------------------------");
    }
}
