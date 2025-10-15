# Left Rotate an Array

## Problem Statement
Given an array `arr[]` of size `n`, perform a **left rotation** on the array by `k` positions.

In a left rotation, each element of the array is shifted one position to the left, and the first element moves to the end of the array.

Example:  
Input: arr = [1, 2, 3, 4, 5], k = 2
Output: [3, 4, 5, 1, 2]

---

## Approaches

### 1. Naive Approach
- Rotate the array one position at a time.
- Repeat this process `k` times.
- Each rotation shifts elements left by one position and moves the first element to the end.

**Steps:**
1. Store the first element in a temporary variable.  
2. Shift remaining elements to the left.  
3. Place the stored element at the end.  
4. Repeat for `k` times.

**Drawback:** Inefficient for large `k` or `n`, as each rotation is `O(n)`.

---

### 2. Optimized Approach (Using Temporary Array)
- Copy the first `k` elements into a temporary array.
- Shift the remaining elements to the left by `k` positions.
- Append the temporary elements to the end.

**Steps:**
1. Copy first `k` elements to a temporary array.  
2. Move elements from index `k` to `n-1` left by `k`.  
3. Copy the temporary array elements to the end.

This approach reduces the time complexity to `O(n)`.

---

## Complexity Analysis

| Approach | Time Complexity | Space Complexity | Explanation |
|-----------|----------------|------------------|--------------|
| Naive | O(n × k) | O(1) | Performs one rotation at a time for k times |
| Optimized | O(n) | O(k) | Uses temporary array for first k elements |

---

## Test Cases

| Test Case | Input Array | k | Expected Output | Description |
|------------|--------------|---|-----------------|--------------|
| 1 | [1, 2, 3, 4, 5] | 3 | [4, 5, 1, 2, 3] | Basic rotation (Naive & Optimized) |
| 2 | [10, 20, 30, 40] | 0 | [10, 20, 30, 40] | No rotation |
| 3 | [5, 10, 15, 20] | 4 | [5, 10, 15, 20] | Rotation by array length (same array) |
| 4 | [9, 8, 7, 6, 5] | 7 | [6, 5, 9, 8, 7] | Rotation greater than array length |
| 5 | [42] | 3 | [42] | Single-element array |
| 6 | [1, 2] | 1 | [2, 1] | Two-element array |
| 7 | [] | 2 | [] | Empty array edge case |

---

## Implementation Highlights
- Includes both **Naive** and **Optimized** methods.
- Handles all **edge cases**: empty array, single element, `k = 0`, and `k > n`.
- Uses a **for loop** in the main method to run all test cases automatically.
- Provides clean and formatted output for clarity.

---

## Example Output
=========== LEFT ROTATION TESTS (Using for loop) ===========

Test Case 1: Rotate by 3 (Naive)
Before: [1, 2, 3, 4, 5]
After : [4, 5, 1, 2, 3]

Test Case 2: Rotate by 3 (Optimized)
Before: [1, 2, 3, 4, 5]
After : [4, 5, 1, 2, 3]

Test Case 3: Rotate by 0 (No Change)
Before: [10, 20, 30, 40]
After : [10, 20, 30, 40]

Test Case 4: Rotate by array length (4)
Before: [5, 10, 15, 20]
After : [5, 10, 15, 20]

Test Case 5: Rotate by 7 (> length)
Before: [9, 8, 7, 6, 5]
After : [6, 5, 9, 8, 7]

Test Case 6: Single element array
Before: [42]
After : [42]

Test Case 7: Two-element array (Rotate by 1)
Before: [1, 2]
After : [2, 1]

Test Case 8: Empty array
Before: []
After : []

=========== END OF TESTS ===========
