import java.util.*;

public class SubstringRange {

//    public static String subString(String str, int startIdx, int endIdx)
//    {
//        String s = "";
//        for ( int i = startIdx; i <= endIdx; i++ )
//        {
//            s += str.charAt(i) + "";
//        }
//
//        return s;
//    }


    /**
     * Naive approach:
     * For each character in s2, search through s1
     * to find its first occurrence.
     * Track the minimum and maximum indices among these occurrences.
     * Finally, return the substring of s1 between min and max.
     * Time Complexity: O(|s1| * |s2|)
     * Space Complexity: O(1)
     */
    public static String findSubstringNaive(String s1, String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();

        int minIdx = Integer.MAX_VALUE;
        int maxIdx = Integer.MIN_VALUE;

        // For each character in s2
        for ( int i = 0; i < n2; i++ )
        {
            int firstOccurence = Integer.MAX_VALUE;

            // Find the first occurrence in s1
            for ( int j = 0; j < n1; j++ )
            {
                if (s1.charAt(j) == s2.charAt(i))
                {
                    firstOccurence = Math.min(firstOccurence, j);
                }
            }

            // Update min and max indices if character was found
            if (firstOccurence != Integer.MAX_VALUE) {
                minIdx = Math.min(firstOccurence, minIdx);
                maxIdx = Math.max(firstOccurence, maxIdx);
            }
        }

        // If no characters were found in s1
        if (minIdx == Integer.MAX_VALUE) { // FIXED
            return "";
        }

        return s1.substring(minIdx, maxIdx+1);
    }

    /**
     * Optimized using HashMap:
     * Preprocess s1 into a map of character -> list of indices.
     * Then for each character in s2, fetch its earliest occurrence index.
     * Update min and max indices accordingly.
     * Time Complexity: O(|s1| + |s2|)   (preprocessing + lookup)
     * Space Complexity: O(|s1|)        (to store indices in map)
     */
    public static String findSubstringUsingHashMap(String s1, String s2)
    {
        // Step 1: Build a map of character -> list of all indices in s1
        Map<Character, List<Integer>> chMap = new HashMap<>();
        for ( int i = 0; i < s1.length(); i++ )
        {
            chMap.computeIfAbsent(s1.charAt(i), k -> new ArrayList<>()).add(i);
        }
        int minIdx = Integer.MAX_VALUE;
        int maxIdx = Integer.MIN_VALUE;

        // Step 2: For each character in s2, check its first index in s1
        for ( char c : s2.toCharArray() )
        {
            if (chMap.containsKey(c))
            {
                // Always take the first occurrence (smallest index)
                int idx = chMap.get(c).get(0);
                minIdx = Math.min(minIdx, idx);
                maxIdx = Math.max(maxIdx, idx);
            }
        }

        // If none of s2’s chars were found in s1, return empty string
        if(minIdx == Integer.MAX_VALUE)
            return "";

        // Return substring spanning min to max index
        return s1.substring(minIdx, maxIdx+1);
    }

    public static void main(String[] args)
    {
        String s1 = "PROGRAMMING";
        String s2 = "GIR";
        System.out.println("Naive: " + findSubstringNaive(s1, s2));   // Expected: ROGRAMMI
        System.out.println("HashSet: " + findSubstringUsingHashMap(s1, s2)); // Expected: ROGRAMMI

        // Test case 2: All characters of s2 appear in order in s1
        s1 = "ABCDEFGH";
        s2 = "ACE";
        System.out.println("Naive: " + findSubstringNaive(s1, s2));   // Expected: ABCDE
        System.out.println("HashSet: " + findSubstringUsingHashMap(s1, s2)); // Expected: ABCDE

        // Test case 3: Characters of s2 not present in s1
        s1 = "HELLOWORLD";
        s2 = "XYZ";
        System.out.println("Naive: " + findSubstringNaive(s1, s2));   // Expected: ""
        System.out.println("HashSet: " + findSubstringUsingHashMap(s1, s2)); // Expected: ""

        // Test case 4: One character string
        s1 = "HELLO";
        s2 = "H";
        System.out.println("Naive: " + findSubstringNaive(s1, s2));   // Expected: H
        System.out.println("HashSet: " + findSubstringUsingHashMap(s1, s2)); // Expected: H

        // Test case 5: Overlapping characters
        s1 = "BANANA";
        s2 = "AN";
        System.out.println("Naive: " + findSubstringNaive(s1, s2));   // Expected: ANA
        System.out.println("HashSet: " + findSubstringUsingHashMap(s1, s2)); // Expected: ANA

        // Test case 6: s2 contains duplicates
        s1 = "COMPUTER";
        s2 = "TOOT";
        System.out.println("Naive: " + findSubstringNaive(s1, s2));   // Expected: OMPUT
        System.out.println("HashSet: " + findSubstringUsingHashMap(s1, s2)); // Expected: OMPUT

        // Test case 7: s1 and s2 are identical
        s1 = "JAVA";
        s2 = "JAVA";
        System.out.println("Naive: " + findSubstringNaive(s1, s2));   // Expected: JAVA
        System.out.println("HashSet: " + findSubstringUsingHashMap(s1, s2)); // Expected: JAVA
    }
}
