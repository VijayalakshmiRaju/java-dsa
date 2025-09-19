# Zigzag Conversion Problem

This folder contains the implementation of the **Zigzag Conversion** problem in Java.  
The solution rearranges characters of a given string into a zigzag pattern on a given number of rows and then reads them row by row to produce the final string.

---

## Problem Statement

Given a string `s` and an integer `numRows`, arrange the characters of the string in a zigzag pattern with `numRows` rows.  
Then, read the pattern row by row to form the output string.

---


## Algorithm

### Zigzag Conversion Approach
1. **Edge Cases**:
   - If string is empty → return empty string.
   - If `numRows == 1` or `numRows >= length of string` → return the original string.

2. Create an array of `StringBuilder` objects, one for each row.

3. Use a pointer `currentRow` to track the current row and a boolean flag `goingDown` to track the direction:
   - Append the current character to the `currentRow`.
   - Change direction when reaching the **top row** or **bottom row**.
   - Move `currentRow` **downwards** when goingDown is `true`, otherwise move **upwards**.

4. After processing all characters, concatenate all rows to form the final string.

---

## Time and Auxiliary Space (extra space used)

| Approach              | Time Complexity | Auxiliary Space | Explanation |
|----------------------|----------------|----------------|-------------|
| Zigzag Conversion    | O(n)           | O(n)           | Each character is visited once and stored in its row before final concatenation. |

---

## Test Cases

| **Input String**  | **numRows** | **Output**           | **Explanation** |
|-------------------|------------|---------------------|-----------------|
| "PAYPALISHIRING"  | 3          | "PAHNAPLSIIGYIR"    | 3-row zigzag |
| "PAYPALISHIRING"  | 4          | "PINALSIGYAHRPI"    | 4-row zigzag |
| "A"               | 1          | "A"                | Single character |
| ""                | 5          | ""                 | Empty string |
| "AB"              | 1          | "AB"               | Only one row → return as is |
| "AB"              | 5          | "AB"               | numRows > length → return as is |
| "ABCDEFGHIJK"     | 2          | "ACEGIKBDFHJ"      | 2-row zigzag |
| "ABCDEFGHIJK"     | 5          | "AIJBDHCEGFK"      | 5-row zigzag |

---

## Files
- `ZigzagConversion.java` – Java file containing the zigzag conversion logic and test cases.

---

## How to Run

1. Compile the program:
```bash
javac ZigzagConversion.java
