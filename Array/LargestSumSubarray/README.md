# Largest Sum Subarray (Kadane’s Algorithm)

This project contains a **Java implementation** of Kadane’s Algorithm to find the **maximum subarray sum** in a given integer array.

---

## Problem Statement

Given an integer array `nums`, find the **contiguous subarray** (containing at least one number) which has the **largest sum** and return its sum.

### Example:
**Input:**  
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

**Output:**  
6

**Explanation:**  
The subarray `[4, -1, 2, 1]` has the largest sum `6`.

---

## Approach

We use **Kadane’s Algorithm**, which is a **Dynamic Programming** approach that runs in `O(n)` time.

1. Initialize two variables:
   - `curSum` → Current subarray sum
   - `maxSum` → Maximum sum found so far
2. Iterate through the array:
   - Either **start a new subarray** from the current element OR **extend the existing subarray** by adding the current element.
   - Update:  
     ```
     curSum = max(nums[i], curSum + nums[i])
     ```
   - Update maximum:  
     ```
     maxSum = max(maxSum, curSum)
     ```
3. Return `maxSum` as the result.

---

## Time & Space Complexity

| Complexity | Explanation |
|-----------|-------------|
| **Time Complexity** | `O(n)` → We traverse the array once. |
| **Auxiliary Space** | `O(1)` → Uses only a few extra variables. |

---

## Test Cases

Our implementation includes a `main` method that runs **multiple edge cases** using a loop:

| # | Test Case | Expected Output | Notes |
|---|-----------|----------------|------|
| 1 | `[-2, 1, -3, 4, -1, 2, 1, -5, 4]` | `6` | Mixed positive & negative values |
| 2 | `[1, 2, 3, 4, 5]` | `15` | All positive numbers |
| 3 | `[-8, -3, -6, -2, -5, -4]` | `-2` | All negative numbers → choose largest single element |
| 4 | `[10]` | `10` | Single positive element |
| 5 | `[-10]` | `-10` | Single negative element |
| 6 | `[-5, -4, -1, 2, 3, 4, 5]` | `14` | Subarray at the end |
| 7 | `[5, 4, -10, 1, 2, -1]` | `9` | Subarray at the start |
| 8 | `[0, -1, 2, 3, 0, -2, 4]` | `5` | Array containing zeros |

---

## Files in This Project
LargestSumSubarray.java # Contains Kadane’s algorithm and test cases

---

## How to Run

1. Compile the file:
```bash
javac LargestSumSubarray.java
```
2. Run the program:
```bash
java LargestSumSubarray
```
