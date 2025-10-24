# Trapping Rain Water Problem

## Overview
This project solves the classic Trapping Rain Water problem in Java using the two-pointer technique.  
The goal is to calculate the total amount of water that can be trapped between bars of varying heights after it rains.

---

## Problem Description
Given an array where each element represents the height of a bar, determine how much water can be trapped between the bars.

For example:
- Input: [3, 0, 2, 0, 4]
- Output: 7  
Explanation: The total trapped water between the bars is 7 units.

---

## Approach
### Algorithm Used
- The optimized **two-pointer approach** is used to solve this problem in linear time.
- Two pointers (`left` and `right`) are initialized at both ends of the array.
- Maintain two variables:
  - `leftMax`: Maximum height seen so far from the left side.
  - `rightMax`: Maximum height seen so far from the right side.
- Move the pointer from the side with the smaller maximum height.
- At each step, calculate trapped water as the difference between the smaller of the two maximums and the current bar’s height.

### Key Points
- The trapped water above each bar depends on the **minimum** of the maximum heights on both sides.
- The algorithm efficiently computes total trapped water without using extra space.

---

## Time and Space Complexity
| Metric | Complexity |
|---------|-------------|
| Time Complexity | O(n) |
| Space Complexity | O(1) |

---

## Test Cases
The solution was tested with various input scenarios, including standard and edge cases.

| Case Type | Input | Expected Output | Description |
|------------|--------|----------------|--------------|
| Standard Case | [3, 0, 2, 0, 4] | 7 | Multiple pits of varying sizes |
| Multiple Pits | [0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2] | 8 | Multiple valleys present |
| Decreasing Heights | [5, 4, 3, 2, 1] | 0 | No water trapped |
| Increasing Heights | [1, 2, 3, 4, 5] | 0 | No valleys |
| Single Pit | [2, 0, 2] | 2 | Simple pit between two bars |
| Flat Surface | [1, 1, 1, 1] | 0 | No elevation differences |
| Small Pit | [1, 0, 1] | 1 | Minimal water trapped |
| Single Element | [5] | 0 | Too few bars |
| Empty Input | [] | 0 | No bars available |
| Null Input | null | 0 | Safely handled case |

---

## Edge Case Handling
- Returns 0 when input is null or empty.
- Handles arrays with fewer than three elements correctly.
- Works for both increasing and decreasing sequences.
- Tested against uniform-height arrays and arrays containing zero heights.

---

## Output Example
=== Trapping Rain Water Problem ===

Test Case 1: Input: [3, 0, 2, 0, 4] -> Trapped Water = 7
Test Case 2: Input: [0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2] -> Trapped Water = 8
Test Case 3: Input: [5, 4, 3, 2, 1] -> Trapped Water = 0
Test Case 4: Input: [1, 2, 3, 4, 5] -> Trapped Water = 0
Test Case 5: Input: [2, 0, 2] -> Trapped Water = 2
Test Case 6: Input: [4, 2, 0, 3, 2, 5] -> Trapped Water = 9
Test Case 7: Input: [1, 1, 1, 1] -> Trapped Water = 0
Test Case 8: Input: [1, 0, 1] -> Trapped Water = 1
Test Case 9: Input: [5] -> Trapped Water = 0
Test Case 10: Input: [] -> Trapped Water = 0
Test Case 11: Input: null -> Trapped Water = 0

---
