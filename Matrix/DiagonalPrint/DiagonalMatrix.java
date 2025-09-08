import java.util.ArrayList;
import java.util.List;

public class DiagonalMatrix {

    public static void printDiagonals(int[][] matrix)
    {
        int n = matrix.length;       // number of rows
        int m = matrix[0].length;    // number of cols

        // Total diagonals = n + m - 1
        for (int k = n+m-2; k >= 0; k-- ) {
            int row, col;

            // Decide starting position of this diagonal
            if (k >= m) {
                // If diagonal index >= number of cols → start from last column, but drop down
                row = k - m + 1;   // shift downwards
                col = m - 1;       // always start from last column
            } else {
                // Otherwise → start from top row
                row = 0;           // top row
                col = k;           // move across columns
            }

            // collect diagonal values first
            List<Integer> diagonalOrder = new ArrayList<>();
            while (row < n && col >= 0) {
                diagonalOrder.add(matrix[row][col]);  // collect current element
                row++;  // move down
                col--;  // move left
            }

            // Print diagonal in reverse order → ensures bottom-to-top output
            for (int i = diagonalOrder.size() - 1; i >= 0; i-- ) {
                System.out.print(diagonalOrder.get(i) + " ");
            }
        }
    }

    // Utility function to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test case 1: 1x1 matrix (edge case)
        int[][] matrix1 = {{5}};
        System.out.println("Matrix 1 (1x1):");
        printMatrix(matrix1);
        System.out.print("Diagonals: ");
        printDiagonals(matrix1);
        System.out.println("\n----------------------");

        // Test case 2: 1x4 matrix (row only)
        int[][] matrix2 = {{1, 2, 3, 4}};
        System.out.println("Matrix 2 (1x4):");
        printMatrix(matrix2);
        System.out.print("Diagonals: ");
        printDiagonals(matrix2);
        System.out.println("\n----------------------");

        // Test case 3: 4x1 matrix (column only)
        int[][] matrix3 = {
                {1},
                {2},
                {3},
                {4}
        };
        System.out.println("Matrix 3 (4x1):");
        printMatrix(matrix3);
        System.out.print("Diagonals: ");
        printDiagonals(matrix3);
        System.out.println("\n----------------------");

        // Test case 4: 3x3 square matrix
        int[][] matrix4 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Matrix 4 (3x3):");
        printMatrix(matrix4);
        System.out.print("Diagonals: ");
        printDiagonals(matrix4);
        System.out.println("\n----------------------");

        // Test case 5: 4x3 rectangular matrix
        int[][] matrix5 = {
                {1,  2,  3},
                {4,  5,  6},
                {7,  8,  9},
                {10, 11, 12}
        };
        System.out.println("Matrix 5 (4x3):");
        printMatrix(matrix5);
        System.out.print("Diagonals: ");
        printDiagonals(matrix5);
        System.out.println("\n----------------------");
    }
}
