# Index of Last Occurrence

This folder contains the implementation of finding the **last occurrence** of a target element in a **sorted array** using Java:

- Linear Search Method
- Binary Search Method (optimized for sorted arrays)

This project demonstrates both a straightforward approach and an efficient divide-and-conquer approach.

---

## Problem Statement

Given a **sorted array** of integers and a target integer `x`:

- Find the **index of the last occurrence** of `x` in the array.
- If `x` is not present, return `-1`.

---

## Algorithm Logic

### 1. Linear Search
- Traverse the array from start to end.
- Keep updating the result whenever the element is found.
- At the end, the stored index will be the **last occurrence**.

### 2. Binary Search (Efficient)
- Perform binary search on the sorted array.
- If the middle element matches `x`, store its index and continue searching on the **right side** (to find later occurrences).
- Continue until the search space is exhausted.
- The stored index will be the **last occurrence**.

---

## Complexities

| Approach        | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
| Linear Search   | O(n)            | O(1)             |
| Binary Search   | O(log n)        | O(1)             |

---
