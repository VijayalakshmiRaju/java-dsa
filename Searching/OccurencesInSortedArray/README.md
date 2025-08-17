# Occurrences in Sorted Array

This folder contains the implementation of finding the **number of occurrences** of a target element in a **sorted array** using Java:

- Linear Search Method
- Binary Search Method (optimized for sorted arrays)

This project demonstrates both a straightforward approach and an efficient divide-and-conquer approach for sorted arrays.

---

## Problem Statement

Given a **sorted array** of integers `arr[]` and a target element `x`, find the **number of times `x` occurs** in the array.

---

## Algorithm Logic

### Linear Search
1. Traverse the entire array.
2. Count every occurrence of the target element.
3. Return the total count.

### Binary Search
1. Use **divide-and-conquer** to find the first occurrence of the target.
2. Use the same method to find the last occurrence of the target.
3. Count = `lastIndex - firstIndex + 1`
4. If the target is not present, return 0.

#### Steps for Binary Search:
- **Find First Index**
  - Check middle element:
    - If it matches and either it is the first element or the previous element is smaller, return mid.
    - Else recurse in the left or right half depending on the comparison.
- **Find Last Index**
  - Check middle element:
    - If it matches and either it is the last element or the next element is larger, return mid.
    - Else recurse in the left or right half depending on the comparison.

---

## Time and Space Complexity

| Approach     | Time Complexity | Auxiliary Space | Notes                              |
|--------------|----------------|----------------|-----------------------------------|
| Linear       | O(n)           | O(1)           | Simple traversal                  |
| Binary       | O(log n)       | O(log n)       | Optimized for sorted arrays       |

---

## Files

- `OccurrencesInSortedArray.java`: Contains both Linear and Binary Search implementations along with a `main` method for testing.
- `README.md`: This file - explanation, logic, and complexity.
