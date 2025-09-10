# Container With Most Water

This folder contains the implementation of the **Container With Most Water** problem in Java.  
The task is to find two vertical lines that, together with the x-axis, form a container that holds the **maximum amount of water**.

We cover two approaches:  
- **Naive Approach** (brute force, O(n²))  
- **Optimized Approach** (two-pointer, O(n))  

---

## Problem Statement

You are given an integer array `height` of length `n`.  
Each element represents the height of a vertical line drawn at index `i`.  

Find two lines that, together with the x-axis, form a container such that the container holds the **most water**.  
Return the maximum amount of water a container can store.  

---

## Algorithm

### Naive Approach
1. Try all pairs `(i, j)` where `i < j`.  
2. For each pair, compute the area as:  
    area = min(height[i], height[j]) * (j - i)

3. Keep track of the maximum area found.  

- **Brute force approach**, checks all possible containers.

---

### Optimized Approach (Two-Pointer)
1. Place one pointer at the **start** (`left = 0`) and one at the **end** (`right = n-1`).  
2. Calculate the current area:  
    area = min(height[left], height[right]) * (right - left)
3. Update the maximum area if needed.  
4. Move the pointer pointing to the **shorter line** inward:  
- If `height[left] < height[right]`, increment `left`.  
- Else, decrement `right`.  
5. Repeat until `left < right`.  

- **Efficient approach**, eliminates unnecessary checks.

---

## Complexity Analysis

| Approach   | Time Complexity | Space Complexity |
|------------|-----------------|------------------|
| Naive      | O(n²)           | O(1)             |
| Optimized  | O(n)            | O(1)             |

---

## Key Notes
- The **naive approach** is easy to understand but inefficient for large inputs.  
- The **optimized approach** is based on the two-pointer technique and runs in linear time.  
- Always move the pointer pointing to the **shorter bar**, since it limits the area.  
