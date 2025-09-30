# Hamming Weight (Number of 1 Bits)

## Problem Statement
The **Hamming Weight** of a number is defined as the number of `1`s in its binary representation.  
Given an integer `n`, the task is to count how many set bits (`1`s) it contains.

---

## Approach
We use **Brian Kernighan’s Algorithm** to count set bits efficiently.

- Key idea:  
  Each operation `n = n & (n - 1)` removes the **rightmost set bit** from `n`.
- The loop continues until `n` becomes `0`.
- The number of times this operation executes equals the total count of set bits.

---

## Example Walkthrough
For `n = 13` (binary `1101`):

1. `1101 & 1100 = 1100` (removed the last `1`)  
2. `1100 & 1011 = 1000` (removed another `1`)  
3. `1000 & 0111 = 0000` (removed last `1`)  

Total `3` set bits → **Hamming Weight = 3**

---

## Complexity Analysis

| Operation       | Complexity |
|-----------------|------------|
| Time Complexity | **O(k)**, where `k` is the number of set bits in `n` (worst-case `O(log n)`) |
| Space Complexity| **O(1)** (no extra space used) |

---

## Edge Cases Covered
- **n = 0** → result = 0  
- **n = 1 or 2** → exactly 1 set bit  
- **Power of 2 values** (e.g., 16, 32, etc.) → always 1 set bit  
- **Consecutive 1s** (e.g., 7 = `111`, 15 = `1111`) → multiple set bits  
- **Large values** like `Integer.MAX_VALUE` (31 set bits) and `Integer.MIN_VALUE` (1 set bit)  

---

## Sample Test Cases

| Input `n` | Binary Representation   | Output (Set Bits) |
|-----------|--------------------------|--------------------|
| 0         | 0000                     | 0 |
| 1         | 1                        | 1 |
| 2         | 10                       | 1 |
| 3         | 11                       | 2 |
| 4         | 100                      | 1 |
| 7         | 111                      | 3 |
| 15        | 1111                     | 4 |
| 16        | 10000                    | 1 |
| 31        | 11111                    | 5 |
| 1023      | 1111111111               | 10 |
| Integer.MAX_VALUE (2147483647) | 111...111 (31 ones) | 31 |
| Integer.MIN_VALUE (-2147483648) | 100...0 | 1 |

---

## Note
- In Java, integers are represented using **two’s complement** (32-bit signed).  
- The algorithm works correctly for both positive and negative numbers when using bitwise operations.

---
