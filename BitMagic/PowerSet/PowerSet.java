import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    // Function to generate all subsets (power set) of the given array
    public static void generatePowerSet(int[] arr) {
        int n = arr.length;

        // Total subsets = 2^n
        int totalSubsets = 1 << n; // left shift: 1 << n = 2^n

        // Loop through all possible subset representations (binary numbers)
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>(); // current subset

            // Check each bit position
            for (int j = 0; j < n; j++) {
                // If j-th bit of i is set, include arr[j] in subset
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            // Print current subset
            System.out.println(subset);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Normal case
        System.out.println("Test Case 1: [1, 2, 3]");
        int[] arr1 = {1, 2, 3};
        generatePowerSet(arr1);
        System.out.println();

        // Test Case 2: Single element
        System.out.println("Test Case 2: [5]");
        int[] arr2 = {5};
        generatePowerSet(arr2);
        System.out.println();

        // Test Case 3: Empty array
        System.out.println("Test Case 3: []");
        int[] arr3 = {};
        generatePowerSet(arr3);
        System.out.println();

        // Test Case 4: Array with negative numbers
        System.out.println("Test Case 4: [-1, 0, 2]");
        int[] arr4 = {-1, 0, 2};
        generatePowerSet(arr4);
        System.out.println();

        // Test Case 5: Array with larger numbers
        System.out.println("Test Case 5: [10, 20, 30, 40]");
        int[] arr5 = {10, 20, 30, 40};
        generatePowerSet(arr5);
    }
}
