# Longest Substring Without Repeating Characters

This Java program finds the **length of the longest substring without repeating characters** using the **Sliding Window** technique.  
It efficiently handles edge cases and works in **O(n)** time complexity.

---

## Problem Description

Given a string `s`, find the **length of the longest substring** that contains **no repeating characters**.

### Example
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

---

## Approach — Sliding Window Technique

The algorithm uses two pointers (`left` and `right`) to represent a **sliding window** over the string.

- Use an integer array to track the **last index** where each character was seen.
- Move the `right` pointer through the string:
  - If a character is repeated and its last occurrence is within the window,  
    shift the `left` pointer to the next position after its previous occurrence.
- Calculate window length as `(right - left + 1)` and update the maximum found.

This ensures each character is processed at most twice (once by `right`, once by `left`).

---

## Example Walkthrough

### Input: `"pwwkew"`

| Step | Character | Left | Right | Window | Max Length |
|------|------------|-------|--------|----------|-------------|
| 1 | p | 0 | 0 | "p" | 1 |
| 2 | w | 0 | 1 | "pw" | 2 |
| 3 | w | 0→2 | 2 | "w" | 2 |
| 4 | k | 2 | 3 | "wk" | 2 |
| 5 | e | 2 | 4 | "wke" | 3 |
| 6 | w | 2→3 | 5 | "kew" | 3 |

**Output:** 3

---

## Test Cases

| # | Input | Expected Output | Explanation |
|---|--------|-----------------|-------------|
| 1 | `"abcabcbb"` | 3 | "abc" |
| 2 | `"bbbbb"` | 1 | "b" |
| 3 | `"pwwkew"` | 3 | "wke" |
| 4 | `"au"` | 2 | "au" |
| 5 | `"abba"` | 2 | "ab" or "ba" |
| 6 | `"abcdef"` | 6 | All unique |
| 7 | `"a1b2c3a1"` | 6 | "1b2c3a" |
| 8 | `"xxabcdeffghxx"` | 7 | "xabcdef" |
| 9 | `"xxabcdefgxx"` | 8 | "xabcdefg" |
| 10 | `""` | 0 | Empty string |

---

## Complexity Analysis

| Complexity Type | Description | Big-O |
|-----------------|--------------|-------|
| **Time Complexity** | Each character is visited at most twice | **O(n)** |
| **Space Complexity** | Extra space for ASCII array (size 128) | **O(1)** |

---

## How to Run

1. Save the Java file (e.g., `LongestSubstringWithoutRepeatingCharacters.java`)  
2. Compile the code:
   ```bash
   javac LongestSubstringWithoutRepeatingCharacters.java
   ```
3. Run the program
   ```bash
   java LongestSubstringWithoutRepeatingCharacters
   ```
