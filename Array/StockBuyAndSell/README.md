# Stock Buy and Sell — Naive Recursive and Optimized Approaches

## Problem Statement
You are given an array `arr[]` where each element represents the price of a stock on a given day.  
You can perform **multiple buy and sell transactions**, but you **must sell the stock before buying again**.  

Your task is to find the **maximum possible profit**.

---

## Approach 1 — Naive Recursive Method (Brute Force)
### Idea:
- Try **every possible pair** of buy (`i`) and sell (`j`) days.
- For every valid transaction (`arr[j] > arr[i]`):
  - Compute profit = `arr[j] - arr[i]`
  - Add profits from **left** (`start` to `i-1`) and **right** (`j+1` to `end`) subarrays recursively.
- Return the **maximum** profit among all possible combinations.

This ensures we explore **all valid buy-sell possibilities**, but at the cost of performance.

---

### Example

**Input:**  
`arr = [1, 5, 3, 8, 12]`

**Explanation:**

- Buy at 1, sell at 5 → profit = 4  
- Buy at 3, sell at 12 → profit = 9  
**Total = 13**

**Output:**  
`13`

---

## Algorithm Steps

1. If there are fewer than 2 elements → return 0.
2. For every pair `(i, j)` where `i < j`:
   - If `arr[j] > arr[i]`, compute:
     ```
     curProfit = arr[j] - arr[i]
               + maxProfitNaive(arr, start, i - 1)
               + maxProfitNaive(arr, j + 1, end)
     ```
3. Keep track of the **maximum** profit among all pairs.
4. Return the final maximum profit.

---

## Approach 2 — Optimized Linear Method
### Idea:
- Every **increasing sequence** contributes profit.
- Whenever `arr[i] > arr[i-1]`, add the difference to total profit.
- This works because small consecutive gains together represent all profitable transactions.

### Formula:
profit += arr[i] - arr[i - 1] (whenever arr[i] > arr[i - 1])

This linear approach eliminates recursion and nested loops.

---

## Time and Space Complexities

| Approach | Time Complexity | Space Complexity | Description |
|-----------|----------------|------------------|--------------|
| **Naive Recursive** | O(n³) | O(n) | Tries all possible buy/sell combinations recursively |
| **Optimized Linear** | O(n) | O(1) | Sums all consecutive increases efficiently |

---

## Test Cases

| # | Input | Expected Output | Description |
|---|--------|----------------|--------------|
| 1 | `[1, 5, 3, 8, 12]` | 13 | Multiple profitable transactions |
| 2 | `[30, 20, 10]` | 0 | Always decreasing — no profit |
| 3 | `[10, 20, 30]` | 20 | Single continuous rise |
| 4 | `[2, 4, 1, 5]` | 6 | Alternating up-down pattern |
| 5 | `[7, 1, 5, 3, 6, 4]` | 7 | Mixed pattern (LeetCode style) |
| 6 | `[5, 5, 5, 5]` | 0 | Constant prices |
| 7 | `[]` | 0 | Empty array edge case |
| 8 | `[10]` | 0 | Single element edge case |
| 9 | `[10, 9, 11, 1, 12]` | 13 | Profitable after initial drop |
| 10 | `[100, 180, 260, 310, 40, 535, 695]` | 865 | Large gains with mid-drop |

---
