# Arrange Numbers in Descending Frequency

This folder contains the implementation of arranging numbers in an array by **descending order of frequency** in Java:
- Naive Bubble Sort based method
- Optimized Sorting using Comparator

The algorithm assumes the array can contain **positive, negative, or duplicate numbers**.

---

## Problem Statement

Given an integer array, rearrange the elements in **descending order of their frequency**.  
- If two numbers have the same frequency, the one that appears **earlier in the array** should come first.  

### Example 1
**Input:**  
`[4, 2, 1, 3, 1, 2, 5, 2]`  

**Output:**  
`[2, 2, 2, 1, 1, 4, 3, 5]`  

### Example 2
**Input:**  
`[9, 9, 1, 1, 1, 2, 3]`  

**Output:**  
`[1, 1, 1, 9, 9, 2, 3]`  

---

## Algorithm

### Naive Bubble Sort Approach
1. Count the frequency of each number using a map.  
2. Track the **first occurrence index** of each number to maintain stable order.  
3. Sort the array using **bubble sort** based on:  
   - Higher frequency first.  
   - If frequencies match → preserve original order.  
4. Rebuild the array with sorted order.  

### Optimized Sorting Approach
1. Count frequencies and store with first occurrence index.  
2. Use `Arrays.sort` or `Collections.sort` with a **custom comparator**:  
   - Compare by frequency (descending).  
   - Tie-breaker: first occurrence index.  
3. Rebuild the result array efficiently.  

---

## Time and Auxiliary Space (extra space used)

| Approach              | Time Complexity | Auxiliary Space | Explanation |
|-----------------------|-----------------|-----------------|-------------|
| Naive (Bubble Sort)   | O(n²)           | O(n)            | Bubble sort applied on frequency-based array |
| Optimized (Sort)      | O(n log n)      | O(n)            | Sorting with comparator and extra maps |

---

## Files
- `ArrangeInDescendingFrequency.java` – Java file with both naive and optimized implementations.
