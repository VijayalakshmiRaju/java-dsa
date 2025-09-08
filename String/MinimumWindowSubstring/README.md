# Minimum Window Substring Problem

This folder contains the implementation of the **Minimum Window Substring** problem in Java:
- **Naive (Brute Force) method**
- **Optimized Sliding Window method**

The goal is to find the **smallest substring** of `s` that contains all the characters of `t` (including duplicates).

---

## Problem Statement

Given two strings `s` and `t`, return the **minimum window substring** of `s` such that every character in `t` is included in the window.  
If no such substring exists, return an empty string `""`.

---

## Algorithm

### Naive Approach
1. Iterate through all possible substrings of `s`.
2. For each substring, check if it contains all characters of `t` with correct frequencies.
3. Track the smallest substring that satisfies the condition.
4. **Time Complexity:** `O(m^2 * n)` where `m` is the length of `s` and `n` is the length of `t`.

---

### Optimized Sliding Window Approach
1. Use two pointers (`left` and `right`) to maintain a sliding window over `s`.
2. Maintain a frequency count of characters in `t` using a hash array.
3. Expand the window by moving `right`, decreasing the frequency for matched characters.
4. Once all characters from `t` are matched, shrink the window by moving `left` to minimize size.
5. Keep track of the **smallest valid window**.
6. **Time Complexity:** `O(m + n)` (linear in both strings).  
   **Space Complexity:** `O(1)` since we only store character frequencies (constant size array of 128 for ASCII).

---

## Example

### Input
s = "ADOBECODEBANC"
t = "ABC"


### Output

Explanation: The smallest substring of `s` that contains `A`, `B`, and `C` is `"BANC"`.

---

## Files
- `MinimumWindowSubstring.java` → Contains **brute force** solution and optimized **sliding window** solution.

---

## Key Learning
- **Naive approach** is useful for understanding but inefficient for large inputs.
- **Sliding Window + Hashing** is the optimal strategy for substring search problems.
