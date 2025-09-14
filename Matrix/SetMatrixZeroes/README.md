# Set Matrix Zeroes (In-Place Solution)

## Problem Statement

You are given an `m x n` integer matrix. If any element in the matrix is `0`, you must set **its entire row and column** to `0`, and you must do this **in place** (without using extra space for another matrix).

### Example 1:
**Input:**
1 1 1
1 0 1
1 1 1


**Output:**
1 0 1
0 0 0
1 0 1


---

## Approach

We use the **first row and first column** of the matrix as markers to track which rows and columns need to be set to zero.

### Steps:
1. **Check first row & column:**  
   Determine if they themselves need to be zeroed out later.
2. **Mark rows and columns:**  
   For each cell `(i, j)` that is `0`, mark its row and column by setting `matrix[i][0]` and `matrix[0][j]` to `0`.
3. **Update inner cells:**  
   For each cell `(i, j)`, if its row or column is marked, set it to `0`.
4. **Zero first row & column if needed:**  
   Based on our initial check, set first row/column to `0` if required.

This approach avoids using additional data structures and works in **constant extra space**.

---

## Time & Space Complexity

| Complexity | Value |
|-----------|-------|
| **Time Complexity** | `O(m * n)` – We iterate through the matrix a few times. |
| **Space Complexity** | `O(1)` – We use only a few extra boolean variables. |

---

## Test Cases

We cover multiple scenarios, including edge cases:

| Test Case | Description |
|----------|-------------|
| 1 | Basic Example (single zero in middle) |
| 2 | Multiple zeros in different rows/columns |
| 3 | No zeros (matrix should remain unchanged) |
| 4 | All zeros (matrix remains all zeros) |
| 5 | Single row |
| 6 | Single column |
| 7 | 1x1 matrix with zero |
| 8 | 1x1 matrix without zero |

---

## Sample Output
Test Case 1: Basic Example
Original Matrix:
[1, 1, 1]
[1, 0, 1]
[1, 1, 1]
Modified Matrix:
[1, 0, 1]
[0, 0, 0]
[1, 0, 1]

Test Case 2: Multiple Zeros in Different Rows & Columns
Original Matrix:
[0, 1, 2, 0]
[3, 4, 5, 2]
[1, 3, 1, 5]
Modified Matrix:
[0, 0, 0, 0]
[0, 4, 5, 0]
[0, 3, 1, 0]

---

## Topics Covered

- **Arrays**
- **Matrix Traversal**
- **In-place Modification**
- **Space Optimization**

---

## Key Takeaways

- Using the first row and column as markers avoids extra space usage.
- Always handle the first row and column separately since they are used as markers.
- Works efficiently for all edge cases, including very small or very large matrices.

---

## File Structure
**SetMatrixZeroes.java** # Contains solution, main method, and test cases
**README.md** # Problem explanation, approach, and sample output
