# Reverse Vowels of a String

## Problem Statement
Given a string, reverse only the vowels (a, e, i, o, u, both lowercase and uppercase).  
All other characters should remain in their original position.

---

## Approach

- Use the **two-pointer technique**:
  - One pointer starts from the left, the other from the right.
  - Move each pointer until a vowel is found.
  - Swap the vowels and move both pointers inward.
- This ensures vowels are reversed while consonants and symbols remain untouched.
- Time Complexity: **O(n)**
- Space Complexity: **O(n)** (due to character array conversion).

---

## Complexity Analysis

| Operation           | Complexity | Explanation |
|---------------------|------------|-------------|
| Time Complexity     | **O(n)**   | Each character is checked at most once while scanning with two pointers. |
| Space Complexity    | **O(n)**   | A character array copy of the input string is used for in-place swaps. |

---

## Test Coverage

The program is tested against multiple scenarios:
- **Normal words** with mixed vowels and consonants.
- **Strings with no vowels** (remains unchanged).
- **Strings with only vowels** (completely reversed).
- **Mixed case sensitivity** (both uppercase and lowercase vowels are handled).
- **Single character strings** (vowel or consonant).
- **Empty string**.
- **Strings with spaces and punctuation**.
- **Palindrome cases**.
- **Sentences** with mixed characters.

---

## Running the Program

1. Save the file as **`ReverseVowelsOfString.java`**.
2. Compile:
   ```bash
   javac ReverseVowelsOfString.java
   ```
3. Run:
   ```bash
   java ReverseVowelsOfString
   ```
---
