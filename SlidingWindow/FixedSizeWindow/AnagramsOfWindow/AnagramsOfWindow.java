import java.util.*;

public class AnagramsOfWindow {
    // Function to find all starting indices of anagrams of p in s
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> answer = new ArrayList<>();

        // Sliding window pointers
        int i = 0, j = 0;

        // Frequency array for pattern p
        int[] arr = new int[26];

        // Count of characters still needed to match an anagram
        int count = p.length();

        // Fill frequency array for pattern p
        for (char ch : p.toCharArray()) {
            arr[ch - 'a']++;
        }

        // Sliding window over string s
        while (j < s.length()) {

            // If this character is needed, reduce count
            if (arr[s.charAt(j) - 'a'] > 0) {
                count--;
            }

            // Reduce frequency for current character
            arr[s.charAt(j) - 'a']--;

            // When window size equals pattern length
            if (j - i + 1 == p.length()) {

                // If all required characters matched → anagram found
                if (count == 0) {
                    answer.add(i);
                }

                // Remove left character from window
                if (arr[s.charAt(i) - 'a'] >= 0) {
                    count++; // we are losing a required character
                }

                // Restore frequency for left character
                arr[s.charAt(i) - 'a']++;
                i++; // Slide window
            }

            j++; // Expand window
        }

        return answer;
    }

    // MAIN METHOD FOR TESTING
    public static void main(String[] args) {
        String[][] tests = {
                {"cbaebabacd", "abc"},   // expected [0, 6]
                {"abab", "ab"},           // expected [0, 1, 2]
                {"aaab", "aab"},           // expected [1]
                {"baa", "aa"},             // expected [1]
                {"abcd", "ef"},            // expected []
                {"a", "a"},                // expected [0]
                {"aaaaaaaaaa", "aa"},      // many overlapping anagrams
                {"abcabcabc", "abc"}       // repeated pattern
        };

        for (int t = 0; t < tests.length; t++) {
            String s = tests[t][0];
            String p = tests[t][1];
            List<Integer> result = findAnagrams(s, p);

            System.out.println("Test Case " + (t + 1));
            System.out.println("s = " + s + ", p = " + p);
            System.out.println("Anagram Indices = " + result);
            System.out.println("------------------------------------");
        }
    }

}
