# Index of Subarray with Given Sum

Given an **integer array** `arr[]` and a target sum `target`, this program finds the **starting and ending index** of a **continuous subarray** that adds up to the given sum.  

---

## Problem Statement

Given:
- An integer array `arr[]` of size `n`
- A target integer `target`

Find:
- Indices `(start, end)` such that the sum of subarray `arr[start ... end]` equals `target`.  
- If multiple subarrays exist, return any one of them.  
- If no such subarray exists, return `-1`.  

---

## Algorithm Logic

We implement two approaches:

### **Approach 1: Naive (Brute Force)**
1. Iterate over all possible starting indices `i`.
2. For each `i`, calculate cumulative sum from `i` to `j`.
3. If sum equals `target`, return indices `(i, j)`.
4. If no subarray matches after all checks, return `-1`.

---

### **Approach 2: Sliding Window (Optimized)**  
*(Works when all numbers are **non-negative**)*
1. Initialize two pointers:  
   - `start = 0`, `end = 0`  
   - `currentSum = arr[0]`  
2. While `end < n`:  
   - If `currentSum == target` → return `(start, end)`.  
   - If `currentSum < target` → expand window → `end++` and add `arr[end]`.  
   - If `currentSum > target` → shrink window → subtract `arr[start]` and increment `start`.  
3. Continue until window ends.  
4. If not found, return `-1`.  

---

## Time and Space Complexity

| Approach                   | Time Complexity | Space Complexity |
|----------------------------|-----------------|------------------|
| Naive (Brute Force)        | O(n²)           | O(1)             |
| Sliding Window (Optimized) | O(n)            | O(1)             |

---

## Files

- `SubarraySumIndex.java`: Contains Java implementations using Naive and Sliding Window approaches.  
- `README.md`: This file - explanation, logic, and complexity.  
