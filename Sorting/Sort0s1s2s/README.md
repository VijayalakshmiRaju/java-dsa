# Sort Colors (Dutch National Flag Problem)

## Introduction
This project implements solutions to the classic **Sort Colors problem**, also known as the **Dutch National Flag Problem** (proposed by Edsger Dijkstra).  
The challenge is to sort an array consisting only of **0’s, 1’s, and 2’s** without using any built-in sorting methods.

---

## Problem Statement
Given an array containing only the integers 0, 1, and 2, sort the array in-place so that all 0’s appear first, followed by all 1’s, and then all 2’s.  

### Example
**Input:**  
[2, 0, 2, 1, 1, 0]


**Output:**  
[0, 0, 1, 1, 2, 2]


---

## Approaches

### 1. Counting Method (Naive Approach)
- Count the frequency of 0’s, 1’s, and 2’s.  
- Overwrite the array with that many 0’s, then 1’s, then 2’s.  

---

### 2. Dutch National Flag Algorithm (Optimized Approach)
- Use three pointers:  
  - `low` → boundary for 0’s  
  - `mid` → current element being checked  
  - `high` → boundary for 2’s  
- Process the array in a single pass:  
  - If `arr[mid] == 0`: swap with `arr[low]`, move both `low` and `mid`.  
  - If `arr[mid] == 1`: just move `mid`.  
  - If `arr[mid] == 2`: swap with `arr[high]`, move `high` backward (don’t increment `mid` yet).  

---

## Complexity Comparison

| Approach                    | Time Complexity | Space Complexity | Passes Over Array |
|-----------------------------|-----------------|------------------|-------------------|
| Counting Method (Naive)     | O(n)            | O(1)             | 2                 |
| Dutch National Flag (Optimized) | O(n)        | O(1)             | 1                 |

---

## Test Cases Covered
The implementation has been tested on:  
- Normal unsorted arrays  
- Already sorted arrays  
- Reverse sorted arrays  
- Arrays with all elements the same (all 0’s, all 1’s, or all 2’s)  
- Single-element arrays  
- Empty arrays  

---

## Key Takeaways
- The **counting method** is simple but requires two passes over the array.  
- The **Dutch National Flag Algorithm** is the most efficient — a one-pass, in-place solution.  
- This problem is frequently asked in **coding interviews** as it demonstrates mastery of in-place array manipulation and pointer techniques.  

---
