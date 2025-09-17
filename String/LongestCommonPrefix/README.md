# Longest Common Prefix Problem

This folder contains the **Java implementation** of the **Longest Common Prefix** problem using the **Vertical Scanning** approach, which is considered one of the most optimal solutions in terms of **time** and **space**.

---

## Problem Statement

Given an array of strings `strs`, find the **longest common prefix string** amongst all the strings.

If there is no common prefix, return an empty string `""`.

---

### Example 1
**Input:**  
`strs = ["flower","flow","flight"]`  

**Output:**  
`"fl"`

---

### Example 2
**Input:**  
`strs = ["dog","racecar","car"]`  

**Output:**  
`""`  

**Explanation:**  
There is no common prefix among these strings.

---

## Approach (Vertical Scanning)

1. **Pick the first string** as a reference.
2. **Iterate character by character** through the first string.
3. For each character position:
   - Compare it with the corresponding character in all other strings.
   - If a mismatch is found or any string ends → **return the prefix found so far**.
4. If no mismatch is found → return the entire first string.

This approach **stops early** as soon as a mismatch is found, making it efficient.

---

## Time & Space Complexity

| Complexity | Analysis |
|-----------|----------|
| **Time**  | **O(n × m)** in worst case <br>• `n` = number of strings <br>• `m` = length of the shortest string <br>• Best case: `O(n)` if mismatch is found at first character |
| **Space** | **O(1)** extra space (uses only a `StringBuilder` for building the prefix) |

---

## Example Output (with Test Cases)

```text
=== Longest Common Prefix Test Cases ===
Test Case 1: [flower, flow, flight]        → Longest Common Prefix: "fl"
Test Case 2: [dog, racecar, car]           → Longest Common Prefix: ""
Test Case 3: [interspecies, interstellar, interstate] → Longest Common Prefix: "inters"
Test Case 4: [throne, throne]              → Longest Common Prefix: "throne"
Test Case 5: [prefix]                      → Longest Common Prefix: "prefix"
Test Case 6: []                            → Longest Common Prefix: ""
