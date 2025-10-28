public class RotateMatrix90Clockwise {
    public static void rotate90ClockwiseNaive(int[][] matrix)
    {
        int n = matrix.length;;

        int[][] result = new int[n][n];

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                result[j][n-i-1] = matrix[i][j];
            }
        }

        for ( int i = 0; i < n; i++ ) {
            System.arraycopy(result[i], 0, matrix[i], 0, n);
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate90ClockwiseNaive(mat);

        // Print the rotated matrix
        for (int[] row : mat) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
