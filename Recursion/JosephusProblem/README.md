# Josephus Problem

## Problem Statement
The Josephus Problem involves `n` people standing in a circle waiting to be executed.  
Counting begins from a specific point, and every `k-th` person is eliminated from the circle.  
After each elimination, counting resumes from the next person, and the process continues until only one person remains.  
The task is to determine the position of the survivor (1-indexed).

---

## Approach

| Step | Description |
|------|--------------|
| 1 | Base Case: When only one person remains (`n == 1`), that person is the survivor. |
| 2 | Recursive Relation: Use the formula `J(n, k) = (J(n - 1, k) + k - 1) % n + 1`, where `J(n, k)` gives the safe position among `n` people. |
| 3 | Recursive Logic: Each elimination shifts the survivor’s position, and the modulo ensures circular counting. |
| 4 | Termination: The recursion continues until the problem reduces to the base case (`n = 1`). |

---

## Complexity Analysis

| Aspect | Complexity | Explanation |
|--------|-------------|-------------|
| Time Complexity | O(n) | The function makes one recursive call per person. |
| Space Complexity | O(n) | Each recursive call adds one frame to the call stack. |

## Key Insights
- The Josephus problem is a classic example of **recursion with circular dependency**.  
- The modulo operation `(% n)` maintains the circular order of elimination.  
- Can be optimized further using an **iterative approach** to reduce recursion overhead.
