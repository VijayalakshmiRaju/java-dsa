# Leaders in Array

## Problem Statement
Given an integer array `arr[]`, print all the **leaders** in the array.  
An element is considered a **leader** if it is **strictly greater than all the elements to its right**.  
The rightmost element is always a leader since there are no elements to its right.

---

## Approach (Naive Method)
1. Traverse the array from left to right.  
2. For every element `arr[i]`, check all elements to its right (`arr[j]` for `j > i`).  
3. If no element to the right is greater than or equal to `arr[i]`, then `arr[i]` is a leader.  
4. Print all such elements.

---

## Time and Space Complexity

| Type | Complexity | Explanation |
|------|-------------|-------------|
| **Time Complexity** | O(n²) | For each element, we compare it with all elements to its right. |
| **Space Complexity** | O(1) | No extra space is used besides a few variables. |

---

## Test Cases

| Test Case | Input | Expected Output | Explanation |
|------------|--------|----------------|--------------|
| 1 | `[16, 17, 4, 3, 5, 2]` | `17 5 2` | 17 > all right, 5 > 2, 2 is last element |
| 2 | `[5, 5, 5, 5, 5]` | `5` | Only last 5 is leader since no element is greater |
| 3 | `[10, 9, 8, 7, 6]` | `10 9 8 7 6` | Decreasing array → every element is leader |
| 4 | `[1, 2, 3, 4, 5]` | `5` | Only last element is leader |
| 5 | `[42]` | `42` | Single element is always a leader |
| 6 | `[]` | *(no output)* | Empty array, nothing to print |
| 7 | `[-1, -2, -3, 0, -4]` | `0 -4` | 0 > -4, -4 is last element |
| 8 | `[100, 50, 60, 30, 20, 10]` | `100 60 30 20 10` | Each element greater than all to right |

---
