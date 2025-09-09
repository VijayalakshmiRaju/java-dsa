# Zig-Zag Matrix Problem

This folder contains the implementation of traversing a **2D matrix** in **Zig-Zag Diagonal Order**:
- Alternates between upward and downward diagonal traversal
- Handles square, rectangular, and edge cases

The algorithm outputs the elements of the matrix in a **zig-zag sequence** along its diagonals.

---

## Problem Statement

Given a 2D matrix of size `m × n`, print all its elements in **zig-zag diagonal order**.  
The traversal alternates between:
- **Even diagonals** → bottom-left to top-right (upward movement)  
- **Odd diagonals** → top-right to bottom-left (downward movement)  

---

## Algorithm

### Zig-Zag Traversal Approach
1. The total number of diagonals is `(m + n - 1)`.
2. For each diagonal `k`:
   - If `k` is **even**:
     - Start at the lowest possible row (`row = min(k, n-1)`) and move upward.
     - Decrease row (`row--`) and increase column (`col++`) until bounds are exceeded.
   - If `k` is **odd**:
     - Start at the leftmost possible column (`col = min(k, m-1)`) and move downward.
     - Increase row (`row++`) and decrease column (`col--`) until bounds are exceeded.
3. Continue until all diagonals are processed.

---

## Time and Auxiliary Space (extra space used)

| Approach            | Time Complexity | Auxiliary Space | Explanation |
|---------------------|-----------------|-----------------|-------------|
| Zig-Zag Traversal   | O(m × n)        | O(1)            | Each element is visited exactly once with constant extra space. |

---

## Test Cases

| **Input Matrix**                | **Output (Zig-Zag Order)**         | **Explanation** |
|---------------------------------|------------------------------------|-----------------|
| [[1,2,3],[4,5,6],[7,8,9]]       | [1,2,4,7,5,3,6,8,9]               | 3×3 square |
| [[1,2,3,4],[5,6,7,8]]           | [1,2,5,6,3,4,7,8]                 | Rectangular 2×4 |
| [[1,2],[3,4],[5,6],[7,8]]       | [1,2,3,5,4,6,7,8]                 | Rectangular 4×2 |
| [[1,2,3,4,5]]                   | [1,2,3,4,5]                       | Single row |
| [[1],[2],[3],[4],[5]]           | [1,2,3,4,5]                       | Single column |
| [[42]]                          | [42]                              | Single element |

---

## Files
- `ZigZagMatrixTraversal.java` – Java file with zig-zag diagonal traversal implementation.
