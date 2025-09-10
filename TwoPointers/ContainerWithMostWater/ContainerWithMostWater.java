public class ContainerWithMostWater {

    // Naive O(n^2) solution
    public static int findContainerWithMostWaterNaive ( int[] arr )
    {
        int maxWaterArea = 0;

        // Try all pairs
        for ( int i = 0; i < arr.length - 1; i++ ) {
            for ( int j = i+1; j < arr.length; j++ ) {
                int h = Math.min(arr[i], arr[j]);            // shorter line
                int width = j - i;                           // distance between lines
                int area = h * width;                        // area formed
                maxWaterArea = Math.max(maxWaterArea, area); // update max
            }
        }

        return maxWaterArea;
    }

    public static int findContainerWithMostWaterOptimized( int[] arr )
    {
        int left = 0;                   // Pointer at start
        int right = arr.length - 1;     // Pointer at end
        int maxWater = 0;               // Track max area found

        while ( left < right )
        {
            // Get the shorter height
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;

            int water = height * width; // Calculate current area
            maxWater = Math.max(water, maxWater); // Update max area

            // Move the pointer pointing to the shorter line
            if (arr[left] < arr[right])
                left++;                    // Try to find a taller line on left
            else
                right--;                   // Try to find a taller line on right
        }

        return maxWater;
    }

    // Main method with test cases
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 8, 6, 2, 5, 4, 8, 3, 7},   // Example from problem
                {1, 1},                        // Minimum size array
                {4, 4, 4, 4, 4},               // All equal heights
                {1, 2, 3, 4, 5},               // Strictly increasing
                {5, 4, 3, 2, 1},               // Strictly decreasing
                {0, 0, 0, 0, 0},               // All zeros
                {2, 0, 2},                     // Valley in middle
                {10000, 1, 10000},             // Tall bars at ends
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int naiveResult = findContainerWithMostWaterNaive(arr);
            int optimizedResult = findContainerWithMostWaterOptimized(arr);

            System.out.println("Test Case " + (i + 1) + ": ");
            System.out.print("  Input: [");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
                if (j < arr.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            System.out.println("  Naive Result     = " + naiveResult);
            System.out.println("  Optimized Result = " + optimizedResult);
            System.out.println("------------------------------------------------");
        }
    }
}
