# Floor in a Sorted Array

Given a sorted array `arr[]` and an integer `x`, this program finds the **index (0-based) of the largest element ≤ x**, also known as the **floor** of `x`.

If no such element exists, it returns `-1`.

---

# Problem Statement

Given:
- A sorted array (non-decreasing order)
- An integer `x`

Find:
- Index of the largest element in the array that is less than or equal to `x`.

In case of multiple occurrences of the same floor value, return the **last occurrence**.

---

## Algorithm Logic

We use **binary search** for efficient search in logarithmic time:

1. Initialize `low = 0`, `high = arr.length - 1`, and `result = -1`.
2. Use binary search to check:
   - If `arr[mid] == x`: store `mid` as a potential answer and continue searching right for last occurrence.
   - If `arr[mid] < x`: store `mid` as a potential answer and search right for a larger valid floor.
   - If `arr[mid] > x`: discard this and search left.
3. Return the value stored in `result` at the end of the loop.

---

## Time and Space Complexity

| Metric           | Complexity |
| ---------------- | ---------- |
| Time Complexity  | O(log n)   |
| Space Complexity | O(1)       |

---

## Files

- `FloorInSortedArray.java`: Contains Java implementation - efficient method to find a floor of a given element. 
- `README.md`: This file - explanation, logic, and complexity

---