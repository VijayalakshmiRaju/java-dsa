# Missing and Repeating Element (Sorting Approach)

This Java program finds the **missing** and **repeating** numbers in an array
containing integers from `1` to `N`, where exactly one number is missing
and one number appears twice.

---

## Problem Statement
Given an array `arr[]` of size `N` containing numbers from `1` to `N`:
- One number is missing.
- One number occurs twice.

Find:
1. The **missing number**.
2. The **repeating number**.

---

## Approach: Sorting
1. **Sort** the array.
2. **Scan once** to detect:
   - **Repeating number:** If `arr[i] == arr[i+1]`
   - **Missing number:** If `arr[i+1] - arr[i] > 1`, then missing = `arr[i] + 1`
3. **Edge cases:**
   - If the first number is not `1` → missing = `1`
   - If no gap is found → missing = `N`

---

## Complexity Analysis

| Operation        | Time Complexity | Space Complexity |
|------------------|-----------------|------------------|
| Sorting array    | O(N log N)      | O(1)             |
| Single scan      | O(N)            | O(1)             |
| **Overall**      | **O(N log N)**  | **O(1)**         |

---
