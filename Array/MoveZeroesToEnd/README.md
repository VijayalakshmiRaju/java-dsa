# Move Zeroes to End

This folder contains the implementation of the **Move Zeroes to End** problem in Java.  
The task is to move all `0`s in the array to the **end**, while maintaining the relative order of the **non-zero elements**.

We cover two approaches:  
- **Naive Approach** (extra space)  
- **Optimized Approach** (in-place, efficient)  

---

## Problem Statement

Given an integer array `arr`, move all zeroes to the **end** while keeping the relative order of the non-zero elements the same.  

---

## Algorithm

### Naive Approach
1. Create a temporary array of the same size.  
2. Traverse the original array and copy all **non-zero** elements to the temporary array.  
3. Fill the remaining positions with `0`s.  
4. Copy the temporary array back to the original array.  

- **Uses extra space**.

---

### Optimized Approach (In-place)
1. Maintain an index `idx` to track where the next **non-zero element** should be placed.  
2. Traverse the array:  
   - If an element is non-zero, assign it to the `idx` position and increment `idx`.  
3. After traversal, fill the rest of the array (from `idx` to end) with `0`s.  

- **No extra space** and done **in-place**.

---

## Complexity Analysis

| Approach   | Time Complexity | Space Complexity |
|------------|-----------------|------------------|
| Naive      | O(n)            | O(n)             |
| Optimized  | O(n)            | O(1)             |

---

## Key Notes
- Both approaches **preserve the order** of non-zero elements.  
- The **optimized approach** is recommended since it is **in-place** and does not require extra memory.  
