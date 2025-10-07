# Power of Two

## Problem Statement
Determine whether a given integer is a **power of two** using **bit manipulation**.  
A number is considered a power of two if it has **exactly one bit set to 1** in its binary representation.

For example:
- 1 → 2⁰  
- 2 → 2¹  
- 4 → 2²  
- 8 → 2³  
- 3 → not a power of two  

---

## Approach

We use a **bitwise trick** to identify powers of two efficiently.

### Key Idea
For any positive integer `n`:
n & (n - 1) == 0 → means n is a power of two


### Why it works
- A power of two has only **one bit set** in its binary form.  
  Example: `8 → 1000`
- Subtracting 1 flips all bits **after** the rightmost set bit.  
  `8 - 1 = 7 → 0111`
- Performing `n & (n - 1)` gives `0000` only for powers of two.

To ensure correctness, we also check `n > 0` since powers of two are **positive** numbers.

---

## Algorithm Steps
1. Check if `n` is greater than 0.  
2. Perform bitwise AND: `(n & (n - 1))`.  
3. If the result is `0`, then `n` is a power of two.  
4. Otherwise, it is not.

---

## Example Run

| Input | Binary | n - 1 | n & (n - 1) | Output | Explanation |
|--------|---------|--------|--------------|----------|--------------|
| 1 | 0001 | 0000 | 0000 | true | 1 = 2⁰ |
| 2 | 0010 | 0001 | 0000 | true | 2 = 2¹ |
| 3 | 0011 | 0010 | 0010 | false | multiple bits set |
| 8 | 1000 | 0111 | 0000 | true | 8 = 2³ |
| 0 | 0000 | — | — | false | not positive |
| -8 | — | — | — | false | negative number |

---

## Code Overview

```java
return (n > 0) && ((n & (n - 1)) == 0);
```

### Breakdown

(n > 0) → ensures only positive numbers are considered
(n & (n - 1)) == 0 → verifies that only one bit is set

## Edge Cases

| **Input** | **Expected Output** | **Explanation** |
|------------|---------------------|------------------|
| `0` | `false` | Zero is **not** a power of two because no positive power of 2 equals 0. |
| `1` | `true` | `1 = 2⁰`, hence it is a valid power of two. |
| `2` | `true` | `2 = 2¹`, exactly one set bit. |
| `3` | `false` | Binary representation `11` has two set bits. |
| `4` | `true` | `4 = 2²`, one set bit in binary `100`. |
| `-2` | `false` | Negative numbers are **not** considered powers of two. |
| `Integer.MAX_VALUE (2147483647)` | `false` | Not a perfect power of two. |
| `Integer.MIN_VALUE (-2147483648)` | `false` | Although binary has one bit set, it’s **negative**, so not valid. |
| Large values near power of two | `false` | Example: `1023` is just below `1024 (2¹⁰)` but not an exact power of two. |

---

## Complexity Analysis

| **Operation** | **Description** | **Time Complexity** | **Space Complexity** |
|----------------|-----------------|----------------------|----------------------|
| Bitwise AND (`n & (n - 1)`) | Checks if only one bit is set | **O(1)** | **O(1)** |
| Comparison (`n > 0`) | Ensures only positive numbers are valid | **O(1)** | **O(1)** |
| Overall | Constant-time and space operation | **O(1)** | **O(1)** |

**Summary:**  
The algorithm runs in **constant time** with **no extra memory usage**, making it highly efficient for all integer values.
