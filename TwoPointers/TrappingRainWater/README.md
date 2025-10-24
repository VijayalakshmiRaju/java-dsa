# Trapping Rain Water Problem (Java)

## Overview
This program solves the **Trapping Rain Water** problem using the **two-pointer technique** in Java.

Given an array `arr[]` representing the height of bars, the goal is to calculate the total amount of rainwater that can be trapped between the bars after it rains.

---

## Problem Explanation
Each element in the array represents the height of a bar.  
Rainwater can be trapped between two bars if there is a smaller bar between taller ones.

Example:
Input: [3, 0, 2, 0, 4]
Output: 7

Explanation:
- Water trapped above each bar = `[0, 3, 1, 3, 0]`
- Total = 7 units of trapped water.

---

## Approach
### Two Pointer Technique (Optimized)
1. Use two pointers `left` and `right` to traverse from both ends.
2. Maintain:
   - `leftMax`: Maximum height encountered so far from the left.
   - `rightMax`: Maximum height encountered so far from the right.
3. Move the pointer from the side with the smaller maximum height.
4. Water trapped on any bar = `min(leftMax, rightMax) - currentBarHeight`.
5. Accumulate trapped water for each position.

### Advantages
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- Single pass through the array without using extra arrays.

---
