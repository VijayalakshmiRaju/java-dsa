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

## Edge Cases Covered

| Case | Description | Expected Output |
|------|--------------|-----------------|
| n = 0 | No set bits | 0 |
| n = 1 | Single set bit | 1 |
| n = 2 | One `1` bit (`10`) | 1 |
| n = 7 | All bits set (`111`) | 3 |
| Power of 2 (e.g., 8, 16) | Only one `1` bit | 1 |
| Consecutive 1s (e.g., 15 = `1111`) | Multiple set bits | 4 |
| Large integer (e.g., 1023) | All lower bits set | 10 |
| Integer.MAX_VALUE | 2147483647 → `111...111` (31 ones) | 31 |
| Integer.MIN_VALUE | -2147483648 → `100...0` | 1 |

---

## Sample Test Cases

| Input (n) | Binary Representation | Output (Set Bits) |
|------------|-----------------------|-------------------|
| 0 | 0000 | 0 |
| 1 | 1 | 1 |
| 2 | 10 | 1 |
| 3 | 11 | 2 |
| 4 | 100 | 1 |
| 7 | 111 | 3 |
| 8 | 1000 | 1 |
| 15 | 1111 | 4 |
| 31 | 11111 | 5 |
| 1023 | 1111111111 | 10 |
| Integer.MAX_VALUE (2147483647) | 111...111 (31 ones) | 31 |
| Integer.MIN_VALUE (-2147483648) | 100...0 | 1 |

---

## Notes
- Works correctly for both **positive** and **negative** integers (due to bitwise nature).  
- This approach is simple but can be optimized using **Brian Kernighan’s Algorithm**, which reduces iterations when `n` has few set bits.
