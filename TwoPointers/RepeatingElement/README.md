# Repeating Element Problem

This folder contains the implementation of finding a **repeating element** in Java, where:  
- The array contains elements in the range **0 to n-1**.  
- **Exactly one element may repeat any number of times**.  
- The array must contain **0**.  

Implemented approaches:
- Naive (Brute Force) method
- Sorting method
- Boolean Array method
- Floyd’s Cycle Detection (Two-Pointer) method

---

## Problem Statement
Given an array `arr[]` of size `n` that contains integers in the range **0 to n-1**,  
find the **repeating element** in the array.  

**Conditions:**
- The array must contain **0**.  
- **Exactly one element may repeat any number of times**.  
- Other elements appear **only once**.  

---

## Algorithm

### Naive Approach
1. Use two nested loops.  
2. Compare every pair of elements.  
3. Return the first element that repeats.

### Sorting Approach
1. Sort the array.  
2. Traverse linearly and check if any adjacent elements are equal.  
3. If equal → return the repeating element.

### Boolean Array Approach
1. Create a boolean array of size `n`.  
2. Traverse the array:  
   - If the element is already `true` → it’s the repeating element.  
   - Else mark it as `true`.  

### Floyd’s Cycle Detection (Two-Pointer) Approach
1. Treat array values as pointers (`arr[i]` → next index).  
2. Use slow and fast pointers to detect a cycle.  
3. Once a cycle is detected, reset one pointer to start and move both one step at a time.  
4. The meeting point is the repeating element.

---

## Time and Auxiliary Space (extra space used)

| Approach               | Time Complexity | Auxiliary Space | Explanation |
|------------------------|-----------------|-----------------|-------------|
| Naive (Brute Force)    | O(n²)           | O(1)            | Compares every pair |
| Sorting                | O(n log n)      | O(1)            | Sorts + single scan |
| Boolean Array          | O(n)            | O(n)            | Tracks visited indices |
| Floyd’s Cycle Detection| O(n)            | O(1)            | Cycle detection with two pointers |

---

## Files
- `RepeatingElement.java` – Java file with all four implementations.
