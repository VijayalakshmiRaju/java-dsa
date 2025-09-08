# Print All Diagonals of a Matrix  

This folder contains the implementation of printing **all diagonals of a 2D matrix** in a specific order:  
- Start from the **bottom-right element**.  
- Traverse each diagonal (bottom-left → top-right).  
- Collect elements and print them in the required zig-zag order.  

---

## Problem Statement  

Given a 2D matrix, print all its diagonals in the order starting from the **last element** (bottom-right) up to the **first element** (top-left).  

### Example  

**Input:**  
1 2 3
4 5 6
7 8 9


**Output:**  
9 8 6 7 5 3 4 2 1


**Explanation:**  
- Diagonal 1 → `9`  
- Diagonal 2 → `8 6`  
- Diagonal 3 → `7 5 3`  
- Diagonal 4 → `4 2`  
- Diagonal 5 → `1`  

---

## Algorithm  

1. A matrix of size `n × m` has **(n + m - 1) diagonals**.  
2. For each diagonal (indexed by `k`):  
   - If `k >= m`:  
     - Start from `(row = k - m + 1, col = m - 1)` → bottom side.  
   - Else:  
     - Start from `(row = 0, col = k)` → top row.  
3. Move along the diagonal by incrementing `row++` and decrementing `col--`.  
4. Collect values in a temporary list.  
5. Print values in **reverse order** to match the required output style.  

---

## Code Features  

- Works for **square** and **rectangular** matrices.  
- Handles **edge cases** like:  
  - Single element (`1x1`)  
  - Single row (`1xN`)  
  - Single column (`Nx1`)  

---

## Sample Test Cases  

### Input Matrix (3x3)  
1 2 3
4 5 6
7 8 9

**Output:**  
9 8 6 7 5 3 4 2 1


---

### Input Matrix (4x3)  
1 2 3
4 5 6
7 8 9
10 11 12

**Output:**  
12 11 9 10 8 6 7 5 3 4 2 1


---

## Complexity Analysis  

- **Time Complexity** → `O(n * m)` (each element is visited once).  
- **Space Complexity** → `O(min(n, m))` (temporary storage of one diagonal).  

---

## File Structure  
DiagonalMatrix.java - contains implementation - to print all diagonal elements in a specific order.
