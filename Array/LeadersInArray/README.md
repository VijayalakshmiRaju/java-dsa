# Leaders in Array

## Problem Statement
Given an integer array `arr[]`, print all the **leaders** in the array.  
An element is considered a leader if it is **strictly greater than all the elements to its right**.  
The rightmost element is always a leader since there are no elements to its right.

---

## Approaches

### 1. Naive Approach (O(n²))
- Traverse the array from left to right.
- For each element `arr[i]`, check all elements to its right.
- If none are greater, `arr[i]` is a leader.

### 2. Optimized Approach (O(n))
- Traverse from right to left.
- Keep track of the **maximum element seen so far**.
- If the current element is greater than this maximum, mark it as a leader.
- The rightmost element is always a leader.
- Output is printed in reverse order since traversal is from right to left.

---

## Time and Space Complexity

| Approach | Time Complexity | Space Complexity | Description |
|-----------|-----------------|------------------|-------------|
| Naive | O(n²) | O(1) | Compares each element with all elements to its right |
| Optimized | O(n) | O(1) | Scans array once from right to left |

---

## Test Cases and Expected Output

| Test Case | Input Array | Expected Output (Naive) | Expected Output (Optimized - Reverse Order) |
|------------|--------------|--------------------------|---------------------------------------------|
| 1 | `[16, 17, 4, 3, 5, 2]` | Leaders: 17 5 2 | Leaders: 2 5 17 |
| 2 | `[5, 5, 5, 5, 5]` | Leaders: 5 | Leaders: 5 |
| 3 | `[10, 9, 8, 7, 6]` | Leaders: 10 9 8 7 6 | Leaders: 6 7 8 9 10 |
| 4 | `[1, 2, 3, 4, 5]` | Leaders: 5 | Leaders: 5 |
| 5 | `[42]` | Leaders: 42 | Leaders: 42 |
| 6 | `[]` | (No leaders - empty array) | (No leaders - empty array) |
| 7 | `[-1, -2, -3, 0, -4]` | Leaders: 0 -4 | Leaders: -4 0 |
| 8 | `[100, 50, 60, 30, 20, 10]` | Leaders: 100 60 30 20 10 | Leaders: 10 20 30 60 100 |

---
