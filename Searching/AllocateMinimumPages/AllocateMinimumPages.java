public class AllocateMinimumPages {

    // Recursive function to find the minimum number of pages that can be allocated
    public static int minPages(int[] arr, int n, int noOfStudents) {
        // Base case: if there is only one student,
        // he/she must take all remaining books
        if (noOfStudents == 1) {
            return sum(arr, 0, n - 1);
        }

        // Base case: if there is only one book,
        // it must be allocated to the student
        if (n == 1) {
            return arr[0];
        }

        int result = Integer.MAX_VALUE;

        // Try every possible partition of books:
        // i divides the array into two parts:
        // - First part: allocated among (noOfStudents - 1) students
        // - Second part: allocated to the last student
        for (int i = 1; i < n; i++) {
            // max() ensures we balance between previous students and last student
            int current = Math.max(
                    minPages(arr, i, noOfStudents - 1), // left partition
                    sum(arr, i, n - 1)                 // right partition
            );

            // Minimize the result over all possible partitions
            result = Math.min(result, current);
        }

        return result;
    }

    // Utility function to calculate sum of pages from start to end index
    public static int sum(int[] arr, int start, int end) {
        int s = 0;
        for (int i = start; i <= end; i++) {
            s += arr[i];
        }
        return s;
    }

    // Main method with looped test cases
    public static void main(String[] args) {
        // Define test cases: {bookArray, noOfStudents, expectedResult}
        Object[][] testCases = {
                {new int[]{12, 34, 67, 90}, 2, 113},   // Example case
                {new int[]{10, 20, 30, 40}, 1, 100},   // Single student takes all
                {new int[]{5, 10, 15, 20}, 4, 20},     // Students = Books
                {new int[]{12, 15}, 3, 15},            // More students than books
                {new int[]{10, 10, 10, 10}, 2, 20},    // Equal page books
                {new int[]{42}, 1, 42}                 // Single book
        };

        // Run all test cases
        for (int i = 0; i < testCases.length; i++) {
            int[] books = (int[]) testCases[i][0];
            int students = (int) testCases[i][1];
            int expected = (int) testCases[i][2];

            int result = minPages(books, books.length, students);

            System.out.println("Test " + (i + 1) +
                    " → Expected: " + expected +
                    ", Got: " + result +
                    (result == expected ? " PASS" : " FAIL"));
        }
    }
}
