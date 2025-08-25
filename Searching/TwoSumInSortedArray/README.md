# Two Sum in a Sorted Array

Given a **sorted integer array** `arr[]` and a target value, this program determines whether there exist **two numbers** in the array whose sum equals the target.

---

# Problem Statement

Given:
- A sorted integer array `arr[]` of size `n`
- A target integer `target`

Find:
- Whether there exist two distinct numbers in `arr[]` such that their sum equals `target`.

---

## Algorithm Logic

We implement two approaches:

### **Approach 1: Naive (Brute Force)**
1. Iterate over all possible pairs `(i, j)` in the array.
2. Check if `arr[i] + arr[j] == target`.
3. If found, return `true`; otherwise, continue.
4. If no pair is found after all iterations, return `false`.

---

### **Approach 2: Two-Pointer (Optimized)**
1. Initialize two pointers:  
   - `i = 0` (start of array)  
   - `j = n-1` (end of array)
2. Calculate `sum = arr[i] + arr[j]`.
   - If `sum == target` → return `true`.
   - If `sum < target` → move `i++` (increase sum).
   - If `sum > target` → move `j--` (decrease sum).
3. Continue until `i < j`.
4. If no pair is found, return `false`.

---

## Time and Space Complexity

| Approach        | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
| Naive (Brute)   | O(n²)           | O(1)             |
| Two-Pointer     | O(n)            | O(1)             |

---

## Files

- `TwoSumInSortedArray.java`: Contains Java implementations using Naive and Two-Pointer approaches.
- `README.md`: This file - explanation, logic, and complexity.

---
