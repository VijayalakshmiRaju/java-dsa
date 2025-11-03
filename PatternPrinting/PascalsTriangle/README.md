# Pascal's Triangle

## Problem Statement
Write a program to print **Pascal’s Triangle** up to a given number of rows.  
Each number in Pascal’s Triangle is the sum of the two numbers directly above it in the previous row.

Example for `n = 5`:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

---

## Approach
1. Use two nested loops:
   - The **outer loop** runs from `1` to `n` for each row.
   - The **inner loop** prints the binomial coefficients for each row.
2. For each element in a row, use the mathematical formula:
   \[
   C(i, j) = C(i, j-1) \times \frac{(i - j)}{j}
   \]
   This avoids recalculating factorials.
3. Add spaces before each row to align the triangle shape.
4. Handle edge cases where `n` is `0` or negative by printing an appropriate message.

---

## Algorithm Steps
1. **Start**  
2. **Input** the number of rows (`n`).  
3. **If** `n <= 0`, print an error message and exit.  
4. For each row `i` from `1` to `n`:  
   - Print `n - i` spaces for alignment.  
   - Initialize `val = 1`.  
   - For each column `j` from `1` to `i`:  
     - Print `val`.  
     - Update `val = val * (i - j) / j`.  
   - Move to the next line.  
5. **End**

---

## Test Cases

| Test Case | Input (`n`) | Expected Output |
|------------|--------------|-----------------|
| 1 | 5 | Prints 5 rows of Pascal's Triangle |
| 2 | 1 | Single row: `1` |
| 3 | 6 | Prints 6 rows with correct alignment |
| 4 | 0 | Prints: `Invalid input. Number of rows must be positive.` |
| 5 | -3 | Prints: `Invalid input. Number of rows must be positive.` |

---

## Time and Space Complexity

| Complexity Type | Description |
|------------------|-------------|
| **Time Complexity** | O(n²) — For each of the `n` rows, up to `n` elements are computed. |
| **Space Complexity** | O(1) — Only a few variables are used; no extra data structures. |

---
