# Isomorphic Strings

This folder contains the **Java implementation** of the **Isomorphic Strings** problem using an **optimized constant space approach** with two integer arrays.

---

## Problem Statement

Given two strings `s` and `t`, determine if they are **isomorphic**.

Two strings are isomorphic if the characters in `s` can be replaced to get `t`.

- All occurrences of a character must be replaced with the **same character**.
- The order of characters must be preserved.
- No two characters may map to the same character, but a character may map to itself.

---

### Example 1
**Input:**  
`s = "egg", t = "add"`

**Output:**  
`true`

**Explanation:**  
Mapping `e → a` and `g → d` transforms `egg` → `add`.

---

### Example 2
**Input:**  
`s = "foo", t = "bar"`

**Output:**  
`false`

**Explanation:**  
`o` would need to map to both `a` and `r`, which is not allowed.

---

## Approach (Optimized with Arrays)

1. Use **two integer arrays of size 256** (`mpS1`, `mpS2`) to store the **last seen positions** of each character from `s` and `t`.
2. Iterate through both strings simultaneously:
   - If the last seen positions of `s[i]` and `t[i]` differ → return `false`.
   - Otherwise, update their positions with the current index (i+1).
3. If the loop completes without conflicts, return `true`.

This approach ensures **one-to-one mapping consistency** and runs in linear time.

---

## Complexity Analysis

| Complexity | Analysis |
|-----------|-----------|
| **Time**  | **O(n)** – Iterate through both strings once (`n` = length of string). |
| **Space** | **O(1)** – Two arrays of size 256 (constant memory, independent of input size). |

---

## Example Output

```text
=== Isomorphic String Test Cases ===
Input: s1 = "egg"     | s2 = "add"     → Isomorphic? true
Input: s1 = "foo"     | s2 = "bar"     → Isomorphic? false
Input: s1 = "paper"   | s2 = "title"   → Isomorphic? true
Input: s1 = "badc"    | s2 = "baba"    → Isomorphic? false
Input: s1 = ""        | s2 = ""        → Isomorphic? true
Input: s1 = "a"       | s2 = "a"       → Isomorphic? true
Input: s1 = "ab"      | s2 = "aa"      → Isomorphic? false
Input: s1 = "abc"     | s2 = "xyz"     → Isomorphic? true
Input: s1 = "abc"     | s2 = "xyy"     → Isomorphic? false
Input: s1 = "aab"     | s2 = "xxy"     → Isomorphic? true
