# Square Root of X

This folder contains the implementation of **Square Root of a Number** in Java using:

- Naive Method  
- Binary Search Method (Optimized)

The task is to compute the **integer square root** of a given number `x`.  
If `x` is a perfect square, the exact square root is returned. Otherwise, the **floor value** of the square root is returned.

---

## Problem Statement

Given an integer `x`, find the **square root** of `x`.  

- If `x` is a perfect square, return the exact square root.  
- Otherwise, return the floor of the square root (the greatest integer less than or equal to √x).  

---


## Algorithm Logic

### 1. Naive Method
1. Start from `i = 1`.  
2. Keep incrementing `i` until `i * i` exceeds `x`.  
3. The integer square root is `i - 1`.  

### 2. Binary Search Method
1. Handle base cases: if `x == 0` or `x == 1`, return `x`.  
2. Set search range:  
   - `low = 1`  
   - `high = x / 2` (since √x ≤ x/2 for x > 1).  
3. Apply binary search:  
   - Find `mid = low + (high - low) / 2`.  
   - If `mid * mid == x` → return `mid`.  
   - If `mid * mid > x` → search left half.  
   - Else → search right half, update result = mid.  
4. Return the final result.  

---

## Time and Space Complexity

| Approach          | Time Complexity | Auxiliary Space | Notes                                 |
|-------------------|-----------------|-----------------|---------------------------------------|
| Naive Method      | O(√x)           | O(1)            | Incrementally checks squares           |
| Binary Search     | O(log x)        | O(1)            | Efficient divide-and-conquer method    |

---

## Files

- `SquareRoot.java`: Contains both **Naive** and **Binary Search** implementations with test cases  
- `README.md`: This file – explanation, logic, and complexity  
