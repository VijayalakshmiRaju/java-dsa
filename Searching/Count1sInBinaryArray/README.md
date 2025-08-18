# Count 1's in a Sorted Binary Array

Given a binary array `arr[]` sorted in **non-increasing order** (all `1`s before all `0`s), this program finds the **total number of 1's** present in the array.

If no `1` is present, it returns `0`.

---

# Problem Statement

Given:
- A binary array sorted in **non-increasing order** (1’s followed by 0’s)

Find:
- The total count of `1`s present in the array.

---

## Algorithm Logic

We use **binary search** for efficient counting in logarithmic time:

1. Initialize `low = 0`, `high = arr.length - 1`, and `lastOneIndex = -1`.
2. Use binary search to check:
   - If `arr[mid] == 1`: store `mid` as a potential answer and search **right** (to find last `1`).
   - If `arr[mid] == 0`: discard this and search **left**.
3. After the loop, the total count of `1`s is `(lastOneIndex + 1)`.
4. If no `1` is found, return `0`.

---

## Time and Space Complexity

| Metric           | Complexity |
| ---------------- | ---------- |
| Time Complexity  | O(log n)   |
| Space Complexity | O(1)       |

---

## Files

- `CountOnesInBinaryArray.java`: Contains Java implementation to count the number of 1’s in the array using binary search.  
- `README.md`: This file - explanation, logic, and complexity.

---
