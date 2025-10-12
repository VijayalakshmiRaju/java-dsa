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

## Formula Explanation

### The Formula
J(n, k) = (J(n - 1, k) + k - 1) % n + 1

Where:
- `n` → Total number of people  
- `k` → Step count (every k-th person is eliminated)  
- `J(n, k)` → Safe position (1-based index)

---

### Step-by-Step Understanding

1. **Base Case**  
   When there is only one person left, that person is obviously safe:  
   `J(1, k) = 1`

2. **Recursive Thought**  
   If we already know the safe position for `(n - 1)` people, we can find it for `n` people.  
   After each elimination, the circle shrinks and positions shift.

3. **Position Shift**  
   When one person is eliminated every `k` steps, the survivor’s position shifts by `(k - 1)` places forward.  
   Since the circle wraps around, we take modulo `n` to keep positions within bounds.

   Hence:
   J(n, k) = (J(n - 1, k) + k - 1) % n
   This gives a zero-based index of the survivor.

4. **Convert to 1-Based Index**  
   To match human counting (starting from 1), we add `1`:
   J(n, k) = (J(n - 1, k) + k - 1) % n + 1

---

### Example Walkthrough

Consider `n = 5`, `k = 3` (every 3rd person is eliminated):

| Step | People Remaining | Eliminated | Safe Position |
|------|------------------|-------------|----------------|
| J(1, 3) | [1] | - | 1 |
| J(2, 3) | [1, 2] | Eliminate 1 → survivor 2 | (1 + 3 - 1) % 2 + 1 = 2 |
| J(3, 3) | [1, 2, 3] | Eliminate 3 → survivor 2 | (2 + 3 - 1) % 3 + 1 = 2 |
| J(4, 3) | [1, 2, 3, 4] | Eliminate 3 → survivor 1 | (2 + 3 - 1) % 4 + 1 = 1 |
| J(5, 3) | [1, 2, 3, 4, 5] | Eliminate 3 → survivor 4 | (1 + 3 - 1) % 5 + 1 = 4 |

Final survivor position = **4**

---

### Intuitive Summary

| Concept | Explanation |
|----------|-------------|
| Base Case | With one person, the survivor is at position 1 |
| Recursive Step | Survivor position shifts by `(k - 1)` each elimination |
| Modulo Operation | Keeps counting circular |
| +1 Adjustment | Converts zero-based result to one-based position |

In simple terms:  
> After every elimination, the circle "rotates" by `(k - 1)` positions.  
> The safe position for `n` people depends on where the safe person stood among the `(n-1)` survivors, adjusted for the circular shift.

---

## Complexity Analysis

| Aspect | Complexity | Explanation |
|--------|-------------|-------------|
| Time Complexity | O(n) | The function makes one recursive call per person. |
| Space Complexity | O(n) | Each recursive call adds one frame to the call stack. |

---

## Key Insights
- The Josephus problem is a classic example of **recursion with circular dependency**.  
- The modulo operation `(% n)` maintains the circular order of elimination.  
- Can be optimized further using an **iterative approach** to reduce recursion overhead.
