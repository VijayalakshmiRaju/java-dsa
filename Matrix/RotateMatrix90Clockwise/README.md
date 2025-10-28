# Rotate Matrix 90° Clockwise (Naive and In-Place Approaches)

## Problem Statement
Given an `N x N` matrix, rotate it **90 degrees clockwise** in such a way that the elements are repositioned as if the matrix was physically turned to the right.

### Example

**Input:**
1 2 3
4 5 6
7 8 9

**Output: (after 90° rotation):**
7 4 1
8 5 2
9 6 3

---

## Approaches

### 1. Naive Approach (Using Extra Matrix)
**Steps:**
1. Create a new result matrix of the same size.
2. For each element at position `(i, j)` in the original matrix,  
   place it at position `(j, N - i - 1)` in the result matrix.
3. Copy all elements from the result matrix back to the original matrix.

**Example Transformation:**
matrix[i][j] → result[j][N - i - 1]

### 2. In-Place Approach (Transpose + Reverse)
**Steps:**
1. **Transpose the matrix:** Convert rows into columns (swap elements at `(i, j)` and `(j, i)`).
2. **Reverse each row:** After transposing, reverse every row to get a 90° clockwise rotation.

**Example:**

Before Transpose:
1 2 3
4 5 6
7 8 9

After Transpose:
1 4 7
2 5 8
3 6 9

After Reversing Each Row:
7 4 1
8 5 2
9 6 3

## Algorithm Steps

### Naive Method
1. Initialize an empty matrix `result[n][n]`.
2. For each element `matrix[i][j]`, assign:
result[j][n - i - 1] = matrix[i][j]

3. Copy all elements from `result` back to `matrix`.

## Time and Space Complexity

| Approach | Time Complexity | Space Complexity | Description |
|-----------|-----------------|------------------|-------------|
| **Naive** | O(N²) | O(N²) | Creates an extra matrix to store rotated result |
| **In-place (Transpose + Reverse)** | O(N²) | O(1) | Rotates the matrix in-place without extra space |

---

## Approach

### Naive Method
1. Create a new `result` matrix of the same size (`N x N`).
2. For every element at position `(i, j)` in the original matrix,  
   place it in the rotated position `(j, N - i - 1)` in the `result` matrix.
3. Copy all elements from the `result` matrix back into the original matrix.

This approach ensures the correct 90° clockwise rotation by repositioning elements based on their original indices.

### 2. In-Place Approach (Transpose + Reverse)
**Steps:**
1. **Transpose the matrix:** Convert rows into columns (swap elements at `(i, j)` and `(j, i)`).
2. **Reverse each row:** After transposing, reverse every row to get a 90° clockwise rotation.

---

## Algorithm Steps

### Naive Method
1. Initialize an empty matrix `result[n][n]`.
2. For each element `matrix[i][j]`, assign:
result[j][n - i - 1] = matrix[i][j]

3. Copy all elements from `result` back to `matrix`.

### In-Place Method
1. **Transpose the Matrix**  
   - Convert rows into columns by swapping elements across the main diagonal.  
   - For each element `(i, j)` where `j > i`, swap `matrix[i][j]` with `matrix[j][i]`.  
   - After transposing, the matrix’s rows become columns.

2. **Reverse Each Row**  
   - After the transpose, reverse every row in the matrix.  
   - Swap elements symmetrically from start to end (e.g., `matrix[i][begin]` ↔ `matrix[i][end]`).  
   - This step ensures the matrix is rotated 90° clockwise.

3. **Final Result**  
   - The matrix is now rotated **90 degrees clockwise** in place (without using extra space).

---

## Example Walkthrough

**For matrix:**
1 2 3
4 5 6
7 8 9

After rotation:
7 4 1
8 5 2
9 6 3

---

## Edge Cases Covered
1. **1x1 Matrix:** No visible change after rotation.
2. **2x2 Matrix:** Small even-sized matrix test.
3. **3x3 Matrix:** Standard example.
4. **4x4 Matrix:** Even-sized larger matrix.
5. **5x5 Matrix:** Tests scalability.
6. **Matrix with Negative Numbers:** Works for all integer types.
7. **Matrix with All Zeros:** Verifies handling of identical values.

---
