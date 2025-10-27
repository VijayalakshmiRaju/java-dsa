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
     * Utility function to print a 2D screen neatly.
     */
    private static void printScreen(int[][] screen) {
        for (int[] row : screen)
            System.out.println(Arrays.toString(row));
    }

    /**
     * Utility function to clone a 2D array (so original can be compared).
     */
    private static int[][] cloneScreen(int[][] screen) {
        int[][] copy = new int[screen.length][];
        for (int i = 0; i < screen.length; i++) {
            copy[i] = screen[i].clone();
        }
        return copy;
    }

    /**
     * Utility to print side-by-side comparison of original and modified screens.
     */
    private static void printComparison(int[][] original, int[][] modified) {
        System.out.println("Original Screen\t\t\t\tModified Screen");
        for (int i = 0; i < original.length; i++) {
            System.out.printf("%-30s", Arrays.toString(original[i]));
            System.out.println(Arrays.toString(modified[i]));
        }
        System.out.println();
    }

    /**
     * Main method with multiple test cases (including edge cases).
     */
    public static void main(String[] args) {
        // ---------- Test Case 1 ----------
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
        int[][] original1 = cloneScreen(screen1);
        int x = 4, y = 4, newColor = 3;
        floodFill(screen1, x, y, newColor);

        System.out.println("========== Test Case 1 ==========");
        System.out.println("Flood Fill at (" + x + ", " + y + ") with new color " + newColor + "\n");
        printComparison(original1, screen1);


        // ---------- Test Case 2 ----------
        int[][] screen2 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] original2 = cloneScreen(screen2);
        floodFill(screen2, 1, 1, 5);
        System.out.println("========== Test Case 2 ==========");
        System.out.println("Entire single-color screen filled with 5\n");
        printComparison(original2, screen2);


        // ---------- Test Case 3 ----------
        int[][] screen3 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        int[][] original3 = cloneScreen(screen3);
        floodFill(screen3, 0, 0, 2);
        System.out.println("========== Test Case 3 ==========");
        System.out.println("No change (oldColor == newColor)\n");
        printComparison(original3, screen3);


        // ---------- Test Case 4 ----------
        int[][] screen4 = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 0}
        };
        int[][] original4 = cloneScreen(screen4);
        floodFill(screen4, 0, 0, 9);
        System.out.println("========== Test Case 4 ==========");
        System.out.println("Fill top-left connected 1's with 9\n");
        printComparison(original4, screen4);
    }
}
