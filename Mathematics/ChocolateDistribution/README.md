# Chocolate Distribution Problem

## Problem Statement

Ruhan invites **N friends** to a party.  
He already has **M chocolates** with him.  

He wants to distribute chocolates **evenly** among his friends such that:

- Each friend gets **at least one chocolate**.
- Ruhan can **make** (create) or **destroy** (remove) chocolates to adjust the total count.
- Making or destroying **1 chocolate takes exactly 1 second**.

Your task is to **find the minimum time (in seconds)** required to make the number of chocolates **evenly distributable** among all friends.

---

## Input

- `N` → Number of friends (`N > 0`)
- `M` → Number of chocolates (`M ≥ 0`)

---

## Output

- Minimum time (in seconds) required to make chocolates evenly distributable.

---

## Examples

### Example 1

**Input**
N = 4
M = 10


**Explanation**

- Ruhan has 10 chocolates and 4 friends.
- 10 % 4 = 2 → cannot distribute evenly.
- Two options:
  1. **Remove 2 chocolates** → Total becomes 8 (evenly divisible).
  2. **Add 2 chocolates** → Total becomes 12 (evenly divisible).
- Both take **2 seconds**, so **minimum time = 2**.

**Output**
2

---

### Example 2

**Input**
N = 3
M = 2


**Explanation**

- Ruhan has only 2 chocolates but needs at least 3 (1 per friend).
- Must **make 1 chocolate** → takes **1 second**.

**Output**
1


---

### Example 3

**Input**
N = 5
M = 9


**Explanation**

- 9 % 5 = 4 → remainder
- Option 1: **Remove 4 chocolates** → Total becomes 5
- Option 2: **Add (5-4)=1 chocolate** → Total becomes 10
- **Adding is cheaper (1 second)**

**Output**
1


---

## Approach

1. **If M < N** → Make `(N - M)` chocolates so that everyone gets at least one.
2. **If M ≥ N** →  
   - Find remainder: `balance = M % N`
   - If `balance == 0` → already evenly distributable → time = 0
   - Else:
     - Option 1: Destroy `balance` chocolates  
     - Option 2: Make `(N - balance)` chocolates  
     - Take the **minimum** of the two.

This ensures the least time is taken to make chocolates evenly distributable.

---

## Complexity Analysis

| Complexity Type      | Value       | Explanation |
|---------------------|-----------|-------------|
| **Time Complexity** | **O(1)** | We only perform a constant number of operations: comparison, modulo, subtraction, and min calculation — all take constant time regardless of input size. |
| **Auxiliary Space** | **O(1)** | We use only a few extra integer variables (`balance`, `chocolatesToDestroy`, `chocolatesToMake`), so space usage does not depend on N or M. |


---

## Test Cases Covered

| Friends (N) | Chocolates (M) | Expected Output | Explanation |
|-------------|----------------|----------------|-------------|
| 4 | 10 | 2 | Add or remove 2 to make divisible |
| 3 | 2 | 1 | Must make 1 chocolate |
| 3 | 3 | 0 | Already divisible |
| 3 | 0 | 3 | Must make 3 chocolates |
| 5 | 1 | 4 | Must make 4 chocolates |
| 5 | 9 | 1 | Adding 1 is cheaper than removing 4 |
| 5 | 11 | 1 | Removing 1 is cheaper than adding 4 |
| 5 | 15 | 0 | Already divisible |
| 1 | 0 | 1 | Must make 1 chocolate |
| 1 | 7 | 0 | Always divisible by 1 |

---

## Key Takeaways

- **Modulo operation** helps check if chocolates are evenly distributable.
- Always ensure **at least N chocolates exist** before distributing.
- Choose the **minimum operation** (add or remove) to minimize time.
- Solution runs in **constant time**, making it very efficient.

---
