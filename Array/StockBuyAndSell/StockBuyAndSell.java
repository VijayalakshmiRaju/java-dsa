import java.util.Arrays;

public class StockBuyAndSell {

    /**
     * Function to calculate the maximum profit by making
     * as many buy-sell transactions as possible (Naive Recursive Approach).
     *
     * Constraint: You must sell before you buy again.
     *
     * Approach:
     * - Try every possible pair of buy (i) and sell (j).
     * - If arr[j] > arr[i], consider it a valid transaction.
     * - Add current profit + profit from subarrays before and after this transaction.
     * - Return the maximum among all possible combinations.
     *
     * Time Complexity: O(n² * recursive calls)
     * Space Complexity: O(n) due to recursion stack
     */
    public static int maxProfitNaive(int[] arr, int start, int end) {
        // Base case: if segment has less than 2 elements
        if (end <= start)
            return 0;

        int profit = 0;

        // Explore every possible pair (i, j)
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {

                // Transaction is valid only if selling price > buying price
                if (arr[j] > arr[i]) {

                    // Current profit = profit from this transaction
                    // + profit from left subarray (before buy)
                    // + profit from right subarray (after sell)
                    int curProfit = arr[j] - arr[i]
                            + maxProfitNaive(arr, start, i - 1)
                            + maxProfitNaive(arr, j + 1, end);

                    // Track maximum profit among all valid pairs
                    profit = Math.max(profit, curProfit);
                }
            }
        }

        return profit;
    }

    /**
     * Optimized approach (Linear Scan)
     * Idea:
     * - Every increasing sequence contributes profit.
     * - Whenever arr[i] > arr[i-1], add (arr[i] - arr[i-1]) to total.
     * - This works because we can sum all small gains between consecutive increases.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfitOptimized(int[] arr) {
        int n = arr.length;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            // If today's price is higher than yesterday's,
            // it means we can gain (arr[i] - arr[i-1])
            if (arr[i] > arr[i - 1])
                profit += arr[i] - arr[i - 1];
        }

        return profit;
    }

    public static void main(String[] args) {
        // Various test cases including edge cases
        int[][] testCases = {
                {1, 5, 3, 8, 12},    // Multiple profitable transactions
                {30, 20, 10},        // Always decreasing (no profit)
                {10, 20, 30},        // Strictly increasing
                {2, 4, 1, 5},        // Mixed fluctuations
                {7, 1, 5, 3, 6, 4},  // Common LeetCode pattern
                {5, 5, 5, 5},        // All same prices (no profit)
                {},                  // Empty array edge case
                {10},                // Single element edge case
                {10, 9, 11, 1, 12},  // Buy-sell separated by loss
                {100, 180, 260, 310, 40, 535, 695} // Large gains with drop in middle
        };

        System.out.println("============== STOCK BUY AND SELL ==============");
        System.out.println("Comparing Naive Recursive vs Optimized Approach");
        System.out.println("================================================\n");

        // Loop through all test cases
        for (int t = 0; t < testCases.length; t++) {
            int[] arr = testCases[t];
            System.out.println("Test Case " + (t + 1) + ": " + Arrays.toString(arr));

            // Handle empty or single-element cases
            if (arr.length <= 1) {
                System.out.println("➡ Max Profit (Naive): 0 (Not enough data)");
                System.out.println("➡ Max Profit (Optimized): 0 (Not enough data)\n");
                continue;
            }

            // Calculate profits using both methods
            int profitNaive = maxProfitNaive(arr, 0, arr.length - 1);
            int profitOptimized = maxProfitOptimized(arr);

            // Display results in formatted way
            System.out.println("➡ Max Profit (Naive Recursive):    " + profitNaive);
            System.out.println("➡ Max Profit (Optimized Linear):   " + profitOptimized);
            System.out.println("------------------------------------------------");
        }

        System.out.println("\n================== SUMMARY ==================");
        System.out.println("Naive Recursive - Tries all buy/sell combinations (O(n³))");
        System.out.println("Optimized Linear - Adds all consecutive profits (O(n))");
        System.out.println("===========================================================");
    }
}
