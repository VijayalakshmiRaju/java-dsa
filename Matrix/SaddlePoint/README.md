# Saddle Point in a Matrix

## Problem Statement
A **saddle point** in a matrix is an element that is **the minimum element in its row** and **the maximum element in its column**.  
If no such element exists, the function should return `-1`.

**Example:**

Given the matrix:
4 5 6
7 8 9
1 2 3

- Minimum elements by row → [4, 7, 1]  
- Checking corresponding columns →  
  - 4 → not max in its column  
  - 7 → max in its column 
  - 1 → not max in its column  

Hence, the saddle point is **7**.

---

## Approach

1. Traverse each row of the matrix.
2. For the current row, find the **minimum element** and note its **column index**.
3. Check the corresponding column to see if this element is the **maximum** value in that column.
4. If it satisfies both conditions, return that element as the saddle point.
5. If no element meets the criteria after scanning all rows, return `-1`.

---

## Algorithm Steps

1. Initialize the number of rows and columns.  
2. For each row:
   - Find the minimum element and its column index.
   - For that column, check if this element is the largest.
3. If a saddle point is found, return it immediately.
4. If the entire matrix is traversed without finding one, return `-1`.

---

## Time and Space Complexity

| Operation | Complexity |
|------------|-------------|
| Finding minimum in each row | O(columns) |
| Checking maximum in column | O(rows) |
| **Total Time Complexity** | **O(rows × columns)** |
| **Space Complexity** | **O(1)** |

---

## Example Output

Matrix:
4 5 6
7 8 9
1 2 3
Saddle Point Found: 7

Matrix:
3 8 4
9 6 7
5 2 1
No Saddle Point Found

Matrix:
42
Saddle Point Found: 42
