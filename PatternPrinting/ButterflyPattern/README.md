# Butterfly Pattern

## Problem Statement
Write a Java program to print a **Butterfly Pattern** using stars (`*`) for a given number of rows (`n`).  
The butterfly pattern consists of two symmetric halves — the **upper wings** and **lower wings** — forming a mirror-like structure.

Example for `n = 4`:
*             *
* *         * *
* * *     * * *
* * * * * * * *
* * * * * * * *
* * *     * * *
* *         * *
*             *

---

## Approach
1. The total number of columns in each row is `2 * n`.
2. Use **two main parts**:
   - **Upper Half:**  
     For each row `i` (from `1` to `n`), print:
     - `*` for the first `i` columns (left wing)
     - spaces in the middle (`2 * (n - i)`)
     - `*` again for the last `i` columns (right wing)
   - **Lower Half:**  
     Repeat the same pattern in reverse order (from `n` down to `1`).
3. Use two nested loops:
   - The **outer loop** controls the number of rows.
   - The **inner loop** controls the stars and spaces in each row.
4. Handle edge cases where `n` is `0` or negative by printing an appropriate message.

---

## Algorithm Steps
1. **Start**  
2. **Input** the number of rows (`n`).  
3. **If** `n <= 0`, print an error message and exit.  
4. For each row `i` from `1` to `n` (Upper Half):  
   - Print `*` from `1` to `i`.  
   - Print spaces from `i + 1` to `2 * n - i`.  
   - Print `*` from `2 * n - i + 1` to `2 * n`.  
5. For each row `i` from `n` down to `1` (Lower Half):  
   - Repeat the same steps as the upper half.  
6. **End**

---

## Time and Space Complexity

| Complexity Type | Description |
|------------------|-------------|
| **Time Complexity** | O(n²) — Each row has up to `2 * n` iterations and there are `n` rows. |
| **Space Complexity** | O(1) — Only a few loop variables are used; pattern is printed directly to console. |

---

## Example Output

### Test Case 1:
**Input:** n = 1  
**Output:**
**
**

--------------------------------

Test Case: n = 3
--------------------------------
*    *
**  **
******
******
**  **
*    *
--------------------------------

Test Case: n = 5
--------------------------------
*        *
**      **
***    ***
****  ****
**********
**********
****  ****
***    ***
**      **
*        *
--------------------------------

Test Case: n = 6
--------------------------------
*          *
**        **
***      ***
****    ****
*****  *****
************
************
*****  *****
****    ****
***      ***
**        **
*          *
--------------------------------
