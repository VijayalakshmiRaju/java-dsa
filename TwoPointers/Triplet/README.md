# Triplet Sum Problem

This folder contains the implementation of finding a **Triplet** in Java whose sum equals a given target:
- Naive (Brute Force) method
- Optimized Two-Pointer method

The algorithm assumes the array can contain **positive, negative, or duplicate numbers**.

---

## Algorithm

### Naive Approach
1. Iterate through all possible triplets using three nested loops.
2. Check if any triplet sums up to the target.
3. If found → return true.

### Two-Pointer Approach
1. Sort the array.
2. Fix one element and use the **two-pointer method** to find if a pair exists with sum = `target - fixed`.
3. If found → return true.

---

## Time and Auxiliary Space (extra space used)

| Approach        | Time Complexity | Auxiliary Space | Explanation |
|-----------------|-----------------|-----------------|-------------|
| Naive (Brute)   | O(n³)           | O(1)            | Checks all possible triplets |
| Two-Pointer     | O(n²)           | O(1)            | Sorting + two-pointer search |

---

## Files
- `Triplet.java` – Java file with both naive and optimized implementations.

---
