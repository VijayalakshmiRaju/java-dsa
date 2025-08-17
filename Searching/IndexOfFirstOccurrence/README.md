# Index of First Occurrence in a Sorted Array

Given a **sorted array `arr[]`** and an integer `x`, this program finds the **index (0-based) of the first occurrence of `x`** in the array.

If the element does not exist, it returns `-1`.

---

# Problem Statement

Given:
- A sorted array (non-decreasing order)
- An integer `x`

Find:
- The **index of the first occurrence** of `x` in the array.  
- If `x` is not present, return `-1`.

---

## Algorithm Logic

We provide **two approaches**:

### 1. Linear Search (Naive)
- Traverse the array from left to right.
- Return the first index where `arr[i] == x`.
- If no match is found, return `-1`.

### 2. Binary Search (Efficient)
Since the array is sorted, binary search can be used:
1. Initialize `low = 0`, `high = arr.length - 1`.
2. While `low <= high`:
   - Compute `mid = low + (high - low) / 2`.
   - If `arr[mid] > x`: search the left half.
   - If `arr[mid] < x`: search the right half.
   - If `arr[mid] == x`:
     - Check if it is the **first occurrence**:
       - If `mid == 0` OR `arr[mid-1] < x`, return `mid`.
       - Else, continue searching on the left (`high = mid - 1`).
3. Return `-1` if not found.

---

## Time and Space Complexity

| Approach         | Time Complexity | Space Complexity |
| ---------------- | --------------- | ---------------- |
| Linear Search    | O(n)            | O(1)             |
| Binary Search    | O(log n)        | O(1)             |

---

## Files

- `IndexOfFirstOccurrence.java`: Contains both **Linear Search** and **Binary Search** implementations.
- `README.md`: This file - explanation, logic, and complexity.

---
