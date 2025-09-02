# Find Two Repeated Elements in an Array

This folder contains the implementation of finding **two repeated elements** in an array:
- Naive (Brute Force) method
- Optimized Frequency Array method

The algorithm assumes the array has:
- Length = `n + 2`
- Elements ranging from `1` to `n`
- Exactly **two numbers are repeated once**, while all others appear only once.

---

## Problem Statement

Given:
- An integer array `arr[]` of size `n+2`.
- The array contains numbers in the range `1` to `n`.
- Exactly two elements are repeated once.

Find:
- The **two repeated elements** in the array.

---

## Algorithm

### Naive Approach
1. Traverse each element of the array.
2. For every element, check if it appears again later in the array.
3. Collect the repeated elements.
4. Stop when both repeated elements are found.

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

---

### Optimized Approach (Frequency Array)
1. Create a frequency array `freq[]` of size `n+1` initialized with `0`.
2. Traverse the array:
   - Increment `freq[arr[i]]` for each element.
   - If `freq[arr[i]] > 1`, mark it as a repeated element.
3. Stop when two repeated elements are found.

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

---

## Files
- `FindTwoRepeatedElements.java` → Java implementation (Naive + Optimized).
- `README.md` → Explanation of the problem, solution approaches, and complexities.
