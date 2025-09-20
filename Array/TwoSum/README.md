# Two Sum Problem

This project contains Java implementations for solving the classic **Two Sum** problem using two approaches:  
1. **Naive (Brute Force)**  
2. **Optimized (HashMap)**  

---

## Problem Statement
Given an array of integers `nums` and an integer `target`, return the **indices** of the two numbers such that they add up to `target`.  

- Each input will have exactly one solution.  
- You may not use the same element twice.  
- Indices can be returned in any order.  

**Example**:  
```text
Input: nums = [2, 7, 11, 15], target = 9  
Output: [0, 1]  
Explanation: nums[0] + nums[1] = 2 + 7 = 9

## Approaches

### 1. Naive Approach (Brute Force)
- **Idea**: Try every possible pair `(i, j)` and check if their sum equals the target.  
- **Steps**:
  1. Iterate through the array with two nested loops.
  2. For each pair, check if `nums[i] + nums[j] == target`.
  3. Return the indices immediately if found.
- **Complexity**:
  - Time: **O(n²)** (two nested loops).
  - Space: **O(1)** (no extra space used).

---

### 2. Optimized Approach (HashMap)
- **Idea**: Use a HashMap to store numbers and their indices as we traverse.  
- **Steps**:
  1. For each element, calculate its **complement = target - nums[i]**.
  2. If the complement already exists in the map, return the indices.
  3. Otherwise, store the current element in the map.
- **Complexity**:
  - Time: **O(n)** (single pass through array).
  - Space: **O(n)** (HashMap storage).

---

### 3. Two Pointers Approach (for Sorted Arrays)
- **Idea**: If the array is sorted, use two pointers (start and end) to find the target sum efficiently.  
- **Steps**:
  1. Initialize two pointers: `left = 0`, `right = nums.length - 1`.
  2. While `left < right`:
     - If `nums[left] + nums[right] == target`, return the indices.
     - If the sum is smaller than target, move `left++`.
     - If the sum is larger, move `right--`.
- **Complexity**:
  - Time: **O(n)** (each element checked at most once).
  - Space: **O(1)** (no extra space needed).
- **Note**: Works only when the array is sorted.

---

## Example Test Cases

| Input Array          | Target | Output Indices | Explanation                        |
|----------------------|--------|----------------|------------------------------------|
| [2, 7, 11, 15]      | 9      | [0, 1]         | 2 + 7 = 9                          |
| [3, 2, 4]           | 6      | [1, 2]         | 2 + 4 = 6                          |
| [3, 3]              | 6      | [0, 1]         | 3 + 3 = 6 (duplicate numbers)      |
| [-1, -2, -3, -4, -5]| -8     | [2, 4]         | -3 + -5 = -8                       |
| [0, 4, 3, 0]        | 0      | [0, 3]         | 0 + 0 = 0 (with zeros)             |
| [1, 2]              | 3      | [0, 1]         | 1 + 2 = 3 (minimum length array)   |

---
