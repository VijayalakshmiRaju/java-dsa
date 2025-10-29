# Wave Array

## Problem Statement

Given an array of integers, rearrange the elements into a **wave-like** array such that:
arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] ...

In this arrangement:
- Elements at even indices (`0, 2, 4, ...`) form **peaks**.
- Elements at odd indices (`1, 3, 5, ...`) form **valleys**.

### Example

**Input:**
[10, 90, 49, 2, 1, 5, 23]

**Output:**
[2, 1, 10, 5, 49, 23, 90]

(There can be multiple valid outputs as long as the wave condition holds.)

---

## Approach (Naive Method)

### Steps

1. **Sort the array** in ascending order.  
   After sorting, smaller elements appear before larger ones.
2. **Swap adjacent pairs** of elements:
   - Swap `arr[0]` with `arr[1]`
   - Swap `arr[2]` with `arr[3]`
   - Swap `arr[4]` with `arr[5]`, and so on.
3. This ensures the pattern `arr[0] >= arr[1] <= arr[2] >= arr[3]...`.

### Example Walkthrough

Input : [10, 90, 49, 2, 1, 5, 23]
Sorted : [1, 2, 5, 10, 23, 49, 90]
Swap : [2, 1, 10, 5, 49, 23, 90]
Output : [2, 1, 10, 5, 49, 23, 90]

---

## Algorithmic Steps

1. Sort the array in ascending order.  
2. For every even index `i` (starting from 0):
   - Swap elements at indices `i` and `i + 1`.
3. Stop when you reach the end of the array.

---

## Complexity Analysis

| Operation | Complexity |
|------------|-------------|
| Sorting | O(n log n) |
| Swapping Adjacent Elements | O(n) |
| **Total Time Complexity** | **O(n log n)** |
| **Auxiliary Space** | **O(1)** (in-place) |

---

## Edge Cases Considered

| Case | Example | Expected Behavior |
|------|----------|-------------------|
| Single element | `[42]` | No swap needed |
| Two elements | `[100, 20]` | Swapped if needed |
| All elements equal | `[4, 4, 4, 4]` | Remains same |
| Already sorted | `[1, 2, 3, 4, 5]` | Still becomes valid wave |
| Reverse sorted | `[10, 9, 8, 7]` | Sorted first, then wave |
| Negative numbers | `[-5, -10, 0, 5]` | Works correctly |
| Empty array | `[]` | No operation performed |

---

## Example Output
========== General Case ==========
Original Array: [10, 90, 49, 2, 1, 5, 23]
Wave Array : [2, 1, 10, 5, 49, 23, 90]

========== Includes Negative Numbers ==========
Original Array: [-5, -10, 0, 5, 10]
Wave Array : [-5, -10, 5, 0, 10]

========== Single Element ==========
Original Array: [42]
Wave Array : [42]
