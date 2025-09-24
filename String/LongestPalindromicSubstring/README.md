# Longest Palindromic Substring

This project provides a Java implementation to find the **Longest Palindromic Substring** in a given string. A palindrome is a sequence of characters that reads the same backward as forward.

---

## Problem Statement

Given a string `s`, the task is to find the **longest substring** of `s` which is a palindrome.

**Examples:**

| Input             | Output       |
|------------------|--------------|
| "babad"           | "bab" or "aba" |
| "cbbd"            | "bb"         |
| "racecar"         | "racecar"    |
| "forgeeksskeegfor"| "geeksskeeg"|

---

## Approach

The solution uses a **center expansion technique**:

1. Treat each character (and the gap between characters) as the center of a potential palindrome.
2. Expand outward while the characters on both sides match.
3. Track the start and end indices of the longest palindrome found.
4. Return the substring from `start` to `end`.

**Steps:**

- Loop through each character in the string as a potential center.
- Expand around the center for **odd-length palindromes** (`i, i`) and **even-length palindromes** (`i, i+1`).
- Update the start and end indices when a longer palindrome is found.

---

## Time and Space Complexity

| Complexity      | Description                                               |
|-----------------|-----------------------------------------------------------|
| Time Complexity | O(n²) — Expand around each center for n characters       |
| Space Complexity| O(1) — Only a few integer variables are used             |

---

## Java Implementation

- The `longestPalindrome` function returns the longest palindromic substring.
- The `expandPalindrome` helper function expands around a center.
- The `main` method demonstrates multiple test cases.

---

## Notes

- The solution handles empty strings and single-character strings.
- For multiple palindromes of the same maximum length, any one valid palindrome may be returned.

---
