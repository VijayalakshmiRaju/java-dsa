# Count Set Bits in an Integer

## Problem Statement
Given a non-negative integer `n`, determine how many bits are set to `1` in its binary representation.  
This operation is also known as finding the **Hamming Weight** of a number.

---

## Approach
We use **bitwise AND (`&`)** and **right shift (`>>`)** operations to count set bits.

### Steps:
1. Initialize a variable `count = 0`.  
2. While `n` is not `0`:  
   - Increment `count` if `(n & 1)` is `1`.  
   - Right shift `n` by 1 (`n >>= 1`) to check the next bit.  
3. Continue until all bits are processed.  
4. Return `count`.

### Example:
For `n = 13` → binary representation: `1101`

| Step | n (Binary) | n & 1 | Count |
|------|-------------|-------|--------|
| 1 | 1101 | 1 | 1 |
| 2 | 110 | 0 | 1 |
| 3 | 11 | 1 | 2 |
| 4 | 1 | 1 | 3 |

**Total Set Bits = 3**

---

## Complexity Analysis

| Operation | Complexity |
|------------|-------------|
| **Time Complexity** | O(log n) → Each bit is processed once |
| **Space Complexity** | O(1) → Constant extra space used |

---

## Notes
- Works correctly for both **positive** and **negative** integers (due to bitwise nature).  
- This approach is simple but can be optimized using **Brian Kernighan’s Algorithm**, which reduces iterations when `n` has few set bits.
