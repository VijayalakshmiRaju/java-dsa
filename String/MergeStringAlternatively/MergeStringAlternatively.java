public class MergeStringAlternatively {

    // Function to merge two strings alternatively
    public static String mergeStringAlternatively(String s1, String s2) {
        // Using StringBuilder for better performance (mutable string)
        StringBuilder result = new StringBuilder();

        // Total length = sum of both string lengths
        int totalLength = s1.length() + s2.length();

        // Iterate through total possible characters
        for (int i = 0; i < totalLength; i++) {
            if (i < s1.length()) {
                result.append(s1.charAt(i));
            }
            if (i < s2.length()) {
                result.append(s2.charAt(i));
            }
        }

        return result.toString();
    }

    // Main method with test cases inside a loop
    public static void main(String[] args) {
        // Each test case: {string1, string2, expectedResult}
        String[][] testCases = {
                {"abc", "xyz", "axbycz"},      // Same length
                {"abcd", "xy", "axbycd"},      // First longer
                {"hi", "world", "hwiorld"},    // Second longer
                {"", "hello", "hello"},        // First empty
                {"hello", "", "hello"},        // Second empty
                {"", "", ""},                  // Both empty
                {"A", "B", "AB"},              // Single chars
                {"123", "!@#", "1!2@3#"},      // Special chars
        };

        // Run all test cases in a loop
        for (int i = 0; i < testCases.length; i++) {
            String s1 = testCases[i][0];
            String s2 = testCases[i][1];
            String expected = testCases[i][2];
            String actual = mergeStringAlternatively(s1, s2);

            // Print formatted result
            System.out.println("Test " + (i + 1) +
                    ": mergeStringAlternatively(\"" + s1 + "\", \"" + s2 + "\")" +
                    " => " + actual +
                    " | Expected: " + expected +
                    " | " + (actual.equals(expected) ? "PASS" : "FAIL"));
        }
    }
}
