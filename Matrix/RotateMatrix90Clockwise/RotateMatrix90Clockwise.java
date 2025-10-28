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

        // Step 1: Move elements to their rotated positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Element at (i, j) moves to (j, n - i - 1)
                result[j][n - i - 1] = matrix[i][j];
            }
        }

        // Step 2: Copy rotated result back into the original matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, n);
        }
    }

    /**
     * Function to rotate a matrix 90 degrees clockwise using the in-place approach.
     *
     * Approach:
     * 1. Transpose the matrix — swap matrix[i][j] and matrix[j][i].
     * 2. Reverse each row to achieve 90° clockwise rotation.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) — in-place rotation.
     */
    public static void rotate90ClockwiseTranspose(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap rows and columns)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to get the final rotated matrix
        for (int i = 0; i < n; i++) {
            int begin = 0, end = n - 1;
            while (begin < end) {
                int temp = matrix[i][begin];
                matrix[i][begin] = matrix[i][end];
                matrix[i][end] = temp;
                begin++;
                end--;
            }
        }
    }

    /**
     * Utility function to print a matrix in a clean and formatted way.
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
     * Main method — tests both naive and transpose-based approaches
     * with multiple test cases and edge cases.
     */
    public static void main(String[] args) {

        // ------------------ TEST CASE 1 ------------------
        // Standard 3x3 matrix
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original 3x3 Matrix:");
        printMatrix(matrix1);
        rotate90ClockwiseNaive(matrix1);
        System.out.println("Rotated 3x3 Matrix (90° Clockwise - Naive):");
        printMatrix(matrix1);
        System.out.println("------------------------------------");

        // ------------------ TEST CASE 2 ------------------
        // 4x4 matrix (even-sized)
        int[][] matrix2 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };
        System.out.println("Original 4x4 Matrix:");
        printMatrix(matrix2);
        rotate90ClockwiseTranspose(matrix2);
        System.out.println("Rotated 4x4 Matrix (90° Clockwise - In-place):");
        printMatrix(matrix2);
        System.out.println("------------------------------------");

        // ------------------ TEST CASE 3 ------------------
        // 1x1 matrix (edge case — no visible change)
        int[][] matrix3 = {
                {5}
        };
        System.out.println("Original 1x1 Matrix:");
        printMatrix(matrix3);
        rotate90ClockwiseNaive(matrix3);
        System.out.println("Rotated 1x1 Matrix (90° Clockwise - Naive):");
        printMatrix(matrix3);
        System.out.println("------------------------------------");

        // ------------------ TEST CASE 4 ------------------
        // 2x2 matrix (small even matrix)
        int[][] matrix4 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Original 2x2 Matrix:");
        printMatrix(matrix4);
        rotate90ClockwiseTranspose(matrix4);
        System.out.println("Rotated 2x2 Matrix (90° Clockwise - In-place):");
        printMatrix(matrix4);
        System.out.println("------------------------------------");

        // ------------------ TEST CASE 5 ------------------
        // Matrix with negative numbers (validates logic consistency)
        int[][] matrix5 = {
                {-1, -2, -3},
                {-4, -5, -6},
                {-7, -8, -9}
        };
        System.out.println("Original 3x3 Matrix with Negative Numbers:");
        printMatrix(matrix5);
        rotate90ClockwiseNaive(matrix5);
        System.out.println("Rotated 3x3 Matrix (90° Clockwise - Naive):");
        printMatrix(matrix5);
        System.out.println("------------------------------------");

        // ------------------ TEST CASE 6 ------------------
        // Matrix with all zeros (uniform values)
        int[][] matrix6 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println("Original 3x3 Zero Matrix:");
        printMatrix(matrix6);
        rotate90ClockwiseTranspose(matrix6);
        System.out.println("Rotated 3x3 Zero Matrix (90° Clockwise - In-place):");
        printMatrix(matrix6);
        System.out.println("------------------------------------");

        // ------------------ TEST CASE 7 ------------------
        // Larger 5x5 matrix (to test scalability)
        int[][] matrix7 = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        System.out.println("Original 5x5 Matrix:");
        printMatrix(matrix7);
        rotate90ClockwiseTranspose(matrix7);
        System.out.println("Rotated 5x5 Matrix (90° Clockwise - In-place):");
        printMatrix(matrix7);
        System.out.println("------------------------------------");
    }
}
