# Optimal Partition of String

## Problem Statement
Given a string `s`, partition it into the **minimum number of substrings** such that no character appears more than once in any substring.  

Return the **number of substrings** created.  

---

## Example

### Input  
`s = "abac"`

### Process  
- `"ab"` → contains unique chars  
- `"a"` → duplicate found, start new substring  
- `"c"` → continue  

### Output  
`2`  

---

## Approach
- Use a **HashSet** to track characters in the current substring.  
- Iterate through the string character by character:  
  - If the character is already in the set, **start a new substring** (increment count and clear set).  
  - Otherwise, keep adding characters to the set.  
- Return the total count of substrings formed.  

---

## Algorithm Complexity

| Operation                     | Complexity |
|-------------------------------|------------|
| Iterating over string         | **O(n)**   |
| HashSet operations            | **O(1)**   |
| **Total Time Complexity**     | **O(n)**   |
| **Space Complexity**          | **O(26)** (at most 26 lowercase letters) |

---

## Edge Cases
- Empty string → `0` substrings  
- Single character string → `1` substring  
- All unique characters → `1` substring  
- All identical characters → `length of string` substrings  

---

## Test Cases

| Input | Expected Output | Explanation |
|-------|-----------------|-------------|
| `"abac"` | `2` | Partition: `"ab"`, `"ac"` |
| `"abcdef"` | `1` | All unique characters |
| `"aaaa"` | `4` | Each `"a"` must be separate |
| `"abab"` | `2` | Partition: `"ab"`, `"ab"` |
| `""` | `0` | Empty string |
| `"z"` | `1` | Single character |
| `"abcdefghijklmnopqrstuvwxyz"` | `1` | All unique characters |
| `"zzzzzzzz"` | `8` | Each `"z"` must be separate |
| `"abacabad"` | `4` | Partition: `"ab"`, `"ac"`, `"ab"`, `"ad"` |

---

## How to Run
1. Save the code in `OptimalPartitionOfString.java`.  
2. Compile:  
   ```bash
   javac OptimalPartitionOfString.java
   ```
3. Run:
   ```bash
   java OptimalPartitionOfString
   ```
