# Remove Duplicates from Sorted Array

## Problem Statement

Given a sorted integer array, remove all duplicate elements in-place (without using extra space for another array) such that each unique element appears only once.  
Return the count of unique elements in the array.  

After the operation, the first part of the array should contain all unique elements in their original order.

---

## Example

**Input:**
arr = [1, 1, 2, 2, 3, 4, 4]

**Process:**
- Start comparing each element with the last unique one.
- Whenever a new number is found, move it to the next position for unique elements.

**Output:**
Unique elements: [1, 2, 3, 4]
New length: 4

---

## Approach

| Step | Description |
|------|--------------|
| 1 | Initialize `idx = 1` (the next unique position). |
| 2 | Traverse the array from the 2nd element (`i = 1`). |
| 3 | Compare the current element `arr[i]` with `arr[idx - 1]`. |
| 4 | If they are different, assign `arr[idx] = arr[i]` and increment `idx`. |
| 5 | After traversal, the first `idx` elements of `arr` are unique. |
| 6 | Return `idx` as the count of unique elements. |

---

## Dry Run Example

**Input:**
arr = [1, 1, 2, 2, 3, 4, 4]


| Step | i | arr[i] | arr[idx-1] | Action | Array State | idx |
|------|---|---------|-------------|---------|--------------|------|
| 0 | — | — | — | Start | [1,1,2,2,3,4,4] | 1 |
| 1 | 1 | 1 | 1 | Duplicate → skip | [1,1,2,2,3,4,4] | 1 |
| 2 | 2 | 2 | 1 | New → move to idx=1 | [1,2,2,2,3,4,4] | 2 |
| 3 | 3 | 2 | 2 | Duplicate → skip | [1,2,2,2,3,4,4] | 2 |
| 4 | 4 | 3 | 2 | New → move to idx=2 | [1,2,3,2,3,4,4] | 3 |
| 5 | 5 | 4 | 3 | New → move to idx=3 | [1,2,3,4,3,4,4] | 4 |
| 6 | 6 | 4 | 4 | Duplicate → skip | [1,2,3,4,3,4,4] | 4 |

**Final Output:**  
Unique elements: `[1, 2, 3, 4]`  
New length: `4`

---

## Complexity Analysis

| Operation | Time Complexity | Space Complexity | Explanation |
|------------|-----------------|------------------|--------------|
| Traversal | O(n) | O(1) | One full pass through the array using constant space |

---

## Test Cases

| Test Case | Initial Array | Output Array | New Length | Explanation |
|------------|----------------|----------------|-------------|--------------|
| 1 | `[1, 1, 2, 2, 3, 4, 4]` | `[1, 2, 3, 4]` | 4 | Normal case with duplicates |
| 2 | `[5, 5, 5, 5, 5]` | `[5]` | 1 | All elements same |
| 3 | `[1, 2, 3, 4, 5]` | `[1, 2, 3, 4, 5]` | 5 | All elements unique |
| 4 | `[]` | `[]` | 0 | Empty array |
| 5 | `[7]` | `[7]` | 1 | Single element array |

---

## Notes

- The algorithm works only for sorted arrays.  
  For unsorted arrays, sort them first.
- The function modifies the array in-place, meaning it doesn’t allocate extra arrays.
- The return value represents the number of unique elements; only the first `n` elements in the array are valid.

---
