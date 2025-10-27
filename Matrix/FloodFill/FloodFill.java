import java.util.Arrays;

public class FloodFill {

    /**
     * Function to perform flood fill (similar to MS Paint fill tool).
     *
     * @param screen   2D matrix representing the color screen
     * @param x        Row index of the pixel where the fill starts
     * @param y        Column index of the pixel where the fill starts
     * @param newColor The new color to fill
     */
    public static void floodFill(int[][] screen, int x, int y, int newColor) {
        int rows = screen.length;
        int cols = screen[0].length;

        int oldColor = screen[x][y];

        // If the old color and new color are the same, no change needed
        if (oldColor == newColor)
            return;

        // Call recursive helper function
        fill(screen, x, y, oldColor, newColor, rows, cols);
    }

    /**
     * Recursive helper method that fills adjacent pixels.
     *
     * @param screen   2D matrix of colors
     * @param x        current row index
     * @param y        current column index
     * @param oldColor color to be replaced
     * @param newColor new color
     * @param rows     total rows in screen
     * @param cols     total columns in screen
     */
    private static void fill(int[][] screen, int x, int y, int oldColor, int newColor, int rows, int cols) {
        // Base condition: return if (x,y) is outside screen bounds
        if (x < 0 || x >= rows || y < 0 || y >= cols)
            return;

        // If current pixel color is not same as oldColor, stop recursion
        if (screen[x][y] != oldColor)
            return;

        // Replace color
        screen[x][y] = newColor;

        // Recursively fill all 4-directionally connected pixels
        fill(screen, x + 1, y, oldColor, newColor, rows, cols); // down
        fill(screen, x - 1, y, oldColor, newColor, rows, cols); // up
        fill(screen, x, y + 1, oldColor, newColor, rows, cols); // right
        fill(screen, x, y - 1, oldColor, newColor, rows, cols); // left
    }

    /**
     * Utility function to print the screen matrix neatly.
     */
    private static void printScreen(int[][] screen) {
        for (int[] row : screen)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }

    /**
     * Main method with multiple test cases (including edge cases).
     */
    public static void main(String[] args) {
        // Test Case 1: Example from problem statement
        int[][] screen1 = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1}
        };

        System.out.println("Original Screen:");
        printScreen(screen1);

        int x = 4, y = 4, newColor = 3;
        floodFill(screen1, x, y, newColor);

        System.out.println("After Flood Fill at (" + x + "," + y + ") with color " + newColor + ":");
        printScreen(screen1);


        // Test Case 2: Fill in a single-color screen
        int[][] screen2 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        floodFill(screen2, 1, 1, 5);
        System.out.println("Test Case 2: Entire screen filled with 5");
        printScreen(screen2);


        // Test Case 3: Click on a region that is already of the target color
        int[][] screen3 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        floodFill(screen3, 0, 0, 2);
        System.out.println("Test Case 3: No change since new color = old color");
        printScreen(screen3);


        // Test Case 4: Non-contiguous color fill
        int[][] screen4 = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 0}
        };
        floodFill(screen4, 0, 0, 9);
        System.out.println("Test Case 4: Fill top-left connected 1's with 9");
        printScreen(screen4);
    }
}
