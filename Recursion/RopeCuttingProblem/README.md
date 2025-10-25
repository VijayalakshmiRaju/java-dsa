# Rope Cutting Problem

## Problem Statement

You are given a rope of length `n`. The task is to determine the maximum number of pieces the rope can be cut into, such that the length of each piece is either `a`, `b`, or `c`.  
If it is not possible to cut the rope in the desired way, return `-1`.

**Example:**  
For a rope of length 17 and possible cut lengths 10, 11, and 3,  
the rope can be cut as 11 + 3 + 3 = 17, giving a maximum of 3 pieces.

---

## Approach: Recursive (Brute Force)

### Idea
The recursive approach explores all possible ways to cut the rope using the three possible lengths (`a`, `b`, and `c`).  
At each step, it reduces the rope length by one of these cut sizes and recursively solves the smaller subproblems.

### Steps
1. If `n` is 0 → no rope left to cut, return 0.  
2. If `n` becomes negative → invalid cut, return -1.  
3. Otherwise, make three recursive calls:
   - one for cutting `a` length,
   - one for `b`,
   - one for `c`.
4. Take the maximum result among the three.
5. If all results are -1, return -1 (no valid cut possible).  
   Otherwise, return the maximum result plus one (for the current cut).

### Characteristics
- This method checks all possible combinations, making it conceptually simple but computationally expensive.

---

## Time and Space Complexities

| Approach | Time Complexity | Space Complexity | Description |
|-----------|-----------------|-----------------|--------------|
| Recursive (Brute Force) | O(3^n) | O(n) | Each call can branch into three new recursive calls. |

---

## Sample Test Cases

| Test Case | Input (n, a, b, c) | Expected Output | Explanation |
|------------|--------------------|-----------------|--------------|
| 1 | (17, 10, 11, 3) | 3 | Rope can be cut as 11 + 3 + 3. |
| 2 | (9, 2, 2, 2) | -1 | 9 cannot be made with pieces of length 2. |
| 3 | (9, 2, 3, 4) | 4 | Rope can be cut as 3 + 2 + 2 + 2. |
| 4 | (5, 5, 3, 2) | 2 | Rope can be cut as 3 + 2. |
| 5 | (7, 5, 2, 6) | 2 | Rope can be cut as 5 + 2. |
| 6 | (0, 2, 3, 4) | 0 | No cuts needed. |
| 7 | (-5, 2, 3, 4) | -1 | Invalid rope length. |
| 8 | (24, 12, 8, 4) | 6 | Rope can be cut as six pieces of length 4. |

---

## Summary

- The recursive solution is straightforward and useful for understanding the problem logic.  
