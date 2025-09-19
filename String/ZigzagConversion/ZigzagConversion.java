public class ZigzagConversion {

    // Function to convert a string into zigzag pattern
    public static String convertZigZag(String s, int numRows) {
        // Edge case: empty string
        if (s.equals(""))
            return "";

        // Edge case: single row or numRows larger than string length
        if (numRows == 1 || numRows >= s.length())
            return s;

        // Create an array of StringBuilder, one for each row
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++)
            rows[i] = new StringBuilder();

        int currentRow = 0;        // Current row index
        boolean goingDown = false; // Direction flag: true = down, false = up

        // Traverse each character of the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c); // Append character to current row

            // Change direction if we reach the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1)
                goingDown = !goingDown;

            // Move to next row based on current direction
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    // Main method with test cases
    public static void main(String[] args) {
        String[] testStrings = {
                "PAYPALISHIRING",
                "PAYPALISHIRING",
                "A",
                "",
                "AB",
                "AB",
                "ABCDEFGHIJK",
                "ABCDEFGHIJK"
        };

        int[] numRowsArray = {3, 4, 1, 5, 1, 5, 2, 5};

        for (int i = 0; i < testStrings.length; i++) {
            String input = testStrings[i];
            int numRows = numRowsArray[i];
            String output = convertZigZag(input, numRows);

            System.out.println("Input String   : " + input);
            System.out.println("Number of Rows : " + numRows);
            System.out.println("ZigZag Output  : " + output);
            System.out.println("----------------------------------------");
        }
    }
}
