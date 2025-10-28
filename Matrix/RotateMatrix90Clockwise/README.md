# Rotate Matrix 90° Clockwise (Naive Approach)

## Problem Statement
Given an `N x N` matrix, rotate it by **90 degrees clockwise**.  
The rotation should modify the matrix so that all elements are repositioned as if the matrix was physically rotated 90° in the clockwise direction.

### Example

**Input:**
1 2 3
4 5 6
7 8 9

**Output:**
7 4 1
8 5 2
9 6 3

---

## Approach

### Naive Method
1. Create a new `result` matrix of the same size (`N x N`).
2. For every element at position `(i, j)` in the original matrix,  
   place it in the rotated position `(j, N - i - 1)` in the `result` matrix.
3. Copy all elements from the `result` matrix back into the original matrix.

This approach ensures the correct 90° clockwise rotation by repositioning elements based on their original indices.

---

## Algorithm Steps
1. Initialize an empty matrix `result[n][n]`.
2. For each element `matrix[i][j]`, assign:
result[j][n - i - 1] = matrix[i][j]

3. Copy all elements from `result` back to `matrix`.

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

## Edge Cases
- **1x1 matrix:** No visible change after rotation.
- **Matrix with negative numbers:** Rotation works the same regardless of sign.
- **Even-sized matrices (2x2, 4x4, etc.):** The logic applies consistently.

---

## Time and Space Complexity

| Complexity Type | Description |
|------------------|-------------|
| **Time Complexity** | O(N²) — Each element is processed once. |
| **Space Complexity** | O(N²) — Additional matrix is used for storing the rotated version. |

---

## Test Cases Covered
1. 3x3 matrix (standard case)  
2. 4x4 matrix (even-sized matrix)  
3. 1x1 matrix (edge case)  
4. 2x2 matrix (small matrix)  
5. 3x3 matrix with negative numbers  

---

## Notes
- This is the **naive approach** since it uses extra space.  
- An **in-place version (O(1) space)** can be implemented using **transpose + reverse row** logic.
