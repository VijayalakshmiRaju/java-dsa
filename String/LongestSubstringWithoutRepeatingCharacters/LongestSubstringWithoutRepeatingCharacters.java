public class LongestSubstringWithoutRepeatingCharacters {
    public static int findSubstringLength( String s )
    {
        int[] seen = new int[128];
        for ( int i = 0; i < 128; i++ ) {
            seen[i] = -1;
        }

        int left = 0;
        int totalLength = 0;

        for ( int right = 0; right < s.length(); right++ ) {
            char ch = s.charAt(right);
            if ( seen[ch] >= left ) {
                left = seen[ch] + 1;
            }

            seen[ch] = right;
            totalLength = Math.max(totalLength, right - left + 1);
        }

        return totalLength;
    }

    // For quick testing
    public static void main(String[] args) {
        System.out.println(findSubstringLength("abcabcbb")); // 3 ("abc")
        System.out.println(findSubstringLength("bbbbb"));    // 1 ("b")
        System.out.println(findSubstringLength("pwwkew"));   // 3 ("wke")
        System.out.println(findSubstringLength(""));         // 0
        System.out.println(findSubstringLength("au"));       // 2
    }
}
