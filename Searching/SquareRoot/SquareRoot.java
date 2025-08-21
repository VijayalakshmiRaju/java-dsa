public class SquareRoot {

    // Naive Method: Linearly check squares until exceeding x
    public static int findSquareRootNaiveMethod(int x)
    {
        // Base cases: square root of 0 = 0, square root of 1 = 1
        if (x == 0 || x == 1)
            return x;

        int i = 1;
        // Keep increasing i until i*i exceeds x
        while( i * i <= x )
        {
            i++;
        }

        // The previous i was the integer square root
        return (i - 1);
    }

    // Optimized Method: Binary Search to find square root
    public static int findSquareRootNaiveBinarySearch(int x)
    {
        if (x == 0 || x == 1)  // base cases
            return x;
        
        long low = 1;
        long high = x / 2; // Optimization: sqrt(x) cannot be > x/2 for x > 1
        long result = -1; // stores floor of sqrt(x)

        while ( low <= high )
        {
            long mid = low + ( high - low ) / 2;

            if (mid * mid == x)
                return (int)mid; // perfect square
            else if (mid * mid > x) {
                high = mid - 1; // search in the left half
            } else {
                low = mid + 1;  // search in the right half
                result = mid;   // update result (floor value)
            }
        }

        return (int)result;
    }

    // Main method with sample test cases
    public static void main(String[] args) {
        int[] testCases = {0, 1, 4, 10, 15, 25, 50};

        System.out.println("Square Root Test Cases:");
        for (int x : testCases) {
            int naive = findSquareRootNaiveMethod(x);
            int binary = findSquareRootNaiveBinarySearch(x);

            System.out.println("x = " + x +
                    " | Naive Method = " + naive +
                    " | Binary Search Method = " + binary);
        }
    }
}
