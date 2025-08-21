# Search in an Infinite Sorted Array

This program demonstrates how to search for an element in an **infinite sorted array** using two approaches:

1. **Naive Approach** – Linearly traverse elements until the target is found or surpassed.  
2. **Optimized Approach** – Use an **exponential search** strategy to find a suitable search window, then apply **binary search** within that range.

The task is to find the **index of a target element** in a sorted array of unknown (or infinite) length.

---

## Problem Statement

Given a sorted array of unknown (or infinite) size and a target element:  

- If the target exists in the array, return its **index**.  
- Otherwise, return `-1`.  

---

## Algorithm Logic

### 1. Naive Approach
1. Start from index `0`.  
2. Traverse the array one element at a time.  
3. If `arr[i] == target`, return `i`.  
4. If `arr[i] > target`, stop the search and return `-1` (since array is sorted).  
5. Continue until the target is found or surpassed.  

---

### 2. Exponential Window Expansion
1. Start with a small range:  
   - `start = 0`  
   - `end = 1`  
2. Expand the window exponentially until `arr[end] ≥ target`.  
   - Formula: `end = end + (end - start + 1) * 2`  
3. Update `start` to the previous `end + 1`.  
4. Stop once the target is guaranteed to lie between `[start, end]`.  

**Binary Search**
1. Perform binary search within the range `[start, end]`.  
2. If `arr[mid] == target`, return `mid`.  
3. If `arr[mid] > target`, search the left half.  
4. Otherwise, search the right half.  
5. If not found, return `-1`.  

---


## Time and Space Complexity

| Approach                      | Time Complexity | Auxiliary Space | Notes                                                   |
|-------------------------------|-----------------|-----------------|---------------------------------------------------------|
| Naive Linear Search           | O(n)            | O(1)            | Traverses sequentially until target or larger element   |
| Exponential Window Expansion  | O(log n)        | O(1)            | Expands window size exponentially until target is within |
| Binary Search in Range        | O(log n)        | O(1)            | Standard binary search inside the identified range       |
| **Overall (Optimized)**       | O(log n)        | O(1)            | Efficient for very large or unknown-sized arrays         |

---

## Files

- `SearchInAnInfiniteArray.java`: Contains **Naive** and **Optimized** (Exponential + Binary Search) implementations with test cases  
- `README.md`: This file – explanation, logic, and complexity
