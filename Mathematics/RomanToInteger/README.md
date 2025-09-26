# Roman to Integer Conversion

This project provides a Java implementation to convert **Roman numerals** into their corresponding **integer (decimal) values**.  

---

## Problem Statement
Given a string representing a **Roman numeral**, convert it to an **integer**.  

Roman numerals are based on seven symbols:

| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

---

## Approach

- Traverse the Roman numeral **from right to left**.
- Keep track of the **previous numeral value**.
- If the current numeral is **less than** the previous one, subtract it from the total.  
- Otherwise, add it to the total and update the previous value.  

This approach naturally handles **subtractive notation** cases such as:
- `IV` = 4 (`5 - 1`)
- `IX` = 9 (`10 - 1`)
- `XL` = 40 (`50 - 10`)
- `CM` = 900 (`1000 - 100`)

---

## Example Walkthrough

**Input:** `"MCMXCIV"`  

Step-by-step:
- Start from last symbol: `V (5)` → total = 5  
- `I (1)` < `5` → subtract → total = 4  
- `C (100)` > `5` → add → total = 104  
- `X (10)` < `100` → subtract → total = 94  
- `M (1000)` > `100` → add → total = 1094  
- `C (100)` < `1000` → subtract → total = 994  
- `M (1000)` > `100` → add → total = 1994  

**Output:** `1994`

---

## Test Cases

| Roman Numeral | Integer |
|---------------|---------|
| I             | 1       |
| III           | 3       |
| IV            | 4       |
| IX            | 9       |
| LVIII         | 58      |
| MCMXCIV       | 1994    |
| MMMCMXCIX     | 3999    |
| XL            | 40      |
| XC            | 90      |
| CD            | 400     |
| CM            | 900     |

---

## Time and Space Complexity

| Operation        | Complexity |
|------------------|------------|
| Time Complexity  | **O(n)** (n = length of Roman numeral string) |
| Space Complexity | **O(1)** (only a fixed map of 7 symbols is used) |

---

## Notes
- This solution assumes the input Roman numeral is **valid**.  
- Validation for invalid numerals (e.g., `"IIII"`, `"VV"`, `"IC"`) can be added if required.  
