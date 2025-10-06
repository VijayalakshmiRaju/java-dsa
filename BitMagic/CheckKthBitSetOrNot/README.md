# Check Kth Bit Set or Not

## Problem Statement
Given an integer `n` and an integer `k`, determine whether the **k-th bit** (0-based index) in the binary representation of `n` is **set (1)** or **not set (0)**.

### Example
Input: n = 5, k = 2
Binary representation: 101
Output: true (since the 2nd bit from the right is 1)

---

## Approach

Each integer in binary consists of bits (0 or 1).  
The **k-th bit** represents the value `2^k` in binary form.

To check whether the k-th bit is set:
1. Left-shift `1` by `k` positions → `(1 << k)`
2. Perform bitwise AND with `n` → `(n & (1 << k))`
3. If the result is not zero → the k-th bit is set.

---

### Example Walkthrough

For `n = 5 (binary: 101)` and `k = 1`:

| Expression | Binary | Result |
|-------------|---------|--------|
| `1 << k` | `010` | Shifts 1 left by 1 position |
| `n & (1 << k)` | `101 & 010 = 000` | Bit is not set |
| Output |  | `false` |

---

#### Output
Number: 5 (Binary: 101)
Is 0th bit set? true
Is 1st bit set? false
Is 2nd bit set? true


## Time and Space Complexities

| Complexity Type | Description | Complexity |
|------------------|-------------|-------------|
| **Time Complexity** | Only one bitwise AND (`&`) and one left shift (`<<`) operation are performed, making it independent of input size. | **O(1)** |
| **Space Complexity** | No additional data structures or memory used apart from a few variables. | **O(1)** |

---

## Key Takeaways
- Efficient, constant-time solution using bitwise operators.
- Avoids unnecessary conversions to binary strings.
- Works for positive and negative integers.
- Demonstrates understanding of **bit masking** and **bitwise operations** in Java.

---
