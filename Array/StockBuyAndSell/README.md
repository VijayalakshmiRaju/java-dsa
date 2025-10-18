# Stock Buy and Sell (Naive Recursive Approach)

## Problem Statement
You are given an array `arr[]` where each element represents the price of a stock on a given day.  
You can perform **multiple buy and sell transactions**, but you **must sell the stock before you buy again**.

Your task is to calculate the **maximum possible profit** that can be earned.

---

## Approach — Naive Recursive Method

### Idea:
- Consider every possible pair of **buy (i)** and **sell (j)** days.  
- If `arr[j] > arr[i]`, then:
  - The profit for this transaction is `arr[j] - arr[i]`
  - Additionally, add profits from:
    - The subarray **before `i`** (i.e., `0` to `i-1`)
    - The subarray **after `j`** (i.e., `j+1` to `n-1`)
- Recursively compute and keep the **maximum** profit among all possible combinations.

---

## Example

**Input:**  
`arr = [1, 5, 3, 8, 12]`

**Explanation:**
- Buy at `1`, sell at `5` → profit = 4  
- Buy at `3`, sell at `12` → profit = 9  
**Total profit = 13**

**Output:**  
`13`

---

## Algorithm Steps

1. If the array has less than 2 elements, return `0`.
2. Iterate over all possible pairs `(i, j)` where `i < j`.
3. For every valid pair where `arr[j] > arr[i]`:
   - Compute `currentProfit = arr[j] - arr[i]`
   - Add `maxProfit(arr, start, i-1)` → profit from left subarray
   - Add `maxProfit(arr, j+1, end)` → profit from right subarray
4. Keep track of the **maximum profit** encountered.
5. Return the maximum profit value.

---

## Time and Space Complexities

| Complexity Type | Description |
|------------------|-------------|
| **Time Complexity** | O(n³) — Due to nested loops and recursive calls |
| **Space Complexity** | O(n) — Due to recursion stack |

---

## Test Cases

| Test Case | Input | Expected Output | Description |
|------------|--------|----------------|--------------|
| 1 | `[1, 5, 3, 8, 12]` | `13` | Multiple profitable transactions |
| 2 | `[30, 20, 10]` | `0` | Decreasing prices — no profit |
| 3 | `[10, 20, 30]` | `20` | Continuous increase — single transaction |
| 4 | `[2, 4, 1, 5]` | `6` | Multiple short-term gains |
| 5 | `[7, 1, 5, 3, 6, 4]` | `7` | Common mixed pattern |
| 6 | `[5, 5, 5, 5]` | `0` | No change in prices |
| 7 | `[]` | `0` | Empty array — no data |
| 8 | `[10]` | `0` | Single element — no transaction possible |

---
