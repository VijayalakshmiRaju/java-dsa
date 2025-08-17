# Peak Element in Unsorted Array

This folder contains the implementation of finding a **peak element** in an **unsorted array** using Java:

- Linear Search Method
- Iterative Binary Search Method (optimized for unsorted arrays)

This project demonstrates both a straightforward approach and an efficient divide-and-conquer approach for finding a peak element.

---

## Problem Statement

Given an **array of integers** `arr[]`, find a **peak element**, i.e., an element that is **not smaller than its neighbors**.  
- For corner elements, consider only one neighbor.  
- The array may contain multiple peaks; returning **any one peak** is sufficient.

---

## Algorithm Logic

### Linear Search
1. If array has only one element, return it as the peak.  
2. Check first and last elements separately; if any is greater than or equal to its neighbor, return it.  
3. Iterate through the middle elements:
   - If `arr[i] >= arr[i-1]` and `arr[i] >= arr[i+1]`, return `arr[i]`.

### Iterative Binary Search
1. Initialize `low = 0` and `high = arr.length - 1`.  
2. While `low <= high`:
   - Compute `mid = low + (high - low)/2`.  
   - If `arr[mid]` is greater than or equal to its neighbors, return `arr[mid]`.  
   - If left neighbor is greater, move search left (`high = mid - 1`).  
   - Else, move search right (`low = mid + 1`).  

---

## Sample Test Cases

| Test Case | Array                  | Output                   |
|-----------|-----------------------|--------------------------|
| 1         | [1, 3, 20, 4, 1, 0]   | Peak element is 20       |
| 2         | [10, 20, 15, 2, 23, 90, 67] | Peak element is 20 or 90 |
| 3         | [5]                    | Peak element is 5        |
| 4         | [1, 2, 3, 4, 5]        | Peak element is 5        |
| 5         | [5, 4, 3, 2, 1]        | Peak element is 5        |

---

## Time and Space Complexity

| Approach            | Time Complexity | Auxiliary Space | Notes                                      |
|--------------------|----------------|----------------|-------------------------------------------|
| Linear Search       | O(n)           | O(1)           | Simple check for all elements             |
| Iterative Binary Search | O(log n)   | O(1)           | Efficient for large arrays; no recursion |

---

## Files

- `PeakElementInUnsortedArray.java`: Contains Linear Search and Iterative Binary Search implementations along with a `main` method demonstrating sample test cases.
- `README.md`: This file – explanation, logic, complexity, and test cases.

---
