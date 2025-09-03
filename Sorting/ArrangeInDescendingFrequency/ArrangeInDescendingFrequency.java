import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrangeInDescendingFrequency {
    public static void arrangeNumbersInDescendingFrequency( int[] arr )
    {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> firstIndexMap = new HashMap<>();

        // Step 1: Count frequency
        for ( int i = 0 ; i < arr.length; i++ )
        {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            if ( !firstIndexMap.containsKey(arr[i]))
                firstIndexMap.put(arr[i], i); // store first occurrence index for stability
        }

        // Step 2: Create info array [value, frequency, firstIndex]
        int[][] info = new int[arr.length][3];
        for (int i = 0; i < arr.length; i++) {
            info[i][0] = arr[i];                     // value
            info[i][1] = frequencyMap.get(arr[i]);        // frequency
            info[i][2] = firstIndexMap.get(arr[i]);  // first index
        }

        // Step 3: Bubble sort based on frequency desc, then first index asc
        for( int i = 0; i < arr.length - 1; i++ )
        {
            for ( int j = 0; j < arr.length - i - 1; j++ )
            {
                if ( info[j][1] < info[j+1][1] || (info[j][1] == info[j+1][1] && info[j][2] > info[j+1][2] ))
                {
                    // swap rows
                    int[] temp = info[j];
                    info[j] = info[j+1];
                    info[j+1] = temp;
                }
            }
        }

        // Step 4: Build result
        int[] result = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ )
            result[i] = info[i][0];

        // Print result
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {4, 2, 1, 3, 1, 2, 5, 2},     // normal
                {7, 7, 7, 7},                 // all same
                {5, 4, 3, 2, 1},              // all distinct
                {8, 9, 8, 9, 10, 10},         // same frequency groups
                {42},                         // single element
                {0, -1, -1, 0, 2},            // includes negative & zero
                {1, 2, 2, 2, 3}               // high frequency vs low
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Test Case " + (i + 1) + ": ");
            arrangeNumbersInDescendingFrequency(testCases[i]);
        }
    }
}
