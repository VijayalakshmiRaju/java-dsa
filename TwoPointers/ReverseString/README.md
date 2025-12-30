# Reverse String

This project contains a simple Java program to **reverse a string in-place** using the **Two Pointer technique**.

Reversing a string means rearranging its characters so that the first character becomes the last, the second becomes the second last, and so on.

**Examples:**
- `"hello"` → `"olleh"`
- `"abcd"` → `"dcba"`
- `"x"` → `"x"`

---

## Features
- Reverses the string **in-place** (no extra array used).
- Uses the **Two Pointer technique** for optimal performance.
- Works for both **even and odd length** strings.
- Supports **special characters**, letters, and digits.
- Includes a `main` method with **multiple test cases**, including edge cases.

---

## How It Works
1. Convert the string into a character array.
2. Initialize two pointers:
   - `left` at the beginning of the array
   - `right` at the end of the array
3. Swap characters at `left` and `right`.
4. Move `left` forward and `right` backward.
5. Repeat until `left >= right`.

---

## Test Cases Covered
The program tests multiple scenarios including:
- Normal strings (`hello`, `abcd`)
- Even-length strings (`java`, `code`)
- Odd-length strings (`madam`, `level`)
- Single-character strings (`x`)
- Empty strings (`""`)
- Palindromic strings (`madam`)
- Strings with special characters (`@#$%`)

---

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
|---------|-----------------|------------------|
| Reversing using Two Pointers | **O(n)** | **O(1)** |
| **Overall** | **O(n)** | **O(1)** |

Where **n = length of the string**.

---

## Why Two Pointers?
- Avoids nested loops.
- Eliminates unnecessary extra memory.
- Reduces time complexity from **O(n²)** (brute force) to **O(n)**.

---

## How to Run
1. Save the file as `ReverseString.java`.
2. Compile the program:
   ```bash
   javac ReverseString.java
   ```
3. Run the program:
   ```bash
   java ReverseString
   ```
