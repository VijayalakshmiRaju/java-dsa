import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {


    /**
     * Find first non-repeating character index using HashMap.
     * Works for all characters (A–Z, a–z, digits, symbols, etc.)
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k = number of distinct characters
     */
    public static int findFirstNonRepeatingCharacterIndexUsingHashMap( String s )
    {
        if ( s == null || s.equals(""))
            return -1; // Handle null/empty input

        if ( s.length() == 1 )
            return 0; // Single character string -> always non-repeating

        Map<Character, Integer> map = new HashMap<>();

        // First pass: count character frequencies
        for ( int i = 0; i < s.length(); i++ )
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        // Second pass: find first character with frequency = 1
        for ( int i = 0; i < s.length(); i++ )
        {
            if (map.get(s.charAt(i)) == 1 )
                return i;
        }

        return -1; // No non-repeating character
    }

    /**
     * Find first non-repeating character index using Array.
     * Optimized for letters only (A–Z and a–z)
     * Index mapping:
     *   0–25  -> 'A'–'Z'
     *   26–51 -> 'a'–'z
     * Time Complexity: O(n)
     * Space Complexity: O(52) = constant
     */
    public static int findFirstNonRepeatingCharIndexUsingArray(String s)
    {
        if (s == null || s.isEmpty())
            return -1;

        if (s.length() == 1)
            return 0;

        // 52 slots: 26 uppercase + 26 lowercase
        int[] freq = new int[52];

        // First pass: count frequencies
        for ( int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt(i);
            if ( c >= 'A' && c <= 'Z') {
                freq[c - 'A']++; // map 'A' -> 0, 'B' -> 1 ... 'Z' -> 25
            } else if ( c >= 'a' && c <= 'z')
                freq[26 + (c - 'a')]++; // map 'a' -> 26, 'b' -> 27 ... 'z' -> 51
        }

        // Second pass: find first character with frequency = 1
        for ( int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt(i);
            int count = (c >= 'A' && c <= 'Z') ? freq[c - 'A'] : freq[26 + (c - 'a')];

            if ( count == 1)
                return i;
        }

        return -1; // No non-repeating character
    }

    // Helper method to print results nicely
    private static void testCase(String input) {
        int hashResult = findFirstNonRepeatingCharacterIndexUsingHashMap(input);
        int arrayResult = findFirstNonRepeatingCharIndexUsingArray(input);

        System.out.println("Input: \"" + input + "\"");

        if (hashResult == -1) {
            System.out.println("  HashMap Result: -1 (No non-repeating character)");
        } else {
            System.out.println("  HashMap Result: Index " + hashResult + " -> '" + input.charAt(hashResult) + "'");
        }

        if (arrayResult == -1) {
            System.out.println("  Array Result:   -1 (No non-repeating character)");
        } else {
            System.out.println("  Array Result:   Index " + arrayResult + " -> '" + input.charAt(arrayResult) + "'");
        }

        System.out.println("------------------------------------------------");
    }

    // Main method with clear outputs
    public static void main(String[] args) {
        System.out.println("=== First Non-Repeating Character Tests ===\n");

        // Edge cases
        testCase(null);
        testCase("");
        testCase("a");

        // General cases
        testCase("leetcode");       // first unique 'l'
        testCase("loveleetcode");   // first unique 'v'
        testCase("aabb");           // none
        testCase("aAbBcCd");        // 'd'
        testCase("AAbbCCdde");      // 'e'
        testCase("z");              // single char
        testCase("XYZabcXYZ");      // 'a'
    }
}
