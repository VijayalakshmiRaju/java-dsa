import java.util.Arrays;

public class StockBuyAndSell {

    /**
     * Function to calculate the maximum profit by making
     * as many buy-sell transactions as possible.
     *
     * Constraint: You must sell before you buy again.
     *
     * Approach (Naive Recursive):
     * - Try every possible pair of buy (i) and sell (j).
     * - If arr[j] > arr[i], then consider this as one transaction.
     * - Add profit from the left subarray (before i) and
     *   right subarray (after j).
     * - Return the maximum profit found among all possibilities.
     *
     * Time Complexity: O(n² * recursive calls)
     * Space Complexity: O(n) (recursion stack)
     */
    public static int maxProfit(int[] arr, int start, int end) {
        // Base case: if array segment is invalid or has one element
        if (end <= start)
            return 0;

        int profit = 0;

        // Try every pair (i, j) where i < j
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {

                // Valid transaction only if selling price > buying price
                if (arr[j] > arr[i]) {

                    // Current profit includes:
                    // profit from current transaction + profits from remaining subarrays
                    int curProfit = arr[j] - arr[i]
                            + maxProfit(arr, start, i - 1)   // profit from left segment
                            + maxProfit(arr, j + 1, end);   // profit from right segment

                    // Keep the maximum profit
                    profit = Math.max(profit, curProfit);
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        // Define test cases
        int[][] testCases = {
                {1, 5, 3, 8, 12},    // Normal case with multiple transactions
                {30, 20, 10},        // Decreasing prices (no profit)
                {10, 20, 30},        // Increasing prices (single long transaction)
                {2, 4, 1, 5},        // Mixed ups and downs
                {7, 1, 5, 3, 6, 4},  // Common LeetCode test case
                {},                  // Empty array edge case
                {10},                // Single element edge case
        };

        System.out.println("====== Stock Buy and Sell (Naive Recursive Approach) ======");
        for (int t = 0; t < testCases.length; t++) {
            int[] arr = testCases[t];
            System.out.println("\nTest Case " + (t + 1) + ": " + Arrays.toString(arr));

            // Edge case: if array is empty or has one element
            if (arr.length <= 1) {
                System.out.println("Max Profit: 0 (Not enough data to buy and sell)");
                continue;
            }

            int profit = maxProfit(arr, 0, arr.length - 1);
            System.out.println("Max Profit: " + profit);
        }
        System.out.println("===========================================================");
    }
}
