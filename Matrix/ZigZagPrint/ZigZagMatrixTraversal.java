public class ZigZagMatrixTraversal {

    /**
     * Prints a given matrix in Zig-Zag (diagonal) order.
     * Zig-Zag means traversing diagonals alternatively:
     *   - Even diagonals → bottom to top
     *   - Odd diagonals → top to bottom
     */
    public static void printZigZag(int[][] matrix) {
        int n = matrix.length;       // Number of rows
        int m = matrix[0].length;    // Number of columns

        // There are (n + m - 1) diagonals in total
        for (int k = 0; k < n + m - 1; k++) {

            if (k % 2 == 0) {
                // EVEN diagonal → traverse UPWARD (bottom-left to top-right)
                int row = (k < n) ? k : n - 1;       // starting row
                int col = (k < n) ? 0 : k - (n - 1); // starting col

                while (row >= 0 && col < m) {
                    System.out.print(matrix[row][col] + " ");
                    row--;  // move up
                    col++;  // move right
                }

            } else {
                // ODD diagonal → traverse DOWNWARD (top-right to bottom-left)
                int row = (k < m) ? 0 : k - (m - 1); // starting row
                int col = (k < m) ? k : m - 1;       // starting col

                while (row < n && col >= 0) {
                    System.out.print(matrix[row][col] + " ");
                    row++;  // move down
                    col--;  // move left
                }
            }
        }
        System.out.println(); // new line after each test case
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1: 3x3 square matrix
        System.out.println("Test Case 1: 3x3 Matrix");
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printZigZag(matrix1);
        // Expected: 1 2 4 7 5 3 6 8 9

        // Test Case 2: 2x4 rectangular matrix (more columns)
        System.out.println("Test Case 2: 2x4 Matrix");
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        printZigZag(matrix2);
        // Expected: 1 2 5 6 3 4 7 8

        // Test Case 3: 4x2 rectangular matrix (more rows)
        System.out.println("Test Case 3: 4x2 Matrix");
        int[][] matrix3 = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        printZigZag(matrix3);
        // Expected: 1 2 3 5 4 6 7 8

        // Test Case 4: Single row matrix
        System.out.println("Test Case 4: 1x5 Matrix");
        int[][] matrix4 = {
                {1, 2, 3, 4, 5}
        };
        printZigZag(matrix4);
        // Expected: 1 2 3 4 5

        // Test Case 5: Single column matrix
        System.out.println("Test Case 5: 5x1 Matrix");
        int[][] matrix5 = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        printZigZag(matrix5);
        // Expected: 1 2 3 4 5

        // Test Case 6: 1x1 matrix (edge case - smallest input)
        System.out.println("Test Case 6: 1x1 Matrix");
        int[][] matrix6 = {
                {42}
        };
        printZigZag(matrix6);
        // Expected: 42
    }
}
