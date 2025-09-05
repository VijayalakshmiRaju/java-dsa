# Triplet Sum Problem

This folder contains the Java implementation of finding all **unique triplets** `(a, b, c)` in an array such that:

\[
a + b + c = \text{target}
\]

The solution includes two approaches:
- **Naive (Brute Force) method**
- **Optimized Two-Pointer method**

The algorithm ensures that **duplicate triplets are removed** from the result.

---

## Problem Statement

Given an integer array `S` of length `n`, return all the **unique triplets** `[a, b, c]` such that:

\[
a + b + c = \text{target}
\]

- Order of elements in a triplet does not matter.  
- The result must not contain duplicate triplets.  
- Array may contain positive, negative, and zero values.

---

## Algorithm

### 1. Naive Approach (Brute Force)
1. Iterate over all possible triplets using three nested loops.
2. For each triplet `(i, j, k)`, check if `arr[i] + arr[j] + arr[k] == target`.
3. Sort the triplet before adding it to a `Set` to avoid duplicates.
4. Convert the set back to a list.

**Time Complexity:** `O(n^3)`  
**Space Complexity:** `O(n)` (for storing results)

---

### 2. Optimized Approach (Sorting + Two Pointers)
1. Sort the array.
2. Fix one element `arr[i]` in each iteration.
3. Use two pointers (`left`, `right`) to find pairs such that:
    arr[i] + arr[left] + arr[right] == target
4. Skip duplicates for `i`, `left`, and `right` to ensure uniqueness.
5. Collect only valid unique triplets.

**Time Complexity:** `O(n^2)`  
**Space Complexity:** `O(1)` (ignoring result storage)

---

## Time and Auxiliary Space (extra space used)

| Approach        | Time Complexity | Auxiliary Space | Explanation |
|-----------------|-----------------|-----------------|-------------|
| Naive (Brute)   | O(n³)           | O(n)            | Generates all triplets and uses a set to filter duplicates |
| Two-Pointer     | O(n²)           | O(1)            | Sorting + two-pointer search with duplicate skipping |

---

## Files
- `TripletsSum.java` – Java file with both naive and optimized implementations.
