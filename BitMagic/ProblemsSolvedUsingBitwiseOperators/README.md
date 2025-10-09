# Problems Solved Using Bitwise Operators

## Problem Statement
This program demonstrates how to **set (turn ON)** and **unset (turn OFF)** specific bits in a number using **bitwise operators** in Java.  
Bitwise operations enable direct manipulation of binary bits, allowing efficient control over data representation and computation at the hardware level.

---

## Concepts Covered
1. **Bitwise Left Shift (`<<`)** – Shifts bits to the left, effectively multiplying by powers of two. Commonly used to create bit masks.  
2. **Bitwise OR (`|`)** – Sets a bit to `1` if either operand has a `1` in that position. Used to **set** bits.  
3. **Bitwise AND (`&`)** – Sets a bit to `1` only if both operands have a `1` in that position. Used to **retain** bits selectively.  
4. **Bitwise NOT (`~`)** – Flips all bits; `0` becomes `1` and `1` becomes `0`. Often used for **bit clearing** operations.

---

## Approach Breakdown

### 1. **Setting a Bit**
To turn ON the k-th bit of a number:
- Create a mask using `1 << (k - 1)` which positions a single `1` at the target bit position.
- Perform a bitwise OR (`|`) between the number and mask.
- This ensures the bit at position `k` becomes `1`, without affecting other bits.

### 2. **Unsetting a Bit**
To turn OFF the k-th bit of a number:
- Create a mask using `1 << (k - 1)`.
- Invert the mask using `~mask` so that the k-th bit becomes `0` and all others remain `1`.
- Perform a bitwise AND (`&`) with the number.
- This clears (sets to 0) the desired bit.

---

## Complexity Analysis

| Operation | Time Complexity | Space Complexity | Explanation |
|------------|-----------------|------------------|--------------|
| `setBit()` | O(1) | O(1) | Involves one shift and one OR operation |
| `unsetBit()` | O(1) | O(1) | Involves one shift, one NOT, and one AND operation |

---

## Example Explanation

| Operation | Input (num, k) | Binary Before | Binary After | Result |
|------------|----------------|----------------|----------------|----------|
| `setBit(5, 2)` | (5, 2) | 0101 | 0111 | 7 |
| `unsetBit(15, 4)` | (15, 4) | 1111 | 0111 | 7 |

---

## Key Takeaways
- Bitwise operations are **fast and memory-efficient**, directly interacting with hardware bits.  
- Essential for systems where performance and memory optimization are crucial, such as:
  - Embedded systems  
  - Cryptography  
  - Graphics programming  
  - Competitive programming problems involving binary logic  
- Understanding bitwise operations builds strong **low-level programming** intuition.

---
