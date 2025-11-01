# Number Triangle Pattern

This folder contains the implementation of a **Number Triangle pattern printer** in Java.  
The program prints a **right-aligned number triangle**, where each row displays the row number repeated as many times as the row index.

---

## Problem Statement

Given a number `n`, print a **right-aligned triangle** pattern using numbers.  
Each row contains the same number repeated equal to the row index.

### Example

For `n = 4`, the output should be:
   1
  2 2
 3 3 3
4 4 4 4

---

## Approach

1. **Iterate rows** from `1` to `n`.  
2. For each row:
   - Print `(n - row)` spaces to align the numbers to the right.
   - Print the current row number followed by a space, repeated `row` times.
3. Move to the next line after each row.
4. Handle invalid inputs (`n <= 0`) by displaying an error message instead of printing the triangle.

---

## Algorithm Steps

1. Start with the first row (`row = 1`).  
2. Print `(n - row)` spaces.  
3. Print the number `row` repeated `row` times, separated by spaces.  
4. Increment `row` and repeat until all rows are printed.  
5. If `n <= 0`, print an appropriate message indicating invalid input.

---

## Time & Space Complexity

| Complexity | Description |
|-------------|--------------|
| **Time Complexity** | O(n²) — Two nested loops (rows × numbers per row) |
| **Space Complexity** | O(1) — Constant extra space used |

---
