# First Negative Integer in Every Window of Size K

## Problem Statement

Given an integer array `arr[]` and a positive integer `k`, find the first negative integer in every contiguous subarray (window) of size `k`.

If a window does not contain any negative integer, return `0` for that window.

---

## Approach

This problem is solved using the Fixed Size Sliding Window technique along with a Deque (Double Ended Queue).

The idea is to maintain a window of size `k` while traversing the array. A deque is used to store negative numbers that are currently present in the window. The first element of the deque always represents the first negative number in the current window.

---

## Algorithm Explanation

1. Initialize two pointers to represent the start and end of the window.
2. Traverse the array using the end pointer.
3. Whenever a negative number is encountered, add it to the deque.
4. Once the window size becomes equal to `k`:
   - If the deque is empty, append `0` to the result.
   - Otherwise, append the element at the front of the deque.
5. Before sliding the window forward, check if the element leaving the window is equal to the front of the deque. If so, remove it from the deque.
6. Slide the window by moving both pointers forward.
7. Repeat the process until all windows are processed.

---

## Example

Input:
arr = [-8, 2, 3, -6, 10], k = 2

Output:
[-8, 0, -6, -6]

Explanation:
Each window of size 2 is evaluated to determine the first negative integer. If no negative number exists in a window, the output for that window is 0.

---

## Edge Cases Considered

- Arrays with no negative numbers
- Arrays with all negative numbers
- Window size equal to 1
- Window size equal to the length of the array

---

## Complexity Analysis

Time Complexity: O(n), where n is the length of the array  
Space Complexity: O(k), where k is the window size

---

## Key Takeaways

- Sliding Window technique helps reduce unnecessary computations.
- Deque is useful for maintaining elements relevant to the current window.
- This approach efficiently handles large input sizes.

---
