# Problems Solved Using Bitwise Operators

## Problem Statement
This program demonstrates common **bitwise operations** used to manipulate specific bits of an integer in Java.  
It includes methods to:
- **Set (turn ON)** a bit  
- **Unset (turn OFF)** a bit  
- **Check** if a specific bit is set  
- **Toggle (flip)** a bit
- Multiplying and dividing numbers using bit shifts
- Swapping two numbers using XOR (without a temporary variable)  

These operations are performed using efficient bit-level logic that directly interacts with binary representation of numbers.

---

## Concepts Covered

1. **Bitwise Left Shift (`<<`)** – Shifts bits left, used to create bit masks.  
   Example: `1 << (k - 1)` places a single `1` at the k-th bit position.

2. **Bitwise OR (`|`)** – Sets a bit to `1` if either operand’s bit is `1`.  
   Used to **set** bits.

3. **Bitwise AND (`&`)** – Keeps a bit `1` only if both operands have `1` in that position.  
   Used to **check** or **unset** bits.

4. **Bitwise XOR (`^`)** – Flips (toggles) bits where bits differ.  
   Used to **invert** or **toggle** a specific bit.

5. **Bitwise NOT (`~`)** – Inverts all bits (0 → 1 and 1 → 0).  
   Used when we need to clear a particular bit.

6. **Bitwise Right Shift (`>>`)** – Moves bits right, effectively dividing by powers of two.  
   Used for bit position checking.

---

## Operations and Their Purpose

| Operation | Description | Formula / Bitwise Logic |
|------------|--------------|--------------------------|
| Set Bit | Turns ON the k-th bit | `num | (1 << (k - 1))` |
| Unset Bit | Turns OFF the k-th bit | `num & ~(1 << (k - 1))` |
| Check Bit | Checks if k-th bit is 1 | `(num & (1 << (k - 1))) != 0` |
| Toggle Bit | Flips the k-th bit | `num ^ (1 << (k - 1))` |
| Multiply by 2 | Shifts bits left by 1 | `num << 1` |
| Divide by 2 | Shifts bits right by 1 | `num >> 1` |
| Swap Numbers | Uses XOR logic | `a ^= b; b ^= a; a ^= b;` |
| **Flip Bits** | Flips all bits within an n-bit range using `(1 << n) - 1 - num`. |
| **Find log₂(num)** | Calculates floor(log₂(num)) by repeated right shifting. |

---

## Approach Breakdown

### 1. **Set a Bit**
Turns ON the k-th bit of a number.  
Steps:
- Create mask `1 << (k - 1)`  
- Perform OR operation → `num | mask`  
Result: The k-th bit is always set to `1`.

---

### 2. **Unset a Bit**
Turns OFF the k-th bit of a number.  
Steps:
- Create mask `1 << (k - 1)`  
- Invert the mask using `~mask`  
- Perform AND operation → `num & (~mask)`  
Result: The k-th bit becomes `0`, others remain unchanged.

---

### 3. **Check if k-th Bit is Set**
Checks whether the k-th bit of a number is `1`.  
Steps:
- Create mask `1 << (k - 1)`  
- Perform AND operation → `(num & mask)`  
- If result > 0 → bit is set; otherwise not.

---

### 4. **Toggle a Bit**
Flips (inverts) the k-th bit of a number.  
Steps:
- Create mask `1 << (k - 1)`  
- Perform XOR operation → `num ^ mask`  
Result: The k-th bit is flipped (1 → 0 or 0 → 1).

---

### 5. **Multiply by Two**
Doubles the number using a left shift.

**Steps:**
- Shift bits left by 1 → `num << 1`  

**Result:**  
Equivalent to `num * 2`.

---

### 6. **Divide by Two**
Halves the number using a right shift.

**Steps:**
- Shift bits right by 1 → `num >> 1`  

**Result:**  
Equivalent to `num / 2` (integer division).

---

### 7. **Swap Two Numbers Without Temporary Variable**
Uses XOR to exchange two values without extra memory.

**Steps:**
num1 = num1 ^ num2
num2 = num2 ^ num1
num1 = num1 ^ num2

**Result:**  
`num1` and `num2` swap their values.

---

### 8. **Flip All Bits (Within n-bit Representation)**

Flips all bits (1→0, 0→1) of a number **within a specified bit range**.

**Logic:**
- Create a mask with all bits set to 1 for `n` bits → `(1 << n) - 1`  
  Example: For `n = 4`, `(1 << 4) - 1 = 15` → Binary: `1111`
- Subtract the number from this mask → `allOnes - num`

**Example:**
num = 5 → Binary: 0101
n = 4
allOnes = 1111 (15)
Result = 1111 - 0101 = 1010 → 10

---

### 9. **log₂(num)**
Repeatedly divide (right shift) until number becomes 0.  
Each shift counts as dividing by 2.

---

## Complexity Analysis

| Operation | Time Complexity | Space Complexity | Explanation |
|------------|-----------------|------------------|--------------|
| `setBit()` | O(1) | O(1) | Uses one left shift and one OR operation |
| `unsetBit()` | O(1) | O(1) | Uses one left shift, NOT, and AND operation |
| `isKthBitSet()` | O(1) | O(1) | Uses one left shift and one AND operation |
| `toggleKthBit()` | O(1) | O(1) | Uses one left shift and one XOR operation |
| `multiplyByTwo()` | O(1) | O(1) | Uses left shift |
| `divideByTwo()` | O(1) | O(1) | Uses right shift |
| `swapNumbers()` | O(1) | O(1) | Uses XOR logic without temporary variable |
| `flipBits()` | O(1) | O(1) | Creates an all-ones mask `(1 << n) - 1` and subtracts the number to flip all bits |
| `log2()` | O(log n) | O(1) | Repeatedly right shifts until the number becomes zero, counting steps |

---

## Example Explanation

| Operation | Input (num, k) | Binary Before | Binary After | Result |
|------------|----------------|----------------|----------------|----------|
| `setBit(5, 2)` | (5, 2) | 0101 | 0111 | 7 |
| `unsetBit(15, 4)` | (15, 4) | 1111 | 0111 | 7 |
| `isKthBitSet(5, 3)` | (5, 3) | 0101 | Bit at position 3 is 1 | true |
| `toggleKthBit(9, 1)` | (9, 1) | 1001 | 1000 | 8 |
| `multiplyByTwo(8)` | (8) | 1000 | 10000 | 16 |
| `divideByTwo(8)` | (8) | 1000 | 100 | 4 |
| `swapNumbers(4, 7)` | (4, 7) | 0100, 0111 | 0111, 0100 | Swapped |
| `flipBits(5, 4)` | (5, 4) | 0101 | 1010 → (1111 - 0101) | 10 |
| `log2(16)` | (16) | 10000 | Divide by 2 → 4 times | 4 |

---

## Key Takeaways
- Bitwise operations are **fast** (constant time) and operate directly on binary representation.  
- They are commonly used in:
  - **Flags and status registers**
  - **Compression algorithms**
  - **Cryptography**
  - **Low-level system programming**
  - **Game development** and **hardware interfacing**
- Understanding these helps in **writing efficient, memory-friendly, and performance-optimized code**.

---
