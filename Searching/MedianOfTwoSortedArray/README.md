# Median of Two Sorted Arrays

This folder contains the implementation of finding the **Median of Two Sorted Arrays** in Java using:

- Naive Method (Merge-based)
- Optimized Method (Binary Search)

The median is the middle value in an ordered list. For two sorted arrays, the challenge is to find the combined median efficiently without fully merging them (especially in large arrays).

---

## Algorithm Logic

### Naive Method
1. Merge both sorted arrays into one sorted array.  
2. If the total length `n` is odd → return the middle element.  
3. If even → return the average of the two middle elements.  

---

### Optimized Method (Binary Search)
1. Perform binary search on the smaller array to partition both arrays into **left** and **right halves**.  
2. Ensure:
   - All elements in left half ≤ all elements in right half.  
   - Partition indexes satisfy total balance (`leftSize = (n1 + n2 + 1)/2`).  
3. Median is then:
   - If total length is odd → `max(left1, left2)`  
   - If even → `(max(left1, left2) + min(right1, right2)) / 2.0`  

---

## Time and Space Complexity

| Approach     | Time Complexity | Auxiliary Space | Notes                                               |
|--------------|------------------|------------------|---------------------------------------------------|
| Naive        | O(m + n)         | O(m + n)         | Requires merging both arrays                      |
| Optimized    | O(log(min(m, n)))| O(1)             | Efficient binary search on the smaller array only |

---

## Files

- `MedianOfTwoSortedArrays.java`: Contains both naive and optimized Java implementations with explanations in comments.  
- `README.md`: This file - explanation, logic, and complexity.  

---
