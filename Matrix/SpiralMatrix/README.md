# Spiral Matrix Problem

This folder contains the implementation of traversing a **2D matrix** in **Spiral Order**:
- Iterative Layer-by-Layer traversal
- Handles square, rectangular, and edge cases

The algorithm outputs the elements of the matrix in a **spiral sequence** starting from the **top-left corner** and moving inward.

---

## Problem Statement

Given a 2D matrix of size `m × n`, print all its elements in **spiral order**.  
The traversal starts from the **top-left** element, moves **right**, then **down**, then **left**, then **up**, and continues inward until all elements are processed.

---

## Algorithm

### Spiral Traversal Approach
1. Initialize four boundaries:
   - `top = 0` (first row)
   - `bottom = m - 1` (last row)
   - `left = 0` (first column)
   - `right = n - 1` (last column)
   
2. Traverse in four steps:
   - Left → Right along `top` row  
   - Top → Bottom along `right` column  
   - Right → Left along `bottom` row (if `top <= bottom`)  
   - Bottom → Top along `left` column (if `left <= right`)  

3. Shrink boundaries (`top++`, `bottom--`, `left++`, `right--`) and repeat until all elements are visited.

---

## Time and Auxiliary Space (extra space used)

| Approach         | Time Complexity | Auxiliary Space | Explanation |
|------------------|-----------------|-----------------|-------------|
| Spiral Traversal | O(m × n)        | O(m × n)        | Each element is visited once and stored in result array. |

---

## Test Cases

| **Input Matrix**                | **Output (Spiral Order)**          | **Explanation** |
|---------------------------------|------------------------------------|-----------------|
| [[1,2,3],[4,5,6],[7,8,9]]       | [1,2,3,6,9,8,7,4,5]               | 3×3 square |
| [[1,2,3,4],[5,6,7,8],[9,10,11,12]] | [1,2,3,4,8,12,11,10,9,5,6,7]   | Rectangular 3×4 |
| [[1,2],[3,4],[5,6],[7,8]]       | [1,2,4,6,8,7,5,3]                 | Rectangular 4×2 |
| [[1,2,3,4]]                     | [1,2,3,4]                         | Single row |
| [[1],[2],[3],[4]]               | [1,2,3,4]                         | Single column |
| [[42]]                          | [42]                              | Single element |

---

## Files
- `SpiralMatrix.java` – Java file with spiral traversal implementation.
- `Main.java` – Contains test cases to verify the solution.
