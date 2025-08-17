import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementGeneralized {
    // Function to find the count of elements in the array
    // that appear more than n/k times.
    public static int countOccurrenceHashMap(int[] arr, int k) {
        int n = arr.length;
        int threshold = n / k; // minimum frequency required

        // Step 1: Count frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Count how many elements exceed the threshold
        int count = 0;
        for (int freq : freqMap.values()) {
            if (freq > threshold) {
                count++;
            }
        }

        return count;
    }

    /**
     * Approach 2: Boyer–Moore Generalized Voting Algorithm
     * - At most (k - 1) elements can appear more than n/k times.
     * - Maintain candidate map of size <= k-1.
     * - Reduce counts when candidate pool overflows.
     * - Verify actual counts in second pass.
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public static int countOccurrenceBoyerMoore(int[] arr, int k)
    {
        int n = arr.length;
        // Step 1: Find potential candidates (<= k-1)
        Map<Integer, Integer> candidates = new HashMap<>();

        for ( int num : arr )
        {
            if (candidates.containsKey(num))
                candidates.put(num, candidates.get(num) + 1);
            else if ( candidates.size() < k-1 )
                candidates.put(num, 1);
            else {
                // Decrease frequency of all candidates
                List<Integer> toRemove = new ArrayList<>();
                for ( Map.Entry<Integer, Integer> ele : candidates.entrySet() )
                {
                    candidates.put(ele.getKey(), ele.getValue() - 1);
                    if (candidates.get(ele.getKey()) == 0)
                        toRemove.add(ele.getKey());
                }

                for ( int rem : toRemove )
                    candidates.remove(rem);
            }
        }

        // Step 2: Verify candidates
        Map<Integer, Integer> freqMap = new HashMap<>();
        for ( int num : arr )
        {
            if ( candidates.containsKey(num))
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for ( int num : freqMap.values() )
        {
            if ( num > n/k )
                count++;
        }

        return count;
    }

    // Driver code to test
    public static void main(String[] args) {

        int[] arr1 = {3, 1, 2, 2, 1, 2, 3, 3};
        int k1 = 4;
        System.out.println("HashMap: " + countOccurrenceHashMap(arr1, k1)); // 2
        System.out.println("Boyer-Moore: " + countOccurrenceBoyerMoore(arr1, k1)); // 2

        int[] arr2 = {2, 3, 3, 2};
        int k2 = 3;
        System.out.println("HashMap: " + countOccurrenceHashMap(arr2, k2)); // 2
        System.out.println("Boyer-Moore: " + countOccurrenceBoyerMoore(arr2, k2)); // 2

        int[] arr3 = {1, 4, 7, 7};
        int k3 = 2;
        System.out.println("HashMap: " + countOccurrenceHashMap(arr3, k3)); // 0
        System.out.println("Boyer-Moore: " + countOccurrenceBoyerMoore(arr3, k3)); // 0
    }
}
