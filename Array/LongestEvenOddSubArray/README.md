# Longest Even-Odd Subarray

## Problem Statement
Given an integer array, find the length of the longest contiguous subarray in which elements strictly alternate between even and odd numbers.

If no such alternating subarray exists (for example, if all numbers are even or all are odd), return 0.

---

## Example
**Input:**  
[10, 12, 14, 7, 8]

**Explanation:**  
The longest alternating sequence is [14, 7, 8]  
Pattern: Even → Odd → Even

**Output:**  
3

---

## Approaches

### 1. Naive Approach (O(n²))
- For every starting index `i`, expand the subarray forward using index `j`.
- Continue expanding while consecutive elements have opposite parity (even/odd alternation).
- Track the length of the longest alternating subarray found.
- If no alternation exists, return 0.

**Steps:**
1. Outer loop picks the starting element.
2. Inner loop expands forward until alternation breaks.
3. Maintain the maximum count found.
4. Return 0 if the longest count is only 1 (no alternation).

---

### 2. Optimized Approach (O(n))
- Traverse the array once, checking if consecutive elements alternate.
- If they do, increment the current alternating length.
- Otherwise, reset the current length to 1.
- Track the maximum length throughout.
- Return 0 if the final maximum length is only 1.

**Steps:**
1. Initialize `curLen = 1` and `maxLen = 1`.
2. For each pair `(arr[i-1], arr[i])`, check if parity differs.
3. If alternating → increment `curLen`.
4. Else → update `maxLen` and reset `curLen`.
5. Finally, return `maxLen` (or 0 if no alternation).

---

## Logic Summary

| Condition | Description |
|------------|--------------|
| (arr[j-1] % 2 == 0 && arr[j] % 2 != 0) | Even → Odd transition |
| (arr[j-1] % 2 != 0 && arr[j] % 2 == 0) | Odd → Even transition |
| Otherwise | Pattern breaks |

---

## Sample Test Outputs

---- Longest Even-Odd Subarray Length ----

Test Case 1: [10, 12, 14, 7, 8] → Longest Alternating Subarray Length = 3
Test Case 2: [7, 10, 13, 14, 15] → Longest Alternating Subarray Length = 5
Test Case 3: [10, 12, 14, 16] → Longest Alternating Subarray Length = 0
Test Case 4: [1, 3, 5, 7, 9] → Longest Alternating Subarray Length = 0
Test Case 5: [5, 10, 20, 6, 3, 8] → Longest Alternating Subarray Length = 3
Test Case 6: [1, 2] → Longest Alternating Subarray Length = 2
Test Case 7: [2, 4] → Longest Alternating Subarray Length = 0
Test Case 8: [2] → Longest Alternating Subarray Length = 0
Test Case 9: [] → Longest Alternating Subarray Length = 0
Test Case 10: [2, 3, 4, 5, 6, 7, 8, 9] → Longest Alternating Subarray Length = 8
Test Case 11: [1, 2, 3, 4, 5, 6] → Longest Alternating Subarray Length = 6
Test Case 12: [2, 3, 5, 7, 8, 10, 11, 12, 13]→ Longest Alternating Subarray Length = 7


---

## Time and Space Complexity

| Approach | Time Complexity | Space Complexity | Explanation |
|-----------|-----------------|------------------|--------------|
| Naive | O(n²) | O(1) | Nested loops for every start and end |
| Optimized | O(n) | O(1) | Single-pass tracking of current streak |

---

## Edge Cases Covered

| Case | Example | Expected Output |
|------|----------|----------------|
| All even numbers | [2, 4, 6, 8] | 0 |
| All odd numbers | [1, 3, 5, 7] | 0 |
| Empty array | [] | 0 |
| Single element | [2] | 0 |
| Two alternating numbers | [1, 2] | 2 |
| Alternation breaks midway | [5, 10, 20, 6, 3, 8] | 3 |
| Perfect alternation | [1, 2, 3, 4, 5, 6] | 6 |

---

## Output Convention
- If the array has no alternating pair, output is **0**.
- Otherwise, the length of the longest alternating subarray is displayed.
- The output is formatted as:  
  `Test Case X: [array] → Longest Alternating Subarray Length = Y`

---
