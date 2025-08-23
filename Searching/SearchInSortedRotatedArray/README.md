# Search in a Sorted Rotated Array

This folder contains the implementation of **Search in a Sorted Rotated Array** in Java using:

- Modified Binary Search

This algorithm is used to efficiently find the position of a target element in a **sorted array that has been rotated** at an unknown pivot point.  

---

## Problem Statement

Given:
- A sorted array of distinct integers that is **rotated** at some pivot.  
- An integer `target` to be searched.  

Find:
- The **index of the target element** if it exists, otherwise return `-1`.


---

## Algorithm Logic

1. Use **modified binary search**:
   - Find the `mid` element.
   - If `arr[mid] == target` → return `mid`.
   - If the left half `arr[low..mid]` is sorted:
     - If `target` lies in this range → search left.
     - Else → search right.
   - Else (right half `arr[mid..high]` is sorted):
     - If `target` lies in this range → search right.
     - Else → search left.

2. Repeat until the element is found or the search space is empty.

---

## Time and Space Complexity

| Approach          | Time Complexity | Auxiliary Space | Notes                                    |
|-------------------|-----------------|-----------------|------------------------------------------|
| Modified Binary Search | O(log n)    | O(1)            | Efficient, no extra space required       |

---

## Files

- `SearchInRotatedSortedArray.java`: Contains the Java implementation with main method and test cases  
- `README.md`: This file - explanation, logic, and complexity  

---
