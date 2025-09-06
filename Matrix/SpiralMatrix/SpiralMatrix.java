import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Returns the elements of a matrix in spiral order as a list.
     *
     * @param arr input 2D matrix
     * @return list of elements in spiral order
     */
    public static List<Integer> getSpiralOrder(int[][] arr) {
        int row = arr.length;          // number of rows
        int col = arr[0].length;       // number of columns
        int top = 0;                   // starting row index
        int bottom = row - 1;          // ending row index
        int left = 0;                  // starting column index
        int right = col - 1;           // ending column index

        List<Integer> result = new ArrayList<>();

        // Spiral traversal continues until all layers are covered
        while (top <= bottom && left <= right) {

            // Traverse the top row (left → right)
            for (int i = left; i <= right; i++) {
                result.add(arr[top][i]);
            }
            top++; // move boundary down

            // Traverse the right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                result.add(arr[i][right]);
            }
            right--; // move boundary left

            // Traverse the bottom row (right → left), only if rows remain
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(arr[bottom][i]);
                }
                bottom--;  // move boundary up
            }

            // Traverse the left column (bottom → top), only if columns remain
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(arr[i][left]);
                }
                left++; // move boundary right
            }
        }

        return result;
    }

    // ---------- MAIN METHOD FOR TESTING ----------
    public static void main(String[] args) {
        // Test 1: Square Matrix (4x4)
        int[][] squareMatrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Spiral of 4x4 matrix: " + getSpiralOrder(squareMatrix));
        // Expected: [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]

        // Test 2: Rectangular Matrix (3x4)
        int[][] rectMatrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("Spiral of 3x4 matrix: " + getSpiralOrder(rectMatrix1));
        // Expected: [1,2,3,4,8,12,11,10,9,5,6,7]

        // Test 3: Rectangular Matrix (4x3)
        int[][] rectMatrix2 = {
                {1,  2,  3},
                {4,  5,  6},
                {7,  8,  9},
                {10, 11, 12}
        };
        System.out.println("Spiral of 4x3 matrix: " + getSpiralOrder(rectMatrix2));
        // Expected: [1,2,3,6,9,12,11,10,7,4,5,8]

        // Test 4: Single Row (1x4)
        int[][] singleRow = {
                {1, 2, 3, 4}
        };
        System.out.println("Spiral of 1x4 matrix: " + getSpiralOrder(singleRow));
        // Expected: [1,2,3,4]

        // Test 5: Single Column (4x1)
        int[][] singleCol = {
                {1},
                {2},
                {3},
                {4}
        };
        System.out.println("Spiral of 4x1 matrix: " + getSpiralOrder(singleCol));
        // Expected: [1,2,3,4]

        // Test 6: Single Element (1x1)
        int[][] singleElement = {
                {42}
        };
        System.out.println("Spiral of 1x1 matrix: " + getSpiralOrder(singleElement));
        // Expected: [42]

        // Test 7: Rectangular Wide Matrix (2x5)
        int[][] wideMatrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        System.out.println("Spiral of 2x5 matrix: " + getSpiralOrder(wideMatrix));
        // Expected: [1,2,3,4,5,10,9,8,7,6]

        // Test 8: Rectangular Tall Matrix (5x2)
        int[][] tallMatrix = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
                {9, 10}
        };
        System.out.println("Spiral of 5x2 matrix: " + getSpiralOrder(tallMatrix));
        // Expected: [1,2,4,6,8,10,9,7,5,3]
    }
}
