# Reverse Array in Groups

## Problem Statement
Given an array of integers and a group size `k`, reverse the elements of the array in groups of size `k`.

If the number of elements is not a multiple of `k`, the last group will contain fewer than `k` elements and should also be reversed.

### Example
**Input:**  
`arr = [1, 2, 3, 4, 5, 6, 7, 8]`, `k = 3`

**Output:**  
`[3, 2, 1, 6, 5, 4, 8, 7]`

---

## Approach
1. Traverse the array in steps of `k` using a loop.
2. For each segment (or group), reverse the subarray from index `i` to `i + k - 1`.
3. If the remaining elements are fewer than `k`, reverse only up to the last index.
4. Continue until all groups are processed.

This approach performs **in-place reversal**, meaning no extra array is created.

---

## Algorithm Steps
1. Initialize `n = arr.length`.
2. Loop through the array using `i` in steps of `k`:
   - Set `left = i`.
   - Set `right = min(i + k - 1, n - 1)` to handle the last smaller group.
3. While `left < right`:
   - Swap `arr[left]` and `arr[right]`.
   - Increment `left` and decrement `right`.
4. Continue until the end of the array.

---

## Example Walkthrough
**Input:**  
`arr = [1, 2, 3, 4, 5, 6, 7, 8]`, `k = 3`

**Steps:**
- Reverse indices [0–2] → `[3, 2, 1, 4, 5, 6, 7, 8]`
- Reverse indices [3–5] → `[3, 2, 1, 6, 5, 4, 7, 8]`
- Reverse indices [6–7] → `[3, 2, 1, 6, 5, 4, 8, 7]`

**Final Output:**  
`[3, 2, 1, 6, 5, 4, 8, 7]`

---

## Time and Space Complexity
- **Time Complexity:** O(n)  
  Each element is swapped at most once.

- **Space Complexity:** O(1)  
  The reversal is performed in place, using constant extra space.

---
