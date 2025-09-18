public class IsomorphicString {

    /**
     * Checks if two strings are isomorphic.
     *
     * Two strings s1 and s2 are isomorphic if the characters in s1 can be replaced
     * to get s2 while preserving the order of characters.
     * - No two characters in s1 can map to the same character in s2.
     * - A character may map to itself.
     *
     * Example:
     *  s1 = "egg", s2 = "add" → true (e->a, g->d)
     *  s1 = "foo", s2 = "bar" → false (o would need to map to a and r)
     */
    public static boolean isIsomorphicString(String s1, String s2) {
        // If lengths differ, they cannot be isomorphic
        if (s1.length() != s2.length())
            return false;

        int n = s1.length();

        // Arrays of size 256 (covers all ASCII characters)
        // mpS1[ch] stores the last seen position (index+1) of character ch in s1
        // mpS2[ch] stores the last seen position (index+1) of character ch in s2
        int[] mpS1 = new int[256];
        int[] mpS2 = new int[256];

        for (int i = 0; i < n; i++) {
            char chS1 = s1.charAt(i);
            char chS2 = s2.charAt(i);

            // If previously seen positions of chS1 and chS2 are different,
            // it means mapping is inconsistent → Not isomorphic
            if (mpS1[chS1] != mpS2[chS2]) {
                return false;
            }

            // Store current index + 1 (so default 0 can be used for "not seen yet")
            mpS1[chS1] = i + 1;
            mpS2[chS2] = i + 1;
        }

        // If we reach here, mapping was consistent throughout
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== Isomorphic String Test Cases ===");

        String[][] testCases = {
                {"egg", "add"},      // true
                {"foo", "bar"},      // false
                {"paper", "title"},  // true
                {"badc", "baba"},    // false
                {"", ""},            // true (two empty strings are trivially isomorphic)
                {"a", "a"},          // true (single characters, same)
                {"ab", "aa"},        // false (a maps to a, but b also maps to a → conflict)
                {"abc", "xyz"},      // true (a->x, b->y, c->z)
                {"abc", "xyy"},      // false (b and c both map to y → conflict)
                {"aab", "xxy"}       // true (a->x, b->y, consistent mapping)
        };

        for (String[] testCase : testCases) {
            String s1 = testCase[0];
            String s2 = testCase[1];
            boolean result = isIsomorphicString(s1, s2);
            System.out.printf("Input: s1 = %-8s | s2 = %-8s → Isomorphic? %s%n", "\"" + s1 + "\"", "\"" + s2 + "\"", result);
        }
    }
}
