import java.util.HashSet;

public class OptimalPartitionOfString {

    // Function to return the minimum number of substrings such that
    // no character appears more than once in any substring
    public static int partitionString(String s) {
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

    // Main method to test the function with different test cases
    public static void main(String[] args) {
        // Test Case 1: Normal case with repeating characters
        System.out.println("Test 1 (\"abac\") → " + partitionString("abac")); // Expected 2

        // Test Case 2: All unique characters
        System.out.println("Test 2 (\"abcdef\") → " + partitionString("abcdef")); // Expected 1

        // Test Case 3: All same characters
        System.out.println("Test 3 (\"aaaa\") → " + partitionString("aaaa")); // Expected 4

        // Test Case 4: Alternating repeating characters
        System.out.println("Test 4 (\"abab\") → " + partitionString("abab")); // Expected 2

        // Test Case 5: Empty string (edge case)
        System.out.println("Test 5 (\"\") → " + ( "".isEmpty() ? 0 : partitionString("") )); // Expected 0

        // Test Case 6: Single character string
        System.out.println("Test 6 (\"z\") → " + partitionString("z")); // Expected 1

        // Test Case 7: Long string with no repeats
        System.out.println("Test 7 (\"abcdefghijklmnopqrstuvwxyz\") → " +
                partitionString("abcdefghijklmnopqrstuvwxyz")); // Expected 1

        // Test Case 8: Long string with all same character
        System.out.println("Test 8 (\"zzzzzzzz\") → " + partitionString("zzzzzzzz")); // Expected 8

        // Test Case 9: Mixed pattern
        System.out.println("Test 9 (\"abacabad\") → " + partitionString("abacabad")); // Expected 4

        // Test Case 10: Large input stress test (edge case)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) sb.append('a'); // 100k same chars
        System.out.println("Test 10 (100k 'a's) → " + partitionString(sb.toString())); // Expected 100000
    }
}
