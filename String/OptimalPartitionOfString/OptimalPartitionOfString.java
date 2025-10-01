import java.util.HashSet;

public class OptimalPartitionOfString {

    // Function to return the minimum number of substrings such that
    // no character appears more than once in any substring
    public static int partitionString(String s) {
        // Edge case: empty string → no partition needed
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // At least one substring will always exist
        int totalCount = 1;

        // HashSet is used to track characters in the current substring
        HashSet<Character> seen = new HashSet<>();

        // Loop through each character in the string
        for (char c : s.toCharArray()) {

            // If the character is already present in the current substring
            if (seen.contains(c)) {
                // We must start a new substring
                totalCount++;

                // Clear the set for the new substring
                seen.clear();
            }

            // Add the current character to the active substring set
            seen.add(c);
        }

        // Return the total number of substrings formed
        return totalCount;
    }

    // Main method with for loop for test cases
    public static void main(String[] args) {
        // Define test inputs
        String[] testInputs = {
                "abac",               // Normal case
                "abcdef",             // All unique
                "aaaa",               // All same
                "abab",               // Alternating repeats
                "",                   // Empty string
                "z",                  // Single character
                "abcdefghijklmnopqrstuvwxyz", // Full alphabet
                "zzzzzzzz",           // Multiple same chars
                "abacabad"            // Mixed pattern
        };

        // Define expected outputs (same index as inputs)
        int[] expectedOutputs = {
                2, // "abac"
                1, // "abcdef"
                4, // "aaaa"
                2, // "abab"
                0, // ""
                1, // "z"
                1, // alphabet
                8, // "zzzzzzzz"
                4  // "abacabad"
        };

        // Loop through test cases
        for (int i = 0; i < testInputs.length; i++) {
            int result = partitionString(testInputs[i]);
            System.out.println("Test " + (i + 1) + " (\"" + testInputs[i] + "\") → "
                    + result + " | Expected: " + expectedOutputs[i]
                    + " | " + (result == expectedOutputs[i] ? "PASS" : "FAIL"));
        }

        // Stress test for very large input
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) sb.append('a'); // 100k 'a's
        System.out.println("Stress Test (100k 'a's) → " + partitionString(sb.toString()));
    }
}
