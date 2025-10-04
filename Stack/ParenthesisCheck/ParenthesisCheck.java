import java.util.Stack;

public class ParenthesisCheck {

    // Function to check if a string has valid (balanced) parentheses
    public static boolean isValidParenthesis(String s) {
        // Stack to hold opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the input string
        for (char ch : s.toCharArray()) {
            // Case 1: If it's an opening bracket → push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Case 2: If it's a closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty → no opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                // Check the top of the stack (last pushed opening bracket)
                char top = stack.peek();

                // If closing bracket does not match the opening bracket → invalid
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }

                // Valid pair found → pop from stack
                stack.pop();
            }
            // Case 3: Ignore all other characters (if string contains extra stuff)
        }

        // If stack is empty → all brackets matched properly
        return stack.isEmpty();
    }

    // Main method to test different cases with descriptive output
    public static void main(String[] args) {
        // Test inputs
        String[] testCases = {
                "()",        // valid simple
                "()[]{}",    // valid multiple types
                "([{}])",    // valid nested
                "(]",        // mismatch
                "([)]",      // wrong order
                "(((",       // only opening
                "))",        // only closing
                "({[})",     // mixed invalid
                "",          // empty string
                "a+b*(c-d)", // with non-bracket chars
                "[",         // single opening
                "]"          // single closing
        };

        System.out.println("Parenthesis Check Results:\n");
        for (String test : testCases) {
            boolean result = isValidParenthesis(test);
            System.out.printf("Input: %-10s → %s\n", "\"" + test + "\"", (result ? "Valid" : "Invalid"));
        }
    }
}
