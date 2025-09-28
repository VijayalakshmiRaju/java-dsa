# Merge String Alternatively

## Problem Statement
Given two strings `s1` and `s2`, merge them **alternatively** such that characters from both strings appear one after another.  
If one string is longer than the other, the remaining characters from the longer string are appended at the end.

---

## Approach
1. Use a **`StringBuilder`** to efficiently build the result string.
2. Iterate through the **combined length** of both strings.
3. Append the character from `s1` if available.
4. Append the character from `s2` if available.
5. Return the merged result.

---

## Example

### Example 1
**Input**:  
`s1 = "abc"`  
`s2 = "xyz"`  

**Output**:  
`axbycz`

---

### Example 2
**Input**:  
`s1 = "abcd"`  
`s2 = "xy"`  

**Output**:  
`axbycd`

---

### Example 3
**Input**:  
`s1 = "hi"`  
`s2 = "world"`  

**Output**:  
`hwiorld`

---

## Edge Cases
- One string empty (`s1=""`, `s2="hello"` → `"hello"`)
- Both strings empty (`"" + ""` → `""`)
- Strings with single characters (`"A", "B"` → `"AB"`)
- Special characters and digits (`"123", "!@#"` → `"1!2@3#"`)

---

## Time and Space Complexity

| Operation        | Complexity |
|------------------|-------------|
| Iteration        | **O(n + m)** (where n = length of `s1`, m = length of `s2`) |
| Appending result | **O(n + m)** |
| Space Complexity | **O(n + m)** (for result storage) |

---

## How to Run
1. Save the file as `MergeStringAlternatively.java`.
2. Compile the program:
   ```bash
   javac MergeStringAlternatively.java
   ```
3. Run the program:
   ```bash
   java MergeStringAlternatively
   ```
---
