public class SaddlePoint {
    public static int findSaddlePoint(int[][] matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i = 0; i < rows; i++ ) {
            int minValue = matrix[i][0];
            int colIndex = 0;

            for ( int j = 1; j < columns; j++ ) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isSaddle = true;
            for ( int k = 0; k < rows; k++ ) {
                if ( matrix[k][colIndex] > minValue ) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle)
                return minValue;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {4, 5, 6},
                {7, 8, 9},
                {1, 2, 3}
        };

        System.out.println(findSaddlePoint(matrix)); // Output: 7
    }
}
