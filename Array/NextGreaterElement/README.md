# Greater on Right Side Problem

This folder contains the implementation of the **Greater on Right Side** problem in Java.  
The task is to replace every element in an array with the **next greatest element on its right side**.  
The **last element** is always replaced with `-1` since no elements exist to its right.

---

## Problem Statement

Given an array `Arr` of size `N`, replace each element with the **next greatest element on its right**.  
If there is no greater element, replace it with `-1`.

**Example:**
Input:
N = 6
Arr = [16, 17, 4, 3, 5, 2]

Output:
[17, 5, 5, 5, 2, -1]

---

## Algorithm

### Naive Approach (O(N²))
1. For every element, traverse all elements to its right.
2. Find the maximum and replace the current element with it.
3. Replace the last element with `-1`.

---

### Optimized Approach (O(N))
1. Initialize a variable `maxRight = -1`.
2. Traverse the array **from right to left**:
   - Store the current element in a temporary variable.
   - Replace the current element with `maxRight`.
   - Update `maxRight = max(maxRight, temp)`.

This ensures each element is replaced by the greatest element on its right in a **single pass**.

---

## Example Walkthrough

For the array:  
[16, 17, 4, 3, 5, 2]

- Start from the right:  
  - Last element → replaced with `-1`  
  - For `5`, the greatest on right is `2` → replace with `2`  
  - For `3`, the greatest on right is `5` → replace with `5`  
  - Continue until the leftmost element.

Final result:  
[17, 5, 5, 5, 2, -1]


---

## Complexities

| Approach     | Time Complexity | Space Complexity |
|--------------|-----------------|------------------|
| Naive        | O(N²)           | O(1)             |
| Optimized    | O(N)            | O(1)             |

---

## Edge Cases
1. **Single element array** → Result should be `[-1]`.
2. **Strictly increasing array** → Each element becomes the last element, except the last which is `-1`.
3. **Strictly decreasing array** → Each element becomes the immediate next element, last is `-1`.
4. **Empty array** → Result is an empty array.

---

This problem is a **classic array manipulation problem**, and the optimized solution ensures efficiency for large inputs.

