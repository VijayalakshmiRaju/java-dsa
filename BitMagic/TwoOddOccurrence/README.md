# Two Odd Occurrence

## Problem Statement
Given an array of integers where **exactly two elements occur an odd number of times** and all other elements occur an even number of times,  
find and return those two odd-occurring elements.

---

## Example
**Input:**
arr = [4, 2, 4, 5, 2, 3, 3, 1]

**Output:**
5 and 1


**Explanation:**
- 4 → appears 2 times (even)
- 2 → appears 2 times (even)
- 5 → appears 1 time (odd)
- 3 → appears 2 times (even)
- 1 → appears 1 time (odd)

Hence, the two odd-occurring numbers are **5** and **1**.

---

## Breakdown of Naive Approach

### Step 1: Iterate through each element
Use two nested loops — for every element `arr[i]`, count how many times it appears in the array.

### Step 2: Count occurrences
For each element, use an inner loop to count all matching occurrences.

### Step 3: Check if count is odd
If the count of a number is odd, add it to the result array (if not already added).

### Step 4: Avoid duplicates
Ensure the same odd-occurring number is not added twice.

### Step 5: Return the two odd-occurring numbers
After the traversal, return the two unique odd-occurring numbers.

---

## Example Walkthrough
For `arr = [4, 2, 4, 5, 2, 3, 3, 1]`:

| Element | Count | Odd/Even | Action |
|----------|--------|-----------|--------|
| 4 | 2 | Even | Skip |
| 2 | 2 | Even | Skip |
| 5 | 1 | Odd | Add to result |
| 3 | 2 | Even | Skip |
| 1 | 1 | Odd | Add to result |

Result → `[5, 1]`

---

## Edge Cases

| Case | Input | Expected Output | Explanation |
|------|--------|-----------------|--------------|
| Both odd elements are distinct | [4, 2, 4, 5, 2, 3, 3, 1] | 5, 1 | Normal case |
| Odd elements at start and end | [9, 4, 4, 6, 6, 3, 3, 9, 1] | 1, 9 | Both edges odd |
| Only two elements (both odd) | [7, 8] | 7, 8 | Each appears once |
| Large even frequency | [2, 2, 2, 2, 5, 6, 6, 6, 6, 7] | 5, 7 | 5 and 7 appear once |
| All even elements | [1, 1, 2, 2, 3, 3] | Undefined | No odd occurrence (invalid input) |

---

## Complexity Analysis

| Operation | Time Complexity | Space Complexity | Explanation |
|------------|-----------------|------------------|--------------|
| Counting each element | O(n²) | O(1) | Nested loops |
| Result storage | O(1) | O(1) | Constant space for two elements |
| **Total** | **O(n²)** | **O(1)** | Quadratic time, constant space |

---
