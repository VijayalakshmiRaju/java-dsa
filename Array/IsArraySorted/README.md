# IsArraySorted (Naive Approach)

## Problem Statement
Given an integer array, determine whether the array is sorted in non-decreasing order (each element is less than or equal to the next).  
If the array satisfies this property, return `true`; otherwise, return `false`.

---

## Approach (Naive Method)
The naive approach compares each element with every other element to its right.

### Steps:
1. For each element `arr[i]`, iterate through all elements `arr[j]` where `j > i`.
2. If any `arr[i] > arr[j]`, the array is not sorted.
3. If no such pair is found, the array is sorted.

This method guarantees correctness but is inefficient for large arrays.

---

## Time and Space Complexity

| Complexity Type | Description |
|------------------|-------------|
| Time Complexity | O(n²) – Due to nested loops comparing every pair of elements |
| Space Complexity | O(1) – Only constant extra space is used |

---

## Test Cases Covered

| Test Case | Description | Expected Output |
|------------|-------------|-----------------|
| `[]` | Empty array | Sorted |
| `[5]` | Single element | Sorted |
| `[1, 2, 3, 4, 5]` | Already sorted array | Sorted |
| `[5, 4, 3, 2, 1]` | Strictly decreasing order | Not Sorted |
| `[1, 1, 2, 2, 3]` | Non-decreasing with duplicates | Sorted |
| `[10, 10, 10]` | All elements same | Sorted |
| `[1, 2, 3, 5, 4]` | Unsorted at the end | Not Sorted |
| `[2, 3, 5, 7, 6, 9]` | Unsorted in the middle | Not Sorted |
| `[Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE]` | Large range sorted | Sorted |
| `[1, 2, Integer.MAX_VALUE, Integer.MIN_VALUE]` | Overflow edge case | Not Sorted |

---

## Sample Output

==== Checking if Arrays are Sorted (Naive Approach) ====

Test Case 1: [] → Sorted
Test Case 2: [5] → Sorted
Test Case 3: [1, 2, 3, 4, 5] → Sorted
Test Case 4: [5, 4, 3, 2, 1] → Not Sorted
Test Case 5: [1, 1, 2, 2, 3] → Sorted
Test Case 6: [10, 10, 10] → Sorted
Test Case 7: [1, 2, 3, 5, 4] → Not Sorted
Test Case 8: [2, 3, 5, 7, 6, 9] → Not Sorted
Test Case 9: [-2147483648, -1, 0, 1, 2147483647] → Sorted
Test Case 10: [1, 2, 2147483647, -2147483648] → Not Sorted

---
