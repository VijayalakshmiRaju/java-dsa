public class SaddlePoint {
    public static int findSaddlePoint(int[][] matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] rowMinimum = new int[rows];
        for(int i = 0; i < rows; i++ ) {
            int ele = matrix[i][0];
            for ( int j = 1; j < columns; j++ ) {
                ele = Math.min(ele, matrix[i][j]);
            }

            rowMinimum[i] = ele;
        }

        for (int col = 0; col < columns; col++ ) {
            int ele = matrix[0][col];
            for ( int row = 1; row < rows; row++ ) {
                ele = Math.max(ele, matrix[row][col]);

                if (row == rows - 1 && rowMinimum[row] == ele) {
                    return rowMinimum[row];
                }
            }
        }

        return -1;
    }
}
