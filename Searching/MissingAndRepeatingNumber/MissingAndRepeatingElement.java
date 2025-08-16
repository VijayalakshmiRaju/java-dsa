import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeatingElement {

    public static void findMissingAndRepeatingElementUsingSorting(int[] arr)
    {
        Arrays.sort(arr);
        int n = arr.length;

        int missingNumber = -1;
        int repeatingNumber = -1;

        // If the first number isn't 1, then 1 is missing
        if ( arr[0] != 1 )
        {
            missingNumber = 1;
        }

        for (int i = 0; i < n - 1; i++ )
        {
            // Repeating: adjacent equal values after sort
            if (arr[i] == arr[i+1])
            {
                repeatingNumber = arr[i];
            }
            // Missing: a gap > 1 implies the missing number is arr[i] + 1
            else if ( arr[i+1] -  arr[i] > 1 )
            {
                missingNumber = arr[i] + 1;
            }

            if ( missingNumber != -1 && repeatingNumber != -1 )
            {
                break;
            }
        }

        // If no gap found, the missing number is N (e.g., [1,2,3,4,4])
        if ( missingNumber == -1 )
        {
            missingNumber = n;
        }

        System.out.println("[Sorting Approach]");
        System.out.println("MISSING NUMBER: " + missingNumber);
        System.out.println("REPEATING NUMBER: " + repeatingNumber);
    }

    /**
     * Approach 2: Mathematical method using Sum & Product equations
     * Uses BigInteger and BigDecimal to safely handle large numbers
     */
    public static void findMissingAndRepeating(int[] arr)
    {
        int n = arr.length;

        // Excepted Sum = n(n+1)/2
        long expectedSum = ((long) n * (n + 1 )) / 2;

        // Expected Product = n!
        BigInteger expectedProduct = BigInteger.ONE;
        for ( int i = 1; i <= n; i++ )
        {
            expectedProduct = expectedProduct.multiply(BigInteger.valueOf(i));
        }

        long actualSum = 0;
        BigInteger actualProduct = BigInteger.ONE;
        for ( int num : arr )
        {
            actualSum += num;
            actualProduct = actualProduct.multiply(BigInteger.valueOf(num));
        }

        // Equation 1: diff = y - x
        long diff = actualSum - expectedSum;

        // Equation 2: ratio = y / x using BigDecimal for precise division
        BigDecimal actualDecimal = new BigDecimal(actualProduct);
        BigDecimal expectedDecimal = new BigDecimal(expectedProduct);

        double ratio = actualDecimal.divide(expectedDecimal, 10, RoundingMode.HALF_UP).doubleValue();

        // Solve equations:
        // y - x = diff
        // y / x = ratio
        double missing = diff / ( ratio - 1 );
        double repeating = missing + diff;

        System.out.println("[Sum & Product Approach]");
        System.out.println("MISSING NUMBER: " + (int) missing);
        System.out.println("REPEATING NUMBER: " + (int) repeating);
    }

    /**
     * Approach 3: Hashing
     */
    public static void findMissingAndRepeatingUsingHashing(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1]; // indices 1..n

        for (int num : arr) {
            hash[num]++;
        }

        int missing = -1;
        int repeating = -1;

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) missing = i;
            if (hash[i] == 2) repeating = i;
        }

        System.out.println("[Hashing Approach]");
        System.out.println("MISSING NUMBER: " + missing);
        System.out.println("REPEATING NUMBER: " + repeating);
    }

    /**
     * Approach 4: Hash Map
     */
    public static void findMissingAndRepeatingUsingHashMap(int[] arr)
    {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr )
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int missing = -1;
        int repeating = -1;
        for ( int i = 1; i <= arr.length; i++ )
        {
            int count = frequencyMap.getOrDefault(i, 0);
            if ( count == 0 ) missing = i;
            if ( count == 2 ) repeating = i;
        }

        System.out.println("[HashMap Approach]");
        System.out.println("MISSING NUMBER: " + missing);
        System.out.println("REPEATING NUMBER: " + repeating);
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 2, 1, 5};
        findMissingAndRepeatingElementUsingSorting(arr.clone());
        findMissingAndRepeating(arr.clone());
        findMissingAndRepeatingUsingHashing(arr.clone());
        findMissingAndRepeatingUsingHashMap(arr.clone());

        int[] arr2 = { 2, 3, 2, 1, 4};
        findMissingAndRepeatingElementUsingSorting(arr2.clone());
        findMissingAndRepeating(arr2.clone());
        findMissingAndRepeatingUsingHashing(arr2.clone());
        findMissingAndRepeatingUsingHashMap(arr2.clone());
    }
}
