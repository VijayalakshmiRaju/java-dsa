# Maximum Consecutive Increasing Steps

Given an **array of building heights**, this program finds the **maximum number of consecutive steps** you can take such that each step goes to a taller building.

---

# Problem Statement

Given:
- An integer array `arr[]` of size `n` representing building heights.

Find:
- The maximum number of **consecutive increasing steps** you can take, where each step moves to the next adjacent building with a greater height.

---

## Algorithm Logic

### **Optimized Approach**
1. Initialize:
   - `count = 0`  
   - `maxSteps = 0`
2. Traverse the array from index `0` to `n-2`:
   - If `arr[i+1] > arr[i]` → increment `count`.
   - Otherwise → reset `count = 0`.
   - Update `maxSteps = max(maxSteps, count)`.
3. Return `maxSteps`.

---

## Time and Space Complexity

| Approach      | Time Complexity | Space Complexity |
|---------------|-----------------|------------------|
| Optimized     | O(n)            | O(1)             |

---

## Example

**Input:**  
`arr = [1, 2, 3, 4]`  

**Output:**  
`3`  

**Explanation:**  
Steps = 1 → 2 → 3 → 4, total **3 consecutive increasing steps**.

---

## Files

- `LongestIncreasingSteps.java`: Contains the optimized Java implementation.
- `README.md`: This file - explanation, logic, and complexity.

---
