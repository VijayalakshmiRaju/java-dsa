# IsArraySorted (Naive and Optimized Approaches)

## Problem Statement
Given an integer array, determine whether the array is sorted in non-decreasing order (each element is less than or equal to the next).  
If the array satisfies this property, return `true`; otherwise, return `false`.

---

## Approach 1: Naive Method
### Idea
- For every element, compare it with all elements to its right.
- If any element is greater than a later element, the array is not sorted.

### Steps
1. Use two nested loops to compare each pair `(arr[i], arr[j])` where `j > i`.
2. Return `false` if any `arr[i] > arr[j]`.
3. Return `true` if no such violation is found.

| Complexity | Description |
|-------------|-------------|
| **Time** | O(n²) – Each element compared with all elements to its right |
| **Space** | O(1) – Constant space |

---

## Approach 2: Optimized Method
### Idea
- A single pass is enough to check if every adjacent pair satisfies `arr[i] <= arr[i + 1]`.

### Steps
1. Traverse the array once.
2. If any `arr[i] > arr[i + 1]`, return `false`.
3. If the loop completes, return `true`.

| Complexity | Description |
|-------------|-------------|
| **Time** | O(n) – Single traversal |
| **Space** | O(1) – Constant space |

---

## Test Cases Covered

| Test Case | Description | Expected Output |
|------------|-------------|-----------------|
| `[]` | Empty array | Sorted |
| `[5]` | Single element | Sorted |
| `[1, 2, 3, 4, 5]` | Already sorted | Sorted |
| `[5, 4, 3, 2, 1]` | Strictly decreasing | Not Sorted |
| `[1, 1, 1, 1, 1]` | All elements same | Sorted |
| `[1, 2, 2, 3, 4]` | Non-decreasing | Sorted |
| `[1, 3, 2, 4, 5]` | Unsorted in between | Not Sorted |
| `[10, 20, 30, 25, 40, 50]` | One unsorted pair | Not Sorted |
| `[1, 2, 3, 4, 5, 6, 7, 8, 9]` | Large sorted array | Sorted |
| `[9, 8, 8, 8, 7, 6]` | Non-increasing array | Not Sorted |
| `[-10, -5, 0, 5, 10]` | Sorted with negatives | Sorted |
| `[-10, -20, -30]` | Decreasing with negatives | Not Sorted |
| `[Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE]` | Large range sorted | Sorted |
| `[1, 2, Integer.MAX_VALUE, Integer.MIN_VALUE]` | Overflow edge case | Not Sorted |

---

## Sample Output

Test Case 1: []
Naive Approach Result -> Sorted
Optimized Approach Result -> Sorted

Test Case 2: [5]
Naive Approach Result -> Sorted
Optimized Approach Result -> Sorted

---
