# Longest Even-Odd Subarray (Naive Approach)

## Problem Statement
Given an integer array, find the length of the longest subarray where elements strictly alternate between even and odd numbers.

If no such alternating subarray exists (for example, all elements are even or all are odd), return 0.

---

## Example
**Input:**  
[10, 12, 14, 7, 8]

**Explanation:**  
The longest alternating sequence is [14, 7, 8]  
Alternation pattern: Even → Odd → Even

**Output:**  
3

---

## Approach (Naive - O(n²))
1. Iterate through every possible starting index `i`.
2. For each starting point, move forward with index `j` while the even-odd pattern continues.
3. If two consecutive elements have opposite parity, increase the count.
4. Stop when the pattern breaks.
5. Track the maximum alternating subarray length found.
6. If no alternation exists, return 0.

---

## Logic Summary

| Condition | Meaning |
|------------|----------|
| (arr[j-1] % 2 == 0 && arr[j] % 2 != 0) | Even → Odd transition |
| (arr[j-1] % 2 != 0 && arr[j] % 2 == 0) | Odd → Even transition |
| Otherwise | Pattern breaks |

---

## Sample Output

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
Test Case 12: [2, 3, 5, 7, 8, 10, 11, 12, 13] → Longest Alternating Subarray Length = 7


---

## Time and Space Complexity

| Complexity Type | Value | Explanation |
|-----------------|--------|-------------|
| Time Complexity | O(n²) | Two nested loops (i, j) |
| Space Complexity | O(1) | Constant extra space used |

---

## Edge Cases Covered

| Case | Example | Expected Output |
|------|----------|----------------|
| All even numbers | [2, 4, 6, 8] | 0 |
| All odd numbers | [1, 3, 5] | 0 |
| Empty array | [] | 0 |
| Single element | [2] | 0 |
| Two alternating elements | [1, 2] | 2 |
| Perfect alternation | [1, 2, 3, 4, 5] | 5 |
| Alternation breaks midway | [10, 12, 14, 7, 8] | 3 |

---
