# Palindrome Triangle Pattern

This folder contains the implementation of the **Palindrome Number Triangle Pattern** in Java.  

The program prints a pyramid-shaped triangle of numbers where each row forms a **palindromic sequence** (reads the same forward and backward).  
It demonstrates the use of nested loops, spacing alignment, and pattern generation logic.

---

## Problem Statement

Given a number `n`, print a **palindromic number triangle** pattern with `n` rows.  

Each row contains numbers decreasing from the current row number down to `1`, and then increasing back to the current row number.

---

### Example

**Input:**
n = 4


**Output:**

      1 
    2 1 2 
  3 2 1 2 3 
4 3 2 1 2 3 4 


---

## Approach

1. **Handle invalid inputs:**  
   If `n <= 0`, display a message indicating invalid input.

2. **Iterate through rows (1 to n):**  
   Each iteration represents one row of the triangle.

3. **Print spaces:**  
   Before the numbers, print `(n - i)` spaces to center-align the pyramid.

4. **Print decreasing numbers:**  
   Print numbers from `i` down to `1` to form the left half of the palindrome.

5. **Print increasing numbers:**  
   Print numbers from `2` up to `i` to form the right half.

6. **Move to the next line** after printing each row.

7. **Test cases:**  
   The program iterates through multiple test cases (including edge cases) using a `for` loop.

---

## Example Test Cases

| Test Case | Input (n) | Description |
|------------|------------|-------------|
| 1 | 6 | Standard case |
| 2 | 1 | Smallest valid input |
| 3 | 4 | Medium-sized pattern |
| 4 | 9 | Large pattern for spacing validation |
| 5 | 0 | Edge case – invalid input |
| 6 | -3 | Edge case – invalid input |

---

## Sample Output

Test Case 1: n = 6
          1 
        2 1 2 
      3 2 1 2 3 
    4 3 2 1 2 3 4 
  5 4 3 2 1 2 3 4 5 
6 5 4 3 2 1 2 3 4 5 6 
-----------------------------
Test Case 2: n = 1
1 
-----------------------------
Test Case 3: n = 4
      1 
    2 1 2 
  3 2 1 2 3 
4 3 2 1 2 3 4 
-----------------------------
Test Case 4: n = 9
                1 
              2 1 2 
            3 2 1 2 3 
          4 3 2 1 2 3 4 
        5 4 3 2 1 2 3 4 5 
      6 5 4 3 2 1 2 3 4 5 6 
    7 6 5 4 3 2 1 2 3 4 5 6 7 
  8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 
9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9 
-----------------------------
Test Case 5: n = 0
Invalid input! Number must be positive.
-----------------------------
Test Case 6: n = -3
Invalid input! Number must be positive.
-----------------------------

---

## Time and Space Complexity

| Complexity | Explanation |
|-------------|-------------|
| **Time Complexity:** O(n²) | Each row prints up to `2n` numbers and spaces. |
| **Space Complexity:** O(1) | Constant space used, as the pattern is printed directly. |

---

## Summary

- Demonstrates **nested loop control** and **pattern symmetry**.  
- Covers **positive**, **zero**, and **negative** input handling.  
- Uses a **for loop** to iterate multiple test cases for scalability and maintainability.
