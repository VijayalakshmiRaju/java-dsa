public class SaddlePoint {

    /**
     * Function to find the Saddle Point in a given matrix.
     * Definition:
     * A saddle point is an element which is:
     *  - the minimum in its row
     *  - and the maximum in its column.
     * If no such element exists, the function returns -1.
     */
    public static int findSaddlePoint(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Iterate through each row
        for (int i = 0; i < rows; i++) {

            // Step 1: Find the minimum element in the current row and its column index
            int minValue = matrix[i][0];
            int colIndex = 0;
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                    colIndex = j;
                }
            }

            // Step 2: Check if this minValue is also the maximum in its column
            boolean isSaddle = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][colIndex] > minValue) {
                    // Found a larger element in the same column → not a saddle point
                    isSaddle = false;
                    break;
                }
            }

            // Step 3: If it satisfies both conditions → return as saddle point
            if (isSaddle)
                return minValue;
        }

        // Step 4: No saddle point found
        return -1;
    }

    public static void main(String[] args) {
        // Test Case 1: Matrix with a saddle point (7)
        int[][] matrix1 = {
                {4, 5, 6},
                {7, 8, 9},
                {1, 2, 3}
        };

        // Test Case 2: Matrix with no saddle point
        int[][] matrix2 = {
                {3, 8, 4},
                {9, 6, 7},
                {5, 2, 1}
        };

        // Test Case 3: Matrix with multiple same values (only one valid saddle point)
        int[][] matrix3 = {
                {10, 10, 10},
                {5,  5,  5},
                {1,  2,  3}
        };

        // Test Case 4: Single element matrix (trivial saddle point)
        int[][] matrix4 = {
                {42}
        };

        // Test Case 5: Matrix with all elements equal (every element is a saddle point)
        int[][] matrix5 = {
                {7, 7},
                {7, 7}
        };

        // Test Case 6: Rectangular matrix (more columns)
        int[][] matrix6 = {
                {3, 1, 4, 2},
                {6, 5, 9, 7}
        };

        // Test Case 7: Rectangular matrix (more rows)
        int[][] matrix7 = {
                {8, 7},
                {6, 5},
                {4, 3},
                {2, 1}
        };

        // Display results
        System.out.println("===== Saddle Point Test Results =====");
        printResult(matrix1, findSaddlePoint(matrix1));
        printResult(matrix2, findSaddlePoint(matrix2));
        printResult(matrix3, findSaddlePoint(matrix3));
        printResult(matrix4, findSaddlePoint(matrix4));
        printResult(matrix5, findSaddlePoint(matrix5));
        printResult(matrix6, findSaddlePoint(matrix6));
        printResult(matrix7, findSaddlePoint(matrix7));
    }

    /**
     * Utility method to display matrix and saddle point result.
     */
    private static void printResult(int[][] matrix, int saddlePoint) {
        System.out.println("\nMatrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }

        if (saddlePoint != -1)
            System.out.println("Saddle Point Found: " + saddlePoint);
        else
            System.out.println("No Saddle Point Found");
    }
}
