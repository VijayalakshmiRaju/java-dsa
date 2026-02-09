# Find All Anagrams in a String (Sliding Window)

## Overview

This project implements an efficient solution to find all starting indices of anagrams of a pattern string `p` inside a given string `s`. The solution uses the Sliding Window technique combined with a frequency array to achieve optimal performance.

---

## Problem Statement

Given two strings `s` and `p`, return all start indices of `p`’s anagrams in `s`.

An anagram is a rearrangement of characters. The order of indices in the result does not matter.

---

## Approach

The solution uses a fixed-size sliding window of length equal to `p.length()`.

Key ideas:

- Maintain a frequency array for characters in `p`.
- Use two pointers (`i` and `j`) to represent the sliding window.
- Track how many characters are still needed using a `count` variable.
- When the window size matches the pattern length and `count` becomes zero, an anagram is found.
- Slide the window by adding the next character and removing the leftmost character.

This approach avoids recalculating frequencies for each window, making it efficient for large inputs.

---

## Time and Space Complexity

- Time Complexity: O(n), where n is the length of string `s`.
- Space Complexity: O(1), since the frequency array has a fixed size of 26.

---

## Test Cases Covered

The implementation has been tested with:

- Strings containing multiple overlapping anagrams
- Strings with no anagrams
- Single-character strings
- Repeated characters
- Large repeating patterns

---

## Key Concepts Used

- Sliding Window (Fixed Window Size)
- Frequency Counting
- Two Pointer Technique
- Array-based Hashing for characters

---

## Notes

This solution is optimized for competitive programming and technical interviews. It avoids nested loops and repeated recomputation, making it scalable for large constraints.

---
