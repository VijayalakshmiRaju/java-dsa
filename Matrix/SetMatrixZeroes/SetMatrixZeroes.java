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
        // Test Case 1: Basic Example
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println("Test Case 1: Basic Example");
        System.out.println("Original Matrix:");
        printMatrix(matrix1);
        setMatrixZero(matrix1);
        System.out.println("Modified Matrix:");
        printMatrix(matrix1);
        System.out.println();

        // Test Case 2: Multiple Zeros in Different Rows & Columns
        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        System.out.println("Test Case 2: Multiple Zeros in Different Rows & Columns");
        System.out.println("Original Matrix:");
        printMatrix(matrix2);
        setMatrixZero(matrix2);
        System.out.println("Modified Matrix:");
        printMatrix(matrix2);
        System.out.println();

        // Test Case 3: No Zeros
        int[][] matrix3 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Test Case 3: No Zeros");
        System.out.println("Original Matrix:");
        printMatrix(matrix3);
        setMatrixZero(matrix3);
        System.out.println("Modified Matrix:");
        printMatrix(matrix3);
        System.out.println();

        // Test Case 4: All Zeros
        int[][] matrix4 = {
                {0, 0},
                {0, 0}
        };
        System.out.println("Test Case 4: All Zeros");
        System.out.println("Original Matrix:");
        printMatrix(matrix4);
        setMatrixZero(matrix4);
        System.out.println("Modified Matrix:");
        printMatrix(matrix4);
        System.out.println();

        // Test Case 5: Single Row
        int[][] matrix5 = {
                {1, 0, 3}
        };
        System.out.println("Test Case 5: Single Row");
        System.out.println("Original Matrix:");
        printMatrix(matrix5);
        setMatrixZero(matrix5);
        System.out.println("Modified Matrix:");
        printMatrix(matrix5);
        System.out.println();

        // Test Case 6: Single Column
        int[][] matrix6 = {
                {1},
                {0},
                {3}
        };
        System.out.println("Test Case 6: Single Column");
        System.out.println("Original Matrix:");
        printMatrix(matrix6);
        setMatrixZero(matrix6);
        System.out.println("Modified Matrix:");
        printMatrix(matrix6);
        System.out.println();

        // Test Case 7: 1x1 Matrix with Zero
        int[][] matrix7 = {
                {0}
        };
        System.out.println("Test Case 7: 1x1 Matrix with Zero");
        System.out.println("Original Matrix:");
        printMatrix(matrix7);
        setMatrixZero(matrix7);
        System.out.println("Modified Matrix:");
        printMatrix(matrix7);
        System.out.println();

        // Test Case 8: 1x1 Matrix without Zero
        int[][] matrix8 = {
                {5}
        };
        System.out.println("Test Case 8: 1x1 Matrix without Zero");
        System.out.println("Original Matrix:");
        printMatrix(matrix8);
        setMatrixZero(matrix8);
        System.out.println("Modified Matrix:");
        printMatrix(matrix8);
    }
}
