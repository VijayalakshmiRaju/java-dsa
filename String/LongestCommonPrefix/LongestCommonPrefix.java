public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs)
    {
        // Edge case: if array is null or empty, no prefix exists
        if (strs == null || strs.length == 0)
            return "";

        StringBuilder result = new StringBuilder();

        // Loop through each character of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i); // Take current character from first string

            // Compare this character with the same index character in other strings
            for (int j = 1; j < strs.length; j++) {
                // If current index is out of bounds OR mismatch found → return result so far
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return result.toString();
                }
            }

            // If loop completed without mismatch → add character to result
            result.append(c);
        }

        // Entire first string is a prefix
        return result.toString();
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"flower", "flow", "flight"},  // Expected: "fl"
                {"dog", "racecar", "car"},     // Expected: ""
                {"interspecies", "interstellar", "interstate"}, // Expected: "inters"
                {"throne", "throne"},          // Expected: "throne" (all strings same)
                {"prefix"},                    // Expected: "prefix" (only one string)
                {},                            // Expected: "" (empty array)
        };

        System.out.println("=== Longest Common Prefix Test Cases ===");
        for (int i = 0; i < testCases.length; i++) {
            String[] input = testCases[i];
            String result = longestCommonPrefix(input);
            System.out.printf("Test Case %d: %-30s → Longest Common Prefix: \"%s\"%n",
                    (i + 1), java.util.Arrays.toString(input), result);
        }
    }
}
