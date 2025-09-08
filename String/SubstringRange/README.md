# Substring Range Problem

This folder contains the implementation of finding a **Substring Range** in Java:
- Naive (Brute Force) method
- Optimized HashMap method

The algorithm extracts the smallest substring of `s1` that spans from the **first occurrence** of any character in `s2` to the **last occurrence** of any character in `s2`.

---

## Problem Statement

Given two strings `s1` and `s2`, find the substring of `s1` that starts at the **minimum index** of any character of `s2` in `s1` and ends at the **maximum index** of any character of `s2` in `s1`.

If none of the characters of `s2` are present in `s1`, return an empty string.

## Algorithm

### Naive Approach
1. For each character in `s2`, scan through `s1` to find its **first occurrence**.
2. Track the **minimum index** and **maximum index** among all found characters.
3. Return the substring from `minIdx` to `maxIdx`.

### HashMap Approach
1. Preprocess `s1` by storing each character’s indices in a **HashMap**.
2. For each character in `s2`, get its **first occurrence index** directly from the map.
3. Track the minimum and maximum indices.
4. Return the substring from `minIdx` to `maxIdx`.

---

## Time and Auxiliary Space (extra space used)

| Approach      | Time Complexity     | Auxiliary Space | Explanation |
|---------------|---------------------|-----------------|-------------|
| Naive         | O(|s1| x |s2|)      | O(1)            | For each char of `s2`, scans entire `s1`. |
| HashMap       | O(|s1| + |s2|)      | O(|s1|)         | Preprocessing with HashMap, then direct lookup. |

---

## Test Cases

| **s1**           | **s2**   | **Output**   | **Explanation** |
|-------------------|----------|--------------|-----------------|
| PROGRAMMING       | GIR      | ROGRAMMI     | First R=1, G=2, I=8 → substring(1–8) |
| ABCDEFGH          | ACE      | ABCDE        | A=0, C=2, E=4 → substring(0–4) |
| HELLOWORLD        | XYZ      | ""           | No common characters → empty string |
| HELLO             | H        | H            | Only H at index 0 → substring(0–0) |
| BANANA            | AN       | ANA          | A=1, N=2 → substring(1–3) |
| COMPUTER          | TOOT     | OMPUT        | O=1, T=6 → substring(1–6) |
| JAVA              | JAVA     | JAVA         | J=0, A=3 → substring(0–3) |

---

## Files
- `SubstringRange.java` – Java file with both naive and optimized implementations.
