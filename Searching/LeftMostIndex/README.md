# Leftmost Index in Sorted Array

This folder contains a Java implementation of **Leftmost Index Search** using **Modified Binary Search**.  
It finds the first (leftmost) occurrence of a given number `x` in a **sorted** array that may contain duplicate elements.

---

## Algorithm Logic

1. Initialize `low = 0`, `high = n - 1`, and `result = -1`.
2. Perform binary search:
   - If `arr[mid] == x`:
     - Store `mid` in `result`.
     - Move `high = mid - 1` to search further left.
   - If `arr[mid] < x`:
     - Move `low = mid + 1`.
   - If `arr[mid] > x`:
     - Move `high = mid - 1`.
3. Return `result` (or `-1` if not found).

---

## Time and Space Complexity

| Case        | Time Complexity | Auxiliary Space |
|-------------|-----------------|-----------------|
| Best Case   | O(log n)        | O(1)            |
| Average Case| O(log n)        | O(1)            |
| Worst Case  | O(log n)        | O(1)            |

> `n` is the number of elements in the array.

---

## Files

- `LeftmostIndexBinarySearch.java`: Java source file containing the modified binary search method.
- `README.md`: This file - explanation, logic, and complexity.

---
