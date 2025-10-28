public class RotateMatrix90Clockwise {

    /**
     * Function to rotate a given N x N matrix 90 degrees clockwise.
     *
     * Naive Approach:
     * 1. Create a new result matrix of the same size.
     * 2. For each element matrix[i][j], place it in result[j][n - i - 1].
     *    - This effectively rotates the matrix by 90° clockwise.
     * 3. Copy the result matrix back to the original matrix.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2) — because we use an additional matrix.
     */
    public static void rotate90ClockwiseNaive(int[][] matrix) {
        int n = matrix.length;

        // Create a new matrix to store the rotated version
        int[][] result = new int[n][n];

        // Step 1: Rotate the matrix by placing elements in rotated positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Element at (i, j) goes to (j, n - i - 1)
                result[j][n - i - 1] = matrix[i][j];
            }
        }

        // Step 2: Copy the rotated elements back into the original matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, n);
        }
    }

    /**
     * Utility function to print a matrix in a formatted manner.
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /**
     * Main method to test rotate90ClockwiseNaive() with multiple test cases.
     */
    public static void main(String[] args) {
        // Test Case 1: 3x3 matrix (basic test)
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original 3x3 Matrix:");
        printMatrix(matrix1);
        rotate90ClockwiseNaive(matrix1);
        System.out.println("Rotated 3x3 Matrix (90° Clockwise):");
        printMatrix(matrix1);
        System.out.println("------------------------------------");

        // Test Case 2: 4x4 matrix (even-sized)
        int[][] matrix2 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };
        System.out.println("Original 4x4 Matrix:");
        printMatrix(matrix2);
        rotate90ClockwiseNaive(matrix2);
        System.out.println("Rotated 4x4 Matrix (90° Clockwise):");
        printMatrix(matrix2);
        System.out.println("------------------------------------");

        // Test Case 3: 1x1 matrix (edge case - rotation doesn’t change anything)
        int[][] matrix3 = {
                {5}
        };
        System.out.println("Original 1x1 Matrix:");
        printMatrix(matrix3);
        rotate90ClockwiseNaive(matrix3);
        System.out.println("Rotated 1x1 Matrix (90° Clockwise):");
        printMatrix(matrix3);
        System.out.println("------------------------------------");

        // Test Case 4: 2x2 matrix (small even matrix)
        int[][] matrix4 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Original 2x2 Matrix:");
        printMatrix(matrix4);
        rotate90ClockwiseNaive(matrix4);
        System.out.println("Rotated 2x2 Matrix (90° Clockwise):");
        printMatrix(matrix4);
        System.out.println("------------------------------------");

        // Test Case 5: Matrix with negative numbers (to verify logic consistency)
        int[][] matrix5 = {
                {-1, -2, -3},
                {-4, -5, -6},
                {-7, -8, -9}
        };
        System.out.println("Original 3x3 Matrix with Negative Numbers:");
        printMatrix(matrix5);
        rotate90ClockwiseNaive(matrix5);
        System.out.println("Rotated 3x3 Matrix (90° Clockwise):");
        printMatrix(matrix5);
        System.out.println("------------------------------------");
    }
}
