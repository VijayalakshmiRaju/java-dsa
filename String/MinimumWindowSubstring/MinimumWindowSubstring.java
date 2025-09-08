public class MinimumWindowSubstring {

    // ------------------ NAIVE APPROACH ------------------
    public static String findMinimumWindowSubstringNaive(String s, String t)
    {
        int m = s.length(), n = t.length();

        // Edge case: if s is smaller than t OR t is empty
        if (m < n || n == 0)
            return "";

        int minLength = Integer.MAX_VALUE;
        String result = "";

        // Check all substrings of s
        for ( int i = 0; i < m; i++ ) {
            for (int j = i; j < m; j++ ) {
                String subStr = s.substring(i, j+1);

                // Check if this substring contains all characters of t
                if (containsAll(subStr, t)) {
                    if (subStr.length() < minLength ) {
                        minLength = subStr.length();
                        result = subStr;
                    }
                }
            }
        }

        return result;
    }

    // Helper function: checks if substring contains all characters of t
    private static boolean containsAll(String sub, String t )
    {
        int[] freq = new int[128];

        // Count frequencies of characters in sub
        for ( char ch : sub.toCharArray() ) {
            freq[ch]++;
        }

        // Check if all characters of t are present in required frequency
        for ( char ch : t.toCharArray() ) {
            if (--freq[ch] < 0 )
                return false;
        }

        return true;
    }

    // ------------------ SLIDING WINDOW APPROACH ------------------
    public static String findMinimumWindowSubstring(String s, String t)
    {
        int m = s.length(), n = t.length();

        // Edge case: if s is smaller than t OR t is empty
        if (m < n || n == 0)
            return "";

        // Frequency array for characters in t (ASCII size = 128)
        int[] hashArr = new int[128];

        // Fill frequency array with required characters from t
        for ( int i = 0; i < n; i++ ) {
            hashArr[t.charAt(i)]++;
        }

        // Sliding window pointers: left (l), right (r)
        int l = 0, r = 0;
        // To track the start index of the minimum window
        int startIndex = -1;
        // To track the minimum length of substring found so far
        int minLength = Integer.MAX_VALUE;
        // To track how many characters of t have been matched
        int count = 0;

        // Expand the window using r (right pointer)
        while ( r < m )
        {
            char rightChar = s.charAt(r);

            // If this character is still needed (hashArr > 0), increase match count
            if (hashArr[rightChar] > 0 )
                count++;

            // Decrease the frequency (because it's included in the window now)
            hashArr[rightChar]--;

            // When all characters of t are matched (count == n)
            while ( count == n ) {
                // Check if current window is smaller than previous best
                if ( r - l + 1 < minLength ) {
                    minLength = r - l + 1;   // update min length
                    startIndex = l;          // update start index
                }

                // Try shrinking the window from the left
                char leftChar = s.charAt(l);
                hashArr[leftChar]++;   // restore frequency when removing this char

                // If restoring makes hashArr[leftChar] > 0,
                // it means this char is required again, so reduce count
                if (hashArr[leftChar] > 0)
                    count--;

                l++;   // move left pointer forward
            }

            r++;   // move right pointer forward
        }

        // If no valid window found, return ""
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex+minLength);
    }

    // ------------------ MAIN METHOD WITH TEST CASES ------------------
    public static void main(String[] args) {
        String[][] testCases = {
                {"ADOBECODEBANC", "ABC"},   // Classic example
                {"a", "a"},                 // Single character match
                {"a", "aa"},                // Target longer than source
                {"ab", "A"},                // Case sensitivity test
                {"", "a"},                  // Empty string s
                {"abc", ""},                // Empty string t
                {"abcdef", "xyz"},          // No common characters
                {"aa", "aa"},               // Exact match
                {"aa", "a"},                // Multiple occurrences
                {"thisisateststring", "tist"} // Larger example
        };

        System.out.println("======= Minimum Window Substring Test Cases =======\n");

        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i][0];
            String t = testCases[i][1];

            String naiveResult = findMinimumWindowSubstringNaive(s, t);
            String optimizedResult = findMinimumWindowSubstring(s, t);

            System.out.println("Test Case " + (i+1) + ":");
            System.out.println("  s = \"" + s + "\"");
            System.out.println("  t = \"" + t + "\"");
            System.out.println("  Naive Result      = \"" + naiveResult + "\"");
            System.out.println("  Sliding Window    = \"" + optimizedResult + "\"");
            System.out.println("---------------------------------------------------\n");
        }
    }
}
