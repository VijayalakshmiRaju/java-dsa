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
}
