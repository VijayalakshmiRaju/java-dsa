# Two Odd Occurrence Problem

## Problem Statement
Given an integer array where **exactly two elements occur an odd number of times** and all other elements occur an even number of times,  
find and return those two odd-occurring elements.

**Example:**
Input: arr = [4, 2, 4, 5, 2, 3, 3, 1]
Output: 5, 1
Explanation: 5 and 1 appear only once (odd), while all others appear even times.

---

## Approaches

### 1. Naive Approach
- Use two nested loops to count occurrences of each element.
- If an element occurs an odd number of times and has not been added before, store it in the result array.
- Stop when both odd-occurring elements are found.

**Steps:**
1. Iterate through each element in the array.
2. Count its occurrences using an inner loop.
3. If count is odd and element is not already added, store it.
4. Return the result array of size 2.

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

---

### 2. Optimized XOR Approach
- Use XOR to cancel out all even-occurring elements.
- XOR of all elements gives `xor = num1 ^ num2` where num1 and num2 are the two odd-occurring numbers.
- Find the rightmost set bit in `xor` to divide elements into two groups.
- XOR each group separately to find the two odd-occurring numbers.

**Steps:**
1. XOR all elements → result = num1 ^ num2
2. Find the rightmost set bit in XOR.
3. Divide elements into two groups based on that bit.
4. XOR each group → gives num1 and num2.

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## Complexity Analysis

| Method                  | Time Complexity | Space Complexity | Description                                      |
|-------------------------|----------------|-----------------|------------------------------------------------|
| Naive Approach          | O(n²)          | O(1)            | Nested loops to count occurrences              |
| Optimized XOR Approach  | O(n)           | O(1)            | Bitwise XOR technique to find numbers efficiently |

---

## Test Cases with Example Outputs

| #  | Input Array                            | Naive Output      | Optimized XOR Output | Notes                                   |
|----|----------------------------------------|-----------------|-------------------|-----------------------------------------|
| 1  | [4, 2, 4, 5, 2, 3, 3, 1]              | 5, 1             | 5, 1               | Normal case                             |
| 2  | [9, 4, 4, 6, 6, 3, 3, 9, 1]           | 1, 9             | 1, 9               | Odd elements at start/end                |
| 3  | [7, 8]                                | 7, 8             | 7, 8               | Only two elements, both odd             |
| 4  | [1, 1, 2, 2, 3, 3]                     | None / Invalid   | 0, 0               | No odd-occurring elements               |
| 5  | [5, 5, 7, 7, 7, 8, 8, 9, 9, 9]        | 7, 9             | 7, 9               | Odd elements in middle                   |
| 6  | [10, 10, 10, 10, 5, 6, 6, 6, 6, 7]    | 5, 7             | 5, 7               | Large even frequencies                   |
| 7  | [4, -1, 2, -1, 2, 5, 4, 7, 7, 9]      | 5, 9             | 5, 9               | Includes negative numbers                |

**Notes:**
- For the **Naive approach**, if there are no odd-occurring numbers, it may return empty or invalid output.
- For the **XOR approach**, zero values indicate no odd-occurring numbers were found.

---

## Summary
- The **Naive approach** is easy to implement but inefficient for large arrays (O(n²)).
- The **Optimized XOR approach** is linear in time and constant in space, ideal for large arrays.
- Both approaches correctly identify the two odd-occurring numbers.

---
