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
     * - Append the space and continue.
     * - After the loop, pop remaining characters (for the last word).
     */
    public static String reverseWords(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Traverse through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Push non-space characters to stack
            if (ch != ' ') {
                stack.push(ch);
            } else {
                // Pop all characters to reverse the word
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                // Append space after the word
                result.append(" ");
            }
        }

        // Pop remaining characters (for the last word)
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("=== Reverse Individual Words Test Cases ===\n");

        // Store all test cases in an array
        String[] testCases = {
                "Welcome to the club",    // Normal sentence
                "Hello",                  // Single word
                "Java   is   fun",        // Multiple spaces
                "",                       // Empty string
                "  Welcome home  ",       // Leading & trailing spaces
                "Hello, world!",          // With punctuation
                "123 456 789",            // Numbers
                "     ",                  // Only spaces
                "HeLLo WoRLd"             // Mixed case
        };

        // Iterate through test cases using a for loop
        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            String output = reverseWords(input);

            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input : \"" + input + "\"");
            System.out.println("Output: \"" + output + "\"");
            System.out.println("------------------------------------------");
        }
    }
}
