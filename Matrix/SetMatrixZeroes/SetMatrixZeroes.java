import java.util.Arrays;

public class SetMatrixZeroes {

    /**
     * Modifies the given matrix in-place:
     * If an element is 0, its entire row and column are set to 0.
     *
     * @param matrix the input 2D integer matrix
     */
    public static void setMatrixZero(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean setFirstRowZero = false;
        boolean setFirstColumnZero = false;

        // Step 1: Check if first row needs to be zeroed
        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) {
                setFirstRowZero = true;
                break;
            }
        }

        // Step 2: Check if first column needs to be zeroed
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                setFirstColumnZero = true;
                break;
            }
        }

        // Step 3: Mark rows and columns that need to be zeroed
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0; // mark row
                    matrix[0][col] = 0; // mark column
                }
            }
        }

        // Step 4: Use the marks to set elements to zero
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Step 5: Zero out the first column if needed
        if (setFirstColumnZero) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }

        // Step 6: Zero out the first row if needed
        if (setFirstRowZero) {
            for (int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }
    }

    /**
     * Utility method to print a matrix in readable format.
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        // Store all test cases in an array of 2D matrices
        int[][][] testCases = {
                { {1, 1, 1}, {1, 0, 1}, {1, 1, 1} },     // Basic example
                { {0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5} }, // Multiple zeros
                { {1, 2}, {3, 4} },                       // No zeros
                { {0, 0}, {0, 0} },                       // All zeros
                { {1, 0, 3} },                            // Single row
                { {1}, {0}, {3} },                        // Single column
                { {0} },                                  // 1x1 with zero
                { {5} }                                   // 1x1 without zero
        };

        String[] descriptions = {
                "Basic Example",
                "Multiple Zeros in Different Rows & Columns",
                "No Zeros",
                "All Zeros",
                "Single Row",
                "Single Column",
                "1x1 Matrix with Zero",
                "1x1 Matrix without Zero"
        };

        // Iterate over test cases with a loop
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": " + descriptions[i]);
            System.out.println("Original Matrix:");
            printMatrix(testCases[i]);
            setMatrixZero(testCases[i]);
            System.out.println("Modified Matrix:");
            printMatrix(testCases[i]);
            System.out.println();
        }
    }
}
