# Jump Game Problem

This folder contains the implementation of the **Jump Game** problem in Java:  
- Uses a **Greedy Algorithm**.  
- Tracks the **farthest index** reachable at every step.  

The algorithm ensures you can determine if it’s possible to **reach the last index** of the array starting from the **first index**.

---

## Problem Statement

You are given an array of **non-negative integers** where each element represents your **maximum jump length** from that position.  

- You start at the **first index**.  
- Your goal is to check if you can reach the **last index**.  

---

## Algorithm

### Greedy Approach
1. **Initialize**:
   - `farthest = 0` → keeps track of the farthest index reachable so far.  

2. **Iterate through the array**:
   - If the current index `i > farthest`, then you cannot reach this index → return `false`.  
   - Otherwise, update `farthest = max(farthest, i + nums[i])`.  

3. **Check termination condition**:
   - If `farthest >= lastIndex`, return `true` (you can reach the end).  

4. After the loop, return whether `farthest` covers the last index.

---

## Time and Auxiliary Space (extra space used)

| Step               | Time Complexity | Auxiliary Space | Explanation |
|--------------------|-----------------|-----------------|-------------|
| Greedy Iteration   | O(n)            | O(1)            | Single pass with constant variables |

---

## Test Cases

| **Input Array**             | **Output** | **Explanation** |
|------------------------------|------------|-----------------|
| `[2,3,1,1,4]`               | true       | Jump 0→1→last |
| `[3,2,1,0,4]`               | false      | Stuck at index 3 (value 0) |
| `[0]`                       | true       | Already at last index |
| `[5,0,0,0,0]`               | true       | First jump reaches the end |
| `[0,0,0,0]`                 | false      | Cannot move beyond first index |
| `[1,1,1,1]`                 | true       | Step-by-step reaches the end |
| `[2,0,0,0]`                 | false      | Stuck at index 1 |

---

## Files
- `JumpGame.java` – Java implementation with greedy algorithm and test cases.  
