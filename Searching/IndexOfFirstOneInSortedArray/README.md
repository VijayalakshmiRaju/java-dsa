# Index of First One in Sorted Binary Array

This folder contains the implementation of finding the **first index of 1** in a **sorted binary array** using Java:

- Binary Search Method (optimized for sorted arrays)

This project demonstrates an efficient divide-and-conquer approach for sorted binary arrays.

---

## Problem Statement

Given a **sorted binary array** of integers `arr[]` (containing only 0s and 1s), find the **first index where `1` occurs** in the array.  
Return `-1` if the array does not contain any `1`.

---

## Algorithm Logic

### Binary Search
1. Initialize `low = 0` and `high = arr.length - 1`.
2. While `low <= high`:
   - Find `mid = low + (high - low)/2`.
   - If `arr[mid] == 1` and either `mid == 0` or `arr[mid-1] == 0`, return `mid` (first occurrence).
   - If `arr[mid] == 1` but not first, search the left half (`high = mid - 1`).
   - If `arr[mid] == 0`, search the right half (`low = mid + 1`).
3. If `1` is not found, return `-1`.

---

## Sample Test Cases

| Test Case | Array                  | Output                           |
|-----------|-----------------------|----------------------------------|
| 1         | [0, 0, 0, 1, 1, 1]    | First occurrence of 1 is at index 3 |
| 2         | [0, 0, 0, 0]          | No 1 found in the array          |
| 3         | [1, 1, 1, 1]          | First occurrence of 1 is at index 0 |
| 4         | [0, 1]                | First occurrence of 1 is at index 1 |
| 5         | [1]                   | First occurrence of 1 is at index 0 |
| 6         | [0]                   | No 1 found in the array          |

---

## Time and Space Complexity

| Approach       | Time Complexity | Auxiliary Space | Notes                        |
|----------------|----------------|----------------|-------------------------------|
| Binary Search  | O(log n)       | O(1)           | Optimized for sorted arrays  |

---

## Files

- `IndexOfFirstOneInSortedArray.java`: Contains Binary Search implementation along with a `main` method demonstrating sample test cases.
- `README.md`: This file – explanation, logic, complexity, and test cases.
