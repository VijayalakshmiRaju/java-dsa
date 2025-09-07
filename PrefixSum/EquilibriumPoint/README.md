# Equilibrium Point Problem

This folder contains the implementation of finding an **Equilibrium Point** in Java:  
- Naive (Brute Force) method  
- Optimized Prefix Sum method  

The algorithm works on arrays that may contain **positive, negative, or zero values**.

---

## Algorithm

### Naive Approach
1. For each index `i`, calculate the sum of all elements to the **left**.  
2. Calculate the sum of all elements to the **right**.  
3. If both sums are equal → return the index.  

### Optimized Prefix Sum Approach
1. Calculate the **total sum** of the array.  
2. Initialize `leftSum = 0`.  
3. Traverse the array:  
   - Subtract the current element from `totalSum` → this becomes the **right sum**.  
   - Compare `leftSum` with `right sum`. If equal → return the index.  
   - Update `leftSum` by adding the current element.  

---

## Time and Auxiliary Space (extra space used)

| Approach        | Time Complexity | Auxiliary Space | Explanation |
|-----------------|-----------------|-----------------|-------------|
| Naive (Brute)   | O(n²)           | O(1)            | Computes left & right sum for every index |
| Optimized       | O(n)            | O(1)            | Single traversal using prefix sum logic |

---

## Files
- `EquilibriumPoint.java` – Java file with both naive and optimized implementations.  
